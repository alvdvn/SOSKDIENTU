package com.example.soskdientu.activity.HoSoSucKhoe;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.soskdientu.R;
import com.example.soskdientu.activity.CaNhanActivity;
import com.example.soskdientu.activity.HomeActivity;
import com.example.soskdientu.model.HsSucKhoe;
import com.example.soskdientu.model.Nguoidung;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Hososuckhoe extends AppCompatActivity {
EditText ht2,sdt2,ns2,gt2,scc2,sbhyt2,nd2,ha2,cc2,cn2,nt2,nm2;
Button btnluu2;
//List<HsSucKhoe> listsk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hososuckhoe);
//        listsk = new ArrayList<>();
//        getlistuser();
        anhxa();
        Intent intent = getIntent();
        String sdt = intent.getStringExtra("sdt");
        sdt2.setText(sdt);
        btnluu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myreb = database.getReference("user/"+sdt);
                HsSucKhoe hsSucKhoe = new HsSucKhoe(

                        nd2.getText().toString(),ha2.getText().toString(),nm2.getText().toString(),
                        nt2.getText().toString(),cc2.getText().toString(),cn2.getText().toString());
                myreb.child("HoSoSuckhoe").child("hoso").setValue(hsSucKhoe, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                        Toast.makeText(getApplicationContext(), "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                        Intent intent2 = new Intent(Hososuckhoe.this, HomeActivity.class);
                        intent2.putExtra("sdt",sdt);
                        startActivity(intent2);
                    }
                });
            }
        });
    }
    public void anhxa(){
        ht2=findViewById(R.id.et_hovaten2);
        gt2=findViewById(R.id.et_gioitinh2);

        ns2=findViewById(R.id.et_namsinh2);
        sdt2=findViewById(R.id.et_sodienthoai2);
        scc2=findViewById(R.id.et_socancuoc2);
        sbhyt2=findViewById(R.id.et_sothebaohiemyte2);
        cc2=findViewById(R.id.et_chieucao2);
        cn2=findViewById(R.id.et_cannang2);
        nt2=findViewById(R.id.et_nhiptim2);
        nm2=findViewById(R.id.et_nhommau2);
        nd2=findViewById(R.id.et_nhietđo2);
        ha2=findViewById(R.id.et_huyetap2);
        btnluu2=findViewById(R.id.btnLuu2);


    }
//    private void getlistuser(){
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference   myreb = database.getReference("user");
//        myreb.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
//                    HsSucKhoe hsSucKhoe =dataSnapshot.getValue(HsSucKhoe.class);
//                    listsk.add(hsSucKhoe);
////                    Nguoidung nguoidung = dataSnapshot.getValue(Nguoidung.class);
////                    listnd.add(nguoidung);
//                }
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Toast.makeText(getApplicationContext(), "ko thể kết nối sv", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//
//    }
}