package com.example.soskdientu.activity.DatLichKham;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.soskdientu.R;
import com.example.soskdientu.adapter.HospitalAdapter;
import com.example.soskdientu.model.Hospital;
import com.example.soskdientu.model.Nguoidung;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    SearchView searchView;
    TextView title;
    List<Hospital> list;
    HospitalAdapter adapter,adapter1;
    List<Hospital> fillterlist;
    String sdt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Intent intent = getIntent();
        sdt = intent.getStringExtra("sdt");

        recyclerView = findViewById(R.id.recycleview);
        title =findViewById(R.id.title1);

//        searchView = findViewById(R.id.searchview);
        fillterlist = new ArrayList<>();
        list = new ArrayList<>();
        getlistbv();

//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                filter(newText);
//                adapter1= new HospitalAdapter(SearchActivity.this,fillterlist,sdt);
//                recyclerView.setAdapter(adapter1);
//                return true;
//            }
//        });
    }

    private void filter(String newText) {

        for (Hospital x : list) {
            if (x.getName().toLowerCase().contains(newText.toLowerCase())) {
                fillterlist.add(x);
            }
        }
    }
    private void getlistbv(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myreb = database.getReference("Hospital/Hà Nội");
        myreb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    Hospital hospital = dataSnapshot.getValue(Hospital.class);
                    list.add(hospital);

                }
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(linearLayoutManager);
                adapter = new HospitalAdapter(SearchActivity.this,list,sdt);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), "ko thể kết nối sv", Toast.LENGTH_SHORT).show();
            }
        });

    }
}








