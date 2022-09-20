package com.example.list_tuan6;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.view.View;
import android.widget.AdapterView;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    ArrayList<item> list;
    private  List<item> getListData() {
        list = new ArrayList<item>();
        item item1 = new item("item1", "dinner_1", "infomation of item1");
        item item2 = new item("item2", "dinner_2", "infomation of item2");
        item item3 = new item("item3", "dinner_3", "infomation of item3");
        item item4 = new item("item4", "dinner_4", "infomation of item4");
        item item5 = new item("item5", "dinner_5", "infomation of item5");



        list.add(item1);
        list.add(item2);
        list.add(item3);
        list.add(item4);
        list.add(item5);

        return list;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<item> image_details = getListData();
        Adapter adapter=new Adapter(this, image_details);
        final ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        // When the user clicks on the ListItem
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View view, int i, long id) {
                Object o = listView.getItemAtPosition(i);
                item dinner = (item) o;
                Toast.makeText(MainActivity.this, "Selected :" + " " + dinner, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, profileActivity.class);
                startActivity(intent);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> a, View view, int i, long id) {
                Object o = listView.getItemAtPosition(i);
                item dinner = (item) o;
                final int which_item=i;

                new AlertDialog.Builder(MainActivity.this).setIcon(R.drawable.ic_baseline_delete_24)
                        .setTitle("Are you sure delete this?")
                        .setMessage("Do you want to delete?")
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                list.remove(which_item);
                                adapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("No",null)
                        .show();

                return true;
            }
        });
    }


}