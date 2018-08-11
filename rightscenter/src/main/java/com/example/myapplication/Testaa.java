package com.example.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Testaa extends AppCompatActivity implements InterestsDetailsFragment.CallBack {

    TextView textView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testactivity);
        textView = findViewById(R.id.testactivitytv);
        InterestsDetailsFragment fragment = new InterestsDetailsFragment();
        fragment.getEditText(this);
    }


    @Override
    public void getResult(String result) {
        textView.setText(result);
    }
}
