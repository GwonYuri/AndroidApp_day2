package com.example.day2project;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class DialogActivity extends AppCompatActivity implements View.OnClickListener {
    Button b1,b2,b3,b4;
    int selectedMenu =0;
    String menu[] = {"치킨", "피자", "스파게티"};
    boolean checked[]={true,true,false};

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
        else if(v.getId()==R.id.button3){
            displayDialog3();
        }
        else if(v.getId()==R.id.button4){
            displayDialog4();
        }
    }

    //checkButton
    private void displayDialog4() {
        View view = View.inflate(this,R.layout.dialog,null);
        final EditText editText = view.findViewById(R.id.etMsg);

        AlertDialog.Builder dig = new AlertDialog.Builder(this);
        dig.setTitle("사용자 정의 대화상자 ");
        dig.setIcon(R.mipmap.ic_launcher);
        dig.setView(view);
        dig.setNegativeButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                displayToast("입력한 메세지 : " + editText.getText().toString());
            }
        });
        dig.setPositiveButton("취소", null);
        dig.show();
    }
    //checkButton
    private void displayDialog3() {
        AlertDialog.Builder dig = new AlertDialog.Builder(this);
        dig.setTitle("기본대화상자3");
        dig.setMultiChoiceItems(menu, checked, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                checked[which] = isChecked;
                for(which =0; which <3; which ++){
                    if(checked[which]){
                        displayToast(menu[which] + " 이(가) 선택되었습니다! ");
                    }
                }

            }
        });
        dig.setIcon(R.mipmap.ic_launcher);
        dig.setNegativeButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                displayToast(menu[selectedMenu] + " 이(가) 선택되었습니다! ");
            }
        });
        dig.show();
    }

    //radioButton
    private void displayDialog2() {
        AlertDialog.Builder dig = new AlertDialog.Builder(this);
        dig.setTitle("기본대화상자2");
        dig.setSingleChoiceItems(menu, selectedMenu, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                selectedMenu=which;
            }
        });
        dig.setIcon(R.mipmap.ic_launcher);
        dig.setNegativeButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                displayToast(menu[selectedMenu] + " 이(가) 선택되었습니다! ");
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