package com.example.stockopnamewarehouse.master_inventori;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.example.stockopnamewarehouse.Home_Role1;
import com.example.stockopnamewarehouse.R;
import com.example.stockopnamewarehouse.helper.DataHelper;


public class TambahBarang extends AppCompatActivity {

    DataHelper dbHelper;
    ImageButton btn_simpan, btn_batal, btn_scan;
    EditText item_cd, item_desc, std_packing, stock_qty, item_barcode;
    String barcode;

    int MY_CAMERA_REQUEST_CODE = 101;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.master_tambahbarang);

        dbHelper = new DataHelper(this);

        item_cd = findViewById(R.id.et_item_cd);
        item_desc = findViewById(R.id.et_item_desc);
        std_packing = findViewById(R.id.et_std_packing);
        stock_qty = findViewById(R.id.et_stock_qty);
        item_barcode = findViewById(R.id.et_item_barcode);

        btn_simpan = findViewById(R.id.btn_simpan);
        btn_batal = findViewById(R.id.btn_batal);
        btn_scan = findViewById(R.id.btn_scan);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.CAMERA}, MY_CAMERA_REQUEST_CODE);
            }
        }

        btn_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater layoutInflater = LayoutInflater.from(TambahBarang.this);
                final View v = layoutInflater.inflate(R.layout.z_dialog_scanning, null);
                AlertDialog alertDialog = new AlertDialog.Builder(TambahBarang.this).create();

                final TextView txt_barcode = (TextView) v.findViewById(R.id.txt_barcode);
                final ImageButton btn_batal = (ImageButton) v.findViewById(R.id.btn_batal);
                final CodeScannerView scannerView = (CodeScannerView) v.findViewById(R.id.scanner_view);
                final CodeScanner mcs =  new CodeScanner(TambahBarang.this, scannerView);

                mcs.startPreview();

                mcs.setDecodeCallback(new DecodeCallback() {
                    @Override
                    public void onDecoded(@NonNull com.google.zxing.Result result) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(TambahBarang.this, result.getText(), Toast.LENGTH_SHORT).show();
                                txt_barcode.setText(result.getText());
                            }
                        });
                    }
                });


                btn_batal.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        barcode = txt_barcode.getText().toString();
                        alertDialog.dismiss();
                        item_barcode.setText(barcode);
                    }
                });

                alertDialog.setView(v);
                alertDialog.show();
            }
        });

        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //item_cd integer primary key, item_desc text null, std_packing text null, stock_qty integer null, item_barcode integer null
                // kalo bisa id barang auto
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into barang(item_cd, item_desc, std_packing, stock_qty, item_barcode) values('" +
                        item_cd.getText().toString() + "','" +
                        item_desc.getText().toString() + "','" +
                        std_packing.getText().toString() + "','" +
                        stock_qty.getText().toString() + "','" +
                        item_barcode.getText().toString() + "')");
                Toast.makeText(getApplicationContext(), "Berhasil Tambah Barang", Toast.LENGTH_SHORT).show();
                DataBarang.dataMaster.getDataBarang();
                onBackPressed();
            }
        });

        btn_batal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(TambahBarang.this, Home_Role1.class);
                startActivity(a);
                finish();
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_CAMERA_REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "camera permission granted", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "camera permission denied", Toast.LENGTH_LONG).show();
            }
        }
    }

    /*@Override
    protected void onResume() {
        super.onResume();
        mcs.startPreview();
    }

    @Override
    protected void onPause() {
        mcs.releaseResources();
        super.onPause();
    }*/

    @Override
    public void onBackPressed() {
        Intent a = new Intent(TambahBarang.this, DataBarang.class);
        startActivity(a);
        finish();
    }
}
