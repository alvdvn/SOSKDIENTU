package com.example.soskdientu.activity.TiemChung;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.soskdientu.R;
import com.example.soskdientu.activity.khaibaoyte.man2;
import com.example.soskdientu.activity.khaibaoyte.man3;
import com.example.soskdientu.model.CaNhan;
import com.example.soskdientu.model.DangKyTiemChung;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DangKyTiemChungActivity extends AppCompatActivity {
    Intent intent1;
    Button btn;
    EditText hoten,ngaysinh,gioitinh,soCMND,soBHYT,diachi;
    CaNhan caNhan;
    String sdt,co;
    CheckBox chk;
    DangKyTiemChung DKTC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky_tiem_chung);
        anhxa();
        Intent intent = getIntent();
        sdt= intent.getStringExtra("sdt");
        getlistuser(sdt);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (chk.isChecked()){
                    co = "co";
                    DKTC = new DangKyTiemChung(co);
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myreb = database.getReference("user/"+sdt);
                    myreb.child("DangKyTiemChung").child("DangKy").setValue(DKTC, new DatabaseReference.CompletionListener() {
                        @Override
                        public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                            Toast.makeText(getApplicationContext(), "Dang Ky thành công ", Toast.LENGTH_SHORT).show();
                            intent1 = new Intent(DangKyTiemChungActivity.this,TiemSuTiemActivity.class);
                            intent1.putExtra("sdt",sdt);
                            startActivity(intent1);
                        }
                    });
                }else {
                    Toast.makeText(getApplicationContext(), "Vui long xac nhan dang ky ", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
    private void anhxa(){
        hoten = findViewById(R.id.edit1);
        ngaysinh = findViewById(R.id.edit2);
        gioitinh = findViewById(R.id.edit3);
        soCMND = findViewById(R.id.edit4);
        soBHYT = findViewById(R.id.edit5);
        diachi = findViewById(R.id.edit6);
        btn = findViewById(R.id.btnTST);
        chk = findViewById(R.id.dk_chk);
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
                Toast.makeText(getApplicationContext(), "ko thể kết nối sv", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void settext(){
        hoten.setText(caNhan.getHoTen());
        ngaysinh.setText(caNhan.getNamSinh());
        gioitinh.setText(caNhan.getGioiTinh());
        soCMND.setText(caNhan.getSoCanCuoc());
        soBHYT.setText(caNhan.getSoTheBaoHiemYTe());
        diachi.setText(caNhan.getDiaChi());
    }

}