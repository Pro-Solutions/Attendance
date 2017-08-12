package com.pro_solutions.attendanceapp;

import android.app.Activity;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ImsWeb extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ims_web);

        WebView webView=(WebView)findViewById(R.id.w);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://www.google.com/");

        WebSettings s=webView.getSettings();
        s.setJavaScriptEnabled(true);
        s.setBuiltInZoomControls(true);
        s.setDomStorageEnabled(true);

    }
}
