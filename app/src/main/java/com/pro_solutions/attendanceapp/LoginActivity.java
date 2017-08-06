package com.pro_solutions.attendanceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_login);

        final ImageButton studentbutton=(ImageButton)findViewById(R.id.studentbutton);
        final ImageButton adminbutton=(ImageButton)findViewById(R.id.adminbutton);
        final ImageButton professorbutton=(ImageButton)findViewById(R.id.professorbutton);
        final Button loginbutton=(Button)findViewById(R.id.loginbutton);

        adminbutton.setOnClickListener(
                new ImageButton.OnClickListener()
                {
                    @Override
                    public void onClick(View view) {

                        adminbutton.setImageResource(R.drawable.check);
                        studentbutton.setImageResource(R.drawable.student);
                        professorbutton.setImageResource(R.drawable.professor);

                    }
                }
        );

        professorbutton.setOnClickListener(
                new ImageButton.OnClickListener()
                {
                    @Override
                    public void onClick(View view) {

                        adminbutton.setImageResource(R.drawable.admin);
                        studentbutton.setImageResource(R.drawable.student);
                        professorbutton.setImageResource(R.drawable.check);
                    }
                }
        );

        studentbutton.setOnClickListener(
                new ImageButton.OnClickListener()
                {
                    @Override
                    public void onClick(View view) {
                        adminbutton.setImageResource(R.drawable.admin);
                        studentbutton.setImageResource(R.drawable.check);
                        professorbutton.setImageResource(R.drawable.professor);
                    }
                }
        );

        loginbutton.setOnClickListener(
                new Button.OnClickListener()
                {
                    @Override
                    public void onClick(View view) {
                        //Intent loginButtonIntent=new Intent(getApplicationContext(),LoginActivity.class);
                        //startActivity(loginButtonIntent);
                        Toast.makeText(getApplicationContext(),"Login successful!",Toast.LENGTH_SHORT).show();
                    }
                }
        );
        loginbutton.setOnLongClickListener(
                new Button.OnLongClickListener()
                {
                    @Override
                    public boolean onLongClick(View view)
                    {
                        Toast.makeText(getApplicationContext(),"LOGIN",Toast.LENGTH_SHORT).show();
                        return true;
                    }
                }
        );

    }
}
