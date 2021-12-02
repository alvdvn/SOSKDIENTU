package com.example.soskdientu.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.soskdientu.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class HoSoCaNhanFragment extends Fragment {
    private FloatingActionButton btnAdd;






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_ho_so_ca_nhan, container, false);

        return view;

    }
}