package com.example.soskdientu.activity.TiemChung;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.soskdientu.R;
import com.example.soskdientu.model.CaNhan;
import com.example.soskdientu.model.PhanUngSauTiem;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TiemSuTiemActivity extends AppCompatActivity {
    TextView hoTen,ngaySinh,gioiTinh,soCMND,soBHYT,diaChi;
    Button btn1;
    CaNhan CN;
    String sdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiem_su_tiem);
        anhxa();
        Intent intent=getIntent();
        sdt= intent.getStringExtra("sdt");
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myreb = database.getReference("user/" + sdt + "/HoSoCaNhan");
        myreb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    CN = dataSnapshot.getValue(CaNhan.class);
                }
                hoTen.setText("Họ và tên: "+CN.getHoTen());
                ngaySinh.setText("Ngay sinh: "+CN.getNamSinh());
                gioiTinh.setText("Gioi tinh: "+CN.getGioiTinh());
                soCMND.setText("So can cuoc: "+CN.getSoCanCuoc());
                soBHYT.setText("So the bao hiem: "+CN.getSoTheBaoHiemYTe());
                diaChi.setText("Địa chỉ: "+CN.getDiaChi());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), "ko thể kết nối sv", Toast.LENGTH_SHORT).show();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(TiemSuTiemActivity.this,PhieuDongYActivity.class);
                intent1.putExtra("sdt",sdt);
                startActivity(intent1);
            }
        });
    }
    private void anhxa(){
        CN= new CaNhan();
        hoTen = findViewById(R.id.dk_hoTen);
        ngaySinh = findViewById(R.id.dk_ngaySinh);
        gioiTinh = findViewById(R.id.dk_gioiTinh);
        soCMND = findViewById(R.id.dk_soCMND);
        soBHYT = findViewById(R.id.dk_soBHYT);
        diaChi = findViewById(R.id.dk_diaChi);
        btn1 = findViewById(R.id.madk);

    }
    private void getlistuser(String sdt1) {

    }
    private void settext() {
        hoTen.setText("Họ và tên: "+CN.getHoTen());
        ngaySinh.setText("Ngay sinh: "+CN.getNamSinh());
        gioiTinh.setText("Gioi tinh: "+CN.getGioiTinh());
        soCMND.setText("So can cuoc: "+CN.getSoCanCuoc());
        soBHYT.setText("So the bao hiem: "+CN.getSoTheBaoHiemYTe());
        diaChi.setText("Địa chỉ: "+CN.getDiaChi());
    }
}