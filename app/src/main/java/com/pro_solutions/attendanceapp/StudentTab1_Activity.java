package com.pro_solutions.attendanceapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Amit Rawat on 09-08-2017.
 */

public class StudentTab1_Activity extends Fragment {


    Button wbutton;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.student_tab1,container,false);

        wbutton=(Button)view.findViewById(R.id.wbutton);
        wbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "WEBBBB VIEWW", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(getActivity(),ImsWeb.class);
                startActivity(i);


            }
        });


        return view;
    }
    /*public void Display(View v)
    {
        Intent i=new Intent(getActivity(),ImsWeb.class);
        startActivity(i);

    }*/
}
