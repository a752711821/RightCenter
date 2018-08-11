package com.example.myapplication;

import android.graphics.Bitmap;
import android.media.Image;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

/**
 * Created by Administrator on 2018/5/25/025.
 */

public class MyH5WebView extends AppCompatActivity implements View.OnClickListener, View.OnKeyListener {

    private WebView mWebView;
    private ImageView mImageViewClose;
    private ImageView mImageViewBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h5_webview);
        if (null != getSupportActionBar()) {
            getSupportActionBar().hide();
        }

        initView();
        initData();
    }

    private void initView() {
        mWebView = findViewById(R.id.webView);
        mImageViewClose = findViewById(R.id.webview_close_iv);
        mImageViewBack = findViewById(R.id.webview_back_iv);
        mImageViewClose.setOnClickListener(this);
        mImageViewBack.setOnClickListener(this);
        mWebView.setOnKeyListener(this);
    }

    private void initData() {
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);//允许在WebView中使用js
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.loadUrl("https://www.ln139.com/ILIAONING/page/index/toIndexPage.jsp?neusoft_param=unctptlc");
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.webview_close_iv) {
            if (mWebView != null) {
                mWebView.removeAllViews();
                finish();
            }

        } else if (i == R.id.webview_back_iv) {
            if (mWebView.canGoBack()) {
                mWebView.goBack();
            } else {
                mWebView.removeAllViews();
                finish();
            }

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mWebView != null) {
            mWebView.destroy();
        }
    }

    @Override
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == KeyEvent.ACTION_DOWN) {
            if (i == KeyEvent.KEYCODE_BACK && mWebView.canGoBack()) {
                mWebView.goBack();
                return true;
            }
        }
        return false;
    }
}
