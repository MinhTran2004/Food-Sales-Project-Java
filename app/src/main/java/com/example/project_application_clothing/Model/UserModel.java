package com.example.project_application_clothing.Model;

public class UserModel {
    private int id;
    private String ten, taikhoan, matkhau, trangthai;

    public UserModel(int id, String ten, String taikhoan, String matkhau, String trangthai) {
        this.id = id;
        this.ten = ten;
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
        this.trangthai = trangthai;
    }

    public UserModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }
}
