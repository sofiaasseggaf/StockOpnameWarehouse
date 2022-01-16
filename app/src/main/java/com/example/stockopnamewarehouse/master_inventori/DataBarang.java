package com.example.stockopnamewarehouse.master_inventori;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.stockopnamewarehouse.Home_Role1;
import com.example.stockopnamewarehouse.Home_Role2;
import com.example.stockopnamewarehouse.Home_Role3;
import com.example.stockopnamewarehouse.Profile;
import com.example.stockopnamewarehouse.R;
import com.example.stockopnamewarehouse.adapter.AdapterDataBarang;
import com.example.stockopnamewarehouse.helper.DataHelper;
import com.example.stockopnamewarehouse.model.BarangModel;
import com.example.stockopnamewarehouse.model.ProfileModel;
import com.example.stockopnamewarehouse.utility.PreferenceUtils;
import com.example.stockopnamewarehouse.utility.RecyclerItemClickListener;

import java.util.List;

public class DataBarang extends AppCompatActivity {

    //String[] daftarNamaBarang;
    //protected Cursor cursor;
    RecyclerView rvDataBarang;
    DataHelper dbCenter;
    ImageButton btn_tambah;
    public static DataBarang dataMaster;
    List<BarangModel> barangModelList;
    AdapterDataBarang itemList;
    int role;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.master_databarang);

        rvDataBarang = findViewById(R.id.rvDataBarang);
        btn_tambah = findViewById(R.id.btn_tambah);
        role = Integer.valueOf(PreferenceUtils.getIdRole(getApplicationContext()));

        dataMaster = this;
        dbCenter = new DataHelper(this);
        getDataBarang();

        btn_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(DataBarang.this, TambahBarang.class);
                startActivity(a);
                finish();
            }
        });

    }

    /*public void RefreshList(){


        SQLiteDatabase db = dbCenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM barang", null);
        daftarNamaBarang = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int cc=0; cc < cursor.getCount(); cc++){
            cursor.moveToPosition(cc);
            daftarNamaBarang[cc] = cursor.getString(1).toString();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(DataBarang.this, R.layout.z_rv_barang, daftarNamaBarang);
        listView.setAdapter(adapter);
        listView.setSelected(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final String selection = daftarNamaBarang[i];
                final CharSequence[] dialogitem = {"Lihat Barang", "Update Barang", "Hapus Barang"};
                AlertDialog.Builder builder = new AlertDialog.Builder(DataBarang.this);
                builder.setTitle("Pilihan");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int item) {
                        switch (item){
                            case 0 :
                                Intent ab = new Intent(getApplicationContext(), EditBarang.class);
                                ab.putExtra("nama", selection);
                                startActivity(ab);
                                break;
                            case 1 :
                                SQLiteDatabase db = dbCenter.getWritableDatabase();
                                db.execSQL("delete from barang where nama_barang = '"+selection+"'");
                                RefreshList();
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });
        ((ArrayAdapter)listView.getAdapter()).notifyDataSetChanged();


    }*/

    public void getDataBarang(){
        Log.d("DataBarang", "get all barang");
        barangModelList = dbCenter.getAllBarang();
        itemList = new AdapterDataBarang(barangModelList);
        rvDataBarang.setLayoutManager(new LinearLayoutManager(DataBarang.this));
        rvDataBarang.setAdapter(itemList);
        rvDataBarang.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), rvDataBarang,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent a = new Intent(DataBarang.this, EditBarang.class);
                        a.putExtra("idbarang", barangModelList.get(position).getItem_cd());
                        startActivity(a);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }
                }));
    }

    @Override
    public void onBackPressed() {
        if (role==1){
            Intent a = new Intent(DataBarang.this, Home_Role1.class);
            startActivity(a);
            finish();
        } else if (role==2){
            Intent a = new Intent(DataBarang.this, Home_Role2.class);
            startActivity(a);
            finish();
        } else if (role==3){
            Intent a = new Intent(DataBarang.this, Home_Role3.class);
            startActivity(a);
            finish();
        }
    }
}