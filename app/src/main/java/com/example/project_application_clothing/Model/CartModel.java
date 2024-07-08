package com.example.project_application_clothing.Model;

public class CartModel {
    private int id;
    private String makh, masp, trangthai;

    public CartModel(int id, String makh, String masp, String trangthai) {
        this.id = id;
        this.makh = makh;
        this.masp = masp;
        this.trangthai = trangthai;
    }

    public CartModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }
}
