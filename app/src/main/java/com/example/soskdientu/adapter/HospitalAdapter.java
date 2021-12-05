package com.example.soskdientu.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soskdientu.R;
import com.example.soskdientu.activity.DatLichKham.ShowBVActivity;
import com.example.soskdientu.model.Hospital;

import java.util.List;

public class HospitalAdapter extends  RecyclerView.Adapter<HospitalAdapter.HospitalViewHodel>  {
    private Context context;
    private List<Hospital> listh;
    String sdt;

    public HospitalAdapter(Context context, List<Hospital> listh,String sdt) {
        this.context = context;
        this.listh = listh;
        this.sdt = sdt;
    }
    public void setlist(List<Hospital> listbv){
        this.listh =listbv;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public HospitalViewHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_hospital, parent, false);
        return new HospitalViewHodel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HospitalViewHodel holder, int position) {
        Hospital hospital = listh.get(position);
        if (hospital==null){
            return;
        }
        holder.tenbv.setText(hospital.getName());
        holder.diachibv.setText(hospital.getAddress());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ShowBVActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("sodt",sdt);
                bundle.putString("tenbv",hospital.getName());
                bundle.putString("diachi",hospital.getAddress());
                bundle.putString("phone",hospital.getPhone());
                bundle.putString("email",hospital.getEmail());
                bundle.putString("website",hospital.getWebsite());
                bundle.putString("fanpage",hospital.getFanpage());
                intent.putExtras(bundle);
               context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(listh != null){
            return listh.size();

        }
        return 0;
    }

    public class HospitalViewHodel extends RecyclerView.ViewHolder{
        TextView tenbv,diachibv;
        LinearLayout layout;
        public HospitalViewHodel(@NonNull View view) {
            super(view);
            tenbv = view.findViewById(R.id.tv_tenbv);
            diachibv = view.findViewById(R.id.tv_diachibv);
            layout = view.findViewById(R.id.item_hospital);

        }
    }
}
