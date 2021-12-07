package com.example.soskdientu.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.soskdientu.R;
import com.example.soskdientu.activity.HomeActivity;
import com.example.soskdientu.activity.TiemChung.PhanUngSauTiemActivity;
import com.example.soskdientu.model.CaNhan;
import com.example.soskdientu.model.PhanUngSauTiem;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PhanUngTIemfragment extends Fragment {

    View view;
    String sdt1;
    TextView hoten,tenVacxin,ngayTiem,thoiGian,noiDung;
    List<PhanUngSauTiem> listPUST;
    PhanUngSauTiem PUST;
    HomeActivity homeActivity;
    PhanUngSauTiemActivity activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_phan_ung_tiem, container, false);
//        homeActivity = (HomeActivity) getActivity();
//        sdt1= homeActivity.getSdt1();
        anhxa();
        getlistuser(sdt1);
        return view;
    }
    private  void  anhxa(){
        listPUST = new ArrayList<>();
        hoten = view.findViewById(R.id.put_hoten1);
        tenVacxin = view.findViewById(R.id.put_tenvacxin1);
        ngayTiem = view.findViewById(R.id.put_ngaytiem1);
        thoiGian = view.findViewById(R.id.put_ngaytiem1);
        noiDung = view.findViewById(R.id.put_noidung1);
    }
    private void getlistuser(String sdt1){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myreb = database.getReference("user/"+sdt1+"/PhanUngNguoiDung");
        myreb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    PUST = dataSnapshot.getValue(PhanUngSauTiem.class);
                    settext();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "ko thể kết nối sv", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void settext(){
        hoten.setText(PUST.getHoTen());
        tenVacxin.setText(PUST.getTenVacxin());
        ngayTiem.setText(PUST.getNgayTiem());
        thoiGian.setText(PUST.getThoiGian());
        noiDung.setText(PUST.getNoidDung());
    }
}
