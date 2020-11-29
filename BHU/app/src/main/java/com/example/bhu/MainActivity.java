package com.example.bhu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private  static final String TAG ="MainActivity";
    private EditText accountEdit;
    private EditText passwordEdit;
    private String accountLogin,passwordLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        accountEdit = findViewById(R.id.accountLogin);
       passwordEdit= findViewById(R.id.passwordLogin);
        Button back =(Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Button registe = findViewById(R.id.register);
        registe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
        Button login =(Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences store=getSharedPreferences("accountInfo", Context.MODE_PRIVATE);
                accountLogin =accountEdit.getText().toString().trim();
                passwordLogin =passwordEdit.getText().toString().trim();
                String accountRe=store.getString("accountRe","");
                String passwordRe=store.getString("passwordRe","");
                //Log.d(TAG, accountLogin);
               // Log.d(TAG, passwordLogin);
                Log.d(TAG, accountRe);
                Log.d(TAG, passwordRe);
                if(accountLogin.equals(accountRe)&&passwordLogin.equals(passwordRe)){
                    Toast.makeText(MainActivity.this,"登陆成功！",Toast.LENGTH_SHORT).show();
                }
                else{Toast.makeText(MainActivity.this,"错误",Toast.LENGTH_SHORT).show();}
            }
        });
    }
}
