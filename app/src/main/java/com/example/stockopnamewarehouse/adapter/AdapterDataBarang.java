package com.example.stockopnamewarehouse.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stockopnamewarehouse.R;
import com.example.stockopnamewarehouse.model.BarangModel;

import java.util.List;

public class AdapterDataBarang extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    List<BarangModel> dataItemList;

    public AdapterDataBarang(List<BarangModel> dataItemList) {
        this.dataItemList = dataItemList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.z_rv_barang, parent, false);
        Penampung penampung = new Penampung(view);
        return penampung;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((Penampung)holder).namaBarang.setText(dataItemList.get(position).getItem_desc());
    }

    @Override
    public int getItemCount() {
        return dataItemList == null ? 0 : dataItemList.size();
    }

    static class Penampung extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView namaBarang;
        public Penampung(View itemView) {
            super(itemView);
            namaBarang = itemView.findViewById(R.id.txt_namabarang);
        }
        @Override
        public void onClick(View v) {
            Log.d("onclick", "onClick " + getLayoutPosition() + " " + namaBarang.getText());
        }
    }
}
