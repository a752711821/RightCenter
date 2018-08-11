package com.example.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.myapplication.adapter.DxtqMoreAdapter;
import com.example.myapplication.base.BaseAppCompatActivity;
import com.example.myapplication.entity.EnjoyGoodsEntity;

import java.util.ArrayList;
import java.util.List;

public class DxtqMoreActivity extends BaseAppCompatActivity implements View.OnClickListener {


    private RecyclerView mRecyclerView;
    private ArrayList<EnjoyGoodsEntity.ObjBean> objBeanList = new ArrayList<>();
    private DxtqMoreAdapter adapter;
    private ImageView mBackIv;

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

    }

    @Override
    public int intiLayout() {
        return R.layout.activity_dxtq_more;
    }

    @Override
    public void initView() {
        mRecyclerView = findViewById(R.id.activity_dxtq_more_rv);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);
        mBackIv = findViewById(R.id.title_back_iv);
    }

    @Override
    public void initData() {
        objBeanList = getIntent().getParcelableArrayListExtra("dxtqData");
        adapter = new DxtqMoreAdapter(this, objBeanList);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void initListener() {
        mBackIv.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.title_back_iv) {
            finish();

        }
    }
}
