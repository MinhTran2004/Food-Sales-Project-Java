package com.example.project_application_clothing.Model;

public class OderModel {
    private int id;
    private String makh, magh, tongtien, trangthai;

    public OderModel(int id, String makh, String magh, String tongtien, String trangthai) {
        this.id = id;
        this.makh = makh;
        this.magh = magh;
        this.tongtien = tongtien;
        this.trangthai = trangthai;
    }

    public OderModel() {
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

    public String getMagh() {
        return magh;
    }

    public void setMagh(String magh) {
        this.magh = magh;
    }

    public String getTongtien() {
        return tongtien;
    }
    public void setTongtien(String tongtien) {
        this.tongtien = tongtien;
    }
    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }
}
