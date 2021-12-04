package com.example.soskdientu.model;

public class HsSucKhoe {
    private String nhietDo,huyetAp,nhomMau,nhipTim,chieuCao,canNang;

    public HsSucKhoe() {
    }

    public HsSucKhoe(String nhietDo, String huyetAp, String nhomMau, String nhipTim, String chieuCao, String canNang) {
        this.nhietDo = nhietDo;
        this.huyetAp = huyetAp;
        this.nhomMau = nhomMau;
        this.nhipTim = nhipTim;
        this.chieuCao = chieuCao;
        this.canNang = canNang;
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

    public String getNhomMau() {
        return nhomMau;
    }

    public void setNhomMau(String nhomMau) {
        this.nhomMau = nhomMau;
    }

    public String getNhipTim() {
        return nhipTim;
    }

    public void setNhipTim(String nhipTim) {
        this.nhipTim = nhipTim;
    }

    public String getChieuCao() {
        return chieuCao;
    }

    public void setChieuCao(String chieuCao) {
        this.chieuCao = chieuCao;
    }

    public String getCanNang() {
        return canNang;
    }

    public void setCanNang(String canNang) {
        this.canNang = canNang;
    }

}
