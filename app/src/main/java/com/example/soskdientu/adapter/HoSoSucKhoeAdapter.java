//package com.example.soskdientu.adapter;
//
//import android.annotation.SuppressLint;
//import android.app.AlertDialog;
//import android.app.Dialog;
//import android.content.Context;
//import android.content.DialogInterface;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.cardview.widget.CardView;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.soskdientu.R;
//import com.example.soskdientu.click.HoSoSucKhoeClick;
//import com.example.soskdientu.dao.HoSoSucKhoeDao;
//
//import java.util.List;
//
//public class HoSoSucKhoeAdapter extends RecyclerView.Adapter<HoSoSucKhoeAdapter.HoSoSucKhoeViewHolder>{
//    private Context context;
////    private List<HoSoSucKhoe> list;
//    private HoSoSucKhoeDao hoSoSucKhoeDao;
//    private HoSoSucKhoeClick hoSoSucKhoeClick;
//
//
////    public HoSoSucKhoeAdapter(Context context, List<HoSoSucKhoe> list) {
////        this.context = context;
////        this.list = list;
////      hoSoSucKhoeDao = new HoSoSucKhoeDao(context);
////    }
//
////    public void setList(List<HoSoSucKhoe> list) {
////        this.list = list;
////        notifyDataSetChanged();
////    }
//
//    public void setHoSoSucKhoeClick(HoSoSucKhoeClick hoSoSucKhoeClick) {
//        this.hoSoSucKhoeClick = hoSoSucKhoeClick;
//    }
//
//    @NonNull
//    @Override
//    public HoSoSucKhoeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(context).inflate(R.layout.item_hososuckhoe, parent, false);
//        return new HoSoSucKhoeViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull HoSoSucKhoeViewHolder holder, @SuppressLint("RecyclerView") int position) {
////        HoSoSucKhoe khoe = list.get(position);
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
////            public void onClick(View v) {
////                hoSoSucKhoeClick.onClick(list.get(position));
////            }
////        });
////        holder.ma.setText("Mã thành viên: " + khoe.getMaHS());
////        holder.hoTen.setText("Họ tên: " + khoe.getHoTen());
////        holder.ns.setText("Năm sinh: " + khoe.getNamSinh());
////        holder.dc.setText("Địa chỉ: " + khoe.getDiaChi());
////        holder.gt.setText("Giới tính: " + khoe.getGioiTinh());
////        holder.sdt.setText("SĐt: " + khoe.getSoDienThoai());
////        holder.cc.setText("Số căn cước: " + khoe.getSoCanCuoc());
////        holder.nd.setText("Nhiệt độ: " + khoe.getNhietDo());
////        holder.ha.setText("Huyết áp: " + khoe.getHuyetAp());
//        holder.delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(context);
//                builder.setTitle("Delete")
//                        .setTitle("Bạn có muốn xóa không")
//                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                if (hoSoSucKhoeDao.delete(khoe.getMaHS()) > 0) {
//                                    Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
//                                    list.clear();
//                                    list.addAll(hoSoSucKhoeDao.getAll());
//                                    notifyDataSetChanged();
//                                } else {
//                                    Toast.makeText(context, "Xóa thất bại", Toast.LENGTH_SHORT).show();
//                                }
//                            }
//                        })
//                        .setNegativeButton("CANNEL", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                dialog.dismiss();
//                            }
//                        });
//                Dialog dialog = builder.create();
//                dialog.show();
//            }
//        });
//    }
//
//
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }
//
//    public class HoSoSucKhoeViewHolder extends RecyclerView.ViewHolder {
//            public TextView hoTen, ns, ma,dc,gt,sdt,cc,nd,ha;
//            public ImageView delete;
//            public CardView cardView;
//
//            public HoSoSucKhoeViewHolder(@NonNull View itemView) {
//                super(itemView);
//                ma = itemView.findViewById(R.id.tv_maTV);
//                hoTen = itemView.findViewById(R.id.tv_hotenTV);
//                ns = itemView.findViewById(R.id.tv_namsinh);
//                dc= itemView.findViewById(R.id.tv_diachi);
//                gt= itemView.findViewById(R.id.tv_gioitinh);
//                sdt= itemView.findViewById(R.id.tv_sodienthoai);
//                cc= itemView.findViewById(R.id.tv_socancuoc);
//                nd= itemView.findViewById(R.id.tv_nhietdo);
//                ha= itemView.findViewById(R.id.tv_huyetap);
//                delete = itemView.findViewById(R.id.img_delete_thanhvien);
//                cardView = itemView.findViewById(R.id.carview);
//            }
//
//
//    }
//}
