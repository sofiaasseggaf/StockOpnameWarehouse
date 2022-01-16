package com.example.stockopnamewarehouse.model;

public class BarangModel {

//    item_cd, item_desc, std_packing, stock_qty, item_barcode

    int item_cd, stock_qty;
    String item_desc, std_packing, item_barcode;




    public BarangModel(int item_cd, String item_desc, String std_packing, int stock_qty, String item_barcode) {
        this.item_cd = item_cd;
        this.stock_qty = stock_qty;
        this.item_barcode = item_barcode;
        this.item_desc = item_desc;
        this.std_packing = std_packing;
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

    public String getItem_barcode() {
        return item_barcode;
    }

    public void setItem_barcode(String item_barcode) {
        this.item_barcode = item_barcode;
    }

    public String getItem_desc() {
        return item_desc;
    }

    public void setItem_desc(String item_desc) {
        this.item_desc = item_desc;
    }

    public String getStd_packing() {
        return std_packing;
    }

    public void setStd_packing(String std_packing) {
        this.std_packing = std_packing;
    }
}
