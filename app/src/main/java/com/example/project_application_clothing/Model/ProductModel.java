package com.example.project_application_clothing.Model;

public class ProductModel {
    private int id;
    private String tensp, giasp, anhsp, theloai, luotmua, yeuthich;

    public ProductModel(int id, String tensp, String giasp, String anhsp, String theloai, String luotmua, String yeuthich) {
        this.id = id;
        this.tensp = tensp;
        this.giasp = giasp;
        this.anhsp = anhsp;
        this.theloai = theloai;
        this.luotmua = luotmua;
        this.yeuthich = yeuthich;
    }

    public ProductModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getGiasp() {
        return giasp;
    }

    public void setGiasp(String giasp) {
        this.giasp = giasp;
    }

    public String getAnhsp() {
        return anhsp;
    }

    public void setAnhsp(String anhsp) {
        this.anhsp = anhsp;
    }

    public String getTheloai() {
        return theloai;
    }

    public void setTheloai(String theloai) {
        this.theloai = theloai;
    }

    public String getLuotmua() {
        return luotmua;
    }

    public void setLuotmua(String luotmua) {
        this.luotmua = luotmua;
    }

    public String getYeuthich() {
        return yeuthich;
    }

    public void setYeuthich(String yeuthich) {
        this.yeuthich = yeuthich;
    }
}
