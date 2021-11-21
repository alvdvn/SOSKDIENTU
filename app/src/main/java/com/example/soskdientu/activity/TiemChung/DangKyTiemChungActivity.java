package com.example.soskdientu.activity.TiemChung;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.soskdientu.R;

public class DangKyTiemChungActivity extends AppCompatActivity {
    Intent intent;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky_tiem_chung);

        btn = findViewById(R.id.btnTST);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(DangKyTiemChungActivity.this,TiemSuTiemActivity.class);
                startActivity(intent);
            }
        });
    }
}