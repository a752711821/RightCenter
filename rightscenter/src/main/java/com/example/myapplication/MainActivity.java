package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.myapplication.adapter.MyInterestsDetailsRecyclerViewAdapter;
import com.example.myapplication.adapter.MyMainRecyclerViewAdapter;
import com.example.myapplication.adapter.MyPecialActivitiesAdapter;
import com.example.myapplication.adapter.MyRecyclerViewAdapter;
import com.example.myapplication.base.BaseAppCompatActivity;
import com.example.myapplication.constant.AppConstant;
import com.example.myapplication.entity.EnjoyGoodsEntity;
import com.example.myapplication.entity.LxzbEntity;
import com.example.myapplication.entity.NewEntity;
import com.example.myapplication.entity.PecialActivitiesEntity;
import com.example.myapplication.linstener.IRichInfoCallback;
import com.example.myapplication.view.EmptyLayout;
import com.google.gson.Gson;
import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MainActivity extends BaseAppCompatActivity implements View.OnClickListener {

    private ProgressBar mProgressBar;

    private ImageView mCircleIv1, mCircleIv2, mCircleIv3;
    private TextView contentTv1, contentTv2, contentTv3;
    private ImageView yuanxingIv1, yuanxingIv2, yuanxingIv3, yuanxingIv4;
    private TextView titleTv1, titleTv2, titleTv3, titleTv4;
    private RecyclerView mRecyclerView, mRecyclerView1;
    private List<EnjoyGoodsEntity.ObjBean> mDatas;
    private List<PecialActivitiesEntity.ActivitysBean> mDatas1;
    private MyRecyclerViewAdapter adapter;
    private MyPecialActivitiesAdapter pAdapter;
    private MyInterestsDetailsRecyclerViewAdapter adapter1;
    private LinearLayout mIntegralLl, mOverdraftLl, mFreestorageLl, mChangedcardLl, mCustomerLl, mSixLl;

    private ImageView imageView1, imageView2, imageView3, imageView4, imageView5, imageView6;
    private TextView textView1, textView2, textView3, textView4, textView5, textView6;

    private List<NewEntity> newEntityList = new ArrayList<>();

    private RecyclerView mainRecyclerView;
    private MyMainRecyclerViewAdapter mainAdapter;

    private StatusViewLayout mStatusView;

    private String starLevel;
    private String mobileNum;
    private String realBalance;
    private String derdge;

    private String mobileNumUU;

    private LinearLayout mainTopLl;

    private List<EnjoyGoodsEntity> dataList;

    private TextView moreTv;
    private TextView dxtqMoreTv;
    private PullToRefreshLayout refreshLayout;

    private LinearLayout mActivityLl;
    private List<PecialActivitiesEntity.ActivitysBean> activitysBeanList = new ArrayList<>();
    private List<EnjoyGoodsEntity.ObjBean> objBeanList;
    private ArrayList<EnjoyGoodsEntity.ObjBean> dxtqObjBeanList;
    private List<LxzbEntity.ListBean.BusinessBean> businessBeanList = new ArrayList<>();

    private EmptyLayout mEmptyLayout;
    private ImageView mBackIv;
    private LinearLayout mLxzbLl;
    private LxzbEntity entity;


    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0x111:
                    newEntityList = (List<NewEntity>) msg.obj;
                    mainAdapter = new MyMainRecyclerViewAdapter(MainActivity.this, newEntityList);
                    mainRecyclerView.setAdapter(mainAdapter);
                    mainTopLl.setVisibility(starLevel.equals("9") || starLevel.equals("9") || starLevel.equals("0") ? View.VISIBLE : View.GONE);
                    break;
                case 0x112:
                    adapter = new MyRecyclerViewAdapter(MainActivity.this, objBeanList);
                    mRecyclerView.setAdapter(adapter);

                    break;
                case 0x113:
                    String show = (String) msg.obj;
                    if (show.equals("0")) {
                        pAdapter = new MyPecialActivitiesAdapter(MainActivity.this, activitysBeanList);
                        mRecyclerView1.setAdapter(pAdapter);
                    }
                    if (show.equals("1")) {
                        mActivityLl.setVisibility(View.GONE);
                    }
                    break;
                case 0x114:
                    //独享授权开始
                    Glide.with(MainActivity.this)
                            .load(dxtqObjBeanList.get(0).getArImagePath())
                            .asBitmap()
                            .centerCrop()
                            .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                            .into(new BitmapImageViewTarget(mCircleIv1) {
                                @Override
                                protected void setResource(Bitmap resource) {
                                    RoundedBitmapDrawable circularBitmapDrawable =
                                            RoundedBitmapDrawableFactory.create(getResources(), resource);
                                    circularBitmapDrawable.setCircular(true);
                                    mCircleIv1.setImageDrawable(circularBitmapDrawable);
                                }
                            });
                    contentTv1.setText(dxtqObjBeanList.get(0).getArName());
                    Glide.with(MainActivity.this)
                            .load(dxtqObjBeanList.get(1).getArImagePath())
                            .asBitmap()
                            .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                            .centerCrop()
                            .into(new BitmapImageViewTarget(mCircleIv2) {
                                @Override
                                protected void setResource(Bitmap resource) {
                                    RoundedBitmapDrawable circularBitmapDrawable =
                                            RoundedBitmapDrawableFactory.create(getResources(), resource);
                                    circularBitmapDrawable.setCircular(true);
                                    mCircleIv2.setImageDrawable(circularBitmapDrawable);
                                }
                            });
                    contentTv2.setText(dxtqObjBeanList.get(1).getArName());
                    Glide.with(MainActivity.this)
                            .load(dxtqObjBeanList.get(2).getArImagePath())
                            .asBitmap()
                            .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                            .centerCrop()
                            .into(new BitmapImageViewTarget(mCircleIv3) {
                                @Override
                                protected void setResource(Bitmap resource) {
                                    RoundedBitmapDrawable circularBitmapDrawable =
                                            RoundedBitmapDrawableFactory.create(getResources(), resource);
                                    circularBitmapDrawable.setCircular(true);
                                    mCircleIv3.setImageDrawable(circularBitmapDrawable);
                                }
                            });
                    contentTv3.setText(dxtqObjBeanList.get(2).getArName());
                    //独享授权结束
                    break;
                case 0x115:
                    if (entity.getList().getShow().equals("0")) {
                        mLxzbLl.setVisibility(View.GONE);
                    }
                    if (entity.getList().getShow().equals("1")) {
                        Glide.with(MainActivity.this)
                                .load(businessBeanList.get(0).getStorePicture())
                                .asBitmap()
                                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                                .centerCrop()
                                .into(new BitmapImageViewTarget(yuanxingIv1) {
                                    @Override
                                    protected void setResource(Bitmap resource) {
                                        RoundedBitmapDrawable circularBitmapDrawable =
                                                RoundedBitmapDrawableFactory.create(getResources(), resource);
                                        circularBitmapDrawable.setCircular(true);
                                        yuanxingIv1.setImageDrawable(circularBitmapDrawable);
                                    }
                                });
//                    titleTv1.setText(businessBeanList.get(0));
                        Glide.with(MainActivity.this)
                                .load(businessBeanList.get(1).getStorePicture())
                                .asBitmap()
                                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                                .centerCrop()
                                .into(new BitmapImageViewTarget(yuanxingIv2) {
                                    @Override
                                    protected void setResource(Bitmap resource) {
                                        RoundedBitmapDrawable circularBitmapDrawable =
                                                RoundedBitmapDrawableFactory.create(getResources(), resource);
                                        circularBitmapDrawable.setCircular(true);
                                        yuanxingIv2.setImageDrawable(circularBitmapDrawable);
                                    }
                                });
                        Glide.with(MainActivity.this)
                                .load(businessBeanList.get(2).getStorePicture())
                                .asBitmap()
                                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                                .centerCrop()
                                .into(new BitmapImageViewTarget(yuanxingIv3) {
                                    @Override
                                    protected void setResource(Bitmap resource) {
                                        RoundedBitmapDrawable circularBitmapDrawable =
                                                RoundedBitmapDrawableFactory.create(getResources(), resource);
                                        circularBitmapDrawable.setCircular(true);
                                        yuanxingIv3.setImageDrawable(circularBitmapDrawable);
                                    }
                                });
                        Glide.with(MainActivity.this)
                                .load(businessBeanList.get(3).getStorePicture())
                                .asBitmap()
                                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                                .centerCrop()
                                .into(new BitmapImageViewTarget(yuanxingIv4) {
                                    @Override
                                    protected void setResource(Bitmap resource) {
                                        RoundedBitmapDrawable circularBitmapDrawable =
                                                RoundedBitmapDrawableFactory.create(getResources(), resource);
                                        circularBitmapDrawable.setCircular(true);
                                        yuanxingIv4.setImageDrawable(circularBitmapDrawable);
                                    }
                                });
                    }
                    mEmptyLayout.hide();
                    break;
            }
        }
    };
    IRichInfoCallback callback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle(false);//设置是否显示标题栏
        setState(true);//设置是否显示状态栏
        //设置title名
        setTitleName("我的权益");
        //设置title颜色
        setTitleColor("#ffffff");
        //设置返回按钮图片
        setBackIcon(R.drawable.back_icon_white);
        //设置背景色
        setToolbarBackground("#D2B48C");
        if (null != getSupportActionBar()) {
            getSupportActionBar().hide();
        }


