package com.example.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.entity.UserRightInfoVO;
import com.example.myapplication.widget.CustomDatePicker;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2018/5/16/016.
 */

public class FreestorageFragment extends Fragment implements View.OnClickListener {

    private EditText mEditText;
    private CustomDatePicker mCustomDatePicker;
    private String now;

    private TextView textView1, textView2;
    private ImageView imageView1;
    private LinearLayout linearLayout1;
    private Button button1;

    private ArrayList<UserRightInfoVO.ListBean.DataBean> infoVOS = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_freestorage, container, false);

//        mEditText = view.findViewById(R.id.fragment_freestorage_et);
        mEditText.setOnClickListener(this);

        textView1 = view.findViewById(R.id.freestorage_left_title_tv);
        textView2 = view.findViewById(R.id.freestorage_mobile_tv);
        imageView1 = view.findViewById(R.id.freestorage_isopen_iv);
        linearLayout1 = view.findViewById(R.id.freestorage_isopen_ll);
        button1 = view.findViewById(R.id.freestorage_bottom_btn);

        initDataPicker();

        postData1();
        return view;
    }

    private void postData1() {
        for (int i = 0; i < infoVOS.size(); i++) {
            String leftTitle = infoVOS.get(i).getLeftTitle();
            if (null != leftTitle) {
                textView1.setText(leftTitle);
            } else {
                textView1.setVisibility(View.GONE);
            }
        }
    }

    private void postData() {
        OkHttpClient client = new OkHttpClient();
        String url = "http://221.180.150.136:8102/AppServices-CMCC/rightsCenter/getUserRightsInfos?";
        FormBody.Builder formBody = new FormBody.Builder();
        formBody.add("mobileNum", "NLMjAxODA1MjMxMDMxNTI4MTEwMjAwOTg=xguM7Kucq5teo7IDdxKQ7uqD0x7jT6e/CHb2BNtLX3qrzUBxrUYM8cXd9uZz26E42j4JI8fJ82+Ii0/fDC8L5ehkW6/gODzk");
        formBody.build();
        Request request = new Request.Builder()
                .url(url)
                .post(formBody.build())
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String jsonData = response.body().string();
                try {
                    JSONObject jsonObject = new JSONObject(jsonData);
                    JSONObject jsonObject1 = jsonObject.getJSONObject("list");
                    JSONArray jsonArray = jsonObject1.getJSONArray("data");

                    final String leftTitle = jsonArray.getJSONObject(3).getString("leftTitle");
                    final String leftDesc = jsonArray.getJSONObject(3).getString("leftDesc");
                    String rightNumber = jsonArray.getJSONObject(3).getString("rightNumber");
                    final String rightTitle = jsonArray.getJSONObject(3).getString("rightTitle");
                    String bottomImgUrl = jsonArray.getJSONObject(3).getString("bottomImgUrl");
                    String rightImage = jsonArray.getJSONObject(3).getString("rightImage");
                    final String bottomBtnName = jsonArray.getJSONObject(3).getString("bottomBtnName");
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if ("" != leftTitle) {
                                textView1.setText(leftTitle);
                            } else {
                                textView1.setVisibility(View.GONE);
                            }
//                            if ("" != leftDesc) {
//                                textView2.setText(leftDesc);
//                            } else {
//                                textView2.setVisibility(View.GONE);
//                            }
                            imageView1.setVisibility(View.GONE);

//                            if ("" != rightNumber) {
//                                textView3.setText(rightNumber);
//                            } else {
//                            textView3.setVisibility(View.GONE);
//                            }
//                            if ("" != rightTitle) {
//                                textView4.setText(rightTitle);
//                            } else {
//                                textView4.setVisibility(View.GONE);
//                            }
//                            if ("" != rightImage) {
//                                Glide.with(getActivity())
//                                        .load(rightImage)
//                                        .asBitmap()
//                                        .placeholder(R.mipmap.ic_launcher)
//                                        .status_view_layout_error(R.mipmap.ic_launcher)
//                                        .fitCenter()
//                                        .into(imageView1);
//                            } else {
//                            imageView1.setVisibility(View.GONE);
//                            }

//                            imageView2.setVisibility(View.GONE);
                            if (null != bottomBtnName) {
                                button1.setText(bottomBtnName);
                            } else {
                                button1.setVisibility(View.GONE);
                            }
                        }
                    });

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
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
                            mEditText.setText(now.split(" ")[0]);
                        }
                    });
                    builder.setMessage("五年内有效");
                    builder.setCancelable(false);
                    builder.show();
                } else {
                    mEditText.setText(time.split(" ")[0]);
                }


            }
        }, "2010-01-01 00:00", "2049-12-31 00:00"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        mCustomDatePicker.showSpecificTime(false); // 不显示时和分
        mCustomDatePicker.setIsLoop(false); // 不允许循环滚动
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
//            case R.id.fragment_freestorage_et:
//                mCustomDatePicker.show(now);
//                break;
        }
    }
}
