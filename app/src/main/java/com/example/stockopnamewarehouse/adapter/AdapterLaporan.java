package com.example.stockopnamewarehouse.adapter;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stockopnamewarehouse.R;
import com.example.stockopnamewarehouse.model.BarangGudangModel;
import com.example.stockopnamewarehouse.model.BarangModel;

import java.util.List;

public class AdapterLaporan extends  RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<BarangModel> listBarang;
    List<BarangGudangModel> listBarangGudang;

    public AdapterLaporan(List<BarangModel> listBarang, List<BarangGudangModel> listBarangGudang) {
        this.listBarang = listBarang;
        this.listBarangGudang = listBarangGudang;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.z_recycleview_laporan, parent, false);
        Penampung penampung = new Penampung(view);
        return penampung;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((Penampung)holder).txt_tgl.setText(listBarangGudang.get(position).getTanggal());
        ((Penampung)holder).txt_item_cd.setText(String.valueOf(listBarang.get(position).getItem_cd()));
        ((Penampung)holder).txt_item_desc.setText(listBarang.get(position).getItem_desc());
        ((Penampung)holder).txt_stock_qty_akhir.setText(String.valueOf(listBarang.get(position).getStock_qty()));
        ((Penampung)holder).txt_stock_qty_gudang.setText(String.valueOf(listBarangGudang.get(position).getStock_qty_gudang()));
        int i = listBarang.get(position).getStock_qty() - listBarangGudang.get(position).getStock_qty_gudang();
        if (i<0){
            ((Penampung)holder).txt_stock_qty_selisih.setTextColor(R.color.redfont);
            ((Penampung)holder).txt_stock_qty_selisih.setText(String.valueOf(i));
        } else {
            ((Penampung)holder).txt_stock_qty_selisih.setText(String.valueOf(i));
        }

        //((Penampung)holder).txt_ket.setText(listBarangGudang.get(position).getKeterangan());

    }

    @Override
    public int getItemCount() {
        return listBarang == null ? 0 : listBarang.size();
    }

    static class Penampung extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView txt_tgl, txt_item_cd, txt_item_desc, txt_stock_qty_akhir, txt_stock_qty_gudang, txt_stock_qty_selisih, txt_ket;
        public Penampung(View itemView) {
            super(itemView);
            txt_tgl = itemView.findViewById(R.id.txt_tgl);
            txt_item_cd = itemView.findViewById(R.id.txt_item_cd);
            txt_item_desc = itemView.findViewById(R.id.txt_item_desc);
            txt_stock_qty_akhir = itemView.findViewById(R.id.txt_stock_qty_akhir);
            txt_stock_qty_gudang = itemView.findViewById(R.id.txt_stock_qty_gudang);
            txt_stock_qty_selisih = itemView.findViewById(R.id.txt_stock_qty_selisih);
            //txt_ket = itemView.findViewById(R.id.txt_ket);
        }
        @Override
        public void onClick(View v) {
            Log.d("onclick", "onClick " + getLayoutPosition() + " " + txt_item_desc.getText());
        }
    }
}
