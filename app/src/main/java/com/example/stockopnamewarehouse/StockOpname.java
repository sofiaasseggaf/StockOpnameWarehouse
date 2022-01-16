package com.example.stockopnamewarehouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.example.stockopnamewarehouse.adapter.AdapterDataBarang;
import com.example.stockopnamewarehouse.helper.DataHelper;
import com.example.stockopnamewarehouse.master_inventori.DataBarang;
import com.example.stockopnamewarehouse.master_inventori.EditBarang;
import com.example.stockopnamewarehouse.master_inventori.TambahBarang;
import com.example.stockopnamewarehouse.model.BarangGudangModel;
import com.example.stockopnamewarehouse.model.BarangModel;
import com.example.stockopnamewarehouse.utility.PreferenceUtils;
import com.example.stockopnamewarehouse.utility.RecyclerItemClickListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class StockOpname extends AppCompatActivity {

    int role;
    ImageButton btn_simpan, btn_batal, btn_scan;
    DataHelper dbHelper;
    EditText et_item_cd, et_item_desc, et_stock_qty, et_item_barcode, et_stock_qty_gudang, et_keterangan;
    String barcode;
    BarangModel barangModel;
    String date;
    String[] listBarcode, listBarcodeBarang;

    //List<BarangModel> barangModelList;
    int barangada;
    int MY_CAMERA_REQUEST_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_stockopname);

        dbHelper = new DataHelper(this);
        date = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());

        role = Integer.valueOf(PreferenceUtils.getIdRole(getApplicationContext()));
        btn_simpan = findViewById(R.id.btn_simpan);
        btn_batal = findViewById(R.id.btn_batal);
        btn_scan = findViewById(R.id.btn_scan);

        et_item_cd = findViewById(R.id.et_item_cd);
        et_item_desc = findViewById(R.id.et_item_desc);
        et_stock_qty = findViewById(R.id.et_stock_qty);
        et_item_barcode = findViewById(R.id.et_item_barcode);
        et_stock_qty_gudang = findViewById(R.id.et_stock_qty_gudang);
        //et_keterangan = findViewById(R.id.et_keterangan);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.CAMERA}, MY_CAMERA_REQUEST_CODE);
            }
        }

        getdataBarcodediGudang();
        getdataBarcodediSistem();

        btn_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater layoutInflater = LayoutInflater.from(StockOpname.this);
                final View v = layoutInflater.inflate(R.layout.z_dialog_scanning, null);
                AlertDialog alertDialog = new AlertDialog.Builder(StockOpname.this).create();

                final TextView txt_barcode = (TextView) v.findViewById(R.id.txt_barcode);
                final ImageButton btn_batal = (ImageButton) v.findViewById(R.id.btn_batal);
                final CodeScannerView scannerView = (CodeScannerView) v.findViewById(R.id.scanner_view);
                final CodeScanner mcs =  new CodeScanner(StockOpname.this, scannerView);
                mcs.startPreview();



                mcs.setDecodeCallback(new DecodeCallback() {
                    @Override
                    public void onDecoded(@NonNull com.google.zxing.Result result) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                //Toast.makeText(StockOpname.this, result.getText(), Toast.LENGTH_SHORT).show();
                                txt_barcode.setText(result.getText());
                                }
                        });
                    }
                });
                /*scannerView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });*/

                btn_batal.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        barcode = txt_barcode.getText().toString();

                        if (barcode.equalsIgnoreCase("")) {
                            alertDialog.dismiss();
                            Toast.makeText(StockOpname.this, "Scan Barcode Terlebih Dahulu", Toast.LENGTH_SHORT).show();
                        }

                        if(listBarcodeBarang.length!=0) {
                            for (int j = 0; j < listBarcodeBarang.length; j++) {
                                if (listBarcodeBarang[j].equalsIgnoreCase(barcode)) {
                                    barangada = 1;
                                }
                            }

                        }

                        if(barangada!=1){
                                     alertDialog.dismiss();
                                    AlertDialog.Builder builder = new AlertDialog.Builder(StockOpname.this);
                                    builder.setMessage("BARANG TIDAK TERDAFTAR DI SISTEM")
                                            .setNegativeButton("Kembali", null)
                                            .create()
                                            .show();

                            }

                        if (barangada == 1) {
                                for (int i = 0; i < listBarcode.length; i++) {
                                    if (listBarcode[i].equalsIgnoreCase(barcode)) {
                                        alertDialog.dismiss();
                                        AlertDialog.Builder builder = new AlertDialog.Builder(StockOpname.this);
                                        builder.setMessage("BARANG SUDAH DI AUDIT")
                                                .setNegativeButton("Kembali", null)
                                                .create()
                                                .show();
                                    } else {
                                        getBarangwithBarcode(barcode);
                                        alertDialog.dismiss();
                                    }
                                }
                            }
                        }

                });

                alertDialog.setView(v);
                alertDialog.show();
            }
        });


        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
// item_cd integer primary key, item_desc text key, stock_qty integer null, stock_qty_gudang integer null, item_barcode integer null, keterangan text null, tanggal text null
                db.execSQL("insert into persediaan_gudang_brg(item_cd, item_desc, stock_qty, stock_qty_gudang, item_barcode, tanggal) values('" +
                        et_item_cd.getText().toString() + "','" +
                        et_item_desc.getText().toString() + "','" +
                        et_stock_qty.getText().toString() + "','" +
                        et_stock_qty_gudang.getText().toString() + "','" +
                        et_item_barcode.getText().toString() + "','" +
                        date + "')");
                Toast.makeText(getApplicationContext(), "Berhasil Tambah Data Persediaan Barang Gudang", Toast.LENGTH_SHORT).show();
                //DataBarang.dataMaster.getDataBarang();
                onBackPressed();
            }
        });

        btn_batal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    public void getdataBarcodediGudang(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM persediaan_gudang_brg", null);
        listBarcode = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int cc=0; cc < cursor.getCount(); cc++) {
            cursor.moveToPosition(cc);
            listBarcode[cc] = cursor.getString(4).toString();
        }
    }

    public void getBarangwithBarcode(String i){
        Log.d("StockOpname", "get barang");
        barangModel = dbHelper.getBarangwithBarcode(i);
        setDataBarang();
    }

    public void setDataBarang(){
        et_item_cd.setText(String.valueOf(barangModel.getItem_cd()));
        et_item_desc.setText(barangModel.getItem_desc());
        et_stock_qty.setText(String.valueOf(barangModel.getStock_qty()));
        et_item_barcode.setText(barangModel.getItem_barcode());
    }

    public void getdataBarcodediSistem(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM barang", null);
        listBarcodeBarang = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int cc=0; cc < cursor.getCount(); cc++) {
            cursor.moveToPosition(cc);
            listBarcodeBarang[cc] = cursor.getString(4).toString();
        }

    }


    @Override
    public void onBackPressed() {
        if (role==1){
            Intent a = new Intent(StockOpname.this, Home_Role1.class);
            startActivity(a);
            finish();
        } else if (role==2){
            Intent a = new Intent(StockOpname.this, Home_Role2.class);
            startActivity(a);
            finish();
        } else if (role==3){
            Intent a = new Intent(StockOpname.this, Home_Role3.class);
            startActivity(a);
            finish();
        }
    }
}