package com.example.soskdientu.activity.khaibaoyte;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.soskdientu.R;
import com.example.soskdientu.activity.HoSoSucKhoe.HSSKhienthiActivity;
import com.example.soskdientu.activity.HoSoSucKhoe.Hososuckhoe;
import com.example.soskdientu.model.CaNhan;
import com.example.soskdientu.model.HsSucKhoe;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.example.soskdientu.model.khaibaoyte;

public class man2 extends AppCompatActivity {
    khaibaoyte khaibao;
    CaNhan caNhan;
    Button btn;
    String sdt,cauhoi1,cauhoi2;
    EditText HT1,NS1,CC1,QT1,SDT1,NOHT;
    RadioButton CO1,CO2,KO1,KO2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man2);
        anhxa();
        Intent intent=getIntent();
        sdt= intent.getStringExtra("sdt");
        getlistuser(sdt);
            btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (CO1.isChecked()){
                    cauhoi1="co";
                }else {
                    cauhoi1="ko";
                }
                if (CO2.isChecked()){
                    cauhoi2="co";
                }else {
                    cauhoi2="ko";
                }
                khaibao=new khaibaoyte(cauhoi1,cauhoi2);
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myreb = database.getReference("user/"+sdt);
                myreb.child("khaibaoyte").child("khaibao").setValue(khaibao, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                        Toast.makeText(getApplicationContext(), "Khai báo thành công ", Toast.LENGTH_SHORT).show();
                        Intent intent2 = new Intent(man2.this, man3.class);
                        intent2.putExtra("sdt",sdt);
                        startActivity(intent2);
                    }
                });
            }
        });

    }
    private void anhxa(){
        btn = findViewById(R.id.btnTST);
        HT1=findViewById(R.id.EDHT);
        NS1=findViewById(R.id.EDNS);
        CC1=findViewById(R.id.EDCCCD);
        QT1=findViewById(R.id.EDQT);
        SDT1=findViewById(R.id.EDSDT);
        CO1=findViewById(R.id.RDOC1);
        CO2=findViewById(R.id.RDOC2);
        KO1=findViewById(R.id.RDOK1);
        KO2=findViewById(R.id.RDOK2);
        NOHT=findViewById(R.id.EDNOHT);
    }
    private void getlistuser(String sdt1){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myreb = database.getReference("user/"+sdt1+"/HoSoCaNhan");
        myreb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    caNhan = dataSnapshot.getValue(CaNhan.class);
                    settext();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), "ko thể kết nối sv", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void settext(){
        HT1.setText(caNhan.getHoTen());
        NS1.setText(caNhan.getNamSinh());
        CC1.setText(caNhan.getSoCanCuoc());
        QT1.setText(caNhan.getQuocTich());
        SDT1.setText(sdt);
        NOHT.setText(caNhan.getDiaChi());
    }
}