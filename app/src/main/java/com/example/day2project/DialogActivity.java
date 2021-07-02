package com.example.day2project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class DialogActivity extends AppCompatActivity implements View.OnClickListener {
    Button b1,b2,b3,b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        init();
    }

    private void init(){
        b1=findViewById(R.id.button1);
        b2=findViewById(R.id.button2);
        b2=findViewById(R.id.button3);
        b2=findViewById(R.id.button4);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.button1){
            displayDialog();
        }
    }

    private void displayDialog() {
        //Toast.makeText(this,"Dialog1",Toast.LENGTH_SHORT).show();
        AlertDialog.Builder dig = new AlertDialog.Builder(this);
        dig.setTitle("기본대화상자1 ");
        dig.setMessage("대화상자 메세지입니다.");
        dig.setIcon(R.mipmap.ic_launcher);
        dig.setNegativeButton("확인",null);
        dig.show();
    }
}