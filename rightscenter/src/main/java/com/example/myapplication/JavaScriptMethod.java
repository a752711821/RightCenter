package com.example.myapplication;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

/**
 * Created by Administrator on 2018/5/25/025.
 */

public class JavaScriptMethod {
    private Context mContext;
    private WebView mWebView;
    public static final String JAVAINTERFACE = "javaInterface";

    public JavaScriptMethod(Context Context, WebView webView) {
        this.mContext = Context;
        this.mWebView = webView;
    }

    @JavascriptInterface
    public void showToast(String json) {
        Toast.makeText(mContext, json, Toast.LENGTH_SHORT).show();
    }
}
