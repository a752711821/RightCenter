package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.util.RichInfoUtil;

/**
 * Created by Administrator on 2018/5/28/028.
 */

public class IndexActivity extends AppCompatActivity {

    private EditText indexEt;
    private Button indexBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        indexEt = findViewById(R.id.index_et);
        indexBtn = findViewById(R.id.index_btn);
        indexBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IndexActivity.this, MainActivity.class);

                intent.putExtra("mobileNumUU", indexEt.getText().toString());

                startActivity(intent);

//                new RichInfoUtil(indexEt.getText().toString(), "240", "1", "1", "1").createA(activity);
            }
        });
    }


}
