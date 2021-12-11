package com.example.soskdientu.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.soskdientu.R;
import com.example.soskdientu.activity.HomeActivity;
import com.example.soskdientu.activity.TiemChung.DangKyTiemChungActivity;
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
    EditText hoten3,tenVacxin3,ngayTiem3,thoiGian3,noiDung3;
    List<PhanUngSauTiem> listPUST;
    PhanUngSauTiem PUST;
    HomeActivity homeActivity;
    MainActivity1 activity;
    CaNhan CN;
    Button btn1,btn2,btn3;

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

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myeref = database.getReference("user/"+sdt1+"/PhanUngSauTiem");
                myeref.removeValue(new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                        Toast.makeText(getContext(),"Xoa thanh cong",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getActivity(), PhanUngSauTiemActivity.class);
                        startActivity(intent);
                    }
                });

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(getActivity());
                View view1 = LayoutInflater.from(getContext()).inflate(R.layout.dialog_phanungsautiem, null);
                builder1.setView(view1);
                Dialog dialog = builder1.create();
                dialog.show();
                hoten3 = view1.findViewById(R.id.put_hoten3);
                tenVacxin3 = view1.findViewById(R.id.put_tenvacxin3);
                ngayTiem3 = view1.findViewById(R.id.put_ngaytiem3);
                thoiGian3 = view1.findViewById(R.id.put_thoigian3);
                noiDung3 = view1.findViewById(R.id.put_noidung3);
                btn3=view.findViewById(R.id.btnLuu3);
                btn3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        FirebaseDatabase database = FirebaseDatabase.getInstance();
                        DatabaseReference myreb = database.getReference("user/"+sdt1);
                        PhanUngSauTiem PU= new PhanUngSauTiem(
                                tenVacxin3.getText().toString()
                                ,ngayTiem3.getText().toString()
                                ,thoiGian3.getText().toString()
                                ,noiDung3.getText().toString());
                        myreb.child("PhanUngSauTiem").setValue(PU, new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                                Toast.makeText(getContext(), "update thành công", Toast.LENGTH_SHORT).show();


                            }
                        });

                    }
                });
            }

        });

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
        btn2 = view.findViewById(R.id.btn_sua);
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

}
