package com.example.soskdientu.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.soskdientu.R;
import com.example.soskdientu.activity.Dangnhap_Dawngky.LoginActivity;

public class ChaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(ChaoActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);


    }
}
