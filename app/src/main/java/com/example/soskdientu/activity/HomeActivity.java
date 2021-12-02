package com.example.soskdientu.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;

import com.example.soskdientu.R;
import com.example.soskdientu.adapter.ViewpagerAdapter;
import com.example.soskdientu.fragment.HoSoCaNhanFragment;
import com.example.soskdientu.fragment.HomeFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HomeActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    String sdt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
         sdt1=intent.getStringExtra("sdt");
         SendDataToFragment();
         SendDataToFragment1();
        setContentView(R.layout.activity_home);
        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);
        ViewpagerAdapter adpter = new ViewpagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adpter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.home1);
        tabLayout.getTabAt(1).setIcon(R.drawable.lich1);
        tabLayout.getTabAt(2).setIcon(R.drawable.chuong5);
        tabLayout.getTabAt(3).setIcon(R.drawable.nguoidung1);


    }
    private  void SendDataToFragment(){
        sdt1.trim();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.viewpager,new HomeFragment());
        fragmentTransaction.commit();


    }
    private  void SendDataToFragment1(){
        sdt1.trim();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.viewpager,new HoSoCaNhanFragment());
        fragmentTransaction.commit();


    }

    public String getSdt1() {
        return sdt1;
    }
}