package com.example.soskdientu.activity.khaibaoyte;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.soskdientu.R;
import com.example.soskdientu.model.CaNhan;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.example.soskdientu.model.khaibaoyte;

public class man3 extends AppCompatActivity {
    khaibaoyte khaibao;
    CaNhan caNhan;
    String sdt;
    TextView HT1, NS1, CC1, QT1, SDT1, NOHT;
    RadioButton CO1, CO2, KO1, KO2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man3);
        anhxa();
        Intent intent=getIntent();
        sdt= intent.getStringExtra("sdt");
        getlistuser(sdt);
        getlistuser1(sdt);
    }

    private void anhxa() {
        HT1 = findViewById(R.id.tvHT);
        NS1 = findViewById(R.id.tvNS);
        CC1 = findViewById(R.id.tvCCCD);
        QT1 = findViewById(R.id.tvQT);
        SDT1 = findViewById(R.id.tvSDT);
        NOHT = findViewById(R.id.tvNOHT);
        CO1 = findViewById(R.id.radiobtnCo1);
        CO2 = findViewById(R.id.radiobtnCo2);
        KO1 = findViewById(R.id.radiobtnkhong1);
        KO2 = findViewById(R.id.radiobtnKhong2);
    }

    private void getlistuser(String sdt1) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myreb = database.getReference("user/" + sdt1 + "/HoSoCaNhan");
        myreb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    caNhan = dataSnapshot.getValue(CaNhan.class);
                    settext();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), "ko th??? k???t n???i sv", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void settext() {
        HT1.setText("H??? v?? t??n: "+caNhan.getHoTen());
        NS1.setText("N??m sinh: "+caNhan.getNamSinh());
        CC1.setText("S??? c??n c?????c: "+caNhan.getSoCanCuoc());
        QT1.setText("Qu???c t???ch: "+caNhan.getQuocTich());
        SDT1.setText("S??T: "+sdt);
        NOHT.setText("?????a ch???: "+caNhan.getDiaChi());
    }
    private void getlistuser1(String sdt1) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myreb = database.getReference("user/" + sdt1 + "/khaibaoyte");
        myreb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    khaibao = dataSnapshot.getValue(khaibaoyte.class);
                    if (khaibao.getCauhoi1().equals("co")){
                        CO1.setChecked(true);
                    }else {
                        KO1.setChecked(true);
                    }
                    if (khaibao.getCauhoi2().equals("co")){
                        CO2.setChecked(true);
                    }else {
                        KO2.setChecked(true);
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