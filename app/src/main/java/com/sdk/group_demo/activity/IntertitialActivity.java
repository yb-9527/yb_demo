package com.sdk.group_demo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.by.sdk.ad.intertitial.IIntertitialAd;
import com.by.sdk.ad.intertitial.IntertitialAdListener;
import com.by.sdk.ad.intertitial.IntertitialAdLoader;
import com.by.sdk.ad.intertitial.IntertitialInteractionListener;
import com.by.sdk.byad.BYAdSlot;
import com.by.sdk.byad.utils.LogUtil;
import com.sdk.group_demo.R;
import com.sdk.group_demo.util.DataUtil;

public class IntertitialActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "IntertitialActivity";
    private IIntertitialAd mIntertitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intertitial);
        initView();
    }

    private void initView() {
        findViewById(R.id.loadIntertitial).setOnClickListener(this);
        findViewById(R.id.showAd).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.loadIntertitial:
                loadIntertitialAd();
                break;
            case R.id.showAd:
                showAd();
                break;
        }
    }

    private void showAd() {
        if (mIntertitialAd!=null){
            mIntertitialAd.showAd(this);
        }
    }

    private void loadIntertitialAd() {
        BYAdSlot adSlot = new BYAdSlot.Builder()
                .setAdJsonData(DataUtil.getIntertitialData())
                .build();
        IntertitialAdLoader loader = new IntertitialAdLoader(this,adSlot, new IntertitialAdListener() {
            @Override
            public void onLoadedSuccess(IIntertitialAd iIntertitialAd) {
                LogUtil.d(TAG,"onLoadedSuccess");
                Toast.makeText(IntertitialActivity.this,"插屏广告加载成功",Toast.LENGTH_SHORT).show();
                mIntertitialAd = iIntertitialAd;
                iIntertitialAd.setInteractionListener(new IntertitialInteractionListener() {
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
                    }
                });
            }

            @Override
            public void onLoadedError(int code, String msg) {
                LogUtil.d(TAG,"onLoadedError code="+code+",msg="+msg);
            }

            @Override
            public void onRenderSuccess(IIntertitialAd iIntertitialAd) {
                LogUtil.d(TAG,"onRenderSuccess");
            }

            @Override
            public void onRenderError(int code, String msg) {
                LogUtil.d(TAG,"onRenderError code="+code+",msg="+msg);
            }
        });
        loader.loadAd();
    }
}
