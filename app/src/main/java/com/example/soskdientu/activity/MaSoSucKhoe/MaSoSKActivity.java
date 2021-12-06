package com.example.soskdientu.activity.MaSoSucKhoe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

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

public class MaSoSKActivity extends AppCompatActivity {
        ImageView QRcode;
        String sdt;
        String nhietDo,huyetAp,nhomMau,nhipTim,chieuCao,canNang;
        String hoTen,namSinh,cccd,text;
        CaNhan caNhan;
        HsSucKhoe sucKhoe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma_so_skactivity);
        Intent intent = getIntent();
        sdt = intent.getStringExtra("sdt");
        caNhan= new CaNhan();
        sucKhoe = new HsSucKhoe();
        QRcode = findViewById(R.id.img_qrcode);
        getlistuser(sdt);
        getlistHS(sdt);
        try {
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myreb = database.getReference("user/"+sdt+"/HoSoCaNhan");
            myreb.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        caNhan = dataSnapshot.getValue(CaNhan.class);


                    }

                    text = "Name: "+ caNhan.getHoTen() +"\n"
                            +"Birthday: "+caNhan.getNamSinh() +"\n"
                            +"CMND/CCCD: "+caNhan.getSoCanCuoc() +"\n";

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(getApplicationContext(), "ko thể kết nối sv", Toast.LENGTH_SHORT).show();
                }

            });

        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myreb = database.getReference("user/" + sdt + "/HoSoSuckhoe");
            myreb.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        sucKhoe = dataSnapshot.getValue(HsSucKhoe.class);


                    }
                text=  text  +"Height : "+sucKhoe.getChieuCao() +"\n"
                            +"Weight : "+sucKhoe.getCanNang() +"\n"
                            +"Blood group: "+sucKhoe.getNhomMau() +"\n"
                            +"temperature: "+sucKhoe.getNhietDo() +"\n"
                            +"Blood Pressure: "+sucKhoe.getHuyetAp() +"\n"
                            +"Heartbeat : "+sucKhoe.getNhipTim() +"\n";
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
        }catch (Exception e){
            e.printStackTrace();
        }





    }



    private void anhxa(){

    }
    private void getlistuser(String sdt1){


    }
    private void getlistHS(String sdt1) {

    }
}