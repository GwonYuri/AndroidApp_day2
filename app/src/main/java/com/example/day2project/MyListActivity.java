package com.example.day2project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyListActivity extends AppCompatActivity {
    ArrayList<String> data = new ArrayList<>();
    MyLIstAdapter adapter;
    RecyclerView recyclerView;
    TextView et;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);
        init();
    }
    private void init(){
        data.add("사과");
        data.add("바나나");
        data.add("체리");

        //recyclerview
        adapter = new MyLIstAdapter(this,data);
        recyclerView=findViewById(R.id.fruitlist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        et=findViewById(R.id.etFruit);
    }

    public void enAAA(View view){
        String newfruit =et.getText().toString();
        data.add(newfruit);
        adapter.notifyDataSetChanged();
    }
}