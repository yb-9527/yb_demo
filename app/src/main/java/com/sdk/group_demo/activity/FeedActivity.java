package com.sdk.group_demo.activity;


import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.by.sdk.ad.feed.FeedAdListener;
import com.by.sdk.ad.feed.FeedAdLoader;
import com.by.sdk.ad.feed.FeedExpressAdInteractionListener;
import com.by.sdk.ad.feed.FeedInteractionListener;
import com.by.sdk.ad.feed.IFeedAd;
import com.by.sdk.byad.BYAdSlot;
import com.by.sdk.byad.utils.LogUtil;
import com.sdk.group_demo.R;
import com.sdk.group_demo.util.DataUtil;

import java.util.ArrayList;
import java.util.List;

public class FeedActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "FeedActivity";
    private RelativeLayout feedExpressContainer;
    private ImageView nativeImage;
    private TextView nativeTitle;
    private TextView nativeDesc;
    private LinearLayout nativeContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        initView();
    }

    private void initView() {
        findViewById(R.id.load_feed_express_btn).setOnClickListener(this);
        findViewById(R.id.load_feed_native_btn).setOnClickListener(this);
        feedExpressContainer = findViewById(R.id.feed_express_container);

        //native
        nativeContainer = findViewById(R.id.feed_native_container);
        nativeImage = findViewById(R.id.feed_native_imageview);
        nativeTitle = findViewById(R.id.feed_native_title);
        nativeDesc = findViewById(R.id.feed_native_desc);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.load_feed_express_btn:
                loadFeedExpressAd();
                break;
            case R.id.load_feed_native_btn:
                loadFeedNativeAd();
                break;
        }
    }

    private void loadFeedNativeAd() {
        loadAd(DataUtil.getFeedNativeData());
    }

    private void loadFeedExpressAd() {
        loadAd(DataUtil.getFeedExpressData());
    }

    /**
     * 自渲染和模板需要传入的jsonData不同
     * 加载成功以后需要通过iFeedAd.isFeedExpress()来判断，true为模板，false为自渲染
     * 自渲染需要通过feedAd来获取标题、描述、图片、视频等自己渲染
     * 模板广告回调onRenderSuccess渲染成功以后，通过iFeedAd.getExpressView()来获取模板View，然后添加到容器中
     * @param feedData
     */
    private void loadAd(String feedData) {
        BYAdSlot adSlot = new BYAdSlot.Builder()
                .setAdJsonData(feedData)
                .setFetchCount(1)
                .build();
        FeedAdLoader feedAdLoader = new FeedAdLoader(this, adSlot, new FeedAdListener() {

            @Override
            public void onLoadedSuccess(List<IFeedAd> adList) {
                if (adList!=null && !adList.isEmpty()){
                    IFeedAd iFeedAd = adList.get(0);
                    if (iFeedAd!=null){
                        LogUtil.d(TAG,"onLoadedSuccess,platform="+iFeedAd.getPlatform());
                        //判断如果是模板
                        if (iFeedAd.isFeedExpress()){
                            feedExpress(iFeedAd);
                        }else {
                            //如果是自渲染
                            feedNative(iFeedAd);
                        }
                    }


                }


            }

            @Override
            public void onLoadedError(int code, String msg) {
                LogUtil.d(TAG,"onLoadedError,code="+code+",msg="+msg);
            }
        });

        feedAdLoader.loadAd();
    }

    /**
     * 自渲染
     * @param iFeedAd
     */
    private void feedNative(IFeedAd iFeedAd) {
        List<View> clickViews = new ArrayList<>();
        clickViews.add(nativeContainer);
        iFeedAd.setNativeAdInteractionListener(new FeedInteractionListener() {
            @Override
            public void onAdClicked() {
                LogUtil.d(TAG,"native onAdClicked");
            }

            @Override
            public void onAdExposure() {
                LogUtil.d(TAG,"native onAdExposure");
            }

            @Override
            public void onAdClosed() {
            }
        });
        iFeedAd.bindViewForInteraction(this, nativeContainer, clickViews, null);
        List<String> imageList = iFeedAd.getImageList();
        if (imageList!=null && !imageList.isEmpty()){
            String s = imageList.get(0);
            Glide.with(this).load(s).into(nativeImage);
        }

        if (!TextUtils.isEmpty(iFeedAd.getTitle())){
            nativeTitle.setText(iFeedAd.getTitle());
        }
        if (!TextUtils.isEmpty(iFeedAd.getDescription())){
            nativeDesc.setText(iFeedAd.getDescription());
        }

    }

    private void feedExpress(IFeedAd iFeedAd) {
        iFeedAd.setExpressAdInteractionListener(new FeedExpressAdInteractionListener() {
            @Override
            public void onAdClicked() {
                LogUtil.d(TAG,"express onAdClicked");
            }

            @Override
            public void onAdExposure() {
                LogUtil.d(TAG,"express onAdExposure");
            }

            @Override
            public void onAdClosed() {
                LogUtil.d(TAG,"express onAdClosed");
            }

            @Override
            public void onRenderError(int errorCode, String errMsg) {
                LogUtil.d(TAG,"express onRenderError,code="+errorCode+",msg="+errMsg);
            }

            @Override
            public void onRenderSuccess() {
                View expressView = iFeedAd.getExpressView();
                LogUtil.d(TAG,"express onRenderSuccess,expressView="+expressView);
                feedExpressContainer.removeAllViews();
                feedExpressContainer.addView(expressView);
            }
        });
        iFeedAd.render(FeedActivity.this);
    }
}
