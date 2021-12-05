package com.example.soskdientu.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.soskdientu.R;
import com.example.soskdientu.activity.HomeActivity;
import com.example.soskdientu.adapter.LichkhamAdapter;
import com.example.soskdientu.model.DatLichKham;
import com.example.soskdientu.model.Nguoidung;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class DatLichFragment extends Fragment {
    View view;
    RecyclerView rcvlskham;
    LichkhamAdapter adapter;
    List<DatLichKham> listlk;
    HomeActivity homeActivity;
    String sdt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       view =inflater.inflate(R.layout.fragment_dat_lich, container, false);
       rcvlskham = view.findViewById(R.id.rcv_lichsu);
       listlk = new ArrayList<>();
       homeActivity = (HomeActivity) getActivity();
       sdt = homeActivity.getSdt1();
       getlistls(sdt);


       return view;
    }
    private void getlistls(String sdt1){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myreb = database.getReference("user/"+sdt1+"/LichKham");
        myreb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    DatLichKham lichKham = dataSnapshot.getValue(DatLichKham.class);
                    listlk.add(lichKham);
                }

               if(listlk!=null){
                   LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                   rcvlskham.setLayoutManager(linearLayoutManager);
                   adapter = new LichkhamAdapter(getContext(),listlk,sdt1);
                   rcvlskham.setAdapter(adapter);
                   RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL);
                   rcvlskham.addItemDecoration(itemDecoration);
               }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "ko thể kết nối sv", Toast.LENGTH_SHORT).show();
            }
        });
    }

}