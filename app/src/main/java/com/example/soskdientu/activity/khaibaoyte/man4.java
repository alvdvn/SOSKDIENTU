package com.example.soskdientu.activity.khaibaoyte;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.soskdientu.R;

public class man4 extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man4);
        button = findViewById(R.id.btnQuaylai);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(man4.this,man1.class);
                startActivity(intent);
            }
        });
    }



}