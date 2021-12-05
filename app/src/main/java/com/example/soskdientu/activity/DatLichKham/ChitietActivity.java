package com.example.soskdientu.activity.DatLichKham;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.soskdientu.R;

public class ChitietActivity extends AppCompatActivity {
    TextView hoten,cmnd,ngaykham,giokham,trieuchung;
    CheckBox co,khong;
    String hoten1,cmnd1,ngaykham1,giokham1,trieuchung1,sdt,bhyt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitiet);
        anhxa();
        getdata();
        hoten.setText(hoten1);
        cmnd.setText(cmnd1);
        ngaykham.setText(ngaykham1);
        giokham.setText(giokham1);
        trieuchung.setText(trieuchung1);
        if (bhyt.equals("Có")) {
            co.setSelected(true);
        }else{
            khong.setSelected(true);
        }



    }

    private void anhxa(){
        hoten=findViewById(R.id.tv_hvtct);
        cmnd = findViewById(R.id.tv_cmndct);
        ngaykham = findViewById(R.id.ngaykhamct);
        giokham= findViewById(R.id.giokhamct);
        trieuchung = findViewById(R.id.tv_trieuchungchitiet);
        co = findViewById(R.id.cb_co);
        khong = findViewById(R.id.cb_ko);

    }
    private void getdata(){
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        sdt=  bundle.getString("sdt");
        hoten1=  bundle.getString("hoten");
        cmnd1 = bundle.getString("cmnd");
        ngaykham1 =bundle.getString("ngaykham");
        giokham1 = bundle.getString("giokham");
        trieuchung1=  bundle.getString("trieuchung");
        bhyt=bundle.getString("bhyt");
    }
}