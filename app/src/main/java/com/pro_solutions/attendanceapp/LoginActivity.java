package com.pro_solutions.attendanceapp;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.support.design.widget.Snackbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


public class LoginActivity extends AppCompatActivity {



    boolean admin=false;
    boolean student=false;
    boolean professor=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_login);


        final ImageButton studentbutton = (ImageButton) findViewById(R.id.studentbutton);
        final ImageButton adminbutton = (ImageButton) findViewById(R.id.adminbutton);
        final ImageButton professorbutton = (ImageButton) findViewById(R.id.professorbutton);
        final Button loginbutton = (Button) findViewById(R.id.loginbutton);

        final EditText Usernametext = (EditText) findViewById(R.id.Usernametext);
        final EditText Passwordtext = (EditText) findViewById(R.id.Passwordtext);
        final EditText ConfirmPasswordtext = (EditText) findViewById(R.id.ConfirmPasswordtext);



        adminbutton.setOnClickListener(
                new ImageButton.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        adminbutton.setImageResource(R.drawable.check);
                        studentbutton.setImageResource(R.drawable.student);
                        professorbutton.setImageResource(R.drawable.professor);
                        admin=true;
                        student=false;
                        professor=false;


                    }
                }
        );

        professorbutton.setOnClickListener(
                new ImageButton.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        adminbutton.setImageResource(R.drawable.admin);
                        studentbutton.setImageResource(R.drawable.student);
                        professorbutton.setImageResource(R.drawable.check);
                        admin=false;
                        student=false;
                        professor=true;
                    }
                }
        );

        studentbutton.setOnClickListener(
                new ImageButton.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        adminbutton.setImageResource(R.drawable.admin);
                        studentbutton.setImageResource(R.drawable.check);
                        professorbutton.setImageResource(R.drawable.professor);

                        admin=false;
                        student=true;
                        professor=false;

                    }
                }
        );

        loginbutton.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (student) {
                            if ((Usernametext.getText().toString().equals("s")) && (Passwordtext.getText().toString().equals("123")) & (ConfirmPasswordtext.getText().toString().equals(Passwordtext.getText().toString()))){
                                Toast.makeText(getApplicationContext(), "Login successful! Student", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(LoginActivity.this, StudentActivity.class);
                                startActivity(i);
                                finish();
                            } else {
                                Toast.makeText(getApplicationContext(), "Wrong Username or Password!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else if (professor) {
                            if ((Usernametext.getText().toString().equals("p")) && (Passwordtext.getText().toString().equals("123")) & (ConfirmPasswordtext.getText().toString().equals(Passwordtext.getText().toString()))) {
                                Toast.makeText(getApplicationContext(), "Login successful!Professor", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(LoginActivity.this, ProfessorActivity.class);
                                startActivity(i);
                                finish();
                            } else {
                                Toast.makeText(getApplicationContext(), "Wrong Username or Password!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else if (admin)
                        {

                            if ((Usernametext.getText().toString().equals("a")) && (Passwordtext.getText().toString().equals("123")) & (ConfirmPasswordtext.getText().toString().equals(Passwordtext.getText().toString()))) {
                                Toast.makeText(getApplicationContext(), "Login successful!", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(LoginActivity.this, AdminActivity.class);
                                startActivity(i);
                                finish();
                            } else {
                                Toast.makeText(getApplicationContext(), "Wrong Username or Password!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Snackbar.make(view, "Please select an option...", Snackbar.LENGTH_LONG).show();
                        }

                    }
                }
        );

        loginbutton.setOnLongClickListener(
                new Button.OnLongClickListener()
                    {
                        @Override
                        public boolean onLongClick(View view)
                        {

                        Toast.makeText(getApplicationContext(), "LOGIN", Toast.LENGTH_SHORT).show();
                        return true;
                        }
                    }
        );


    }


}
