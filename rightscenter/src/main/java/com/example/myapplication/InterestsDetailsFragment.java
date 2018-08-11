package com.example.myapplication;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.myapplication.constant.AppConstant;
import com.example.myapplication.entity.NewEntity;
import com.example.myapplication.entity.UserRightInfoVO;
import com.example.myapplication.widget.CustomDatePicker;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2018/5/22/022.
 */
public class InterestsDetailsFragment extends Fragment implements View.OnClickListener {

    private TextView textView1, textView2, textView3, textView4;
    private ImageView imageView1, imageView2;
    private Button button1;
    //国漫
    private TextView gTextView1, gTextView2;
    private ImageView gImageView1;
    private Button gButton1;
    private LinearLayout gLinearLayout1;
    private EditText gEditText;

    private CustomDatePicker mCustomDatePicker;
    private String now;

    private List<UserRightInfoVO.ListBean.DataBean> infoVOS = new ArrayList<>();

    private int position, listPosition;

    private String starLevel;
    private String mobileNum;
    private String mobileNumUU;
    private String realBalance;
    private String derdge;

    private Bundle bundle;
    private String enjoyState;
    private String permissionsName;
    private String rightNumber;
    private String rightTitle;
    private String rightImage;
    private String leftTitle;
    private String leftDesc;
    private String bottomImgUrl;
    private String bottomBtnName;
    private String bottomBtnUrl;
    private String guaranteeNumber;
    private String guaranteeRemainingNumber;
    private String rightInfoCheckImage;
    private String rightInfoUnCheckImage;

    private ScrollView scrollView;
    private List<NewEntity> newEntityList = new ArrayList<>();

    @SuppressLint("HandlerLeak")
    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0x111:
                    String result = (String) msg.obj;
                    if (result.equals("1")) {
                        gButton1.setVisibility(View.GONE);
                        gLinearLayout1.setVisibility(View.GONE);
                        gImageView1.setVisibility(View.VISIBLE);
                    }
                    if (result.equals("0")) {
                        gButton1.setVisibility(View.VISIBLE);
                        gLinearLayout1.setVisibility(View.VISIBLE);
                        gImageView1.setVisibility(View.GONE);
                    }

