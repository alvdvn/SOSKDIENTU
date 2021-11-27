package com.example.soskdientu.dao;

import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.soskdientu.model.Nguoidung;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.Context;

import java.util.ArrayList;
import java.util.List;

public class NguoiDungDao {
    List<Nguoidung>  listnd= new ArrayList<>();
    Context context;

}
