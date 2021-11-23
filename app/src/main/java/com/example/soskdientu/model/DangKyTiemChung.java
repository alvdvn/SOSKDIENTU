package com.example.soskdientu.model;

import android.content.Intent;

public class DangKyTiemChung {
    private String hoTen,diaChi,gioiTinh;
    private int soCMND,soBHYT,ngaySinh;

    public DangKyTiemChung() {
    }

    public DangKyTiemChung(String hoTen, String diaChi, String gioiTinh, int soCMND, int soBHYT, int ngaySinh) {
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.soCMND = soCMND;
        this.soBHYT = soBHYT;
        this.ngaySinh = ngaySinh;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(int soCMND) {
        this.soCMND = soCMND;
    }

    public int getSoBHYT() {
        return soBHYT;
    }

    public void setSoBHYT(int soBHYT) {
        this.soBHYT = soBHYT;
    }

    public int getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(int ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
}
