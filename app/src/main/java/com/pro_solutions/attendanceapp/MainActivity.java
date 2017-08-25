package com.pro_solutions.attendanceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton studentbutton;
    private ImageButton adminbutton;
    private ImageButton professorbutton;
    private Button signupbutton;
    private TextView loginhere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        studentbutton=(ImageButton)findViewById(R.id.studentbutton);
        adminbutton=(ImageButton)findViewById(R.id.adminbutton);
        professorbutton=(ImageButton)findViewById(R.id.professorbutton);
        signupbutton=(Button)findViewById(R.id.signupbutton);
        loginhere=(TextView)findViewById(R.id.loginhere);

        studentbutton.setOnClickListener(this);
        adminbutton.setOnClickListener(this);
        professorbutton.setOnClickListener(this);
        signupbutton.setOnClickListener(this);
        loginhere.setOnClickListener(this);

        //final EditText Emailtext=(EditText) findViewById(R.id.Emailtext);
        //Emailtext.getUrls();

        signupbutton.setOnLongClickListener(
                new Button.OnLongClickListener()
                {
                    @Override
                    public boolean onLongClick(View view)
                    {
                        Toast.makeText(getApplicationContext(),"Sign up",Toast.LENGTH_SHORT).show();
                        return true;
                    }
                }
        );


    }


    @Override
    public void onClick(View view) {

        if(view==loginhere){
            finish();
            startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            Toast.makeText(getApplicationContext(),"Login Here!",Toast.LENGTH_SHORT).show();
        }
        if(view==signupbutton){
            finish();
            startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            Toast.makeText(getApplicationContext(),"Sign up successful!",Toast.LENGTH_SHORT).show();
        }
        if(view==adminbutton){
            adminbutton.setImageResource(R.drawable.check);
            studentbutton.setImageResource(R.drawable.student);
            professorbutton.setImageResource(R.drawable.professor);
        }
        if(view==studentbutton){

            adminbutton.setImageResource(R.drawable.admin);
            studentbutton.setImageResource(R.drawable.check);
            professorbutton.setImageResource(R.drawable.professor);
        }
        if(view==professorbutton){
            adminbutton.setImageResource(R.drawable.admin);
            studentbutton.setImageResource(R.drawable.student);
            professorbutton.setImageResource(R.drawable.check);
        }

    }
}
