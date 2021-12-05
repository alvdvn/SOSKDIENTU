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
import com.example.soskdientu.activity.DatLichKham.Chitiet2Activity;
import com.example.soskdientu.model.DatLichKham;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class LichkhamAdapter extends RecyclerView.Adapter<LichkhamAdapter.lickhamViewHolder> {
    Context context;
    List<DatLichKham>  listlk ;
    String sdt;

    public LichkhamAdapter(Context context, List<DatLichKham> listlk, String sdt) {
        this.context = context;
        this.listlk = listlk;
        this.sdt = sdt;
    }

    @NonNull
    @Override
    public lickhamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_lskham, parent, false);
        return new lickhamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull lickhamViewHolder holder, int position) {
        DatLichKham lskham = listlk.get(position);
        if (lskham==null){
            return;
        }
        holder.hoten.setText(lskham.getHoten());
        holder.benhvien.setText(lskham.getBenhvien());
        holder.ngaykham.setText(lskham.getDate());
        holder.giokham.setText(lskham.getTime());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Chitiet2Activity.class);
                Bundle bundle = new Bundle();
                bundle.putString("date",lskham.getDate());
                bundle.putString("sdt",sdt);
                intent.putExtras(bundle);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        if(listlk!=null){
            return listlk.size();
        }
        return 0;
    }

    public class  lickhamViewHolder extends RecyclerView.ViewHolder{
        TextView hoten,benhvien,ngaykham,giokham;
        LinearLayout layout;

        public lickhamViewHolder(@NonNull View view) {
            super(view);
            hoten = view.findViewById(R.id.item_ten);
            benhvien = view.findViewById(R.id.item_benhvien);
            ngaykham = view.findViewById(R.id.item_ngaykham);
            giokham  = view.findViewById(R.id.item_giokham);
            layout = view.findViewById(R.id.onclickitem);
        }

    }
}
