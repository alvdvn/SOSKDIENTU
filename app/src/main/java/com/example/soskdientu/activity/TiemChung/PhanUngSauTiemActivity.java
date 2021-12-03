package com.example.soskdientu.activity.TiemChung;

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
import com.example.soskdientu.fragment.HomeFragment;
import com.example.soskdientu.fragment.PhanUngTIemfragment;
import com.example.soskdientu.model.CaNhan;
import com.example.soskdientu.model.PhanUngSauTiem;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PhanUngSauTiemActivity extends AppCompatActivity {
    EditText hoten,ngayTiem,tenVacxin,thoiGian,noidDung;
    Button btn;
    String sdt1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phan_ung_sau_tiem);

        anhxa();
        Intent intent = getIntent();
        sdt1 = intent.getStringExtra("sdt");
        hoten.setText(sdt1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myreb = database.getReference("user/"+sdt1);
                PhanUngSauTiem PhanUngSauTiem= new PhanUngSauTiem(
                        hoten.getText().toString(),
                        tenVacxin.getText().toString(),
                        ngayTiem.getText().toString(),
                        thoiGian.getText().toString(),
                        noidDung.getText().toString());
                myreb.child("PhanUngSauTiem").child("PhanUngNguoiDung").setValue(PhanUngSauTiem, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                        Toast.makeText(getApplicationContext(), "Nhập thông tin thành công", Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(PhanUngSauTiemActivity.this, PhanUngTIemfragment.class);
                        intent1.putExtra("sdt",sdt1);
                        startActivity(intent1);
                    }
                });
            }
        });

    }

    private void anhxa() {

        hoten = findViewById(R.id.edit1);
        ngayTiem = findViewById(R.id.put_ngayTiem);
        tenVacxin = findViewById(R.id.put_tenvacxin);
        thoiGian = findViewById(R.id.put_thoigian);
        noidDung = findViewById(R.id.put_noidung);
        btn = findViewById(R.id.btn_put);
    }
}