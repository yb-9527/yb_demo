package com.sdk.group_demo.util;

import com.by.sdk.byad.bean.BYAdInfo;
import com.by.sdk.byad.utils.BYAdContanst;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class DataUtil {

    public static String getBannerData(){
        List<BYAdInfo> list = new ArrayList<>();
        BYAdInfo info = new BYAdInfo();
        info.setPlatformName(BYAdContanst.PLATFROM_CSJ);
        info.setAppId("5001121");
        info.setPid("901121700");
        info.setPriority(1);
        list.add(info);

        BYAdInfo gdtInfo = new BYAdInfo();
        gdtInfo.setPlatformName(BYAdContanst.PLATFROM_GDT);
        gdtInfo.setAppId("1101152570");
        gdtInfo.setPid("4080052898050840");
        gdtInfo.setPriority(2);
        list.add(gdtInfo);


        Gson gson = new Gson();
        return gson.toJson(list);
    }
    public static String getSplashData(){
        List<BYAdInfo> list = new ArrayList<>();
        BYAdInfo info = new BYAdInfo();
        info.setPlatformName(BYAdContanst.PLATFROM_CSJ);
        info.setAppId("5001121");
        info.setPid("801121648");
        info.setPriority(1);
        list.add(info);

        BYAdInfo gdtInfo = new BYAdInfo();
        gdtInfo.setPlatformName(BYAdContanst.PLATFROM_GDT);
        gdtInfo.setAppId("1101152570");
        gdtInfo.setPid("9093517612222759");
        gdtInfo.setPriority(1);
        list.add(gdtInfo);

        BYAdInfo bdInfo = new BYAdInfo();
        bdInfo.setPlatformName(BYAdContanst.PLATFROM_BD);
        bdInfo.setAppId("e866cfb0");
        bdInfo.setPid("2058622");
        bdInfo.setPriority(1);
        list.add(bdInfo);

        BYAdInfo ksInfo = new BYAdInfo();
        ksInfo.setPlatformName(BYAdContanst.PLATFROM_KS);
        ksInfo.setAppId("90009");
        ksInfo.setPid("4000000042");
        ksInfo.setPriority(1);
        list.add(ksInfo);


        Gson gson = new Gson();
        return gson.toJson(list);
    }


    public static String getRewardData(){
        List<BYAdInfo> list = new ArrayList<>();
        BYAdInfo info = new BYAdInfo();
        info.setPlatformName(BYAdContanst.PLATFROM_CSJ);
        info.setAppId("5001121");
        info.setPid("901121593");
        info.setPriority(1);
        list.add(info);

        BYAdInfo gdtInfo = new BYAdInfo();
        gdtInfo.setPlatformName(BYAdContanst.PLATFROM_GDT);
        gdtInfo.setAppId("1101152570");
        gdtInfo.setPid("4000898212322043");
        gdtInfo.setPriority(1);
        list.add(gdtInfo);

        BYAdInfo bdInfo = new BYAdInfo();
        bdInfo.setPlatformName(BYAdContanst.PLATFROM_BD);
        bdInfo.setAppId("e866cfb0");
        bdInfo.setPid("5925490");
        bdInfo.setPriority(1);
        list.add(bdInfo);

        BYAdInfo ksInfo = new BYAdInfo();
        ksInfo.setPlatformName(BYAdContanst.PLATFROM_KS);
        ksInfo.setAppId("90009");
        ksInfo.setPid("90009001");
        ksInfo.setPriority(1);
        list.add(ksInfo);


        Gson gson = new Gson();
        return gson.toJson(list);
    }


    public static String getIntertitialData(){
        List<BYAdInfo> list = new ArrayList<>();
        BYAdInfo info = new BYAdInfo();
        info.setPlatformName(BYAdContanst.PLATFROM_CSJ);
        info.setAppId("5001121");
        info.setPid("947793385");
        info.setPriority(1);
        list.add(info);

        BYAdInfo gdtInfo = new BYAdInfo();
        gdtInfo.setPlatformName(BYAdContanst.PLATFROM_GDT);
        gdtInfo.setAppId("1101152570");
        gdtInfo.setPid("4080298282218338");
        gdtInfo.setPriority(1);
        list.add(gdtInfo);

        BYAdInfo bdInfo = new BYAdInfo();
        bdInfo.setPlatformName(BYAdContanst.PLATFROM_BD);
        bdInfo.setAppId("e866cfb0");
        bdInfo.setPid("2403633");
        bdInfo.setPriority(1);
        list.add(bdInfo);

        BYAdInfo ksInfo = new BYAdInfo();
        ksInfo.setPlatformName(BYAdContanst.PLATFROM_KS);
        ksInfo.setAppId("90009");
        ksInfo.setPid("4000000276");
        ksInfo.setPriority(1);
        list.add(ksInfo);


        Gson gson = new Gson();
        return gson.toJson(list);
    }


    public static String getFeedExpressData(){
        List<BYAdInfo> list = new ArrayList<>();
        BYAdInfo info = new BYAdInfo();
        info.setPlatformName(BYAdContanst.PLATFROM_CSJ);
        info.setAppId("5001121");
        info.setPid("901121253");//自渲染和模板广告位不同
        info.setFeedType(2);//模板feedType=2
        info.setPriority(1);
        list.add(info);

        BYAdInfo gdtInfo = new BYAdInfo();
        gdtInfo.setPlatformName(BYAdContanst.PLATFROM_GDT);
        gdtInfo.setAppId("1101152570");
        gdtInfo.setPid("7030020348049331");
        gdtInfo.setFeedType(2);
        gdtInfo.setPriority(1);
        list.add(gdtInfo);

        BYAdInfo bdInfo = new BYAdInfo();
        bdInfo.setPlatformName(BYAdContanst.PLATFROM_BD);
        bdInfo.setAppId("e866cfb0");
        bdInfo.setPid("8035132");
        bdInfo.setFeedType(2);
        bdInfo.setPriority(1);
        list.add(bdInfo);

        BYAdInfo ksInfo = new BYAdInfo();
        ksInfo.setPlatformName(BYAdContanst.PLATFROM_KS);
        ksInfo.setAppId("90009");
        ksInfo.setPid("4000000004");
        ksInfo.setFeedType(2);
        ksInfo.setPriority(1);
        list.add(ksInfo);


        Gson gson = new Gson();
        return gson.toJson(list);
    }

    public static String getFeedNativeData(){
        List<BYAdInfo> list = new ArrayList<>();
        BYAdInfo info = new BYAdInfo();
        info.setPlatformName(BYAdContanst.PLATFROM_CSJ);
        info.setAppId("5001121");
        info.setPid("901121737");//自渲染和模板广告位不同
        info.setFeedType(1);//自渲染feedType=1
        info.setPriority(1);
        list.add(info);

        BYAdInfo gdtInfo = new BYAdInfo();
        gdtInfo.setPlatformName(BYAdContanst.PLATFROM_GDT);
        gdtInfo.setAppId("1101152570");
        gdtInfo.setPid("9091145780212745");
        gdtInfo.setFeedType(1);//自渲染feedType=1
        gdtInfo.setPriority(1);
        list.add(gdtInfo);

        BYAdInfo bdInfo = new BYAdInfo();
        bdInfo.setPlatformName(BYAdContanst.PLATFROM_BD);
        bdInfo.setAppId("e866cfb0");
        bdInfo.setPid("2058628");
        bdInfo.setFeedType(1);//自渲染feedType=1
        bdInfo.setPriority(1);
        list.add(bdInfo);

        BYAdInfo ksInfo = new BYAdInfo();
        ksInfo.setPlatformName(BYAdContanst.PLATFROM_KS);
        ksInfo.setAppId("90009");
        ksInfo.setPid("4000001377");
        ksInfo.setFeedType(1);//自渲染feedType=1
        ksInfo.setPriority(2);
        list.add(ksInfo);


        Gson gson = new Gson();
        return gson.toJson(list);
    }

}
