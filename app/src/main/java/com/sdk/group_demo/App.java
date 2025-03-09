package com.sdk.group_demo;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;

import com.by.sdk.byad.BYAdConfig;
import com.by.sdk.byad.BYAdSdk;


public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        BYAdSdk.init(this, buildConfig());
    }

    private BYAdConfig buildConfig() {
        return new BYAdConfig.Builder()
                .setAppId("111")
                .setEnableDebug(true)
                .customController(new BYAdConfig.CustomController() {

                    @Override
                    public boolean isCanUsePersonalRecommend() {
                        return super.isCanUsePersonalRecommend();
                    }

                    @Override
                    public boolean isCanUseLocation() {
                        return super.isCanUseLocation();
                    }



                    @Override
                    public boolean isCanUsePhoneState() {
                        return super.isCanUsePhoneState();
                    }


                    @Override
                    public boolean isCanUseImsi() {
                        return super.isCanUseImsi();
                    }

                    @Override
                    public boolean isCanUseWifiState() {
                        return super.isCanUseWifiState();
                    }


                    @Override
                    public boolean isCanUseAndroidId() {
                        return super.isCanUseAndroidId();
                    }

                    @Override
                    public String getAndroidId() {
                        return super.getAndroidId();
                    }

                    @Override
                    public boolean canUseMacAddress() {
                        return super.canUseMacAddress();
                    }

                    @Override
                    public boolean canUseNetworkState() {
                        return super.canUseNetworkState();
                    }

                    @Override
                    public boolean canUseStoragePermission() {
                        return super.canUseStoragePermission();
                    }

                    @Override
                    public boolean canReadInstalledPackages() {
                        return super.canReadInstalledPackages();
                    }


                })
                .build();
    }

    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }
}
