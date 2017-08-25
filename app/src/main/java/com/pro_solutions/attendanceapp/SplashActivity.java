package com.pro_solutions.attendanceapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import static java.lang.Thread.sleep;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);*/


        setContentView(R.layout.activity_splash);

        final ImageView splashImage = (ImageView) findViewById(R.id.splashImage);
        final ProgressBar progressBar=(ProgressBar)findViewById(R.id.progressBar);
        progressBar.setMax(100);
        progressBar.setProgress(0);

        Handler handler=new Handler();

        handler.postDelayed(new Runnable()
        {
            public void run() {
                progressBar.setProgress(10);

            }
        },500);

        handler.postDelayed(new Runnable()
        {
            public void run() {
                progressBar.setProgress(20);

            }
        },800);

        handler.postDelayed(new Runnable()
        {
            public void run() {
                progressBar.setProgress(30);

            }
        },1000);

        handler.postDelayed(new Runnable()
        {
            public void run() {
                progressBar.setProgress(45);

            }
        },1200);

        handler.postDelayed(new Runnable()
        {
            public void run() {
                progressBar.setProgress(60);

            }
        },1400);
        handler.postDelayed(new Runnable()
        {
            public void run() {
                progressBar.setProgress(80);

            }
        },1600);
        handler.postDelayed(new Runnable()
        {
            public void run() {
                progressBar.setProgress(100);

            }
        },1800);

        handler.postDelayed(new Runnable()
        {
            public void run() {

                Animation shake=AnimationUtils.loadAnimation(SplashActivity.this,R.anim.shake_splash);
                splashImage.startAnimation(shake);

                Animation splash_anim_prog_bar = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.splash_anim_prog_bar);
                progressBar.startAnimation(splash_anim_prog_bar);



            }
        },2000);


        handler.postDelayed(new Runnable()
        {
            public void run() {
                splashImage.clearAnimation();

                Animation splash_anim = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.splash_anim);
                Animation splash_anim_text = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.splash_anim_text);
                Animation splash_anim_text2 = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.splash_anim_text2);


                TextView textApp = (TextView) findViewById(R.id.textApp);
                TextView textAttendance = (TextView) findViewById(R.id.textAttendance);

                splashImage.startAnimation(splash_anim);
                textApp.startAnimation(splash_anim_text);
                textAttendance.startAnimation(splash_anim_text2);

            }
        },2500);



        Thread thread = new Thread() {
            @Override
            public void run() {

                try {
                    sleep(4500);
                } catch (InterruptedException e) {
                    e.printStackTrace();

                } finally {
                    Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(i);
                    finish();
                }

            }
        };
        thread.start();
    }



}
