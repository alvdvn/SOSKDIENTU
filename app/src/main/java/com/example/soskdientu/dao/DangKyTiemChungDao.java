package com.example.soskdientu.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.soskdientu.model.DangKyTiemChung;
import com.example.soskdientu.model.HoSoSucKhoe;
import com.example.soskdientu.mysqlite.MySQLite;

import java.util.ArrayList;
import java.util.List;

public class DangKyTiemChungDao {
    private MySQLite mySQLite;
    private SQLiteDatabase db;

    public DangKyTiemChungDao(Context context){
        mySQLite=new MySQLite(context);
        db=mySQLite.getWritableDatabase();
    }
    public long insert(DangKyTiemChung t){
        ContentValues values= new ContentValues();
        values.put("hoTen",t.getHoTen());
        values.put("ngaySinh",t.getNgaySinh());
        values.put("diaChi",t.getDiaChi());
        values.put("gioitinh",t.getGioiTinh());
        values.put("soCMND",t.getSoCMND());
        values.put("soBHYT",t.getSoBHYT());
        return db.insert("DangKyTiemChung",null,values);

    }

    public int update(DangKyTiemChung t){
        ContentValues values=new ContentValues();
        values.put("hoTen",t.getHoTen());
        values.put("ngaySinh",t.getNgaySinh());
        values.put("diaChi",t.getDiaChi());
        values.put("gioitinh",t.getGioiTinh());
        values.put("soCMND",t.getSoCMND());
        values.put("soBHYT",t.getSoBHYT());
        return db.update("DangKyTiemChung",values,"HoTen=?",new String[]{t.getHoTen()+""});
    }

    public int delete(int ma){
        return db.delete("DangKyTiemChung","HoTen=?",new String[]{ma+""});
    }
    public List<DangKyTiemChung> getDaTa(String sql, String...selectionArgs){
        List<DangKyTiemChung> list=new ArrayList<>();
        Cursor c=db.rawQuery(sql,selectionArgs);
        if (c.getCount() > 0) {
            c.moveToNext();
            while (!c.isAfterLast()) {
                String a = c.getString(0);
                String b = c.getString(1);
                String cc = c.getString(2);
                int d = c.getInt(3);
                int e = c.getInt(4);
                int f = c.getInt(5);
                list.add(new DangKyTiemChung(a,b,cc,d,e,f));
                c.moveToNext();
            }
            c.close();
        }
        return list;
    }
    public List<DangKyTiemChung> getAll(){
        String sql="select * from DangKyTiemChung";
        return getDaTa(sql);
    }
    public DangKyTiemChung getID(String id){
        String sql="select * from DangKyTiemChung where HoTen=?";
        List<DangKyTiemChung> list=getDaTa(sql,id);
        return list.get(0);
    }
    public List<DangKyTiemChung> searchTV(String ten){
        String sql="select * from  DangKyTiemChung  where HoTen=?";
        return getDaTa(sql,ten);
    }
}
