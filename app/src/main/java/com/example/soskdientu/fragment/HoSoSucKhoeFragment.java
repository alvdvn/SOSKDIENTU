package com.example.soskdientu.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soskdientu.R;
import com.example.soskdientu.adapter.HoSoSucKhoeAdapter;
import com.example.soskdientu.click.HoSoSucKhoeClick;
import com.example.soskdientu.dao.HoSoSucKhoeDao;
import com.example.soskdientu.model.HoSoSucKhoe;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class HoSoSucKhoeFragment extends Fragment {
    private HoSoSucKhoeDao hoSoSucKhoeDao;

    private List<HoSoSucKhoe> list = new ArrayList<>();
    private RecyclerView recyclerView;
    private FloatingActionButton btnAdd;
    private HoSoSucKhoeAdapter adapter;
    private HoSoSucKhoe khoe;
    private EditText ht, ns,dc,gt,sdt,cc,nd,ha, ht_ed, ns_ed,dc_ed,gt_ed,sdt_ed,cc_ed,nd_ed,ha_ed,search;
    private TextInputLayout textInputLayout;
    private Button them, huy, sua, huysua;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_ho_so_suc_khoe, container, false);

        hoSoSucKhoeDao = new HoSoSucKhoeDao(getContext());
        list =hoSoSucKhoeDao.getAll();
        adapter = new HoSoSucKhoeAdapter(getContext(), list);
        recyclerView = view.findViewById(R.id.rv_data_thanhvien);
        search=view.findViewById(R.id.ed_search);
        textInputLayout=view.findViewById(R.id.click_search);
        btnAdd = view.findViewById(R.id.btn_fl_them_thanhvien);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

        adapter.setHoSoSucKhoeClick(new HoSoSucKhoeClick() {
            @Override
            public void onClick(HoSoSucKhoe hoSoSucKhoe) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_hososuckhoeedit, null);
                builder.setView(view);
                Dialog dialog = builder.create();
                dialog.show();
                ht_ed = view.findViewById(R.id.ed_edit_hotentv);

                ns_ed = view.findViewById(R.id.ed_edit_namsinh);
                dc_ed= view.findViewById(R.id.ed_edit_diachi);
                gt_ed= view.findViewById(R.id.ed_edit_gioitinh);
                sdt_ed= view.findViewById(R.id.ed_edit_sodienthoai);
                cc_ed= view.findViewById(R.id.ed_edit_socancuoc);
                nd_ed= view.findViewById(R.id.ed_edit_nhietdo);
                ha_ed= view.findViewById(R.id.ed_edit_huyetap);
                sua = view.findViewById(R.id.btn_edit_save_thanhvien);
                huysua = view.findViewById(R.id.btn_edit_huy_thanhvien);
                ht_ed.setText(hoSoSucKhoe.getHoTen());
                ns_ed.setText(hoSoSucKhoe.getNamSinh());
                dc_ed.setText(hoSoSucKhoe.getDiaChi());
                gt_ed.setText(hoSoSucKhoe.getGioiTinh());
                sdt_ed.setText(hoSoSucKhoe.getSoDienThoai());
                cc_ed.setText(hoSoSucKhoe.getSoCanCuoc());
                nd_ed.setText(hoSoSucKhoe.getNhietDo());
                ha_ed.setText(hoSoSucKhoe.getHuyetAp());
                sua.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        hoSoSucKhoe.setHoTen(ht_ed.getText().toString());
                        hoSoSucKhoe.setNamSinh(ns_ed.getText().toString());
                        hoSoSucKhoe.setDiaChi(dc_ed.getText().toString());
                        hoSoSucKhoe.setGioiTinh(gt_ed.getText().toString());
                        hoSoSucKhoe.setSoDienThoai(sdt_ed.getText().toString());
                        hoSoSucKhoe.setSoCanCuoc(cc_ed.getText().toString());
                        hoSoSucKhoe.setNhietDo(nd_ed.getText().toString());
                        hoSoSucKhoe.setHuyetAp(ha_ed.getText().toString());


                        if (ht_ed.getText().length() == 0 || ns_ed.getText().length() == 0 || dc_ed.getText().length() == 0
                                || gt_ed.getText().length() == 0 || sdt_ed.getText().length() == 0 || cc_ed.getText().length() == 0 || nd_ed.getText().length() == 0
                                || ha_ed.getText().length() == 0) {
                            Toast.makeText(getContext(), "Không để trống", Toast.LENGTH_SHORT).show();
                        } else {
                            if (hoSoSucKhoeDao.update(hoSoSucKhoe) > 0) {
                                Toast.makeText(getContext(), "Sửa thành viên thành công", Toast.LENGTH_SHORT).show();
                                list.clear();
                                list.addAll(hoSoSucKhoeDao.getAll());
                                adapter.notifyDataSetChanged();
                                ht_ed.setText("");
                                ns_ed.setText("");
                                dc_ed.setText("");
                                gt_ed.setText("");
                                sdt_ed.setText("");
                                cc_ed.setText("");
                                nd_ed.setText("");
                                ha.setText("");
                            } else {
                                Toast.makeText(getContext(), "Sửa thành viên thất bại", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
                huysua.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        textInputLayout.setEndIconOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list=hoSoSucKhoeDao.searchTV(search.getText().toString());
                adapter.setList(list);
                search.setText("");
            }
        });
        return view;
    }
    private void openDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_hososuckhoe, null);
        builder.setView(view);
        Dialog dialog = builder.create();
        dialog.show();
        ht = view.findViewById(R.id.ed_hotentv);
        ns = view.findViewById(R.id.ed_namsinh);
        dc= view.findViewById(R.id.ed_diachi);
        gt= view.findViewById(R.id.ed_gioitinh);
        sdt= view.findViewById(R.id.ed_sodienthoai);
        cc= view.findViewById(R.id.ed_socancuoc);
        nd= view.findViewById(R.id.ed_nhietdo);
        ha= view.findViewById(R.id.ed_huyetap);
        them = view.findViewById(R.id.btn_save_thanhvien);
        huy = view.findViewById(R.id.btn_huy_thanhvien);
        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                khoe = new HoSoSucKhoe();
                khoe.setHoTen(ht.getText().toString());
                khoe.setNamSinh(ns.getText().toString());
                khoe.setDiaChi(dc.getText().toString());
                khoe.setGioiTinh(gt.getText().toString());
                khoe.setSoDienThoai(sdt.getText().toString());
                khoe.setSoCanCuoc(cc.getText().toString());
                khoe.setNhietDo(nd.getText().toString());
                khoe.setHuyetAp(ha.getText().toString());

                if (ht.getText().length() == 0 || ns.getText().length() == 0 || dc.getText().length() == 0
                        || gt.getText().length() == 0 || sdt.getText().length() == 0 || cc.getText().length() == 0
                        || nd.getText().length() == 0 || ha.getText().length() == 0) {
                    Toast.makeText(getContext(), "Không để trống", Toast.LENGTH_SHORT).show();
                } else {
                    if (hoSoSucKhoeDao.insert(khoe) > 0) {
                        Toast.makeText(getContext(), "Thêm thành viên thành công", Toast.LENGTH_SHORT).show();
                        list.clear();
                        list.addAll(hoSoSucKhoeDao.getAll());
                        adapter.notifyDataSetChanged();
                        ht.setText("");
                        ns.setText("");
                        dc.setText("");
                        gt.setText("");
                        sdt.setText("");
                        cc.setText("");
                        nd.setText("");
                        ha.setText("");
                    } else {
                        Toast.makeText(getContext(), "Thêm thành viên thất bại", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }
}