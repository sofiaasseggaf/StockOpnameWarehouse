package com.example.stockopnamewarehouse;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stockopnamewarehouse.helper.DataHelper;
import com.example.stockopnamewarehouse.utility.PreferenceUtils;

public class Profile extends AppCompatActivity {

    EditText et_nama, et_username, et_password, et_jabatan;
    ImageButton btn_logout, btn_simpan;
    DataHelper dbHelper;
    TextView seepw;
    int role;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        et_nama = findViewById(R.id.et_nama);
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        et_jabatan = findViewById(R.id.et_jabatan);
        btn_logout = findViewById(R.id.btn_logout);
        btn_simpan = findViewById(R.id.btn_simpan);
        seepw = findViewById(R.id.seepw);
        role = Integer.valueOf(PreferenceUtils.getIdRole(getApplicationContext()));

      setDataProfile();

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupLogout();
            }
        });
        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupSimpan();
            }
        });
        seepw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (seepw.getText().toString().equalsIgnoreCase("show password")){
                    et_password.setTransformationMethod(null);
                    seepw.setText("hide password");
                } else if(seepw.getText().toString().equalsIgnoreCase("hide password")){
                    et_password.setTransformationMethod(new PasswordTransformationMethod());
                    seepw.setText("show password");
                }
            }
        });

    }

    public void setDataProfile(){
        et_nama.setText(PreferenceUtils.getNama(getApplicationContext()));
        et_username.setText(PreferenceUtils.getUsername(getApplicationContext()));
        et_password.setText(PreferenceUtils.getPassword(getApplicationContext()));
        et_password.setTransformationMethod(new PasswordTransformationMethod());
        String a = PreferenceUtils.getIdRole(getApplicationContext());
        if (a.equalsIgnoreCase("1")) {
            et_jabatan.setText("Petugas Inventori");
        } else if (a.equalsIgnoreCase("2")){
            et_jabatan.setText("Peserta Stock Opname");
        } else if(a.equalsIgnoreCase("3")){
            et_jabatan.setText("Petugas Audit");
        }
    }

    public void saveDataProfileBaru(){
        PreferenceUtils.saveNama(et_nama.getText().toString(), getApplicationContext());
        PreferenceUtils.savePassword(et_password.getText().toString(),getApplicationContext());
        setDataProfile();
    }

    public void showPopupLogout(){
        AlertDialog.Builder alert = new AlertDialog.Builder(Profile.this);
        alert.setMessage("Are you sure?")
                .setPositiveButton("Logout", new DialogInterface.OnClickListener()                 {

                    public void onClick(DialogInterface dialog, int which) {

                        deleteDataProfile(); // Last step. Logout function

                    }
                }).setNegativeButton("Cancel", null);

        AlertDialog alert1 = alert.create();
        alert1.show();
    }

    public void showPopupSimpan(){
        AlertDialog.Builder alert = new AlertDialog.Builder(Profile.this);
        alert.setMessage("Are you sure?")
                .setPositiveButton("Simpan", new DialogInterface.OnClickListener()                 {

                    public void onClick(DialogInterface dialog, int which) {

                        simpanDataProfile(); // Last step. Logout function

                    }
                }).setNegativeButton("Cancel", null);

        AlertDialog alert1 = alert.create();
        alert1.show();
    }

    public void deleteDataProfile(){
        PreferenceUtils.saveIdUser(null, getApplicationContext());
        PreferenceUtils.saveNama(null, getApplicationContext());
        PreferenceUtils.saveUsername(null, getApplicationContext());
        PreferenceUtils.savePassword(null, getApplicationContext());
        PreferenceUtils.saveIdRole(null, getApplicationContext());

        Intent a = new Intent(Profile.this, SplashScreen.class);
        startActivity(a);
        finish();
    }

    public void simpanDataProfile(){
        dbHelper = new DataHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        //id_user, nama, username, password, id_role
        db.execSQL("update user set nama='"+et_nama.getText().toString()+"', password='"+et_password.getText().toString()+"' " +
                "where id_user='"+ PreferenceUtils.getIdUser(getApplicationContext()) +"'");
        Toast.makeText(getApplicationContext(), "Berhasil Simpan Data Profile", Toast.LENGTH_SHORT).show();
        saveDataProfileBaru();
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        if (role==1){
            Intent a = new Intent(Profile.this, Home_Role1.class);
            startActivity(a);
            finish();
        } else if (role==2){
            Intent a = new Intent(Profile.this, Home_Role2.class);
            startActivity(a);
            finish();
        } else if (role==3){
            Intent a = new Intent(Profile.this, Home_Role3.class);
            startActivity(a);
            finish();
        }
    }
}