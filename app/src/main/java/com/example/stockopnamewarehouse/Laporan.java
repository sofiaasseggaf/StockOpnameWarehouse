package com.example.stockopnamewarehouse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.stockopnamewarehouse.adapter.AdapterDataBarang;
import com.example.stockopnamewarehouse.adapter.AdapterLaporan;
import com.example.stockopnamewarehouse.helper.DataHelper;
import com.example.stockopnamewarehouse.master_inventori.DataBarang;
import com.example.stockopnamewarehouse.master_inventori.EditBarang;
import com.example.stockopnamewarehouse.model.BarangGudangModel;
import com.example.stockopnamewarehouse.model.BarangModel;
import com.example.stockopnamewarehouse.utility.PreferenceUtils;
import com.example.stockopnamewarehouse.utility.RecyclerItemClickListener;

import java.util.List;

public class Laporan extends AppCompatActivity {

    RecyclerView rv;
    DataHelper dbCenter;
    int role;
    List<BarangModel> listBarang;
    List<BarangGudangModel> listBarangGudang;
    AdapterLaporan itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_laporan);

        rv = findViewById(R.id.rv);
        role = Integer.valueOf(PreferenceUtils.getIdRole(getApplicationContext()));

        dbCenter = new DataHelper(this);
        getLaporan();

    }

    public void getLaporan(){
        Log.d("Laporan", "get laporan");
        listBarang = dbCenter.getAllBarang();
        listBarangGudang = dbCenter.getAllBarangGudang();
        itemList = new AdapterLaporan(listBarang, listBarangGudang);
        rv.setLayoutManager(new LinearLayoutManager(Laporan.this));
        rv.setAdapter(itemList);
    }

    @Override
    public void onBackPressed() {
        if (role==1){
            Intent a = new Intent(Laporan.this, Home_Role1.class);
            startActivity(a);
            finish();
        } else if (role==2){
            Intent a = new Intent(Laporan.this, Home_Role2.class);
            startActivity(a);
            finish();
        } else if (role==3){
            Intent a = new Intent(Laporan.this, Home_Role3.class);
            startActivity(a);
            finish();
        }    }
}