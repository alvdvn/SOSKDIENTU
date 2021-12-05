package com.example.soskdientu.activity.HoSoSucKhoe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.soskdientu.R;
import com.example.soskdientu.model.HsSucKhoe;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HSSKhienthiActivity extends AppCompatActivity {
    TextView ht,gt,ns,scc,sbhyt,sdt4,nd,ha,nt,nm,cc,cn;
    String sdt ;
    View view;
    HsSucKhoe hsSucKhoe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hsskhienthi);
        anhxa();
        Intent intent = getIntent();
        sdt=intent.getStringExtra("sdt");
        getlistuser(sdt);

    }
    private void getlistuser(String sdt1) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myreb = database.getReference("user/" + sdt1 + "/HoSoSucKhoe");
        myreb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    hsSucKhoe = dataSnapshot.getValue(HsSucKhoe.class);


                }
                settext();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), "ko thể kết nối sv", Toast.LENGTH_SHORT).show();
            }

        });
    }
    private  void  anhxa(){
        hsSucKhoe=new HsSucKhoe();
//        listsk = new ArrayList<>();
        sdt4 = view.findViewById(R.id.tv_sodienthoai2);
        ht=view.findViewById(R.id.tv_hoten2);
        ns=view.findViewById(R.id.tv_namsinh2);
        gt=view.findViewById(R.id.tv_gioitinh2);
        scc=view.findViewById(R.id.tv_socancuoc2);
        sbhyt=view.findViewById(R.id.tv_sobaohiemyte2);
        nd=view.findViewById(R.id.tv_nhietdo2);
        ha=view.findViewById(R.id.tv_huyetap2);

        nt=view.findViewById(R.id.tv_nhiptim2);
        nm=view.findViewById(R.id.tv_nhommau2);
        cc=view.findViewById(R.id.tv_chieucao2);
        cn=view.findViewById(R.id.tv_cannang2);

    }
    private void settext(){
        sdt4.setText(sdt);
        cc.setText(hsSucKhoe.getChieuCao());
        cn.setText(hsSucKhoe.getCanNang());
        nd.setText(hsSucKhoe.getNhietDo());
        ha.setText(hsSucKhoe.getHuyetAp());
        nt.setText(hsSucKhoe.getNhipTim());
        nm.setText(hsSucKhoe.getNhomMau());
    }
}