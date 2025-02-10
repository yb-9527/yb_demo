package com.sdk.group_demo.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.sdk.group_demo.R;

public class SplashActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int LOAD_AND_SHOW =1;
    public static final int LOAD_ONLY = 2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();



    }

    private void initView() {
        findViewById(R.id.loadOnly).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.loadOnly:
                Intent intent1 = new Intent(this, SplashAdActivity.class);
                intent1.putExtra("showType",LOAD_ONLY);
                startActivity(intent1);
                break;
        }
    }


}