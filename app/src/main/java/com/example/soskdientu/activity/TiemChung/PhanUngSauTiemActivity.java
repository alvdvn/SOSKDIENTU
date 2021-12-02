package com.example.soskdientu.activity.TiemChung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.example.soskdientu.R;
import com.example.soskdientu.fragment.HomeFragment;

public class PhanUngSauTiemActivity extends AppCompatActivity {
    EditText hoten;
    String sdt1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phan_ung_sau_tiem);

       Intent intent = getIntent();
//        sdt1 = intent.getStringExtra("sdt");

        hoten.setText(sdt1);

    }

    private void anhxa() {
        hoten = findViewById(R.id.edit1);
    }
}