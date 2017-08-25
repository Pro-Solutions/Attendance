package com.pro_solutions.attendanceapp;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.support.design.widget.Snackbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    private ImageButton studentbutton;
    private ImageButton adminbutton;
    private ImageButton professorbutton;
    private Button loginbutton;

    private EditText Usernametext;
    private EditText Passwordtext;

    private TextView forgotPassword;
    private TextView signuphere;

    private boolean admin = false;
    private boolean student = false;
    private boolean professor = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_login);


        studentbutton = (ImageButton) findViewById(R.id.studentbutton);
        adminbutton = (ImageButton) findViewById(R.id.adminbutton);
        professorbutton = (ImageButton) findViewById(R.id.professorbutton);
        loginbutton = (Button) findViewById(R.id.loginbutton);
        forgotPassword = (TextView) findViewById(R.id.forgotPassword);
        signuphere = (TextView) findViewById(R.id.signuphere);

        Usernametext = (EditText) findViewById(R.id.Usernametext);
        Passwordtext = (EditText) findViewById(R.id.Passwordtext);


        studentbutton.setOnClickListener(this);
        adminbutton.setOnClickListener(this);
        professorbutton.setOnClickListener(this);
        signuphere.setOnClickListener(this);
        loginbutton.setOnClickListener(this);
        forgotPassword.setOnClickListener(this);

        loginbutton.setOnLongClickListener(
                new Button.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {

                        Toast.makeText(getApplicationContext(), "LOGIN", Toast.LENGTH_SHORT).show();
                        return true;
                    }
                }
        );


    }


    @Override
    public void onClick(View view) {

        if(view==forgotPassword){
            Toast.makeText(getApplicationContext(), "☺☻Forgot Password? ♥", Toast.LENGTH_SHORT).show();
        }

        if (view == signuphere) {

            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            Toast.makeText(getApplicationContext(), "Signup Here!", Toast.LENGTH_SHORT).show();
        }
        if (view == loginbutton) {
            UserLogin(view);
        }


        if (view == adminbutton) {
            adminbutton.setImageResource(R.drawable.check);
            studentbutton.setImageResource(R.drawable.student);
            professorbutton.setImageResource(R.drawable.professor);

            admin = true;
            student = false;
            professor = false;
        }
        if (view == studentbutton) {
            adminbutton.setImageResource(R.drawable.admin);
            studentbutton.setImageResource(R.drawable.check);
            professorbutton.setImageResource(R.drawable.professor);

            admin = false;
            student = true;
            professor = false;
        }
        if (view == professorbutton) {
            adminbutton.setImageResource(R.drawable.admin);
            studentbutton.setImageResource(R.drawable.student);
            professorbutton.setImageResource(R.drawable.check);

            admin = false;
            student = false;
            professor = true;
        }

    }

    private void UserLogin(View view)
    {

        if (student)
        {
            if ((Usernametext.getText().toString().equals("s")) && (Passwordtext.getText().toString().equals("123")))
            {
                Toast.makeText(getApplicationContext(), "Login successful! Student", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(LoginActivity.this, StudentActivity.class);
                startActivity(i);
                finish();
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Wrong Username or Password!", Toast.LENGTH_SHORT).show();
            }
        }
        else if (professor)
        {
            if ((Usernametext.getText().toString().equals("p")) && (Passwordtext.getText().toString().equals("123")))
            {
                Toast.makeText(getApplicationContext(), "Login successful!Professor", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(LoginActivity.this, ProfessorActivity.class);
                startActivity(i);
                finish();
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Wrong Username or Password!", Toast.LENGTH_SHORT).show();
            }
        }
        else if (admin)
        {
            if ((Usernametext.getText().toString().equals("a")) && (Passwordtext.getText().toString().equals("123")))
            {
                Toast.makeText(getApplicationContext(), "Login successful!", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(LoginActivity.this, AdminActivity.class);
                startActivity(i);
                finish();
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Wrong Username or Password!", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Snackbar.make(view, "Please select an option...", Snackbar.LENGTH_LONG).show();
        }

    }

}