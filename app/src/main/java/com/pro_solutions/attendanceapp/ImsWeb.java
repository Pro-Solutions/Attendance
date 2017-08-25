package com.pro_solutions.attendanceapp;

import android.app.Activity;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;


public class ImsWeb extends AppCompatActivity {

    private String webaddress="http://www.google.com/";
    private FrameLayout frameLayout;
    private ProgressBar progressBar;
    private WebView w;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ims_web);

        w=(WebView)findViewById(R.id.w);
        frameLayout=(FrameLayout) findViewById(R.id.frameLayout);
        progressBar=(ProgressBar) findViewById(R.id.webProgressbar);

        progressBar.setMax(100);

        w.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView webView, String url) {
                webView.loadUrl(url);
                frameLayout.setVisibility(View.VISIBLE);

                return true;
            }


        });

        w.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView webView, int newProgress) {

                frameLayout.setVisibility(View.VISIBLE);
                progressBar.setProgress(newProgress);
                setTitle("Loading");

                if(newProgress==100)
                {
                    frameLayout.setVisibility(View.GONE);
                    setTitle(webView.getTitle());
                }

                super.onProgressChanged(webView, newProgress);
            }
        });




        WebSettings s=w.getSettings();
        w.setVerticalScrollBarEnabled(false);
        s.setJavaScriptEnabled(true);
        s.setBuiltInZoomControls(true);
        s.setDomStorageEnabled(true);
        w.loadUrl(webaddress);
        progressBar.setProgress(0);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            if(w.canGoBack())
            {
                w.goBack();
                return true;
            }

        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
