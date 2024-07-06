package com.example.project_application_clothing.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.project_application_clothing.Model.ProductModel;

import java.util.ArrayList;
import java.util.List;

public class ProductApi {
    DataHelper dataHelper;
    SQLiteDatabase db;
    public ProductApi(Context context){
        dataHelper = new DataHelper(context);
        db = dataHelper.getReadableDatabase();
    }
    public boolean insertProduct(ProductModel model){
        ContentValues values = new ContentValues();
        values.put("tensp", model.getTensp());
        values.put("giasp", model.getGiasp());
        values.put("anhsp", model.getAnhsp());
        values.put("theloai", model.getTheloai());
        values.put("luotmua", model.getLuotmua());
        values.put("yeuthich", model.getYeuthich());

        long check = db.insert("Product", null, values);
        return check > 0;
    }
    public boolean deleteProduct(ProductModel model){
        String[] data = new String[]{String.valueOf(model.getId())};
        long check = db.delete("Product", "id=?", data);
        return check > 0;
    }
    public boolean updateProduct(ProductModel model){
        String[] data = new String[]{String.valueOf(model.getId())};
        ContentValues values = new ContentValues();
        values.put("tensp", model.getTensp());
        values.put("giasp", model.getGiasp());
        values.put("anhsp", model.getAnhsp());
        values.put("theloai", model.getTheloai());
        values.put("luotmua", model.getLuotmua());
        values.put("yeuthich", model.getYeuthich());

        long check = db.update("Product", values, "id=?", data);
        return check > 0;
    }
    public List<ProductModel> getAllProduct (){
        List<ProductModel> list = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT * FROM Product", null);
        if (c.moveToFirst()){
            do{
                ProductModel productModel = new ProductModel();
                productModel.setId(c.getInt(0));
                productModel.setTensp(c.getString(1));
                productModel.setGiasp(c.getString(2));
                productModel.setAnhsp(c.getString(3));
                productModel.setTheloai(c.getString(4));
                productModel.setLuotmua(c.getString(5));
                productModel.setYeuthich(c.getString(6));
                list.add(productModel);
            }while (c.moveToNext());
        }
        return list;
    }


}
