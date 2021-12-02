//package com.example.soskdientu.adapter;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.soskdientu.R;
//import com.example.soskdientu.model.CaNhan;
//
//import java.util.List;
//
//public class HoSoCaNhanAdapter extends RecyclerView.Adapter<HoSoCaNhanAdapter.HoSoCaNhanViewHolder> {
//    private Context context;
//    private List<CaNhan> list;
//
//    public HoSoCaNhanAdapter(Context context, List<CaNhan> list) {
//        this.context = context;
//        this.list = list;
//
//    }
//    public void setList(List<CaNhan> list) {
//        this.list = list;
//      notifyDataSetChanged();
//
//    }
//
//
//    @NonNull
//    @Override
//    public HoSoCaNhanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(context).inflate(R.layout.item_hosocanhan, parent, false);
////        return new HoSoSucKhoeViewHolder(view);
//        return new HoSoCaNhanViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull HoSoCaNhanAdapter.HoSoCaNhanViewHolder holder, int position) {
//        CaNhan caNhan = list.get(position);
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//
//        });
//
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return 0;
//    }
//
//    public class HoSoCaNhanViewHolder extends RecyclerView.ViewHolder {
//        public HoSoCaNhanViewHolder(View view) {
//            super();
//        }
//    }
//}
