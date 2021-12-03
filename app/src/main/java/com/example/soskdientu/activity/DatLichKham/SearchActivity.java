package com.example.soskdientu.activity.DatLichKham;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
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
    List<Hospital> list;
    HospitalAdapter adapter,adapter1;
    List<Hospital> fillterlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        recyclerView = findViewById(R.id.recycleview);
        searchView = findViewById(R.id.searchview);
        fillterlist = new ArrayList<>();
        list = new ArrayList<>();
        getlistbv();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new HospitalAdapter(getApplicationContext(),list);
        recyclerView.setAdapter(adapter);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                adapter1= new HospitalAdapter(getApplicationContext(),fillterlist);
                recyclerView.setAdapter(adapter1);
                return true;
            }
        });
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

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), "ko thể kết nối sv", Toast.LENGTH_SHORT).show();
            }
        });

    }
}








