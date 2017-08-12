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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


public class ProfessorTab3_Activity extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.professor_tab3,container,false);

        Button sendbutton=(Button)view.findViewById(R.id.sendbutton);
        final EditText messagetext=(EditText)view.findViewById(R.id.messsagetext);
        //final ListView messagelist=(ListView)view.findViewById(R.id.messsagelist);
        final TextView messages=(TextView)view.findViewById(R.id.messages);

        sendbutton.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View view) {
                messages.append("\n"+messagetext.getText().toString());


                messagetext.setText("");

            }
        });



        /*WebView webView=(WebView)view.findViewById(R.id.w2);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://www.tutorialspoint.com");

        WebSettings s=webView.getSettings();
        s.setJavaScriptEnabled(true);
        s.setBuiltInZoomControls(true);
        s.setDomStorageEnabled(true);*/



        return view;
    }
}
