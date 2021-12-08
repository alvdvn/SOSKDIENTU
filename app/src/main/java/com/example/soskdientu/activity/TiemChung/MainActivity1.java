package com.example.soskdientu.activity.TiemChung;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.soskdientu.R;
import com.example.soskdientu.fragment.HoSoCaNhanFragment;
import com.example.soskdientu.fragment.PhanUngTIemfragment;

public class MainActivity1 extends AppCompatActivity {
    String sdt1,hoten;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        Intent intent = getIntent();
        sdt1 = intent.getStringExtra("sdt");

        hoten = intent.getStringExtra("hoten");

        SendDataToFragment1();
        SendDataToFragment2();


        getSupportFragmentManager().beginTransaction().add(R.id.frg,new PhanUngTIemfragment()).commit();


    }
    private  void SendDataToFragment1(){
        sdt1.trim();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frg,new PhanUngTIemfragment());
        fragmentTransaction.commit();


    }
    private  void SendDataToFragment2(){
        hoten.trim();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frg,new PhanUngTIemfragment());
        fragmentTransaction.commit();


    }

    public String getSdt1() {
        return sdt1;
    }
    public String getHoten(){
        return hoten;
    }
}