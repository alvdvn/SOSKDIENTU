package com.example.soskdientu.activity.HoSoSucKhoe;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.soskdientu.R;
import com.example.soskdientu.activity.HomeActivity;
import com.example.soskdientu.activity.khaibaoyte.man1;
import com.example.soskdientu.activity.khaibaoyte.man2;
import com.example.soskdientu.model.CaNhan;
import com.example.soskdientu.model.HsSucKhoe;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HSSKhienthiActivity extends AppCompatActivity {
    TextView ht,gt,ns,scc,sbhyt,sdt4,nd,ha,nt,nm,cc,cn;
    EditText ht4,gt4,ns4,sdt14,scc4,sbhyt4,nt4,nm4,cc4,cn4,nd4,ha4;
    String sdt ;
   Button btnupdate5, btnupdate4,btntrangchu;
    CaNhan caNhan;
    HsSucKhoe hsSucKhoe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hsskhienthi);
        anhxa();
        Intent intent = getIntent();
        sdt=intent.getStringExtra("sdt");
        getlistuser(sdt);
        getlistuser1(sdt);
        btntrangchu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HSSKhienthiActivity.this, HomeActivity.class);
                intent.putExtra("sdt",sdt);
                startActivity(intent);
            }
        });
        btnupdate5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(HSSKhienthiActivity.this);
                View view = LayoutInflater.from(HSSKhienthiActivity.this).inflate(R.layout.dialog_sk, null);
                builder.setView(view);
                Dialog dialog = builder.create();
                dialog.show();
//                ht4=view.findViewById(R.id.et_hovaten4);
//                gt4=view.findViewById(R.id.et_gioitinh4);
//                ns4=view.findViewById(R.id.et_namsinh4);
//                sdt14=view.findViewById(R.id.et_sodienthoai5);
//                scc4=view.findViewById(R.id.et_socancuoc4);
               nd4=view.findViewById(R.id.et_nhietdo4);
               ha4=view.findViewById(R.id.et_huyetao4);
               nt4=view.findViewById(R.id.et_nhiptim4);
               nm4=view.findViewById(R.id.et_nhommau4);
               cn4=view.findViewById(R.id.et_cannang4);
               cc4=view.findViewById(R.id.et_chieucao4);
               btnupdate4=view.findViewById(R.id.btnLuu4);


                nd4.setText("Nhiệt độ: "+hsSucKhoe.getChieuCao());
                ha4.setText("Huyết áp: "+hsSucKhoe.getCanNang());
                nt4.setText("Nhịp tim: "+hsSucKhoe.getNhipTim());
                nm4.setText("Nhóm máu: "+hsSucKhoe.getNhomMau());
                cn4.setText("Cân nặng: "+hsSucKhoe.getHuyetAp());
                cc4.setText("Chiều Cao: "+hsSucKhoe.getNhietDo());
//                sbhyt4=view.findViewById(R.id.et_sothebaohiemyte4);
                btnupdate4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        FirebaseDatabase database = FirebaseDatabase.getInstance();
                        DatabaseReference myreb = database.getReference("user/"+sdt);
                        HsSucKhoe hsSucKhoe = new HsSucKhoe(cc4.getText().toString(),cn4.getText().toString()
                        ,nm4.getText().toString(),nt4.getText().toString(),nd4.getText().toString(),
                                ha4.getText().toString());
                        myreb.child("HoSoSuckhoe").child("hoso").setValue(hsSucKhoe, new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                                Toast.makeText(getApplicationContext(), "update thành công", Toast.LENGTH_SHORT).show();


                            }
                        });
                    }
                });
            }
        });

    }
    private  void  anhxa(){
        hsSucKhoe=new HsSucKhoe();
        caNhan = new CaNhan();
//        listsk = new ArrayList<>();
        sdt4 = findViewById(R.id.tv_sodienthoai2);
        ht=findViewById(R.id.tv_hoten2);
        ns=findViewById(R.id.tv_namsinh2);
        gt=findViewById(R.id.tv_gioitinh2);
        scc=findViewById(R.id.tv_socancuoc2);
        sbhyt=findViewById(R.id.tv_sobaohiemyte2);
        nd=findViewById(R.id.tv_nhietdo2);
        ha=findViewById(R.id.tv_huyetap2);
        btnupdate5=findViewById(R.id.btnupdate5);
        btntrangchu=findViewById(R.id.btntrangchu);
        nt=findViewById(R.id.tv_nhiptim2);
        nm=findViewById(R.id.tv_nhommau2);
        cc=findViewById(R.id.tv_chieucao2);
        cn=findViewById(R.id.tv_cannang2);

    }
    private void getlistuser(String sdt1) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myreb = database.getReference("user/" + sdt1 + "/HoSoSuckhoe");
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
    private void getlistuser1(String sdt1) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myreb = database.getReference("user/" + sdt1+"/HoSoCaNhan" );
        myreb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    caNhan = dataSnapshot.getValue(CaNhan.class);


                }
                settext1();

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), "ko thể kết nối sv", Toast.LENGTH_SHORT).show();
            }

        });
    }


    private void settext(){
        sdt4.setText("Số Điện thoại:"+sdt);
        nd.setText("Nhiệt độ: "+hsSucKhoe.getChieuCao());
        ha.setText("Huyết áp: "+hsSucKhoe.getCanNang());
        nt.setText("Nhịp tim: "+hsSucKhoe.getNhipTim());
        nm.setText("Nhóm máu: "+hsSucKhoe.getNhomMau());
        cn.setText("Cân nặng: "+hsSucKhoe.getHuyetAp());
        cc.setText("Chiều Cao: "+hsSucKhoe.getNhietDo());

    }
    private void settext1(){
        sdt4.setText("Số điện thoai: "+sdt);
        ht.setText("Họ tên: "+caNhan.getHoTen());
        gt.setText("Giới Tính: "+caNhan.getGioiTinh());
        ns.setText("Ngày sinh: " +caNhan.getNamSinh());
        scc.setText("Số Căn Cước: "+caNhan.getSoCanCuoc());
        sbhyt.setText("Số BHYT: "+caNhan.getSoTheBaoHiemYTe());
    }
}