package com.example.soskdientu.activity.khaibaoyte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.soskdientu.R;

public class man1 extends AppCompatActivity {
    String sdt;
    Button button,btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man1);
        Intent intent = getIntent();
        sdt = intent.getStringExtra("sdt");
        button=findViewById(R.id.btnKhaibao);
        btn1=findViewById(R.id.btnChitiet);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(man1.this,man2.class);
                intent.putExtra("sdt",sdt);
                startActivity(intent);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(man1.this,man5.class);
                intent.putExtra("sdt",sdt);
                startActivity(intent);
            }
        });
    }
}