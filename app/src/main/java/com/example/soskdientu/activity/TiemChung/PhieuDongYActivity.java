package com.example.soskdientu.activity.TiemChung;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.soskdientu.R;
import com.example.soskdientu.model.CaNhan;
import com.example.soskdientu.model.HsSucKhoe;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class PhieuDongYActivity extends AppCompatActivity {

    ImageView QRcode;
    String sdt;
    String text;
    CaNhan caNhan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phieu_dong_yactivity);
        Intent intent = getIntent();
        sdt = intent.getStringExtra("sdt");
        caNhan = new CaNhan();
        QRcode = findViewById(R.id.img_qrcode);
        try {
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myreb = database.getReference("user/" + sdt + "/HoSoCaNhan");
            myreb.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        caNhan = dataSnapshot.getValue(CaNhan.class);


                    }

                    text = "Ho Ten: " + caNhan.getHoTen() + "\n"
                            + "Ngay Sinh: " + caNhan.getNamSinh() + "\n"
                            + "Gioi Tinh: " + caNhan.getGioiTinh() + "\n"
                            + "So CMND: " + caNhan.getSoCanCuoc() + "\n"
                            + "So BHYT: " + caNhan.getSoTheBaoHiemYTe() + "\n"
                            + "Dia Chi: " + caNhan.getDiaChi() + "\n";

                    MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                    try {

                        BitMatrix bitMatrix =multiFormatWriter.encode(text, BarcodeFormat.QR_CODE,700,700);
                        BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                        Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                        QRcode.setImageBitmap(bitmap);

                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(getApplicationContext(), "ko thể kết nối sv", Toast.LENGTH_SHORT).show();
                }

            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}