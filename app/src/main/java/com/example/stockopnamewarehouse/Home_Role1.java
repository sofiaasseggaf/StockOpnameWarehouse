package com.example.stockopnamewarehouse;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.stockopnamewarehouse.master_inventori.DataBarang;
import com.example.stockopnamewarehouse.utility.PreferenceUtils;

//HOME PETUGAS INVENTORI
public class Home_Role1 extends AppCompatActivity {

    ImageButton btn_akun, btn_master, btn_scan, btn_banding, btn_about;
    TextView user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_role1);

        user = findViewById(R.id.user);
        btn_akun = findViewById(R.id.btn_akun);
        btn_master = findViewById(R.id.btn_master);
        btn_scan = findViewById(R.id.btn_scan);
        btn_banding = findViewById(R.id.btn_banding);
        btn_about = findViewById(R.id.btn_about);

        user.setText("Hi, " + PreferenceUtils.getNama(getApplicationContext()));

        btn_akun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(Home_Role1.this, Profile.class);
                startActivity(a);
                finish();
            }
        });

        btn_master.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(Home_Role1.this, DataBarang.class);
                startActivity(a);
                finish();
            }
        });

        btn_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Home_Role1.this);
                builder.setMessage("HANYA UNTUK PESERTA STOCK OPNAME")
                        .setNegativeButton("Kembali", null)
                        .create()
                        .show();
            }
        });

        btn_banding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Home_Role1.this);
                builder.setMessage("HANYA UNTUK PETUGAS AUDIT")
                        .setNegativeButton("Kembali", null)
                        .create()
                        .show();
            }
        });

        btn_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(Home_Role1.this, About.class);
                startActivity(a);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alert = new AlertDialog.Builder(Home_Role1.this);
        alert.setMessage("Keluar dari aplikasi ?")
                .setPositiveButton("Keluar", new DialogInterface.OnClickListener()                 {

                    public void onClick(DialogInterface dialog, int which) {

                        Home_Role1.super.onBackPressed();
                        finish();
                        finishAffinity();

                    }
                }).setNegativeButton("Cancel", null);

        AlertDialog alert1 = alert.create();
        alert1.show();
    }
}