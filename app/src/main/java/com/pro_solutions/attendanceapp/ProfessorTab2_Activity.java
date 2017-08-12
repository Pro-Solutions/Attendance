package com.pro_solutions.attendanceapp;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Arrays;






import android.support.v7.app.ActionBarActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Arrays;






public class ProfessorTab2_Activity extends Fragment {

    ArrayAdapter<String> adapter;
    EditText editText;
    ArrayList<String> itemList;
    Button btAdd;
    /*RelativeLayout layout;
    Button addbutton;
    EditText add;*/
    @Nullable
    //@Override



    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.professor_tab2,container,false);


        String[] items={"ADARSH","ADITYA","ALOK","AMIT"};
        itemList=new ArrayList<String>(Arrays.asList(items));

        adapter=new ArrayAdapter<String>(getActivity(),R.layout.list_item,R.id.txtview,itemList);
        ListView listV=(ListView)view.findViewById(R.id.list);
        listV.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listV.setAdapter(adapter);
        editText=(EditText)view.findViewById(R.id.txtInput);
        btAdd=(Button)view.findViewById(R.id.btAdd);


/*
        addbutton=(Button)view.findViewById(R.id.addbutton);
        add=(EditText)view.findViewById(R.id.add);
*/


        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(editText.getText().toString().equals(""))
                {
                    Toast.makeText(getActivity(),"Please Add Something!",Toast.LENGTH_SHORT).show();
                }
                else
                {

                    /*t.setText(add.getText().toString());

                    layout.addView(t,details);
                    add.setText("");*/


                    String newItem=editText.getText().toString();
                    // add new item to arraylist
                    itemList.add(newItem);
                    // notify listview of data changed
                    adapter.notifyDataSetChanged();
                    editText.setText("");

                }

            }
        });

        return view;
    }

}
