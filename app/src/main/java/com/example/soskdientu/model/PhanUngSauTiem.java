package com.example.soskdientu.model;

public class PhanUngSauTiem {
    private String tenVacxin, ngayTiem,thoiGian,noidDung;

    public PhanUngSauTiem() {
    }

    public PhanUngSauTiem(String tenVacxin, String ngayTiem, String thoiGian, String noidDung) {
        this.tenVacxin = tenVacxin;
        this.ngayTiem = ngayTiem;
        this.thoiGian = thoiGian;
        this.noidDung = noidDung;
    }

    public String getTenVacxin() {
        return tenVacxin;
    }

    public void setTenVacxin(String tenVacxin) {
        this.tenVacxin = tenVacxin;
    }

    public String getNgayTiem() {
        return ngayTiem;
    }

    public void setNgayTiem(String ngayTiem) {
        this.ngayTiem = ngayTiem;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getNoidDung() {
        return noidDung;
    }

    public void setNoidDung(String noidDung) {
        this.noidDung = noidDung;
    }
}
