package com.example.soskdientu.activity.MaSoSucKhoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.soskdientu.R;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

public class MaSoSKActivity extends AppCompatActivity {
        ImageView QRcode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma_so_skactivity);
        QRcode = findViewById(R.id.img_qrcode);

        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try {
//            BitMatrix bitMatrix =multiFormatWriter.encode()
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}