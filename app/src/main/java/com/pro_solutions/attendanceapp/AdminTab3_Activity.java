package com.pro_solutions.attendanceapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class AdminTab3_Activity extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.admin_tab3,container,false);

        WebView webView=(WebView)view.findViewById(R.id.w1);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://www.imsnoida.com");

        WebSettings s=webView.getSettings();
        s.setJavaScriptEnabled(true);
        s.setBuiltInZoomControls(true);
        s.setDomStorageEnabled(true);

        return view;
    }
}
