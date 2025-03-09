package com.sdk.group_demo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.sdk.group_demo.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        Button splashBtn = findViewById(R.id.activity_main_splash);
        Button rewardBtn = findViewById(R.id.activity_main_reward);
        Button intertitialBtn = findViewById(R.id.activity_main_intertitial);
        Button feedBtn = findViewById(R.id.activity_main_feed);
        Button bannerBtn = findViewById(R.id.activity_main_banner);

        splashBtn.setOnClickListener(this);
        rewardBtn.setOnClickListener(this);
        intertitialBtn.setOnClickListener(this);
        feedBtn.setOnClickListener(this);
        bannerBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_main_splash:
                Intent intent = new Intent(this, SplashActivity.class);
                startActivity(intent);
                break;
            case R.id.activity_main_reward:
                intent = new Intent(this, RewardActivity.class);
                startActivity(intent);
                break;
            case R.id.activity_main_intertitial:
                intent = new Intent(this, IntertitialActivity.class);
                startActivity(intent);
                break;
            case R.id.activity_main_feed:
                intent = new Intent(this, FeedActivity.class);
                startActivity(intent);
                break;
            case R.id.activity_main_banner:
                intent = new Intent(this, BannerActivity.class);
                startActivity(intent);
                break;
        }
    }
}