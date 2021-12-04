package com.example.soskdientu.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.soskdientu.R;
import com.example.soskdientu.activity.DatLichKham.SearchActivity;
import com.example.soskdientu.activity.HoSoSucKhoe.Hososuckhoe;
import com.example.soskdientu.activity.HomeActivity;
import com.example.soskdientu.activity.TiemChung.PhanUngSauTiemActivity;
import  com.example.soskdientu.activity.khaibaoyte.man1;
import  com.example.soskdientu.activity.khaibaoyte.man2;
import  com.example.soskdientu.activity.khaibaoyte.man3;


public class HomeFragment extends Fragment {
    ImageView Khaibao,Hososk,datlich;
    TextView hoten;
    View view;
    String sdt;
    ImageView btnphanung;
    HomeActivity homeActivity;
    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home, container, false);
            homeActivity = (HomeActivity) getActivity();
            anhxa();
            sdt = homeActivity.getSdt1();
            hoten.setText(sdt);
            btnphanung.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), PhanUngSauTiemActivity.class);
                    intent.putExtra("sdt",sdt);
                  startActivity(intent);

                }
            });
            Khaibao.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), man1.class);
                    intent.putExtra("sdt",sdt);
                    getActivity().startActivity(intent);
                }
            });
            datlich.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), SearchActivity.class);
                    intent.putExtra("sdt",sdt);
                    getActivity().startActivity(intent);
                }
            });
            Hososk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), Hososuckhoe.class);
                    intent.putExtra("sdt",sdt);
                    startActivity(intent);
                }
            });
        return view;

    }
    private void anhxa(){
        hoten = view.findViewById(R.id.tv_hvt);
        datlich = view.findViewById(R.id.datlich);
        btnphanung =view.findViewById(R.id.phanung);
        Hososk = view.findViewById(R.id.hososk);
        Khaibao = view.findViewById(R.id.khaibao);
    }


}