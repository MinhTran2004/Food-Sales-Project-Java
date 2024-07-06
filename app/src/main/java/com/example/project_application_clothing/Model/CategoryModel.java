package com.example.project_application_clothing.Model;

public class CategoryModel {
    private int id, anh;
    private String  ten;

    public CategoryModel(int id, int anh, String ten) {
        this.id = id;
        this.anh = anh;
        this.ten = ten;
    }
    public CategoryModel(int id, String ten) {
        this.id = id;
        this.ten = ten;
    }
    public CategoryModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
