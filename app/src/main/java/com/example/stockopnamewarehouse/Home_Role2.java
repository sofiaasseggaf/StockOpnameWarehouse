package com.example.stockopnamewarehouse;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.stockopnamewarehouse.utility.PreferenceUtils;

//HOME PETUGAS AUDIT
public class Home_Role2 extends AppCompatActivity {

    ImageButton btn_akun, btn_master, btn_scan, btn_banding, btn_about;
    TextView user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_role2);

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
                Intent a = new Intent(Home_Role2.this, Profile.class);
                startActivity(a);
                finish();
            }
        });

        btn_master.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Home_Role2.this);
                builder.setMessage("HANYA UNTUK PETUGAS INVENTORI")
                        .setNegativeButton("Kembali", null)
                        .create()
                        .show();
            }
        });

        btn_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(Home_Role2.this, StockOpname.class);
                startActivity(a);
                finish();
            }
        });

        btn_banding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Home_Role2.this);
                builder.setMessage("HANYA UNTUK PETUGAS AUDIT")
                        .setNegativeButton("Kembali", null)
                        .create()
                        .show();
            }
        });

        btn_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(Home_Role2.this, About.class);
                startActivity(a);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alert = new AlertDialog.Builder(Home_Role2.this);
        alert.setMessage("Keluar dari aplikasi ?")
                .setPositiveButton("Keluar", new DialogInterface.OnClickListener()                 {

                    public void onClick(DialogInterface dialog, int which) {

                        Home_Role2.super.onBackPressed();
                        finish();
                        finishAffinity();

                    }
                }).setNegativeButton("Cancel", null);

        AlertDialog alert1 = alert.create();
        alert1.show();
    }
}