package com.sdk.group_demo;

import android.app.Application;
import android.content.Context;
import android.location.Location;

import androidx.multidex.MultiDex;


import com.by.sdk.core.BYAdConfig;
import com.by.sdk.core.BYAdSdk;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        BYAdConfig config = new BYAdConfig.Builder()
                .setAppId("111")
                .setEnableDebug(true)
                .customController(new BYAdConfig.CustomController() {
                    @Override
                    public String getOaid() {
                        return super.getOaid();
                    }

                    @Override
                    public boolean isCanUsePersonalRecommend() {
                        return super.isCanUsePersonalRecommend();
                    }

                    @Override
                    public boolean isCanUseLocation() {
                        return super.isCanUseLocation();
                    }


                    @Override
                    public Location getLocation() {
                        return super.getLocation();
                    }

                    @Override
                    public boolean isCanUsePhoneState() {
                        return super.isCanUsePhoneState();
                    }

                    @Override
                    public String getDevImei() {
                        return super.getDevImei();
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
                    public String getMacAddress() {
                        return super.getMacAddress();
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


                    @Override
                    public boolean isCanUsePermissionRecordAudio() {
                        return super.isCanUsePermissionRecordAudio();
                    }
                })
                .build();
        BYAdSdk.init(this, config);
    }

    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }
}
