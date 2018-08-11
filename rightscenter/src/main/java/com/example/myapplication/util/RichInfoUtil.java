package com.example.myapplication.util;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.example.myapplication.MainActivity;
import com.example.myapplication.linstener.IRichInfoCallback;

public class RichInfoUtil {

    private static RichInfoUtil instance;

    private RichInfoUtil() {
    }

    public static RichInfoUtil getInstance() {

        if (instance == null) {
            instance = new RichInfoUtil();
        }
        return instance;
    }

    private IRichInfoCallback callback;

    public void setStartActivity(IRichInfoCallback callback) {
        this.callback = callback;
    }


    public RichInfoUtil(String mobileNum, String citycode, String num, String page, String starlv) {
        this.mobileNum = mobileNum;
        this.citycode = citycode;
        this.num = num;
        this.page = page;
        this.starlv = starlv;
    }

    public void createA(AppCompatActivity activity) {
        Intent intent = new Intent(activity, MainActivity.class);

        intent.putExtra("mobileNumUU", mobileNum);

        activity.startActivity(intent);
    }

    //顶部导航
    public void setDbdhParameter(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    //专享活动
    String mobileNum;
    private String citycode;
    private String num;
    private String page;
    private String starlv;

    public void setZxhdParameter(String mobileNum, String citycode, String num, String page, String starlv) {
        this.mobileNum = mobileNum;
        this.citycode = citycode;
        this.num = num;
        this.page = page;
        this.starlv = starlv;
    }

    //独享特权
    private String arType;
    private String areaCode;
    private String bgnPos;
    private String dicId;
    private String payType;
    private String sortType;
    private String userStarLvLimit;

    public void setDxtqParameter(String arType, String areaCode, String bgnPos, String dicId, String payType, String sortType, String userStarLvLimit) {
        this.arType = arType;
        this.areaCode = areaCode;
        this.bgnPos = bgnPos;
        this.dicId = dicId;
        this.payType = payType;
        this.sortType = sortType;
        this.userStarLvLimit = userStarLvLimit;
    }

    //乐享周边
    public void setLxzbParameter(String areaCode) {
        this.areaCode = areaCode;
    }

    //惠享商品
    public void setHxspParameter(String arType, String areaCode, String bgnPos, String dicId, String payType, String sortType, String userStarLvLimit) {
        this.arType = arType;
        this.areaCode = areaCode;
        this.bgnPos = bgnPos;
        this.dicId = dicId;
        this.payType = payType;
        this.sortType = sortType;
        this.userStarLvLimit = userStarLvLimit;
    }
}
