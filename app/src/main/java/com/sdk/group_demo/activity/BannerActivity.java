package com.sdk.group_demo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.by.sdk.ad.InteractionListener;
import com.by.sdk.ad.banner.BannerAdListener;
import com.by.sdk.ad.banner.BannerAdLoader;
import com.by.sdk.ad.banner.IBannerAd;
import com.by.sdk.byad.BYAdSlot;
import com.by.sdk.byad.utils.LogUtil;
import com.sdk.group_demo.R;
import com.sdk.group_demo.util.DataUtil;

public class BannerActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "BannerActivity";
    private RelativeLayout bannerContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_ad);

        initView();
    }

    private void initView() {
        findViewById(R.id.load_banner).setOnClickListener(this);
        bannerContainer = findViewById(R.id.banner_container);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.load_banner){
            loadBanner();
        }
    }

    private void loadBanner() {

        BYAdSlot adSlot = new BYAdSlot.Builder()
                .setAdJsonData(DataUtil.getBannerData())
                .build();
        BannerAdLoader loader = new BannerAdLoader(this, adSlot, new BannerAdListener() {
            @Override
            public void onLoadedSuccess(IBannerAd iBannerAd) {
                LogUtil.d(TAG,"onLoadedSuccess");
            }

            @Override
            public void onLoadedError(int code, String msg) {
                LogUtil.d(TAG,"onLoadedError: code="+code+",msg="+msg);
            }

            @Override
            public void onRenderSuccess(IBannerAd iBannerAd) {
                LogUtil.d(TAG,"onRenderSuccess");
                if (iBannerAd!=null){
                    iBannerAd.setInteractionListener(new InteractionListener() {
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
                if (bannerContainer!=null){
                    bannerContainer.removeAllViews();
                    iBannerAd.showAd(bannerContainer);
                }
            }

            @Override
            public void onRenderError(int code, String msg) {
                LogUtil.d(TAG,"onRenderError: code="+code+",msg="+msg);
            }
        });
        loader.loadAd();
    }
}
