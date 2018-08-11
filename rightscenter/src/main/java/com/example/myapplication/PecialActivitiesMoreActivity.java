package com.example.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.example.myapplication.adapter.MyPecialActivitiesMoreAdapter;
import com.example.myapplication.entity.PecialActivitiesEntity;

import java.util.List;

public class PecialActivitiesMoreActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<PecialActivitiesEntity.ActivitysBean> dataList;
    private MyPecialActivitiesMoreAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_pecial_activities_more);
        dataList = (List<PecialActivitiesEntity.ActivitysBean>) getIntent().getSerializableExtra("pecialData");

        initView();
    }


    private void initView() {
        mRecyclerView = findViewById(R.id.activity_pecial_activities_more_rv);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);

        adapter = new MyPecialActivitiesMoreAdapter(this, dataList);
        mRecyclerView.setAdapter(adapter);
    }
}
