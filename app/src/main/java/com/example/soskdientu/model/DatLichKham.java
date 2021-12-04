package com.example.soskdientu.model;

public class DatLichKham {
    String hoten;
    String CMND;
    String date;
    String time;
    String trieuchung;
    String BHYT;

    public DatLichKham() {
    }

    public DatLichKham(String hoten, String CMND, String date, String time, String trieuchung, String BHYT) {
        this.hoten = hoten;
        this.CMND = CMND;
        this.date = date;
        this.time = time;
        this.trieuchung = trieuchung;
        this.BHYT = BHYT;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTrieuchung() {
        return trieuchung;
    }

    public void setTrieuchung(String trieuchung) {
        this.trieuchung = trieuchung;
    }

    public String getBHYT() {
        return BHYT;
    }

    public void setBHYT(String BHYT) {
        this.BHYT = BHYT;
    }
}