//        initData();
//        initView();
    }

    @Override
    public int intiLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        Intent intent = getIntent();
        mobileNumUU = intent.getStringExtra("mobileNumUU");

        mEmptyLayout = findViewById(R.id.empty_layout);

        // 初始化mStatusView一开始状态为loading
//        mStatusView.showLoading();
//        mStatusView.showContent();

        // 当状态为error、empty事件回调
//        mStatusView.setOnRetryListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                postData();
//            }
//        });


        mCircleIv1 = findViewById(R.id.activity_main_circle_iv1);
        mCircleIv2 = findViewById(R.id.activity_main_circle_iv2);
        mCircleIv3 = findViewById(R.id.activity_main_circle_iv3);
        //--------------------------------------------------------------
        yuanxingIv1 = findViewById(R.id.yuanxing_iv1);
        yuanxingIv2 = findViewById(R.id.yuanxing_iv2);
        yuanxingIv3 = findViewById(R.id.yuanxing_iv3);
        yuanxingIv4 = findViewById(R.id.yuanxing_iv4);

        titleTv1 = findViewById(R.id.title_tv1);
        titleTv2 = findViewById(R.id.title_tv2);
        titleTv3 = findViewById(R.id.title_tv3);
        titleTv4 = findViewById(R.id.title_tv4);

        mainTopLl = findViewById(R.id.main_top);

