package com.example.stockopnamewarehouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.stockopnamewarehouse.master_inventori.DataBarang;
import com.example.stockopnamewarehouse.utility.PreferenceUtils;

public class About extends AppCompatActivity {

    ImageButton btn_back;
    int role;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        btn_back = findViewById(R.id.btn_back);
        role = Integer.valueOf(PreferenceUtils.getIdRole(getApplicationContext()));

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (role==1){
            Intent a = new Intent(About.this, Home_Role1.class);
            startActivity(a);
            finish();
        } else if (role==2){
            Intent a = new Intent(About.this, Home_Role2.class);
            startActivity(a);
            finish();
        } else if (role==3){
            Intent a = new Intent(About.this, Home_Role3.class);
            startActivity(a);
            finish();
        }    }
}