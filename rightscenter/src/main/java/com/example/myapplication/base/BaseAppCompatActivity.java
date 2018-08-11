package com.example.myapplication.base;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2018/6/25/025.
 */

public abstract class BaseAppCompatActivity extends AppCompatActivity implements View.OnTouchListener {

    /***是否显示标题栏*/
    private boolean isshowtitle;
    /***是否显示标题栏*/
    private boolean isshowstate;
    /***封装toast对象**/
    private static Toast toast;
    /***获取TAG的activity名称**/
    protected final String TAG = this.getClass().getSimpleName();

    private TextView title;

    private View decorView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (isshowtitle) {
            getSupportActionBar().show();
        } else {
            if (getSupportActionBar() != null) {
                getSupportActionBar().hide();
            }
        }

        if (isshowstate) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);

        } else {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
        }

        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS); //去除半透明状态栏
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN); //全屏显示
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }


        try {
            ViewPager.DecorView decordView = (ViewPager.DecorView) getWindow().getDecorView();     //获取DecorView实例
            Field field = ViewPager.DecorView.class.getDeclaredField("mSemiTransparentStatusBarColor");  //获取特定的成员变量
            field.setAccessible(true);   //设置对此属性的可访问性
            field.setInt(decordView, Color.TRANSPARENT);  //修改属性值
        } catch (Exception e) {
            e.printStackTrace();
        }

        //设置布局
        setContentView(intiLayout());
        //初始化控件
        initView();
        //设置数据
        initData();
        //设置监听
        initListener();
    }

    /**
     * 设置布局
     *
     * @return
     */
    public abstract int intiLayout();

    /**
     * 初始化布局
     */
    public abstract void initView();

    /**
     * 设置数据
     */
    public abstract void initData();

    /**
     * 设置监听
     */
    public abstract void initListener();

    /**
     * 是否设置标题栏
     *
     * @return
     */
    public void setTitle(boolean ishow) {
        isshowtitle = ishow;
    }

    /**
     * 设置是否显示状态栏
     *
     * @param ishow
     */
    public void setState(boolean ishow) {
        isshowstate = ishow;
    }

    /**
     * 显示长toast
     *
     * @param msg
     */
    public void toastLong(String msg) {
        if (null == toast) {
            toast = new Toast(this);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setText(msg);
            toast.show();
        } else {
            toast.setText(msg);
            toast.show();
        }
    }

    /**
     * 显示短toast
     *
     * @param msg
     */
    public void toastShort(String msg) {
        if (null == toast) {
            toast = new Toast(this);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setText(msg);
            toast.show();
        } else {
            toast.setText(msg);
            toast.show();
        }
    }

    /**
     * 设置title
     *
     * @param titleName
     */
    public void setTitleName(String titleName) {
        title = findViewById(R.id.titleName);
        title.setText(titleName);

    }

    /**
     * 设置title颜色
     *
     * @param color
     */
    public void setTitleColor(String color) {
        title.setTextColor(Color.parseColor(color));
    }

    /**
     * 设置返回按钮图片
     *
     * @param image
     */
    public void setBackIcon(@DrawableRes int image) {
        ImageView iv = findViewById(R.id.title_back_iv);
        iv.setBackgroundResource(image);
    }

    public void setToolbarBackground(String color) {
        Toolbar toolbar = findViewById(R.id.title_toolbar);
        toolbar.setBackgroundColor(Color.parseColor(color));
    }

    private void init() {
        int flag = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide
                | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        //判断当前版本在4.0以上并且存在虚拟按键，否则不做操作
        if (Build.VERSION.SDK_INT < 19 || !checkDeviceHasNavigationBar()) {
            //一定要判断是否存在按键，否则在没有按键的手机调用会影响别的功能。如之前没有考虑到，导致图传全屏变成小屏显示。
            return;
        } else {
            // 获取属性
            decorView.setSystemUiVisibility(flag);
        }
    }

    /**
     * 判断是否存在虚拟按键
     *
     * @return
     */
    public boolean checkDeviceHasNavigationBar() {
        boolean hasNavigationBar = false;
        Resources rs = getResources();
        int id = rs.getIdentifier("config_showNavigationBar", "bool", "android");
        if (id > 0) {
            hasNavigationBar = rs.getBoolean(id);
        }
        try {
            Class<?> systemPropertiesClass = Class.forName("android.os.SystemProperties");
            Method m = systemPropertiesClass.getMethod("get", String.class);
            String navBarOverride = (String) m.invoke(systemPropertiesClass, "qemu.hw.mainkeys");
            if ("1".equals(navBarOverride)) {
                hasNavigationBar = false;
            } else if ("0".equals(navBarOverride)) {
                hasNavigationBar = true;
            }
        } catch (Exception e) {

        }
        return hasNavigationBar;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

}
