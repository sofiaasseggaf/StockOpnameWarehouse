package com.example.stockopnamewarehouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.stockopnamewarehouse.helper.DataHelper;
import com.example.stockopnamewarehouse.model.ProfileModel;
import com.example.stockopnamewarehouse.utility.PreferenceUtils;

import java.util.List;

public class Login extends AppCompatActivity {

    DataHelper dbHelper;
    String username, password;
    int idrole;
    ImageButton btn_login;
    EditText et_username, et_password;
    List<ProfileModel> profileModelList;
    ProfileModel profileModelLogged;
    int bener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        dbHelper = new DataHelper(this);
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        btn_login = findViewById(R.id.btn_login);

        first();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    for (int i = 0; i < 3; i++) {
                        username = profileModelList.get(i).getUsername();
                        password = profileModelList.get(i).getPassword();
                        idrole = profileModelList.get(i).getId_role();
                        if (username.equalsIgnoreCase(et_username.getText().toString()) && password.equalsIgnoreCase(et_password.getText().toString())) {
                            bener = 1;
                            getDataProfileLogged1(idrole);
                            break;
                        }
                    }
                } catch (Exception e){ }
                if (bener!=1){
                    Toast.makeText(Login.this, "Akun Belum Terdaftar", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void first(){
        if (PreferenceUtils.getUsername(this) == null || PreferenceUtils.getUsername(this).equalsIgnoreCase("")){
            second();
        } else if(PreferenceUtils.getIdRole(this).equalsIgnoreCase("1")){
            Intent a = new Intent(Login.this, Home_Role1.class);
            startActivity(a);
            finish();
        } else if (PreferenceUtils.getIdRole(this).equalsIgnoreCase("2")){
            Intent a = new Intent(Login.this, Home_Role2.class);
            startActivity(a);
            finish();
        } else if (PreferenceUtils.getIdRole(this).equalsIgnoreCase("3")){
            Intent a = new Intent(Login.this, Home_Role3.class);
            startActivity(a);
            finish();
        }
    }

    private void second(){
        findViewById(R.id.framelayout).setVisibility(View.VISIBLE);
        new Thread(new Runnable() {
            @Override
            public void run() {
                getDataProfile();
            }
        }).start();
    }

    public void getDataProfile(){
        Log.d("Login", "get all profile");
        profileModelList = dbHelper.getAllProfile();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                findViewById(R.id.framelayout).setVisibility(View.GONE);
            }
        });
    }

    public void getDataProfileLogged1(int i){
        Log.d("Login", "get profile logged");
        profileModelLogged = dbHelper.getProfile(i);
        saveDataProfile();
    }

    public void saveDataProfile(){
        PreferenceUtils.saveIdUser(String.valueOf(profileModelLogged.getId_user()), getApplicationContext());
        PreferenceUtils.saveNama(profileModelLogged.getNama(), getApplicationContext());
        PreferenceUtils.saveUsername(profileModelLogged.getUsername(), getApplicationContext());
        PreferenceUtils.savePassword(profileModelLogged.getPassword(),getApplicationContext());
        PreferenceUtils.saveIdRole(String.valueOf(profileModelLogged.getId_role()), getApplicationContext());

        if (PreferenceUtils.getIdRole(getApplicationContext()).equalsIgnoreCase("1")){
            Intent a = new Intent(Login.this, Home_Role1.class);
            startActivity(a);
            finish();
        } else if(PreferenceUtils.getIdRole(getApplicationContext()).equalsIgnoreCase("2")){
            Intent a = new Intent(Login.this, Home_Role2.class);
            startActivity(a);
            finish();
        } else if(PreferenceUtils.getIdRole(getApplicationContext()).equalsIgnoreCase("3")) {
            Intent a = new Intent(Login.this, Home_Role3.class);
            startActivity(a);
            finish();
        }
    }

}