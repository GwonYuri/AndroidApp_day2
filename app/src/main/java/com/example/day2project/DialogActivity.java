package com.example.day2project;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class DialogActivity extends AppCompatActivity implements View.OnClickListener {
    Button b1,b2,b3,b4;
    int selectedMenu =0;
    String menu[] = {"치킨", "피자", "스파게티"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        init();
    }

    private void init(){
        b1=findViewById(R.id.button1);
        b2=findViewById(R.id.button2);
        b3=findViewById(R.id.button3);
        b4=findViewById(R.id.button4);

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
        else if(v.getId()==R.id.button2){
            displayDialog2();
        }
    }

    //radioButton
    private void displayDialog2() {

        AlertDialog.Builder dig = new AlertDialog.Builder(this);
        dig.setTitle("기본대화상자2");
        dig.setSingleChoiceItems(menu, 1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                selectedMenu=which;
            }
        });
        dig.setIcon(R.mipmap.ic_launcher);
        dig.setNegativeButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                displayToast(menu[selectedMenu] + "이/가 선택되었습니다! ");
            }
        });
        dig.show();
    }

    private void displayDialog() {
        //Toast.makeText(this,"Dialog1",Toast.LENGTH_SHORT).show();
        AlertDialog.Builder dig = new AlertDialog.Builder(this);
        dig.setTitle("기본대화상자1");
        dig.setMessage("대화상자 메세지입니다.");
        dig.setIcon(R.mipmap.ic_launcher);
        dig.setNegativeButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                displayToast(null);
            }
        });
        dig.show();
    }

    private void displayToast(String msg) {
        Toast.makeText(this,msg, Toast.LENGTH_SHORT).show();
    }
}