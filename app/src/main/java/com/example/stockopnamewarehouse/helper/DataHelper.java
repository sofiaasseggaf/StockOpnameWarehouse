package com.example.stockopnamewarehouse.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.stockopnamewarehouse.model.BarangGudangModel;
import com.example.stockopnamewarehouse.model.BarangModel;
import com.example.stockopnamewarehouse.model.ProfileModel;

import java.util.ArrayList;
import java.util.List;

public class DataHelper extends SQLiteOpenHelper {

    private  static final String DATABASE_NAME = "stockopname.db";
    private static final int DATABASE_VERSION = 1;

    public DataHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE_USER = "create table user(id_user integer primary key, nama text null, username text null, password text null, id_role integer null);";
        Log.d("Data", "onCreate : " + CREATE_TABLE_USER);
        db.execSQL(CREATE_TABLE_USER);

        String CREATE_TABLE_ROLE = "create table role(id_role integer primary key, nama_role text null);";
        Log.d("Data", "onCreate : " + CREATE_TABLE_ROLE);
        db.execSQL(CREATE_TABLE_ROLE);

        String CREATE_TABLE_BARANG = "create table barang(item_cd integer primary key, item_desc text null, std_packing text null, stock_qty integer null, item_barcode text null);";
        Log.d("Data", "onCreate : " + CREATE_TABLE_BARANG);
        db.execSQL(CREATE_TABLE_BARANG);

        //Tabel Persediaan Gudang Barang
        String CREATE_TABLE_PG = "create table persediaan_gudang_brg(item_cd integer primary key, item_desc text key, stock_qty integer null, stock_qty_gudang integer null, item_barcode text null, tanggal text null);";
        Log.d("Data", "onCreate : " + CREATE_TABLE_PG);
        db.execSQL(CREATE_TABLE_PG);

        /*//Tabel Persediaan Awal Barang
        String CREATE_TABLE_PAB = "create table persediaan_awal_brg(id_psd_awal integer primary key, item_cd integer null, stock_qty_awal integer null);";
        Log.d("Data", "onCreate : " + CREATE_TABLE_PAB);
        db.execSQL(CREATE_TABLE_PAB);

        //Tabel Persediaan Akhir Barang
        String CREATE_TABLE_PAKB = "create table persediaan_akhir_brg(id_psd_akhir integer primary key, item_cd integer null, stock_qty_akhir integer null);";
        Log.d("Data", "onCreate : " + CREATE_TABLE_PAKB);
        db.execSQL(CREATE_TABLE_PAKB);

        //Tabel Barang Masuk
        String CREATE_TABLE_BM = "create table brg_masuk(id_barang_masuk integer primary key, item_cd integer null, stock_qty_bm integer null);";
        Log.d("Data", "onCreate : " + CREATE_TABLE_BM);
        db.execSQL(CREATE_TABLE_BM);

        //Tabel Penjualan Barang atau Barang Keluar
        String CREATE_TABLE_BK = "create table penjualan_brg(id_barang_keluar integer primary key, item_cd integer null, stock_qty_bk integer null);";
        Log.d("Data", "onCreate : " + CREATE_TABLE_BK);
        db.execSQL(CREATE_TABLE_BK);

        //Tabel Selisih / Output / Stock Opname
        String CREATE_TABLE_STOCK_OPNAME = "create table stock_opname(id_stock_opname integer primary key, item_cd integer null, stock_qty_selisih integer null, keterangan text null);";
        Log.d("Data", "onCreate : " + CREATE_TABLE_STOCK_OPNAME);
        db.execSQL(CREATE_TABLE_STOCK_OPNAME);
         */


        // --------------- INSERT DATA TO TABLE -----------

        String INSERT_INTO_USER = "INSERT INTO user (id_user, nama, username, password, id_role) VALUES ('1', 'Sofia', 'sofia', '1', '1');";
        db.execSQL(INSERT_INTO_USER);
        String INSERT_INTO_USER2 = "INSERT INTO user (id_user, nama, username, password, id_role) VALUES ('2', 'Adam', 'adam', '2', '2');";
        db.execSQL(INSERT_INTO_USER2);
        String INSERT_INTO_USER3 = "INSERT INTO user (id_user, nama, username, password, id_role) VALUES ('3', 'Anna', 'anna', '3', '3');";
        db.execSQL(INSERT_INTO_USER3);

        String INSERT_INTO_ROLE = "INSERT INTO role (id_role, nama_role) VALUES ('1', 'Petugas Inventori');";
        db.execSQL(INSERT_INTO_ROLE);
        String INSERT_INTO_ROLE2 = "INSERT INTO role (id_role, nama_role) VALUES ('2', 'Petugas Audit');";
        db.execSQL(INSERT_INTO_ROLE2);
        String INSERT_INTO_ROLE3 = "INSERT INTO role (id_role, nama_role) VALUES ('3', 'Manager');";
        db.execSQL(INSERT_INTO_ROLE3);


