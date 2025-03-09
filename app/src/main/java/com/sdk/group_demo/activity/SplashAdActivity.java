package com.sdk.group_demo.activity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.by.sdk.ad.splash.ISplashAd;
import com.by.sdk.ad.splash.SplashAdListener;
import com.by.sdk.ad.splash.SplashAdLoader;
import com.by.sdk.ad.splash.SplashInteractionListener;
import com.by.sdk.byad.BYAdSlot;
import com.by.sdk.byad.utils.LogUtil;
import com.sdk.group_demo.R;
import com.sdk.group_demo.util.DataUtil;

public class SplashAdActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "SplashAdActivity";
    private RelativeLayout adContainer;
    private Button showAdBtn;
    private ISplashAd mSplashAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_ad);

        initView();
        initData();
    }



    private void initView() {
        adContainer = findViewById(R.id.adContainer);
        showAdBtn = findViewById(R.id.showAd);

        showAdBtn.setOnClickListener(this);
    }

    private void initData() {
        int showType = getIntent().getIntExtra("showType", SplashActivity.LOAD_AND_SHOW);
        if (showType == SplashActivity.LOAD_ONLY){
            loadAdOnly();
        }
    }

    private void loadAdOnly() {
        LogUtil.d(TAG,"loadAdOnly");
        DisplayMetrics dm = getResources().getDisplayMetrics();
        getWindowManager().getDefaultDisplay().getRealMetrics(dm);
        int bottomHeight = (int) (120 * dm.density);
        BYAdSlot adSlot = new BYAdSlot.Builder()
                .setAdJsonData(DataUtil.getSplashData())
                .setWidth(dm.widthPixels)
                .setHeight(dm.heightPixels-bottomHeight)
                .build();

        SplashAdLoader adLoader = new SplashAdLoader(this, adSlot, new SplashAdListener() {

            @Override
            public void onLoadedSuccess(ISplashAd splashAd) {
                LogUtil.d(TAG,"onLoadedSuccess");
            }

            @Override
            public void onLoadedError(int code, String msg) {
                LogUtil.d(TAG,"onLoadedError,code="+code+",msg="+msg);
            }

            @Override
            public void onRenderSuccess(ISplashAd splashAd) {
                LogUtil.d(TAG,"onRenderSuccess");
                showAdBtn.setVisibility(View.VISIBLE);
                mSplashAd = splashAd;

                mSplashAd.setInteractionListener(new SplashInteractionListener() {
                    @Override
                    public void onSkip(ISplashAd splashAd) {

                    }

                    @Override
                    public void onTimeOver(ISplashAd splashAd) {

                    }

                    @Override
                    public void onTick(long leftMillisecond) {

                    }

                    @Override
                    public void onAdClicked() {
                        LogUtil.d(TAG,"onAdClicked");
                    }

                    @Override
                    public void onAdExposure() {
                        LogUtil.d(TAG,"onAdExposure");
                    }

                    @Override
                    public void onAdClosed() {
                        LogUtil.d(TAG,"onAdClosed");
                        finish();
                    }
                });
            }

            @Override
            public void onRenderError(int code, String msg) {
                LogUtil.d(TAG,"onRenderError,code="+code+",msg="+msg);
            }
        },3500);

        adLoader.loadAd();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.showAd:
                if (mSplashAd!=null){
                    mSplashAd.showAd(adContainer);
                }
                break;
        }
    }
}