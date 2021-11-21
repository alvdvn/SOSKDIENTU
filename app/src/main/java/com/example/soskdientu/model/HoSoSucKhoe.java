package com.example.soskdientu.model;

public class HoSoSucKhoe {
    private int maHS;
    private String hoTen,namSinh,diaChi,gioiTinh,soDienThoai,soCanCuoc,nhietDo,huyetAp;

    public HoSoSucKhoe() {
    }

    public HoSoSucKhoe(int maHS, String hoTen, String namSinh, String diaChi, String gioiTinh, String soDienThoai, String soCanCuoc, String nhietDo, String huyetAp) {
        this.maHS = maHS;
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.soDienThoai = soDienThoai;
        this.soCanCuoc = soCanCuoc;
        this.nhietDo = nhietDo;
        this.huyetAp = huyetAp;
    }

    public int getMaHS() {
        return maHS;
    }

    public void setMaHS(int maHS) {
        this.maHS = maHS;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(String namSinh) {
        this.namSinh = namSinh;
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

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getSoCanCuoc() {
        return soCanCuoc;
    }

    public void setSoCanCuoc(String soCanCuoc) {
        this.soCanCuoc = soCanCuoc;
    }

    public String getNhietDo() {
        return nhietDo;
    }

    public void setNhietDo(String nhietDo) {
        this.nhietDo = nhietDo;
    }

    public String getHuyetAp() {
        return huyetAp;
    }

    public void setHuyetAp(String huyetAp) {
        this.huyetAp = huyetAp;
    }

    @Override
    public String toString() {
        return "HoSoSucKhoe{" +
                "maHS=" + maHS +
                ", hoTen='" + hoTen + '\'' +
                ", namSinh='" + namSinh + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                ", soCanCuoc='" + soCanCuoc + '\'' +
                ", nhietDo='" + nhietDo + '\'' +
                ", huyetAp='" + huyetAp + '\'' +
                '}';
    }
}
