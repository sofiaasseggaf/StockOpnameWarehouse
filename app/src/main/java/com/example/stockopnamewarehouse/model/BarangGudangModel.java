package com.example.stockopnamewarehouse.model;


public class BarangGudangModel {

    int item_cd, stock_qty, stock_qty_gudang;
    String item_desc, tanggal, item_barcode;



    public BarangGudangModel(int item_cd, String item_desc, int stock_qty, int stock_qty_gudang, String item_barcode, String tanggal) {
        this.item_cd = item_cd;
        this.stock_qty = stock_qty;
        this.stock_qty_gudang = stock_qty_gudang;
        this.item_desc = item_desc;
        this.tanggal = tanggal;
        this.item_barcode = item_barcode;
    }

    public int getItem_cd() {
        return item_cd;
    }

    public void setItem_cd(int item_cd) {
        this.item_cd = item_cd;
    }

    public int getStock_qty() {
        return stock_qty;
    }

    public void setStock_qty(int stock_qty) {
        this.stock_qty = stock_qty;
    }

    public int getStock_qty_gudang() {
        return stock_qty_gudang;
    }

    public void setStock_qty_gudang(int stock_qty_gudang) {
        this.stock_qty_gudang = stock_qty_gudang;
    }

    public String getItem_desc() {
        return item_desc;
    }

    public void setItem_desc(String item_desc) {
        this.item_desc = item_desc;
    }


    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String  getItem_barcode() {
        return item_barcode;
    }

    public void setItem_barcode(String item_barcode) {
        this.item_barcode = item_barcode;
    }
}
