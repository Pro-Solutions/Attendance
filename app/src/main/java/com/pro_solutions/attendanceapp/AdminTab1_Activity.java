package com.pro_solutions.attendanceapp;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;





public class AdminTab1_Activity extends Fragment implements AdapterView.OnItemSelectedListener {

    private TextView adminName;
    Spinner sp1;
    Spinner sp2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.admin_tab1,container,false);

        String[] Courses=new String[]{"BCA","MCA"};
        ArrayAdapter course_adapter=new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,Courses);
        sp1=(Spinner)view.findViewById(R.id.courses);
        course_adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        sp1.setAdapter(course_adapter);


        String[] Semester=new String[]{"I","II","III","IV","V","VI"};
        ArrayAdapter sem_adapter=new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,Semester);
        sp2=(Spinner)view.findViewById(R.id.sem);
        sem_adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        sp2.setAdapter(sem_adapter);

        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {



    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
