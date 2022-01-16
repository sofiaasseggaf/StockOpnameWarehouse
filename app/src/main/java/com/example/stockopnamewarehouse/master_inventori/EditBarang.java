package com.example.stockopnamewarehouse.master_inventori;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.stockopnamewarehouse.Home_Role1;
import com.example.stockopnamewarehouse.R;
import com.example.stockopnamewarehouse.adapter.AdapterDataBarang;
import com.example.stockopnamewarehouse.helper.DataHelper;
import com.example.stockopnamewarehouse.model.BarangModel;
import com.example.stockopnamewarehouse.utility.PreferenceUtils;
import com.example.stockopnamewarehouse.utility.RecyclerItemClickListener;

import java.util.List;

public class EditBarang extends AppCompatActivity {

    DataHelper dbHelper;
    ImageButton btn_simpan, btn_batal, btn_barang_masuk, btn_barang_keluar, btn_hapus;
    EditText et_item_cd, et_item_desc, et_std_packing, et_stock_qty, et_item_barcode;
    int item_cd;
    BarangModel barangModel;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.master_editbarang);

        dbHelper = new DataHelper(this);
        et_item_cd = findViewById(R.id.et_item_cd);
        et_item_desc = findViewById(R.id.et_item_desc);
        et_std_packing = findViewById(R.id.et_std_packing);
        et_stock_qty = findViewById(R.id.et_stock_qty);
        et_item_barcode = findViewById(R.id.et_item_barcode);

        btn_hapus = findViewById(R.id.btn_hapus);
        btn_simpan = findViewById(R.id.btn_simpan);
        btn_batal = findViewById(R.id.btn_batal);
        btn_barang_masuk = findViewById(R.id.btn_barang_masuk);
        btn_barang_keluar = findViewById(R.id.btn_barang_keluar);

        Intent intent = getIntent();
        item_cd = intent.getIntExtra("idbarang", 0);
        getBarang(item_cd);

        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                simpanDataBarang();
            }
        });

        btn_batal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btn_barang_masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(EditBarang.this, BarangMasuk.class);
                a.putExtra("idbarang", barangModel.getItem_cd());
                startActivity(a);
            }
        });

        btn_barang_keluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(EditBarang.this, BarangKeluar.class);
                a.putExtra("idbarang", barangModel.getItem_cd());
                startActivity(a);
            }
        });

        btn_hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(EditBarang.this);
                alert.setMessage("Hapus Barang ?")
                        .setPositiveButton("Hapus", new DialogInterface.OnClickListener()                 {

                            public void onClick(DialogInterface dialog, int which) {
                                hapusBarang();
                            }
                        }).setNegativeButton("Cancel", null);

                AlertDialog alert1 = alert.create();
                alert1.show();
            }
        });
    }

    public void getBarang(int i){
        Log.d("DataBarang", "get barang");
        barangModel = dbHelper.getBarang(i);
         setDataBarang();
    }

    public void setDataBarang(){

        et_item_cd.setText(String.valueOf(barangModel.getItem_cd()));
        et_item_desc.setText(barangModel.getItem_desc());
        et_std_packing.setText(barangModel.getStd_packing());
        et_stock_qty.setText(String.valueOf(barangModel.getStock_qty()));
        // NOMER BARCODE BEDA (ganti tipe data)
        et_item_barcode.setText(barangModel.getItem_barcode());

    }

    public void simpanDataBarang(){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        // et_item_desc, et_std_packing
        db.execSQL("update barang set item_desc='"+et_item_desc.getText().toString()+"', std_packing='"+et_std_packing.getText().toString()+"' " +
                "where item_cd='"+ barangModel.getItem_cd() +"'");
        Toast.makeText(getApplicationContext(), "Berhasil Simpan Barang", Toast.LENGTH_SHORT).show();
        DataBarang.dataMaster.getDataBarang();
        finish();
    }

    public void hapusBarang(){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL("delete from barang where item_cd = '"+barangModel.getItem_cd()+"'");
        DataBarang.dataMaster.getDataBarang();
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        Intent a = new Intent(EditBarang.this, DataBarang.class);
        startActivity(a);
        finish();
    }
}
