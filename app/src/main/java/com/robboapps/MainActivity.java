package com.robboapps.ottawa4kidstest3;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.HashSet;

public class MainActivity extends ListActivity {

    String[] outsidestuff;
    String[] Row = new String[3];
    //how to grab context from MainActivity and use it in other non activity classes (?)


   //public MainActivity(Context context) {
        // Required empty public constructor in order to access methods in the MainActivity Class
       //Context context = this;
    //}

    //Context context;
    //context = this.getBaseContext();

   // public Context grabContext() {
    //context = this.getBaseContext();
    //return context;
    //}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView lstView = getListView();
        lstView.setTextFilterEnabled(true);
        outsidestuff = getResources().getStringArray(R.array.outsidestuff_array);
        String[] Options = new String[outsidestuff.length];
        for (int i = 0; i < outsidestuff.length; i++) {
            Options = outsidestuff[i].split(",");
            Row[i] = Options[0];
        }
        //finds unique elements in the Row Array @ Java 7 level (Java 8 has simpler method)
        String[] DisplayRow = new HashSet<String>(Arrays.asList(Row)).toArray(new String[0]);
        //display only unique items
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, DisplayRow));

        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?>parent,View v, int position, long id){
                String  itemValue    = (String) lstView.getItemAtPosition(position);
                Intent i = new Intent("com.robboapps.ottawa4kidstest3.SecondActivity");
                //---use putExtra() to add new nam/value pairs---
                i.putExtra("str1", itemValue);
                startActivity(i);
            }
        });
    }

    public void onListItemClick(ListView parent, View v, int position, long id){
        Toast.makeText(this, "You have selected " + outsidestuff[position], Toast.LENGTH_SHORT).show();
    }



}
