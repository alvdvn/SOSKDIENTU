package com.example.soskdientu.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.soskdientu.R;
import com.example.soskdientu.activity.DatLichKham.SearchActivity;
import com.example.soskdientu.activity.HoSoSucKhoe.HSSKhienthiActivity;
import com.example.soskdientu.activity.HoSoSucKhoe.Hososuckhoe;
import com.example.soskdientu.activity.MaSoSucKhoe.MaSoSKActivity;
import com.example.soskdientu.activity.TiemChung.ChungNhanActivity;
import com.example.soskdientu.activity.TiemChung.DangKyTiemChungActivity;
import com.example.soskdientu.activity.TiemChung.MainActivity1;
import com.example.soskdientu.activity.TiemChung.PhieuDongYActivity;
import com.example.soskdientu.activity.TiemChung.TiemSuTiemActivity;
import com.example.soskdientu.activity.camnangyte.CamnangyteActivity;
import com.example.soskdientu.activity.khaibaoyte.man1;
import com.example.soskdientu.activity.HomeActivity;
import com.example.soskdientu.activity.TiemChung.PhanUngSauTiemActivity;
import com.example.soskdientu.activity.tracuubaohiem.TracuubaohiemActivity;
import com.example.soskdientu.activity.tuvantuxa.TuVanActivity;
import com.example.soskdientu.model.CaNhan;
import com.example.soskdientu.model.DangKyTiemChung;
import com.example.soskdientu.model.HsSucKhoe;
import com.example.soskdientu.model.PhanUngSauTiem;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
    ImageView Khaibao,Hososk,datlich,mxnhan,camNang,chungnhan,tuvan;
    TextView hoten;
    View view;
    String sdt;
    ImageView btnphanung,btnmasosk,btndktiemchung,btntracuubh;
    HsSucKhoe hsSucKhoe;
    CaNhan caNhan;
    List<HsSucKhoe> hsSucKhoeList;
    HomeActivity homeActivity;
    PhanUngSauTiem phanung1;
    DangKyTiemChung DKTC;
    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home, container, false);
            homeActivity = (HomeActivity) getActivity();
            anhxa();
            sdt = homeActivity.getSdt1();
            hoten.setText(sdt);
            phanung1 = new PhanUngSauTiem();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myreb = database.getReference("user/"+sdt+"/HoSoCaNhan");
        myreb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    caNhan = dataSnapshot.getValue(CaNhan.class);
                    hoten.setText(caNhan.getHoTen());
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "ko thể kết nối sv", Toast.LENGTH_SHORT).show();
            }
        });
            btnphanung.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myreb = database.getReference("user/" + sdt + "/PhanUngSauTiem");
                    myreb.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                phanung1 = dataSnapshot.getValue(PhanUngSauTiem.class);



                            }
                            if(phanung1.getThoiGian()==null){
                                Intent intent = new Intent(getActivity(), PhanUngSauTiemActivity.class);
                                intent.putExtra("sdt",sdt);

                                startActivity(intent);
                            }else {
                                Intent intent = new Intent(getActivity(), MainActivity1.class);
                                intent.putExtra("sdt", sdt);
                                intent.putExtra("hoten",hoten.getText().toString());
                                startActivity(intent);
                            }



                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(getContext(), "ko thể kết nối sv", Toast.LENGTH_SHORT).show();
                        }

                    });


                }
            });
            datlich.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), SearchActivity.class);
                    intent.putExtra("sdt",sdt);
                    startActivity(intent);
                }
            });
            Hososk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    hsSucKhoe = new HsSucKhoe();
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myreb = database.getReference("user/" + sdt + "/HoSoSuckhoe");
                    myreb.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                hsSucKhoe = dataSnapshot.getValue(HsSucKhoe.class);


                            }
                            if(hsSucKhoe.getCanNang()==null){
                                Intent intent = new Intent(getActivity(), Hososuckhoe.class);
                                intent.putExtra("sdt",sdt);
                                startActivity(intent);
                            }else {
                                Intent intent = new Intent(getActivity(), HSSKhienthiActivity.class);

                                intent.putExtra("sdt", sdt);
                                startActivity(intent);
                            }



                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(getContext(), "ko thể kết nối sv", Toast.LENGTH_SHORT).show();
                        }

                    });

                }
            });
            Khaibao.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), man1.class);
                    intent.putExtra("sdt",sdt);
                    startActivity(intent);
                }
            });
            btnmasosk.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getActivity(), MaSoSKActivity.class);
                            intent.putExtra("sdt",sdt);
                            startActivity(intent);
                }
            });
            btndktiemchung.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(),DangKyTiemChungActivity.class);
                    intent.putExtra("sdt",sdt);
                    startActivity(intent);
                }
            });
        mxnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DKTC = new DangKyTiemChung();
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myreb = database.getReference("user/" + sdt + "/DangKyTiemChung");
                myreb.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                            DKTC = dataSnapshot.getValue(DangKyTiemChung.class);



                        }
                        if(DKTC.getChk1()==null){
                           Toast.makeText(getContext(),"Ban chua dang ky tiem",Toast.LENGTH_SHORT).show();

                        }else {
                            Intent intent = new Intent(getActivity(), PhieuDongYActivity.class);
                            intent.putExtra("sdt", sdt);
                            startActivity(intent);
                        }



                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(getContext(), "ko thể kết nối sv", Toast.LENGTH_SHORT).show();
                    }

                });

            }
        });
        camNang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CamnangyteActivity.class);
                intent.putExtra("sdt",sdt);
                startActivity(intent);
            }
        });
        btntracuubh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TracuubaohiemActivity.class);
                intent.putExtra("sdt",sdt);
                startActivity(intent);
            }
        });
        chungnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ChungNhanActivity.class);
                intent.putExtra("sdt",sdt);
                startActivity(intent);
            }
        });
        tuvan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TuVanActivity.class);
                intent.putExtra("sdt",sdt);
                startActivity(intent);

            }
        });

        return view;

    }

    private void anhxa(){
        tuvan = view.findViewById(R.id.tuvan);
        hsSucKhoeList = new ArrayList<>();

        hoten = view.findViewById(R.id.tv_hvt);
        datlich = view.findViewById(R.id.datlich);
        btnphanung =view.findViewById(R.id.phanung);
        Hososk = view.findViewById(R.id.hososk);
        Khaibao = view.findViewById(R.id.khaibao);
        btnmasosk = view.findViewById(R.id.masosk);
        btndktiemchung = view.findViewById(R.id.dktiemChung);
        btntracuubh=view.findViewById(R.id.bhyt);
        mxnhan = view.findViewById(R.id.maxacnhan);
        camNang = view.findViewById(R.id.camnang);
        chungnhan = view.findViewById(R.id.cncovid);
        caNhan = new CaNhan();
    }



}