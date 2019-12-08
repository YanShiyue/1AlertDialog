package com.example.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button tishi=(Button)findViewById(R.id.tishi);
        tishi.setOnClickListener(this);
        Button denglu=(Button)findViewById(R.id.denglu);
        denglu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        AlertDialog.Builder dialog=new AlertDialog.Builder(MainActivity.this);
        switch (v.getId()){
            case R.id.tishi:
                dialog.setTitle("提示对话框");
                dialog.setMessage("---提示内容---");
                dialog.setCancelable(false);
                dialog.setPositiveButton("我知道啦", null);
                dialog.show();
                break;
            case R.id.denglu:
                final LinearLayout denglu=(LinearLayout)getLayoutInflater().inflate(R.layout.denglu,null);
                dialog.setTitle("登录对话框").setMessage("请输入用户id和密码").setView(denglu);
                dialog.setPositiveButton("登录", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText UerId=(EditText)denglu.findViewById(R.id.UerId);
                        EditText Password=(EditText)denglu.findViewById(R.id.Password);
                        if(UerId.getText().toString().equals("abc")&&Password.getText().toString().equals("123"))
                            Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(MainActivity.this,"登录失败",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.setNegativeButton("取消",null);
                dialog.show();
                break;
        }
    }
}
