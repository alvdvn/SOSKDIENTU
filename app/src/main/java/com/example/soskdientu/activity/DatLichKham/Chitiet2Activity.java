package com.example.soskdientu.activity.DatLichKham;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.soskdientu.R;
import com.example.soskdientu.activity.HomeActivity;
import com.example.soskdientu.adapter.LichkhamAdapter;
import com.example.soskdientu.model.DatLichKham;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Chitiet2Activity extends AppCompatActivity {
    TextView hoten,cmnd,ngaykham,giokham,trieuchung,benhvien;
    CheckBox co,khong;

    List<DatLichKham> listlk;
    String sdt,ngaykham1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitiet2);
        anhxa();
        listlk = new ArrayList<>();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        sdt = bundle.getString("sdt");
        ngaykham1 = bundle.getString("date");

        getlistlk(sdt, ngaykham1);

    }
    private void anhxa(){

        hoten=findViewById(R.id.tv_hvtct1);
        cmnd = findViewById(R.id.tv_cmndct1);
        benhvien = findViewById(R.id.tv_benhvienct1);
        ngaykham = findViewById(R.id.ngaykhamct1);
        giokham= findViewById(R.id.giokhamct1);
        trieuchung = findViewById(R.id.tv_trieuchungchitiet1);
        co = findViewById(R.id.cb_co1);
        khong = findViewById(R.id.cb_ko1);

    }

    private void getlistlk(String sdt1 ,String date){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myreb = database.getReference("user/"+sdt1+"/LichKham");
        myreb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    DatLichKham lichKham = dataSnapshot.getValue(DatLichKham.class);
                    listlk.add(lichKham);
                }
                if (listlk!=null) {
                    for (DatLichKham x : listlk) {
                        if (x.getDate().equals(date)) {
                            hoten.setText("H??? v?? t??n : " + x.getHoten());
                            cmnd.setText("S??? CMND/CCCD: " + x.getCMND());
                            benhvien.setText("B???nh vi???n: " + x.getBenhvien());
                            ngaykham.setText("Ng??y kh??m : " + x.getDate());
                            giokham.setText("Gi??? kh??m: " + x.getTime());
                            trieuchung.setText("Tri???u ch???ng: " + x.getTrieuchung());
                            if (x.getBHYT().equals("co")) {
                                co.setChecked(true);
                            } else {
                                khong.setChecked(true);
                            }
                        }
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), "ko th??? k???t n???i sv", Toast.LENGTH_SHORT).show();
            }
        });
    }
}