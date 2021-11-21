package com.example.soskdientu.activity.TiemChung;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.soskdientu.R;

public class TiemSuTiemActivity extends AppCompatActivity {
    Button btn1,btn2;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiem_su_tiem);
        btn1 = findViewById(R.id.btnQL);
        btn2 = findViewById(R.id.btnNext);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(TiemSuTiemActivity.this,DangKyTiemChungActivity.class);
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(TiemSuTiemActivity.this,PhieuDongYActivity.class);
                startActivity(intent);
            }
        });
    }
}