package com.example.project_application_clothing.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.project_application_clothing.Controller.ProductController;
import com.example.project_application_clothing.Model.CartModel;
import com.example.project_application_clothing.Model.ProductModel;

import java.util.ArrayList;
import java.util.List;

public class CartApi {
    SQLiteDatabase db;
    DataHelper dataHelper;
    public CartApi(Context context){
        dataHelper = new DataHelper(context);
        db = dataHelper.getReadableDatabase();
    }
    public boolean insertCart(int id, String makh){
        ContentValues values = new ContentValues();
        values.put("masp", id);
        values.put("makh", makh);
        values.put("trangthai", "1");

        long check = db.insert("Cart", null, values);
        return check > 0;
    }
    public boolean deleteCart(CartModel cartModel){
        String[] data = new String[]{String.valueOf(cartModel.getId())};

        long check = db.delete("Cart", "id=?", data);
        return check > 0;
    }
    public boolean updateCart(CartModel cartModel){
        String[] data = new String[]{String.valueOf(cartModel.getId())};

        ContentValues values = new ContentValues();
        values.put("makh", cartModel.getMakh());
        values.put("masp", cartModel.getMasp());
        values.put("trangthai", "0");

        long check = db.update("Cart", values, "id=?", data);
        return check > 0;
    }
    public List<CartModel> getAllCart(int makh){
        List<CartModel> list = new ArrayList<>();
        String[] data = new String[]{String.valueOf(makh), "1"};
        Cursor cursor = db.rawQuery("SELECT * FROM Cart WHERE makh=? AND trangthai=?", data);

        if (cursor.moveToFirst()){
            do {
                CartModel cartModel = new CartModel();
                cartModel.setId(cursor.getInt(0));
                cartModel.setMakh(cursor.getString(1));
                cartModel.setMasp(cursor.getString(2));
                cartModel.setTrangthai(cursor.getString(3));
                list.add(cartModel);
            }while (cursor.moveToNext());
        }
        return list;
    }
}
