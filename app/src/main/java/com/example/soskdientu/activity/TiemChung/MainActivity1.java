package com.example.soskdientu.activity.TiemChung;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.soskdientu.R;
import com.example.soskdientu.fragment.PhanUngTIemfragment;

public class MainActivity1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        getSupportFragmentManager().beginTransaction().add(R.id.frg,new PhanUngTIemfragment()).commit();
    }
}