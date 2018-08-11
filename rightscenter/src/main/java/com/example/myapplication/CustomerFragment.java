package com.example.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.myapplication.entity.UserRightInfoVO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2018/5/16/016.
 */

public class CustomerFragment extends Fragment {
    private TextView textView1, textView2, textView3, textView4;
    private ImageView imageView1, imageView2;
    private Button button1;

    private ArrayList<UserRightInfoVO.ListBean.DataBean> infoVOS = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_birthday_test, container, false);

        initView(view);

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

    private void initView(View view) {
        textView1 = view.findViewById(R.id.test_left_title_tv);
        textView2 = view.findViewById(R.id.test_left_content_tv);
        textView3 = view.findViewById(R.id.test_right_title_tv);
        textView4 = view.findViewById(R.id.test_right_content_tv);
        imageView1 = view.findViewById(R.id.test_right_image_iv);
//        imageView2 = view.findViewById(R.id.test_center_image_iv);
        button1 = view.findViewById(R.id.test_bottom_btn);
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

                    final String leftTitle = jsonArray.getJSONObject(2).getString("leftTitle");
                    final String leftDesc = jsonArray.getJSONObject(2).getString("leftDesc");
                    final String rightNumber = jsonArray.getJSONObject(2).getString("rightNumber");
                    final String rightTitle = jsonArray.getJSONObject(2).getString("rightTitle");
                    String bottomImgUrl = jsonArray.getJSONObject(2).getString("bottomImgUrl");
                    final String rightImage = jsonArray.getJSONObject(2).getString("rightImage");
                    final String bottomBtnName = jsonArray.getJSONObject(2).getString("bottomBtnName");
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if ("" != leftTitle) {
                                textView1.setText(leftTitle);
                            } else {
                                textView1.setVisibility(View.GONE);
                            }
                            if ("" != leftDesc) {
                                textView2.setText(leftDesc);
                            } else {
                                textView2.setVisibility(View.GONE);
                            }
//                            if ("" != rightNumber) {
//                                textView3.setText(rightNumber);
//                            } else {
                            textView3.setVisibility(View.GONE);
//                            }
//                            if ("" != rightTitle) {
//                                textView4.setText(rightTitle);
//                            } else {
                            textView4.setVisibility(View.GONE);
//                            }
                            if ("" != rightImage) {
                                Glide.with(getActivity())
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

                            imageView2.setVisibility(View.GONE);
                            if ("" != bottomBtnName) {
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
}
