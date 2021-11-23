package com.example.soskdientu.mysqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLite extends SQLiteOpenHelper {
    public MySQLite(Context context) {
        super(context, "SPM.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_HoSoSucKhoe = "CREATE TABLE HoSoSucKhoe (maHS INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "hoTen TEXT NOT NULL, namSinh TEXT NOT NULL,diaChi TEXT NOT NULL,gioiTinh TEXT NOT NULL,soDienThoai TEXT NOT NULL, " +
                "soCanCuoc TEXT NOT NULL,nhietDo TEXT NOT NULL, huyetAp TEXT NOT NULL )";
        db.execSQL(create_HoSoSucKhoe);

        String create_DangKyTiemChung = "CREATE TABLE DangKyTiemChung ( hoTen TEXT NOT NULL, ngaySinh DATE NOT NULL, diaChi TEXT NOT NULL," +
                "gioiTinh TEXT NOT NULL, soBHYT INTEGER NOT NULL, soCMND INTEGER NOT NULL )";
        db.execSQL(create_DangKyTiemChung);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS HoSoSucKhoe");

    }


}
