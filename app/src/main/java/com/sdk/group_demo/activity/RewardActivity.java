package com.sdk.group_demo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.by.sdk.ad.reward.IRewardAd;
import com.by.sdk.ad.reward.RewardAdListener;
import com.by.sdk.ad.reward.RewardAdLoader;
import com.by.sdk.ad.reward.RewardInteractionListener;
import com.by.sdk.byad.BYAdSlot;
import com.by.sdk.byad.utils.LogUtil;
import com.sdk.group_demo.R;
import com.sdk.group_demo.util.DataUtil;

import java.util.Map;

public class RewardActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "RewardActivity";

    private IRewardAd rewardAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reward);
        initView();



    }

    private void initView() {
        findViewById(R.id.loadReward).setOnClickListener(this);
        findViewById(R.id.showAd).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.loadReward:
                loadRewardAd();
                break;
            case R.id.showAd:
                if (rewardAd!=null){
                    rewardAd.showAd(this);
                }
                break;
        }
    }

    private void loadRewardAd() {
        BYAdSlot adSlot = new BYAdSlot.Builder()
                .setAdJsonData(DataUtil.getRewardData())
                .setIsMute(true)
                .build();
        RewardAdLoader loader = new RewardAdLoader(this,adSlot, new RewardAdListener() {
            @Override
            public void onLoadedSuccess(IRewardAd iRewardAd) {
                LogUtil.d(TAG,"onLoadedSuccess");
                rewardAd = iRewardAd;
                if (rewardAd!=null){
                    Toast.makeText(RewardActivity.this,"激励视频广告加载成功",Toast.LENGTH_SHORT).show();
                    rewardAd.setInteractionListener(new RewardInteractionListener() {
                        @Override
                        public void onReward(Map<String, Object> map) {
                            LogUtil.d(TAG,"onReward");
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
                        }
                    });
                }
            }

            @Override
            public void onLoadedError(int code, String msg) {
                LogUtil.d(TAG,"onLoadedError,code="+code+",msg="+msg);
            }

            @Override
            public void onRenderSuccess(IRewardAd iRewardAd) {
                LogUtil.d(TAG,"onRenderSuccess");
            }

            @Override
            public void onRenderError(int code, String msg) {
                LogUtil.d(TAG,"onRenderError,code="+code+",msg="+msg);
            }
        });
        loader.loadAd();
    }
}
