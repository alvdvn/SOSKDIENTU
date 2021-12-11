package com.example.soskdientu.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.soskdientu.R;
import com.example.soskdientu.activity.HoSoSucKhoe.Hososuckhoe;
import com.example.soskdientu.model.CaNhan;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CaNhanActivity extends AppCompatActivity {
EditText ht,gt,ns,dc,sdt1,scc,sbhyt,tht,thd,qt,tg;
String hto;
Button btnluu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ca_nhan);
       anhxa();
        Intent intent= getIntent();
        String sdt = intent.getStringExtra("sdt");
        sdt1.setText(sdt);
     btnluu.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
           hto=ht.getText().toString();

             FirebaseDatabase database = FirebaseDatabase.getInstance();
             DatabaseReference myreb = database.getReference("user/"+sdt);
             CaNhan caNhan= new CaNhan(ht.getText().toString(),ns.getText().toString()
                     ,dc.getText().toString(),gt.getText().toString()
                     ,scc.getText().toString(),sbhyt.getText().toString()
                     ,tht.getText().toString(),thd.getText().toString(),
                     qt.getText().toString(),tg.getText().toString());
             try {
                 if( ht.getText().length() == 0 || ns.getText().length() == 0 || dc.getText().length() == 0
                         || gt.getText().length() == 0 || scc.getText().length() == 0
                         || sbhyt.getText().length() == 0 || tht.getText().length() == 0|| thd.getText().length() == 0
                         || qt.getText().length() == 0|| tg.getText().length() == 0){
                     Toast.makeText(getApplicationContext(), "Không để trống", Toast.LENGTH_SHORT).show();
                 }
             }catch(Exception e){
                 Log.e("Lỗi", "onClick: ",e );
             }
             myreb.child("HoSoCaNhan").child("hoso").setValue(caNhan, new DatabaseReference.CompletionListener() {
                 @Override
                 public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                     Toast.makeText(getApplicationContext(), "Lưu thành công", Toast.LENGTH_SHORT).show();
                     Intent intent1 = new Intent(CaNhanActivity.this, HomeActivity.class);
                     intent1.putExtra("sdt",sdt);
                     startActivity(intent1);
                 }
             });
         }
     });
    }
    public void anhxa(){
        ht=findViewById(R.id.et_hovaten);
        gt=findViewById(R.id.et_gioitinh);
        dc=findViewById(R.id.et_diachi);
        ns=findViewById(R.id.et_namsinh);
        sdt1=findViewById(R.id.et_sodienthoai);
        scc=findViewById(R.id.et_socancuoc);
        sbhyt=findViewById(R.id.et_sothebaohiemyte);
        tht=findViewById(R.id.et_thtu);
        thd=findViewById(R.id.et_thdn);
        qt=findViewById(R.id.et_quoctich);
        tg=findViewById(R.id.et_tongiao);
        btnluu=findViewById(R.id.btnLuu);

    }
    private void clear(){
        ht.setText("");
        gt.setText("");
        dc.setText("");
        ns.setText("");
        scc.setText("");
        sbhyt.setText("");
        thd.setText("");
        tht.setText("");
        qt.setText("");
        tg.setText("");
    }
}