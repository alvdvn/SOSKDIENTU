package com.example.soskdientu.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.soskdientu.model.HoSoSucKhoe;
import com.example.soskdientu.mysqlite.MySQLite;

import java.util.ArrayList;
import java.util.List;

public class HoSoSucKhoeDao {
    private MySQLite mySQLite;
    private SQLiteDatabase db;


    public HoSoSucKhoeDao(Context context){
        mySQLite=new MySQLite(context);
        db=mySQLite.getWritableDatabase();
    }
    public long insert(HoSoSucKhoe t){
        ContentValues values= new ContentValues();
        values.put("hoTen",t.getHoTen());
        values.put("namSinh",t.getNamSinh());
        values.put("diaChi",t.getDiaChi());
        values.put("gioitinh",t.getGioiTinh());
        values.put("soDienThoai",t.getSoDienThoai());
        values.put("soCanCuoc",t.getSoCanCuoc());
        values.put("nhietDo",t.getNhietDo());
        values.put("huyetAp",t.getHuyetAp());
        return db.insert("HoSoSucKhoe",null,values);

    }

    public int update(HoSoSucKhoe t){
        ContentValues values=new ContentValues();
        values.put("hoTen",t.getHoTen());
        values.put("namSinh",t.getNamSinh());
        values.put("diaChi",t.getDiaChi());
        values.put("gioitinh",t.getGioiTinh());
        values.put("soDienThoai",t.getSoDienThoai());
        values.put("soCanCuoc",t.getSoCanCuoc());
        values.put("nhietDo",t.getNhietDo());
        values.put("huyetAp",t.getHuyetAp());
        return db.update("HoSoSucKhoe",values,"maHS=?",new String[]{t.getMaHS()+""});
    }

    public int delete(int ma){
        return db.delete("HoSoSucKhoe","maHS=?",new String[]{ma+""});
    }
    public List<HoSoSucKhoe> getDaTa(String sql, String...selectionArgs){
        List<HoSoSucKhoe> list=new ArrayList<>();
        Cursor c=db.rawQuery(sql,selectionArgs);
        if (c.getCount() > 0) {
            c.moveToNext();
            while (!c.isAfterLast()) {
                int a = c.getInt(0);
                String b = c.getString(1);
                String cc = c.getString(2);
                String d = c.getString(3);
                String e = c.getString(4);
                String f = c.getString(5);
                String g = c.getString(6);
                String h = c.getString(7);
                String j = c.getString(8);
                list.add(new HoSoSucKhoe(a,b,cc,d,e,f,g,h,j));
                c.moveToNext();
            }
            c.close();
        }
        return list;
    }
    public List<HoSoSucKhoe> getAll(){
        String sql="select * from HoSoSucKhoe";
        return getDaTa(sql);
    }
    public HoSoSucKhoe getID(String id){
        String sql="select * from HoSoSucKhoe where maHS=?";
        List<HoSoSucKhoe> list=getDaTa(sql,id);
        return list.get(0);
    }
    public List<HoSoSucKhoe> searchTV(String ten){
        String sql="select * from  HoSoSucKhoe  where hoTen=?";
        return getDaTa(sql,ten);
    }

}
