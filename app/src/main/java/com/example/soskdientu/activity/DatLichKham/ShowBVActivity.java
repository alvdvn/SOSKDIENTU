package com.example.soskdientu.activity.DatLichKham;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.soskdientu.R;

public class ShowBVActivity extends AppCompatActivity {
    TextView ten,diachi,sdt1,website,fanpage,email;
    Button datlich;
    String tenbv,diachibv,sodt1,email1,website1,fanpage1 ,sdt;
    Intent intent;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bvactivity);
        intent = getIntent();
        bundle = intent.getExtras();
        anhxa();
        tenbv= bundle.getString("tenbv");
        diachibv =bundle.getString("diachi");
        sodt1 = bundle.getString("phone");
        email1 = bundle.getString("email");
        website1 = bundle.getString("website");
        fanpage1 = bundle.getString("fanpage");
        sdt = bundle.getString("sodt");
       ten.setText(tenbv);
       diachi.setText(diachibv);
       sdt1.setText("Số điện thoại: "+sodt1);
       email.setText("Email: "+email1);
       website.setText("Website: "+website1);
       fanpage.setText("Email: "+fanpage1);
       datlich.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                Intent  intent1 = new Intent(ShowBVActivity.this,InfoActivity.class);
                Bundle bundle1 = new Bundle();
                bundle1.putString("sdt",sdt);
                bundle1.putString("ten",tenbv);
               bundle1.putString("diachi",diachibv);
               bundle1.putString("phone",sodt1);
               bundle1.putString("email",email1);
               bundle1.putString("website",website1);
               bundle1.putString("fanpage",fanpage1);
                intent1.putExtras(bundle1);
                startActivity(intent1);

           }
       });
    }
    private void anhxa(){
        ten = findViewById(R.id.tv_tenbv1);
        diachi = findViewById(R.id.tv_diachibv1);
        sdt1 = findViewById(R.id.tv_sdtbv);
        email = findViewById(R.id.tv_emailbv);
        website= findViewById(R.id.tv_websitebv);
        fanpage = findViewById(R.id.tv_fbbv);
        datlich = findViewById(R.id.btndatlich);

    }
    private void getdata(){



    }
}