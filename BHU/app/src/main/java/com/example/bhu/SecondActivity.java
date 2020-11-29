package com.example.bhu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "SecondActivity";
    private EditText accountEdit;
    private EditText passwordEdit;
    private  EditText passwordEdit2;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        accountEdit=(EditText) findViewById(R.id.account);
        passwordEdit=(EditText) findViewById(R.id.password);
        passwordEdit2=(EditText) findViewById(R.id.passwordAgain);
        Button zhuche=(Button) findViewById(R.id.Zchuche);
        zhuche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ImageButton tencent=(ImageButton) findViewById(R.id.tencent);
        tencent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SecondActivity.this,"正在跳转...",Toast.LENGTH_SHORT).show();
            }
        });
        ImageButton xinlang=(ImageButton) findViewById(R.id.xinlang);
        xinlang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SecondActivity.this,"正在跳转...",Toast.LENGTH_SHORT).show();
            }
        });
        Button  register =(Button) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences Store =getSharedPreferences("accountInfo", Context.MODE_PRIVATE);
                String accountStore =accountEdit.getText().toString();
                String passwordStore =passwordEdit.getText().toString();
                String passwordStore2 =passwordEdit2.getText().toString();
                SharedPreferences.Editor store =Store.edit();
                store.putString("accountRE",accountStore);
                store.putString("passwordRE",passwordStore);
                store.putString("passwordRE2",passwordStore2);
                store.commit();
                SharedPreferences Test=getSharedPreferences("accountInfo",Context.MODE_PRIVATE);
                String test =Test.getString("accountRe","");
                Log.d(TAG,test);
               // Log.d(TAG,passwordStore);
                Toast.makeText(SecondActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
               // Intent intent=new Intent(SecondActivity.this,MainActivity.class);
             //   startActivity(intent);
                finish();
            }
        });
    }
}
