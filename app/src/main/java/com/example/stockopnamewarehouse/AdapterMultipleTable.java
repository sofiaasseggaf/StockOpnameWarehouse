 package com.example.stockopnamewarehouse;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class AdapterMultipleTable {
}

/*
public class AdapterMultipleTable extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<TrPortofolio> dataListTrPortfolio;
    private List<MsGuru> dataListMsGuru;
    private List<MsMatapelajaran> dataListMapel;
    private List<MsStrategi> dataListStrategi;

    public AdapterMultipleTable(List<TrPortofolio> dataListTrPortfolio, List<MsGuru> dataListMsGuru, List<MsMatapelajaran> dataListMapel, List<MsStrategi> dataListStrategi) {
        this.dataListTrPortfolio = dataListTrPortfolio;
        this.dataListMsGuru = dataListMsGuru;
        this.dataListMapel = dataListMapel;
        this.dataListStrategi = dataListStrategi;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.v_student_output_portfolio_d, parent, false);
        Penampung penampung = new Penampung(view);
        return penampung;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        //strategi
        for (int i=0; i<dataListStrategi.size(); i++){
            try {
                if (dataListTrPortfolio.get(position).getStrategiid().equalsIgnoreCase(dataListStrategi.get(i).getIdStrategi())){
                    ((Penampung)holder).txtOutputStrategi.setText(dataListStrategi.get(i).getNameStrategi());
                    break;
                }
                else {
                    ((Penampung)holder).txtOutputStrategi.setText("ID Strategi : "+dataListTrPortfolio.get(position).getStrategiid());
                }
            } catch (Exception a){
            }
        }

        //mapel
        for (int i=0; i<dataListMapel.size(); i++){
            try {
                if (dataListTrPortfolio.get(position).getMapelid().equalsIgnoreCase(dataListMapel.get(i).getId())){
                    ((Penampung)holder).txtOutputMapel.setText("Mata Pelajaran : "+dataListMapel.get(i).getName());
                    break;
                }
                else {
                    ((Penampung)holder).txtOutputMapel.setText("ID Mata Pelajaran : "+dataListTrPortfolio.get(position).getMapelid());
                }
            } catch (Exception a){
            }
        }

        //judulkd
        ((Penampung)holder).txtOutputJudulKD.setText(dataListTrPortfolio.get(position).getJudulKd());

        //nilai
        ((Penampung)holder).txtOutputNilai.setText(dataListTrPortfolio.get(position).getNilai());

        //predikat
        ((Penampung)holder).txtOutputPredikat.setText(dataListTrPortfolio.get(position).getPredikatMutu());

        //tanggal
        ((Penampung)holder).txtOutputTanggal.setText(dataListTrPortfolio.get(position).getTanggal());

        //tempat
        ((Penampung)holder).txtOutputTanggal.setText(dataListTrPortfolio.get(position).getTempat());

        //strategii
        for (int i=0; i<dataListStrategi.size(); i++){
            try {
                if (dataListTrPortfolio.get(position).getStrategiid().equalsIgnoreCase(dataListStrategi.get(i).getIdStrategi())){
                    ((Penampung)holder).txtOutputStrategi.setText(dataListStrategi.get(i).getNameStrategi());
                    break;
                }
                else {
                    ((Penampung)holder).txtOutputStrategi.setText("ID Strategi : "+dataListTrPortfolio.get(position).getStrategiid());
                }
            } catch (Exception a){
            }
        }

        //narasi
        ((Penampung)holder).txtOutputNarasi.setText(dataListTrPortfolio.get(position).getNarasi());

        //guru
        for (int i=0; i<dataListMsGuru.size(); i++){
            try {
                if (dataListTrPortfolio.get(position).getGuruid().equalsIgnoreCase(dataListMsGuru.get(i).getUserid())){
                    ((Penampung)holder).txtOutputGuru.setText(dataListMsGuru.get(i).getFirstname()+" "+dataListMsGuru.get(i).getMidname()+" "+dataListMsGuru.get(i).getLastname());
                    break;
                }
                else {
                    ((Penampung)holder).txtOutputGuru.setText("ID Guru : "+dataListTrPortfolio.get(position).getGuruid());
                }
            } catch (Exception a){
            }
        }


    }

    @Override
    public int getItemCount() {
        return dataListTrPortfolio == null ? 0 : dataListTrPortfolio.size();
    }

    static class Penampung extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView txtOutputStrategi, txtOutputMapel, txtOutputJudulKD, txtOutputNilai, txtOutputPredikat;
        public TextView txtOutputTanggal, txtOutputTempat, txtOutputStrategii, txtOutputNarasi, txtOutputGuru;
        public Penampung(View itemView) {
            super(itemView);
            txtOutputStrategi = itemView.findViewById(R.id.txtOutputStrategi);
            txtOutputMapel = itemView.findViewById(R.id.txtOutputMapel);
            txtOutputJudulKD = itemView.findViewById(R.id.txtOutputJudulKD);
            txtOutputNilai = itemView.findViewById(R.id.txtOutputNilai);
            txtOutputPredikat = itemView.findViewById(R.id.txtOutputPredikat);
            txtOutputTanggal = itemView.findViewById(R.id.txtOutputTanggal);
            txtOutputTempat = itemView.findViewById(R.id.txtOutputTempat);
            txtOutputStrategii = itemView.findViewById(R.id.txtOutputStrategii);
            txtOutputNarasi = itemView.findViewById(R.id.txtOutputNarasi);
            txtOutputGuru = itemView.findViewById(R.id.txtOutputGuru);
        }
        @Override
        public void onClick(View v) {
            Log.d("onclick", "onClick " + getLayoutPosition() + " " + txtOutputStrategi.getText());
        }
    }
}
*/
