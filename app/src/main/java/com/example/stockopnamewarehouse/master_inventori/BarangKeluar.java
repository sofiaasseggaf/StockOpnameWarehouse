package com.example.stockopnamewarehouse.master_inventori;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.stockopnamewarehouse.R;
import com.example.stockopnamewarehouse.helper.DataHelper;
import com.example.stockopnamewarehouse.model.BarangModel;

public class BarangKeluar extends AppCompatActivity {

    EditText et_item_cd, et_item_desc, et_jml_barang_keluar;
    ImageButton btn_simpan, btn_batal;
    int item_cd;
    BarangModel barangModel;
    DataHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.master_barang_keluar);

        dbHelper = new DataHelper(this);
        et_item_cd = findViewById(R.id.et_item_cd);
        et_item_desc = findViewById(R.id.et_item_desc);
        et_jml_barang_keluar = findViewById(R.id.et_jml_barang_keluar);
        btn_simpan = findViewById(R.id.btn_simpan);
        btn_batal = findViewById(R.id.btn_batal);

        Intent intent = getIntent();
        item_cd = intent.getIntExtra("idbarang", 0);
        getBarang(item_cd);

        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                simpanBarangKeluar();
            }
        });

        btn_batal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
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
    }

    public void simpanBarangKeluar(){
        int stock_terakhir = barangModel.getStock_qty();
        int total_stock = stock_terakhir - Integer.parseInt(et_jml_barang_keluar.getText().toString());

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL("update barang set stock_qty='"+total_stock+"' " +
                "where item_cd='"+ barangModel.getItem_cd() +"'");
        Toast.makeText(getApplicationContext(), "Berhasil Simpan Barang Keluar", Toast.LENGTH_SHORT).show();
        DataBarang.dataMaster.getDataBarang();
        Intent a = new Intent(BarangKeluar.this, EditBarang.class);
        a.putExtra("idbarang", item_cd);
        startActivity(a);
        finish();
    }
}