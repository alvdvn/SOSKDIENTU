package com.example.soskdientu.activity.TiemChung;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.soskdientu.R;

public class DangKyTiemChungActivity extends AppCompatActivity {
    Intent intent;
    Button btn;
    EditText hoten,ngaysinh,gioitinh,soCMND,soBHYT,diachi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky_tiem_chung);
        anhxa();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(DangKyTiemChungActivity.this,TiemSuTiemActivity.class);
                startActivity(intent);
            }
        });
    }
    private void anhxa(){
        hoten = findViewById(R.id.edit1);
        ngaysinh = findViewById(R.id.edit2);
        gioitinh = findViewById(R.id.edit3);
        soCMND = findViewById(R.id.edit4);
        soBHYT = findViewById(R.id.edit5);
        diachi = findViewById(R.id.edit6);
    }
}