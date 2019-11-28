package com.example.androidhw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListVIewItem data;
    private ArrayList<ListVIewItem> arrays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listview = null;
        ListViewAdapter adapter;
        arrays = new ArrayList<ListVIewItem>();
        adapter = new ListViewAdapter(arrays);
        Log.i("aaa","aaaa");

        initialData();
        listview = (ListView)findViewById(R.id.listview1);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListVIewItem item = (ListVIewItem) parent.getItemAtPosition(position);

                Toast.makeText(MainActivity.this,position+1 + "번째 선택\n"+ item.getTitle() + item.getDescStr(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initialData() {
        data = new ListVIewItem();
        data.setData(getResources().getDrawable(R.drawable.p1),"장","010-234-234","abcd@avbc","인천");
        arrays.add(data);

        data = new ListVIewItem();
        data.setData(getResources().getDrawable(R.drawable.p2),"도","010-2345-2345","abcd@avbc","서울");
        arrays.add(data);
    }
}
