package com.example.soskdientu.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.soskdientu.R;
import com.example.soskdientu.activity.DatLichKham.SearchActivity;
import com.example.soskdientu.activity.HoSoSucKhoe.HSSKhienthiActivity;
import com.example.soskdientu.activity.HoSoSucKhoe.Hososuckhoe;
import com.example.soskdientu.activity.HomeActivity;
import com.example.soskdientu.activity.TiemChung.PhanUngSauTiemActivity;
import com.example.soskdientu.model.HsSucKhoe;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class HomeFragment extends Fragment {
    ImageView Khaibao,Hososk,datlich;
    TextView hoten;
    View view;
    String sdt;
    ImageView btnphanung;
    HsSucKhoe hsSucKhoe;
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
            datlich.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), SearchActivity.class);
                    intent.putExtra("sdt",sdt);
                    startActivity(intent);
                }
            });
            Hososk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getHSSK(sdt);
                }
            });
        return view;

    }
    private void anhxa(){
        hsSucKhoe = new HsSucKhoe();
        hoten = view.findViewById(R.id.tv_hvt);
        datlich = view.findViewById(R.id.datlich);
        btnphanung =view.findViewById(R.id.phanung);
        Hososk = view.findViewById(R.id.hososk);
    }
    private void  getHSSK(String sdt1){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myreb = database.getReference("user/" + sdt1 + "/HoSoSucKhoe");
        myreb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    hsSucKhoe = dataSnapshot.getValue(HsSucKhoe.class);


                }
                    if(hsSucKhoe!=null){
                        Intent intent = new Intent(getActivity(), HSSKhienthiActivity.class);
                        intent.putExtra("sdt",sdt1);
                        startActivity(intent);
                    }else{
                        Intent intent = new Intent(getActivity(), Hososuckhoe.class);
                        intent.putExtra("sdt",sdt1);
                        startActivity(intent);
                    }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "ko thể kết nối sv", Toast.LENGTH_SHORT).show();
            }

        });
    }


}