                    break;
                case 0x112:
                    List<NewEntity> newEntityList = (List<NewEntity>) msg.obj;
                    String derdge = newEntityList.get(2).getDerdge();
                    if (derdge.equals("1")) {
                        gButton1.setVisibility(View.VISIBLE);
                        gLinearLayout1.setVisibility(View.VISIBLE);
                        gImageView1.setVisibility(View.GONE);
                    }
                    if (derdge.equals("0")) {
                        gButton1.setVisibility(View.GONE);
                        gLinearLayout1.setVisibility(View.GONE);
                        gImageView1.setVisibility(View.VISIBLE);
                    }
                    break;
            }

        }
    };


    /**
     * 查询国漫开通状态
     */
    private void postData() {
        OkHttpClient client = new OkHttpClient();
        String url = AppConstant.httpAddress + AppConstant.interestsMain;
        FormBody.Builder formBody = new FormBody.Builder();
        formBody.add("mobileNum", mobileNumUU);
        formBody.build();
        final Request request = new Request.Builder()
                .url(url)
                .post(formBody.build())
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                // 异常状态
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
//                        mStatusView.showError();
                    }
                });
            }

            @Override
            public void onResponse(final Call call, final Response response) throws IOException {
                // 解析json
                String jsonData = response.body().string();
                try {
                    JSONObject jsonObject = new JSONObject(jsonData);
                    String result = jsonObject.getString("result");
                    JSONObject jsonObject1 = jsonObject.getJSONObject("list");
                    JSONArray jsonArray = jsonObject1.getJSONArray("data");
                    JSONObject jsonObject2 = jsonArray.getJSONObject(0);
                    JSONArray jsonArray1 = jsonObject2.getJSONArray("userRights");

                    JSONObject jsonObject3 = jsonArray.getJSONObject(1);
                    starLevel = jsonObject3.getString("starLevel");
                    JSONObject jsonObject4 = jsonArray.getJSONObject(2);
                    mobileNum = jsonObject4.getString("mobileNum");
                    JSONObject jsonObject5 = jsonArray.getJSONObject(3);
                    realBalance = jsonObject5.getString("realBalance");
                    for (int i = 0; i < jsonArray1.length(); i++) {
                        NewEntity entity = new NewEntity();
                        String name = jsonArray1.getJSONObject(i).getString("name");
                        String imageUrl = jsonArray1.getJSONObject(i).getString("imageUrl");
                        String derdge = jsonArray1.getJSONObject(i).getString("derdge");
//
                        entity.setName(name);
                        entity.setImageUrl(imageUrl);
                        entity.setDerdge(derdge);
//                                entity.setStarLevel(starLevel);
//                                entity.setStarLevel(realBalance);
                        newEntityList.add(entity);
                    }

                    Message message = new Message();
                    message.what = 0x112;
                    message.obj = newEntityList;
                    mHandler.sendMessage(message);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        bundle = getArguments();
        infoVOS = bundle.getParcelableArrayList("dataList");
        position = bundle.getInt("position");
        starLevel = bundle.getString("starLevel");
        mobileNum = bundle.getString("mobileNum");
        mobileNumUU = bundle.getString("mobileNumUU");
        realBalance = bundle.getString("realBalance");

//        initDataPicker();

        if (infoVOS.get(position).getPermissionsName().equals("国漫免预存")) {
            View view1 = inflater.inflate(R.layout.fragment_freestorage, container, false);
            initView1(view1);
            initDataFreestorage();
            postData();
            return view1;
        } else {
            View view = inflater.inflate(R.layout.fragment_birthday_test, container, false);
            initView(view);
            initData();
            return view;
        }
    }

    private void initView1(View view1) {
        //国漫
        gTextView1 = view1.findViewById(R.id.freestorage_left_title_tv);
        gTextView2 = view1.findViewById(R.id.freestorage_mobile_tv);
        gImageView1 = view1.findViewById(R.id.freestorage_isopen_iv);
        gButton1 = view1.findViewById(R.id.freestorage_bottom_btn);
//        gEditText = view1.findViewById(R.id.fragment_freestorage_et);
        gLinearLayout1 = view1.findViewById(R.id.freestorage_isopen_ll);
//        gEditText.setOnClickListener(this);
        gButton1.setOnClickListener(this);

    }

    private void initDataFreestorage() {
        String enjoyState = infoVOS.get(position).getEnjoyState();
        String leftTitle = infoVOS.get(position).getLeftTitle();
        String bottomBtnName = infoVOS.get(position).getBottomBtnName();
        if (enjoyState.equals("0")) {
            gLinearLayout1.setVisibility(View.GONE);
            gImageView1.setVisibility(View.VISIBLE);
        } else if (enjoyState.equals("1")) {
            gLinearLayout1.setVisibility(View.VISIBLE);
            gImageView1.setVisibility(View.GONE);
            if (!leftTitle.equals("")) {
                gTextView1.setText(leftTitle);
            } else {
                gTextView1.setVisibility(View.GONE);
            }

            if (!mobileNum.equals("")) {
                gTextView2.setText(mobileNum);
            } else {
                gTextView2.setVisibility(View.GONE);
            }
        }

        if (!bottomBtnName.equals("")) {
            gButton1.setText(bottomBtnName);
        } else {
            gButton1.setVisibility(View.GONE);
        }
    }

    /**
     * 开通国际漫游
     */
    private void openFreestorage() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String url = AppConstant.httpAddress + AppConstant.openFreestorage;
                OkHttpUtils.post()
                        .url(url)
                        .addParams("mobileNum", mobileNumUU)
                        .addParams("endDate", "20180908")
                        .build()
                        .execute(new StringCallback() {
                            @Override
                            public void onError(Call call, Exception e, int id) {

                            }

                            @Override
                            public void onResponse(String response, int id) {
                                try {
                                    JSONObject jsonObject = new JSONObject(response);
                                    String result = jsonObject.getString("result");

                                    Message message = new Message();
                                    message.what = 0x111;
                                    message.obj = result;
                                    mHandler.sendMessage(message);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
            }
        }).start();

    }


    private void initData() {
        enjoyState = infoVOS.get(position).getEnjoyState();
        permissionsName = infoVOS.get(position).getPermissionsName();
        rightNumber = infoVOS.get(position).getRightNumber();
        rightTitle = infoVOS.get(position).getRightTitle();
        rightImage = infoVOS.get(position).getRightImage();
        leftTitle = infoVOS.get(position).getLeftTitle();
        leftDesc = infoVOS.get(position).getLeftDesc();
        bottomImgUrl = infoVOS.get(position).getBottomImgUrl();
        bottomBtnName = infoVOS.get(position).getBottomBtnName();
        bottomBtnUrl = infoVOS.get(position).getBottomBtnUrl();
        guaranteeNumber = infoVOS.get(position).getGuaranteeNumber();
        guaranteeRemainingNumber = infoVOS.get(position).getGuaranteeRemainingNumber();
        rightInfoCheckImage = infoVOS.get(position).getRightInfoCheckImage();
        rightInfoUnCheckImage = infoVOS.get(position).getRightInfoUnCheckImage();

        if (enjoyState.equals("0")) {
            if (!"".equals(leftTitle)) {
                textView1.setText(leftTitle);
            } else {
                textView1.setText("");
            }

            if (!"".equals(leftDesc)) {
                textView2.setText(leftDesc);
            } else {
                textView2.setText("");
            }

            if (!"".equals(rightNumber)) {
                textView3.setText(rightNumber);
            } else {
                textView3.setText("");
            }

            if (!"".equals(rightTitle)) {
                textView4.setText(rightTitle);
            } else {
                textView4.setText("");
            }

            if (!rightImage.equals("")) {
                Glide.with(this)
                        .load(rightImage)
                        .asBitmap()
                        .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                        .placeholder(R.mipmap.ic_launcher)
                        .error(R.mipmap.ic_launcher)
                        .fitCenter()
                        .into(imageView1);
            } else {
                imageView1.setVisibility(View.GONE);
            }

            if (!bottomImgUrl.equals("")) {
                Glide.with(this)
                        .load(bottomImgUrl)
                        .asBitmap()
                        .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                        .placeholder(R.mipmap.ic_launcher)
                        .error(R.mipmap.ic_launcher)
                        .fitCenter()
                        .into(imageView2);
            } else {
                imageView2.setVisibility(View.GONE);
            }

        } else if (enjoyState.equals("1")) {
            if (!leftTitle.equals("")) {
                textView1.setText(leftTitle);
            } else {
                textView1.setVisibility(View.GONE);
            }

            if (!leftDesc.equals("")) {
                textView2.setText(leftDesc);
            } else {
                textView2.setVisibility(View.GONE);
            }

//            if (!rightNumber.equals("")) {
//                textView3.setText(rightNumber);
//            } else {
            textView3.setVisibility(View.GONE);
//            }

//            if (!rightTitle.equals("")) {
//                textView4.setText(rightTitle);
//            } else {
            textView4.setVisibility(View.GONE);
//            }

//            if (!rightImage.equals("")) {
            Glide.with(this)
                    .load(rightImage)
                    .asBitmap()
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .fitCenter()
                    .into(imageView1);
//            } else {
//                imageView1.setVisibility(View.GONE);
//            }

//            if (!bottomImgUrl.equals("")) {
//                Glide.with(this)
//                        .load(bottomImgUrl)
//                        .asBitmap()
//                        .placeholder(R.mipmap.ic_launcher)
//                        .error(R.mipmap.ic_launcher)
//                        .fitCenter()
//                        .into(imageView2);
//            } else {
//            imageView2.setVisibility(View.GONE);
            if (permissionsName.equals("积分倍享")) {
                Glide.with(this)
                        .load(bottomImgUrl)
                        .asBitmap()
                        .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                        .placeholder(R.mipmap.ic_launcher)
                        .error(R.mipmap.ic_launcher)
                        .fitCenter()
                        .into(imageView2);
            } else if (permissionsName.equals("免费补换卡")) {
                Glide.with(this)
                        .load(bottomImgUrl)
                        .asBitmap()
                        .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                        .placeholder(R.mipmap.ic_launcher)
                        .error(R.mipmap.ic_launcher)
                        .fitCenter()
                        .into(imageView2);
            } else {
                imageView2.setVisibility(View.GONE);
            }

//            }
        }

        if (!bottomBtnName.equals("")) {
            button1.setText(bottomBtnName);
        } else {
            button1.setVisibility(View.GONE);
        }

    }

    private void initDataPicker() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        now = sdf.format(new Date());

        mCustomDatePicker = new CustomDatePicker(getActivity(), new CustomDatePicker.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                int data = Integer.parseInt(time.substring(0, 4) + (time.substring(5, 7)) + time.substring(8, 10));
                int dataNow = Integer.parseInt(now.substring(0, 4) + (now.substring(5, 7)) + now.substring(8, 10));
                if (data - dataNow > 49999) {
                    final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setNeutralButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            gEditText.setText(now.split(" ")[0]);
                        }
                    });
                    builder.setMessage("五年内有效");
                    builder.setCancelable(false);
                    builder.show();
                } else {
                    gEditText.setText(time.split(" ")[0]);
                }


            }
        }, "2010-01-01 00:00", "2049-12-31 00:00"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        mCustomDatePicker.showSpecificTime(false); // 不显示时和分
        mCustomDatePicker.setIsLoop(false); // 不允许循环滚动
    }

    private void initView(View view) {
        textView1 = view.findViewById(R.id.test_left_title_tv);
        textView2 = view.findViewById(R.id.test_left_content_tv);
        textView3 = view.findViewById(R.id.test_right_title_tv);
        textView4 = view.findViewById(R.id.test_right_content_tv);
        imageView1 = view.findViewById(R.id.test_right_image_iv);
        imageView2 = view.findViewById(R.id.test_center_image_iv);
        button1 = view.findViewById(R.id.test_bottom_btn);
        button1.setOnClickListener(this);
        scrollView = view.findViewById(R.id.scrollView);
    }

    public InterestsDetailsFragment() {

    }

    /*接口回调*/
    public void getEditText(CallBack callBack) {
        /*获取文本框的信息*/
        String msg = "111222333";
        callBack.getResult(msg);
    }

    /*接口*/
    public interface CallBack {
        /*定义一个获取信息的方法*/
        public void getResult(String result);
    }

    private String getData(String string) {

        return string;
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.test_bottom_btn) {
            if (bottomBtnUrl.indexOf("https") != -1) {
                startActivity(new Intent(getActivity(), MyH5WebView.class));
            } else if (bottomBtnUrl.contains("{\"target")) {
                getData(bottomBtnUrl);
                startActivity(new Intent(getContext(), Testaa.class));
            }

            if (bottomBtnName.indexOf("话费充值") != -1) {
                Toast.makeText(getActivity(), bottomBtnUrl, Toast.LENGTH_SHORT).show();
            }

            if (bottomBtnName.indexOf("营业厅") != -1) {
                Toast.makeText(getActivity(), bottomBtnUrl, Toast.LENGTH_SHORT).show();
            }

            if (bottomBtnName.indexOf("10086") != -1) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("10086")
                        .setPositiveButton("呼叫", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE}, 1);
                                } else {
                                    callPhone("10086");
                                }
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                builder.setCancelable(false);
                builder.create().show();
            }

        } else if (i == R.id.freestorage_bottom_btn) {
            openFreestorage();
            Toast.makeText(getContext(), "12312312312312312", Toast.LENGTH_SHORT).show();

        }
    }

    private void callPhone(String phoneNum) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        Uri data = Uri.parse("tel:" + "10086");
        intent.setData(data);
        startActivity(intent);
    }
}
