package com.example.soskdientu.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.soskdientu.R;
import com.example.soskdientu.activity.CaNhanActivity;
import com.example.soskdientu.activity.Dangnhap_Dawngky.LoginActivity;
import com.example.soskdientu.activity.HomeActivity;
import com.example.soskdientu.model.CaNhan;
import com.example.soskdientu.model.Nguoidung;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class HoSoCaNhanFragment extends Fragment {
    EditText ht3,gt3,ns3,dc3,sdt13,scc3,sbhyt3,tht3,thd3,qt3,tg3;
    private FloatingActionButton btnAdd;
    Button btnupdate1, btnlogout;
    View view;
    String sdt;
     TextView ht,dc,gt,ns,cc,sbhyt,tht,thd,qt,tg,sdt1;
     List<CaNhan> listcn;
    CaNhan caNhan;
    HomeActivity homeActivity ;
    LoginActivity loginActivity;
    Button btnupdate;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_ho_so_ca_nhan, container, false);
        homeActivity = (HomeActivity) getActivity();
        sdt= homeActivity.getSdt1();
//        loginActivity = (LoginActivity) getActivity();
        anhxa();
       getlistuser(sdt);
       btnupdate.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_canhan, null);
                builder.setView(view);
                Dialog dialog = builder.create();
                dialog.show();
                ht3=view.findViewById(R.id.et_hovaten3);
                gt3=view.findViewById(R.id.et_gioitinh3);
                ns3=view.findViewById(R.id.et_namsinh3);
//                sdt13=view.findViewById(R.id.et_sodienthoai3);
                scc3=view.findViewById(R.id.et_socancuoc3);
                dc3=view.findViewById(R.id.et_diachi3);
                sbhyt3=view.findViewById(R.id.et_sothebaohiemyte3);
                thd3=view.findViewById(R.id.et_thdn3);
                tht3=view.findViewById(R.id.et_thtu3);
                qt3=view.findViewById(R.id.et_quoctich3);
                tg3=view.findViewById(R.id.et_tongiao3);
                btnupdate1=view.findViewById(R.id.btnLuu3);

               ht3.setText("H??? v?? t??n: "+caNhan.getHoTen());
               dc3.setText("?????a ch???: "+caNhan.getDiaChi());
               ns3.setText(" Ng??y sinh: " +caNhan.getNamSinh());
               gt3.setText("Gi???i t??nh: "+caNhan.getGioiTinh());
               scc3.setText("S??? c??n c?????c:"+caNhan.getSoCanCuoc());
               sbhyt3.setText("S??? BHYT: "+caNhan.getSoTheBaoHiemYTe());
               tht3.setText(" T??? ng??y: "+caNhan.getThoiHanSdTheTuNgay());
               thd3.setText(" ?????n ng??y: "+caNhan.getThoiHanSdTheDenNgay());
               qt3.setText("Qu???c t???ch: "+caNhan.getQuocTich());
               tg3.setText("T??n gi??o: "+caNhan.getTonGiao());

              btnupdate1.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      FirebaseDatabase database = FirebaseDatabase.getInstance();
                      DatabaseReference myreb = database.getReference("user/"+sdt);
                      CaNhan caNhan= new CaNhan(ht3.getText().toString(),ns3.getText().toString()
                              ,dc3.getText().toString(),gt3.getText().toString()
                              ,scc3.getText().toString(),sbhyt3.getText().toString()
                              ,tht3.getText().toString(),thd3.getText().toString(),
                              qt3.getText().toString(),tg3.getText().toString());
                      myreb.child("HoSoCaNhan").child("hoso").setValue(caNhan, new DatabaseReference.CompletionListener() {
                          @Override
                          public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                              Toast.makeText(getContext(), "update th??nh c??ng", Toast.LENGTH_SHORT).show();


                          }
                      });

                  }
              });

           }
       });
       btnlogout.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(getActivity(), LoginActivity.class);
               startActivity(intent);
             homeActivity.finish();

           }
       });
        return view;

    }
    private  void  anhxa(){

        listcn = new ArrayList<>();
        btnlogout = view.findViewById(R.id.btnlogout);
        sdt1 = view.findViewById(R.id.tv_sodienthoai1);
        ht=view.findViewById(R.id.tv_hoten1);
        ns=view.findViewById(R.id.tv_namsinh1);
        gt=view.findViewById(R.id.tv_gioitinh1);
        dc=view.findViewById(R.id.tv_diachi1);
        cc=view.findViewById(R.id.tv_socancuoc1);
        sbhyt=view.findViewById(R.id.tv_sobaohiemyte1);
        thd=view.findViewById(R.id.tv_thoihanden1);
        tht=view.findViewById(R.id.tv_thoihantu1);
        qt=view.findViewById(R.id.tv_quoctich1);
        tg=view.findViewById(R.id.tv_tongiao1);
        btnupdate=view.findViewById(R.id.btnupdate);

    }
        private void getlistuser(String sdt1){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myreb = database.getReference("user/"+sdt1+"/HoSoCaNhan");
        myreb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    caNhan = dataSnapshot.getValue(CaNhan.class);
                    settext();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "ko th??? k???t n???i sv", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void settext(){
        sdt1.setText("S??T: "+sdt);
        ht.setText("H??? v?? t??n: "+caNhan.getHoTen());
        dc.setText("?????a ch???: "+caNhan.getDiaChi());
        ns.setText(" Ng??y sinh: " +caNhan.getNamSinh());
        gt.setText("Gi???i t??nh: "+caNhan.getGioiTinh());
        cc.setText("S??? c??n c?????c:"+caNhan.getSoCanCuoc());
        sbhyt.setText("S??? BHYT: "+caNhan.getSoTheBaoHiemYTe());
        tht.setText(" T??? ng??y: "+caNhan.getThoiHanSdTheTuNgay());
        thd.setText(" ?????n ng??y: "+caNhan.getThoiHanSdTheDenNgay());
        qt.setText("Qu???c t???ch: "+caNhan.getQuocTich());
        tg.setText("T??n gi??o: "+caNhan.getTonGiao());
    }
}