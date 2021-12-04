package com.example.soskdientu.activity.HoSoSucKhoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.soskdientu.R;

public class Hososuckhoe extends AppCompatActivity {
EditText ht2,sdt2,ns2,gt2,scc2,sbhyt2,nd2,ha2,cc2,cn2,nt2,nm2;
Button btnluu2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hososuckhoe);
        anhxa();
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
}