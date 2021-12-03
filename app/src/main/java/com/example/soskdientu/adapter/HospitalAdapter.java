package com.example.soskdientu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soskdientu.R;
import com.example.soskdientu.model.Hospital;

import java.util.List;

public class HospitalAdapter extends  RecyclerView.Adapter<HospitalAdapter.HospitalViewHodel>  {
    private Context context;
    private List<Hospital> listh;

    public HospitalAdapter(Context context, List<Hospital> listh) {
        this.context = context;
        this.listh = listh;
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
        public HospitalViewHodel(@NonNull View view) {
            super(view);
            tenbv = view.findViewById(R.id.tv_tenbv);
            diachibv = view.findViewById(R.id.tv_diachibv);

        }
    }
}
