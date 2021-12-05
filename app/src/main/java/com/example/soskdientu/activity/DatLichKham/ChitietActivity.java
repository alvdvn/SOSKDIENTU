package com.example.soskdientu.activity.DatLichKham;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.soskdientu.R;

public class ChitietActivity extends AppCompatActivity {
    TextView hoten,cmnd,ngaykham,giokham,trieuchung,bẹnhvien;
    CheckBox co,khong;
    String hoten1,cmnd1,ngaykham1,giokham1,trieuchung1,sdt,bhyt,tenbv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitiet);
        anhxa();
        getdata();
        hoten.setText("Họ và tên : "+hoten1);
        cmnd.setText("Số CMND/CCCD: "+cmnd1);
        bẹnhvien.setText("Bệnh viện: "+tenbv);
        ngaykham.setText("Ngày khám : "+ngaykham1);
        giokham.setText("Giờ khám: "+giokham1);
        trieuchung.setText("Triệu chứng: "+trieuchung1);
        if(bhyt.equals("co")){
            co.setChecked(true);
        }else{
            khong.setChecked(true);
        }



    }

    private void anhxa(){
        hoten=findViewById(R.id.tv_hvtct);
        cmnd = findViewById(R.id.tv_cmndct);
        bẹnhvien = findViewById(R.id.tv_benhvienct);
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
        tenbv = bundle.getString("ten");

    }
}