//        if (starLevel.equals("9") || starLevel.equals("9") || starLevel.equals("0")) {

//        }

        mRecyclerView = findViewById(R.id.recyclerView);

        //**************************************

        //设置布局管理器 , 将布局设置成纵向
        GridLayoutManager manager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(manager);

        //设置分隔线
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(this , DividerItemDecoration.VERTICAL));
        mRecyclerView.addItemDecoration(new DividerGridItemDecoration(this));


        //设置增加或删除条目动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        //禁止rcyc嵌套滑动
        mRecyclerView.setNestedScrollingEnabled(false);

        //头部
        mainRecyclerView = findViewById(R.id.main_recyclerview);
        LinearLayoutManager manager1 = new LinearLayoutManager(this, LinearLayout.HORIZONTAL, false);
        mainRecyclerView.setLayoutManager(manager1);

        mRecyclerView1 = findViewById(R.id.main_recyclerview1);
        LinearLayoutManager manager2 = new LinearLayoutManager(this, LinearLayout.HORIZONTAL, false);
        mRecyclerView1.setLayoutManager(manager2);

        moreTv = findViewById(R.id.activity_main_more_tv);
        moreTv.setOnClickListener(this);

        refreshLayout = findViewById(R.id.activity_main_ptrl);
        refreshLayout.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.finishRefresh();
                    }
                }, 2000);
            }

            @Override
            public void loadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.finishLoadMore();
                    }
                }, 2000);
            }
        });

        mActivityLl = findViewById(R.id.activity_main_activity_ll);
        mBackIv = findViewById(R.id.title_back_iv);
        contentTv1 = findViewById(R.id.activity_main_content_tv1);
        contentTv2 = findViewById(R.id.activity_main_content_tv2);
        contentTv3 = findViewById(R.id.activity_main_content_tv3);
        dxtqMoreTv = findViewById(R.id.activity_main_dxtq_more_tv);
        mLxzbLl = findViewById(R.id.activity_main_lxzb_ll);
    }

    @Override
    public void initData() {
        mEmptyLayout.showLoading();
        postData();
        getDxtqEnjoyGoodsData();
        getEnjoyGoodsData();
        getSpecialActivities();
        getLxzbJsonData();
    }

    /**
     * 专享活动
     */
    private void getSpecialActivities() {
        String url = AppConstant.httpAddress + AppConstant.specialActivities;
        OkHttpUtils.get()
                .url(url)
                .addParams("mobileNum", getIntent().getStringExtra("mobileNumUU"))
                .addParams("citycode", "240")
                .addParams("num", "")
                .addParams("page", "")
                .addParams("starlv", "1")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String show = jsonObject.getString("show");

                            if (show.equals("0")) {
                                Gson gson = new Gson();
                                PecialActivitiesEntity entity = gson.fromJson(response, PecialActivitiesEntity.class);
                                activitysBeanList = entity.getActivitys();
                            }

                            Message message = new Message();
                            message.what = 0x113;
                            message.obj = show;
                            mHandler.sendMessage(message);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    /**
     * 独享特权
     */
    private void getDxtqEnjoyGoodsData() {
        String url = AppConstant.httpAddress + AppConstant.enjoyGoods;
        OkHttpUtils.get()
                .url(url)
                .addParams("arType", "2")
                .addParams("areaCode", "024")
                .addParams("bgnPos", "1")
                .addParams("dicId", "")
                .addParams("payType", "")
                .addParams("sortType", "2")
                .addParams("userStarLvLimit", "")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Gson gson = new Gson();
                        EnjoyGoodsEntity entity = gson.fromJson(response, EnjoyGoodsEntity.class);
                        dxtqObjBeanList = new ArrayList<>();
                        dxtqObjBeanList = (ArrayList<EnjoyGoodsEntity.ObjBean>) entity.getObj();

                        Message message = new Message();
                        message.what = 0x114;
                        mHandler.sendMessage(message);
                    }
                });
    }

    /**
     * 乐享周边
     */
    private void getLxzbJsonData() {
        String url = AppConstant.httpAddress + AppConstant.business;
        OkHttpUtils.get()
                .url(url)
                .addParams("areaCode", "240")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Gson gson = new Gson();
                        entity = gson.fromJson(response, LxzbEntity.class);
                        businessBeanList = entity.getList().getBusiness();

                        Message message = new Message();
                        message.what = 0x115;
                        mHandler.sendMessage(message);
                    }
                });
    }


    /**
     * 惠享商品
     */
    private void getEnjoyGoodsData() {
        String url = AppConstant.httpAddress + AppConstant.enjoyGoods;
        OkHttpUtils.get()
                .url(url)
                .addParams("arType", "4")
                .addParams("areaCode", "024")
                .addParams("bgnPos", "1")
                .addParams("dicId", "")
                .addParams("payType", "")
                .addParams("sortType", "2")
                .addParams("userStarLvLimit", "")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Gson gson = new Gson();
                        EnjoyGoodsEntity entity = gson.fromJson(response, EnjoyGoodsEntity.class);
                        objBeanList = new ArrayList<>();
                        objBeanList = entity.getObj();

                        Message message = new Message();
                        message.what = 0x112;
                        mHandler.sendMessage(message);
                    }
                });
    }

    /**
     * 顶部导航
     */
    private void postData() {
        OkHttpClient client = new OkHttpClient();
        String url = AppConstant.httpAddress + AppConstant.interestsMain;
        FormBody.Builder formBody = new FormBody.Builder();
        formBody.add("mobileNum", mobileNumUU);
        formBody.build();
        final Request request = new Request.Builder()
                .url(url)
                .post(formBody.build())
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                // 异常状态
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
//                        mStatusView.showError();
                    }
                });
            }

            @Override
            public void onResponse(final Call call, final Response response) throws IOException {
                // 解析json
                String jsonData = response.body().string();
                try {
                    JSONObject jsonObject = new JSONObject(jsonData);
                    String result = jsonObject.getString("result");
                    JSONObject jsonObject1 = jsonObject.getJSONObject("list");
                    JSONArray jsonArray = jsonObject1.getJSONArray("data");
                    JSONObject jsonObject2 = jsonArray.getJSONObject(0);
                    JSONArray jsonArray1 = jsonObject2.getJSONArray("userRights");

                    JSONObject jsonObject3 = jsonArray.getJSONObject(1);
                    starLevel = jsonObject3.getString("starLevel");
                    JSONObject jsonObject4 = jsonArray.getJSONObject(2);
                    mobileNum = jsonObject4.getString("mobileNum");
                    JSONObject jsonObject5 = jsonArray.getJSONObject(3);
                    realBalance = jsonObject5.getString("realBalance");
                    for (int i = 0; i < jsonArray1.length(); i++) {
                        NewEntity entity = new NewEntity();
                        String name = jsonArray1.getJSONObject(i).getString("name");
                        String imageUrl = jsonArray1.getJSONObject(i).getString("imageUrl");
                        String derdge = jsonArray1.getJSONObject(i).getString("derdge");
//
                        entity.setName(name);
                        entity.setImageUrl(imageUrl);
                        entity.setDerdge(derdge);
//                                entity.setStarLevel(starLevel);
//                                entity.setStarLevel(realBalance);
                        newEntityList.add(entity);
                    }

                    Message message = new Message();
                    message.what = 0x111;
                    message.obj = newEntityList;
                    mHandler.sendMessage(message);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    @Override
    public void initListener() {
        mBackIv.setOnClickListener(this);
        dxtqMoreTv.setOnClickListener(this);
    }

    public void onItemClick(View view) {
        int childAdapterPosition = mRecyclerView.getChildAdapterPosition(view);
//        Toast.makeText(this, "item click index = " + childAdapterPosition, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        intent.putExtra("position", childAdapterPosition);
        intent.setClass(MainActivity.this, MyFragmentActivity.class);
        intent.putExtra("starLevel", starLevel);
        intent.putExtra("mobileNum", mobileNum);
        intent.putExtra("mobileNumUU", mobileNumUU);
        intent.putExtra("realBalance", realBalance);
        intent.putExtra("derdge", newEntityList.get(2).getDerdge());
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        int i = view.getId();
        if (i == R.id.activity_main_more_tv) {
            intent = new Intent(this, PecialActivitiesMoreActivity.class);
            intent.putExtra("pecialData", (Serializable) mDatas1);
            startActivity(intent);

        } else if (i == R.id.title_back_iv) {
            finish();

        } else if (i == R.id.activity_main_dxtq_more_tv) {
            intent = new Intent(this, DxtqMoreActivity.class);
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("dxtqData", dxtqObjBeanList);
            intent.putExtras(bundle);
            startActivity(intent);

        }
    }
}
