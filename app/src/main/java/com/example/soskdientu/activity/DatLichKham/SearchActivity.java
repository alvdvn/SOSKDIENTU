package com.example.soskdientu.activity.DatLichKham;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.soskdientu.R;
import com.example.soskdientu.model.CSYT;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    SearchView searchView;
    List<CSYT> mcsyt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        recyclerView = findViewById(R.id.recycleview);
        searchView = findViewById(R.id.searchview);
        mcsyt = new ArrayList<>();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return true;
            }
        });
    }

    private void filter(String newText) {
        List<CSYT> fillterlist = new ArrayList<>();
        for(CSYT x :mcsyt){
            if (x.getName().toLowerCase().contains(newText.toLowerCase())){
                fillterlist.add(x);
            }
        }
    }
}