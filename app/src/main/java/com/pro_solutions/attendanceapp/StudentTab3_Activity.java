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

/**
 * Created by Amit Rawat on 09-08-2017.
 */

public class StudentTab3_Activity extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.student_tab3,container,false);

        WebView webView=(WebView)view.findViewById(R.id.w3);
        webView.setWebViewClient(new WebViewClient());
        //webView.loadUrl("http://192.163.211.186/~ccsuresu/");
        webView.loadUrl("http://www.tutorialspoint.com");

        WebSettings s=webView.getSettings();
        s.setJavaScriptEnabled(true);
        s.setBuiltInZoomControls(true);
        s.setDomStorageEnabled(true);


        return view;
    }
}
