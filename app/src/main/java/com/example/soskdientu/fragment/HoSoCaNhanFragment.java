package com.example.soskdientu.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.soskdientu.R;
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
    private FloatingActionButton btnAdd;
    View view;
    String sdt;
     TextView ht,dc,gt,ns,cc,sbhyt,tht,thd,qt,tg,sdt1;
     List<CaNhan> listcn;
    CaNhan caNhan;
    HomeActivity homeActivity ;
    Button btnupdate;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_ho_so_ca_nhan, container, false);
        homeActivity = (HomeActivity) getActivity();
        sdt= homeActivity.getSdt1();
        anhxa();
       getlistuser(sdt);
        return view;

    }
    private  void  anhxa(){
        listcn = new ArrayList<>();
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

    }   private void getlistuser(String sdt1){
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
                Toast.makeText(getContext(), "ko thể kết nối sv", Toast.LENGTH_SHORT).show();
            }

        });


    }

    private void settext(){
        sdt1.setText(sdt);
        ht.setText("Họ và tên: "+caNhan.getHoTen());
        dc.setText("Địa chỉ: "+caNhan.getDiaChi());
        ns.setText(" Ngày sinh: " +caNhan.getNamSinh());
        gt.setText("Giới tính: "+caNhan.getGioiTinh());
        cc.setText("Số căn cước:"+caNhan.getSoCanCuoc());
        sbhyt.setText("Số BHYT: "+caNhan.getSoTheBaoHiemYTe());
        tht.setText(" Từ ngày: "+caNhan.getThoiHanSdTheTuNgay());
        thd.setText(" Đến ngày: "+caNhan.getThoiHanSdTheDenNgay());
        qt.setText("Quốc tịch: "+caNhan.getQuocTich());
        tg.setText("Tôn giáo: "+caNhan.getTonGiao());
    }
}