       /* String INSERT_INTO_PAB = "INSERT INTO persediaan_awal_brg (id_psd_awal, item_cd, stock_qty_awal) VALUES ('1', '1', '20');";
        db.execSQL(INSERT_INTO_PAB);

        String INSERT_INTO_PAKB = "INSERT INTO persediaan_akhir_brg (id_psd_akhir, item_cd, stock_qty_akhir) VALUES ('1', '1', '30');";
        db.execSQL(INSERT_INTO_PAKB);

        String INSERT_INTO_BM = "INSERT INTO brg_masuk (id_barang_masuk, item_cd, stock_qty_bm) VALUES ('1', '1', '12');";
        db.execSQL(INSERT_INTO_BM);

        String INSERT_INTO_BK = "INSERT INTO penjualan_brg (id_barang_keluar, item_cd, stock_qty_bk) VALUES ('1', '1', '2');";
        db.execSQL(INSERT_INTO_BK);

        String INSERT_INTO_PG = "INSERT INTO persediaan_gudang_brg (item_cd, item_desc, stock_qty_gudang, item_barcode, tanggal) VALUES ('2', 'Rokok', '7', '8999909002876', '25 Des 2021');";
        db.execSQL(INSERT_INTO_PG);

        String INSERT_INTO_STOCK_OPNAME = "INSERT INTO stock_opname (id_stock_opname, item_cd, stock_qty_selisih, Keterangan) VALUES ('1', '1', '1', 'Barang Rusak');";
        db.execSQL(INSERT_INTO_STOCK_OPNAME);

    }*/

    }

    public List<ProfileModel> getAllProfile() {
        List<ProfileModel> profileModelList = new ArrayList<ProfileModel>();
        // Select All Query
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT  * FROM user", null);
        cursor.moveToFirst();
        // Looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                ProfileModel profileModel = new ProfileModel(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getInt(4));

                profileModelList.add(profileModel);
            } while (cursor.moveToNext());
        }

        // return student list
        return profileModelList;
    }

    public List<BarangModel> getAllBarang() {
        List<BarangModel> barangModelList = new ArrayList<BarangModel>();
        // Select All Query
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT  * FROM barang", null);
        cursor.moveToFirst();
        // Looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                BarangModel barangModel = new BarangModel(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getInt(3),
                        cursor.getString(4));

                barangModelList.add(barangModel);
            } while (cursor.moveToNext());
        }

        // return student list
        return barangModelList;
    }

    public ProfileModel getProfile(int iduser) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM user WHERE id_user = '" + iduser + "'", null);
        String[] profile = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int cc=0; cc < cursor.getCount(); cc++) {
            cursor.moveToPosition(cc);
            profile[cc] = cursor.getString(0).toString();
        }
        ProfileModel profilelogged = new ProfileModel(
                Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                Integer.parseInt(cursor.getString(4)));

        //Return Student
        return profilelogged;
    }

    //getbarang with id
    public BarangModel getBarang(int item_cd) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM barang WHERE item_cd = '" + item_cd + "'", null);
        String[] barang = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int cc=0; cc < cursor.getCount(); cc++) {
            cursor.moveToPosition(cc);
            barang[cc] = cursor.getString(0).toString();
        }
        BarangModel baranglogged = new BarangModel(
                cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getInt(3),
                cursor.getString(4));

        //Return Student
        return baranglogged;
    }

    //getbarang with barcode
    public BarangModel getBarangwithBarcode(String item_barcode) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM barang WHERE item_barcode = '" + item_barcode + "'", null);
        String[] barang = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int cc=0; cc < cursor.getCount(); cc++) {
            cursor.moveToPosition(cc);
            barang[cc] = cursor.getString(0).toString();
        }
        BarangModel barangnya = new BarangModel(
                cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getInt(3),
                cursor.getString(4));

        //Return Student
        return barangnya;
    }

    public List<BarangGudangModel> getAllBarangGudang() {
        List<BarangGudangModel> barangGudangList = new ArrayList<BarangGudangModel>();
        // Select All Query
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT  * FROM persediaan_gudang_brg", null);
        cursor.moveToFirst();
        // Looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                BarangGudangModel barangGudangModel = new BarangGudangModel(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getInt(2),
                        cursor.getInt(3),
                        cursor.getString(4),
                        cursor.getString(5));

                barangGudangList.add(barangGudangModel);
            } while (cursor.moveToNext());
        }

        return barangGudangList;
    }


    //getlaporan with barcode
    public BarangGudangModel getLaporanwithbarcode(String item_barcode) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT  * FROM persediaan_gudang_brg WHERE item_barcode = '" + item_barcode + "'", null);
        String[] barang = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int cc=0; cc < cursor.getCount(); cc++) {
            cursor.moveToPosition(cc);
            barang[cc] = cursor.getString(0).toString();
        }
        BarangGudangModel barangGudangModel = new BarangGudangModel(
                cursor.getInt(0),
                cursor.getString(1),
                cursor.getInt(2),
                cursor.getInt(3),
                cursor.getString(4),
                cursor.getString(5));

        //Return Student
        return barangGudangModel;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
