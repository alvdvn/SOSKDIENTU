package com.example.soskdientu.activity.khaibaoyte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.soskdientu.R;

public class man2 extends AppCompatActivity {

    Button btn;
    String sdt;
    TextView HT,NS,CC,QT,NO,TV1,TV2,SDT;
    EditText HT1,NS1,CC1,QT1,SDT1;
    RadioButton CO1,CO2,KO1,KO2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(man2.this,man3.class);
                intent.putExtra("sdt",sdt);
                startActivity(intent);
            }
        });

    }
    private void anhxa(){
        btn = findViewById(R.id.btnTST);
        HT =findViewById(R.id.HT);
        NS = findViewById(R.id.NS);
        CC = findViewById(R.id.CCCD);
        QT = findViewById(R.id.CCCD);
        NO =findViewById(R.id.NOHT);
        TV1 =findViewById(R.id.TV1);
        TV2=findViewById(R.id.TV2);
        HT1=findViewById(R.id.EDHT);
        NS1=findViewById(R.id.EDNS);
        CC1=findViewById(R.id.EDCCCD);
        QT1=findViewById(R.id.EDQT);
        TV1=findViewById(R.id.TV1);
        TV2=findViewById(R.id.TV2);
        SDT=findViewById(R.id.SDT);
        SDT1=findViewById(R.id.EDSDT);
        CO1=findViewById(R.id.RDOC1);
        CO2=findViewById(R.id.RDOC2);
        KO1=findViewById(R.id.RDOK1);
        KO2=findViewById(R.id.RDOK2);
    }
}