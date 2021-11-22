package com.example.soskdientu.adapter;

import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.soskdientu.fragment.DatLichFragment;
import com.example.soskdientu.fragment.HoSoCaNhanFragment;
import com.example.soskdientu.fragment.HomeFragment;
import com.example.soskdientu.fragment.ThongbaoFragment;

public class ViewpagerAdapter extends FragmentStatePagerAdapter {
    public ViewpagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new DatLichFragment();
            case 2:
                return new ThongbaoFragment();
            case 3:
                return new HoSoCaNhanFragment();

        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }

//    @Nullable
//    @Override
//    public CharSequence getPageTitle(int position) {
//        String title ="";
//       switch (position){
//           case 0:
//               title ="home";
//               break;
//           case 1:
//               title = "lich";
//               break;
//           case 2:
//               title = "tb";
//               break;
//           case 3:
//               title = "HS";
//               break;
//
//       }
//       return title;
//    }
}
