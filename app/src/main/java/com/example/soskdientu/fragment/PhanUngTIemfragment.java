package com.example.soskdientu.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.soskdientu.R;
import com.example.soskdientu.activity.HomeActivity;
import com.example.soskdientu.activity.TiemChung.MainActivity1;
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
    String sdt1,hoTen;
    TextView hoten,tenVacxin,ngayTiem,thoiGian,noiDung;
    List<PhanUngSauTiem> listPUST;
    PhanUngSauTiem PUST;
    HomeActivity homeActivity;
    MainActivity1 activity;
    CaNhan CN;
    Button btn1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_phan_ung_tiem, container, false);
        activity = (MainActivity1) getActivity();
        sdt1= activity.getSdt1();
        hoTen = activity.getHoten();
        anhxa();
        hoten.setText("Ho Ten: "+hoTen);
        getlistuser(sdt1);

//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                new AlertDialog.Builder( getActivity())
//                        .setTitle("RealtimeDatabase").setMessage("Ban muon xoa noi dung phan ung tiem nay khong?")
//                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                                FirebaseDatabase database = FirebaseDatabase.getInstance();
//                                DatabaseReference myref = database.getReference("user/"+sdt1+"/PhanUngSauTiem");
//                                myref.removeValue(new DatabaseReference.CompletionListener() {
//                                    @Override
//                                    public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
//                                        Toast.makeText(getContext(),"Xoa thanh cong",Toast.LENGTH_SHORT).show();
//                                    }
//                                });
//                            }
//                        });
//
//            }
//        });

        return view;
    }
    private  void  anhxa(){
        listPUST = new ArrayList<>();
        hoten = view.findViewById(R.id.put_hoten1);
        tenVacxin = view.findViewById(R.id.put_tenvacxin1);
        ngayTiem = view.findViewById(R.id.put_ngaytiem1);
        thoiGian = view.findViewById(R.id.put_thoigian1);
        noiDung = view.findViewById(R.id.put_noidung1);
        btn1 = view.findViewById(R.id.btn_xoa);
    }
    private void getlistuser(String sdt1){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myreb = database.getReference("user/"+sdt1+"/PhanUngSauTiem");
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

        tenVacxin.setText("Loai Vacxin: "+PUST.getTenVacxin());
        ngayTiem.setText("Ngay Tiem: "+PUST.getNgayTiem());
        thoiGian.setText("Thoi gian tiem: "+PUST.getThoiGian());
        noiDung.setText("Noi dung phan ung: "+PUST.getNoidDung());
    }
    private void onClickDeletePUST(){
        new AlertDialog.Builder( getActivity())
                .setTitle("RealtimeDatabase").setMessage("Ban muon xoa noi dung phan ung tiem nay khong?")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseDatabase database = FirebaseDatabase.getInstance();
                        DatabaseReference myref = database.getReference("user/"+sdt1+"/PhanUngSauTiem");
                        myref.removeValue(new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                                Toast.makeText(getContext(),"Xoa thanh cong",Toast.LENGTH_SHORT).show();
//                                Intent intent1 = new Intent(PhanUngSauTiemActivity.this, MainActivity1.class);

                            }
                        });
                    }
                });
    }



}
