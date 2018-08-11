package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myapplication.adapter.MyInterestsDetailsRecyclerViewAdapter;
import com.example.myapplication.base.BaseAppCompatActivity;
import com.example.myapplication.constant.AppConstant;
import com.example.myapplication.entity.UserRightInfoVO;
import com.example.myapplication.view.EmptyLayout;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2018/5/20/020.
 */

public class MyFragmentActivity extends BaseAppCompatActivity implements View.OnClickListener {

    private InterestsDetailsFragment interestsDetailsFragment;

    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;

    private List<UserRightInfoVO.ListBean.DataBean> dataBeanList = new ArrayList<>();

    private RecyclerView mRecyclerView;
    private MyInterestsDetailsRecyclerViewAdapter adapter;
    private UserRightInfoVO.ListBean.DataBean infoVO;
    private String starLevel;
    private String realBalance;
    private ImageView backImageView;
    private String mobileNumUU;
    private EmptyLayout mEmptyLayout;

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0x111) {
                dataBeanList = (ArrayList<UserRightInfoVO.ListBean.DataBean>) msg.obj;
                adapter = new MyInterestsDetailsRecyclerViewAdapter(MyFragmentActivity.this, dataBeanList);
                mRecyclerView.setAdapter(adapter);
                setDefault();
                mEmptyLayout.hide();
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle(false);//设置是否显示标题栏
        setState(true);//设置是否显示状态栏
        //设置title名
        setTitleName("我的权益");
        //设置title颜色
        setTitleColor("#000000");
        //设置返回按钮图片
        setBackIcon(R.drawable.icon_back);
        //设置背景色
        setToolbarBackground("#ffffff");

        if (null != getSupportActionBar()) {
            getSupportActionBar().hide();
        }

        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
    }

    @Override
    public int intiLayout() {
        return R.layout.activity_myfragment;
    }

    @Override
    public void initView() {
        Intent intent = getIntent();
        mobileNumUU = intent.getStringExtra("mobileNumUU");
        mRecyclerView = findViewById(R.id.myfragment_recyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayout.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(manager);
        backImageView = findViewById(R.id.title_back_iv);
        backImageView.setOnClickListener(this);
        mEmptyLayout = findViewById(R.id.empty_layout);
//        mStatusView.setOnRetryListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                postData();
//            }
//        });
    }

    private void postData() {
        String url = AppConstant.httpAddress + AppConstant.interestsDetails;
        OkHttpUtils.post()
                .url(url)
                .addParams("mobileNum", mobileNumUU)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Gson gson = new Gson();
                        UserRightInfoVO entity = gson.fromJson(response, UserRightInfoVO.class);
                        dataBeanList = entity.getList().getData();

                        Message message = new Message();
                        message.what = 0x111;
                        message.obj = dataBeanList;
                        mHandler.sendMessage(message);
                    }
                });
    }

    private void setDefault() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        interestsDetailsFragment = new InterestsDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("dataList", (ArrayList<? extends Parcelable>) dataBeanList);
        bundle.putInt("position", getIntent().getIntExtra("position", -1));
        bundle.putString("starLevel", getIntent().getStringExtra("starLevel"));
        bundle.putString("mobileNum", getIntent().getStringExtra("mobileNum"));
        bundle.putString("mobileNumUU", getIntent().getStringExtra("mobileNumUU"));
        bundle.putString("realBalance", getIntent().getStringExtra("realBalance"));
        interestsDetailsFragment.setArguments(bundle);
        transaction.replace(R.id.fragment_content_fl, interestsDetailsFragment);
        transaction.commit();

        adapter.changeSelected(getIntent().getIntExtra("position", -1));
        mRecyclerView.scrollToPosition(getIntent().getIntExtra("position", -1));

    }

    public void onItemClick(View view) {
        int childAdapterPosition = mRecyclerView.getChildAdapterPosition(view);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();

        interestsDetailsFragment = new InterestsDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("dataList", (ArrayList<? extends Parcelable>) dataBeanList);
        bundle.putInt("position", childAdapterPosition);
        bundle.putString("starLevel", getIntent().getStringExtra("starLevel"));
        bundle.putString("mobileNum", getIntent().getStringExtra("mobileNum"));
        bundle.putString("mobileNumUU", getIntent().getStringExtra("mobileNumUU"));
        bundle.putString("realBalance", getIntent().getStringExtra("realBalance"));
        bundle.putString("derdge", getIntent().getStringExtra("derdge"));
        interestsDetailsFragment.setArguments(bundle);
        transaction.replace(R.id.fragment_content_fl, interestsDetailsFragment);
        transaction.commit();

        adapter.changeSelected(childAdapterPosition);
    }

    @Override
    public void initData() {
        mEmptyLayout.showLoading();
        postData();
    }

    @Override
    public void initListener() {

    }

    @Override
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.title_back_iv) {
            finish();

        }
    }
}
