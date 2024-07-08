package com.example.project_application_clothing.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.project_application_clothing.Model.UserModel;

public class UserApi {
    DataHelper dataHelper;
    SQLiteDatabase db;
    public UserApi(Context context){
        dataHelper = new DataHelper(context);
        db = dataHelper.getReadableDatabase();
    }
    public boolean addUser(UserModel model){
        ContentValues values = new ContentValues();
        values.put("ten", model.getTen());
        values.put("taikhoan", model.getTaikhoan());
        values.put("matkhau", model.getMatkhau());
        values.put("trangthai", model.getTrangthai());

        long check = db.insert("User", null, values);
        return check > 0;
    }
    public boolean deleteUser(UserModel model){
        String[] data = new String[]{String.valueOf(model.getId())};
        long check = db.delete("User", "id=?", data);
        return check > 0;
    }
    public boolean updateUser(UserModel model){
        String[] data = new String[]{String.valueOf(model.getId())};
        ContentValues values = new ContentValues();
        values.put("ten", model.getTen());
        values.put("taikhoan", model.getTaikhoan());
        values.put("matkhau", model.getMatkhau());
        values.put("trangthai", model.getTrangthai());

        long check = db.update("User", values, "id=?", data);
        return check > 0;
    }
    public boolean checkuser(UserModel model, String screen){
        boolean check = true;
        if (screen == "login"){
            String[] data = new String[]{String.valueOf(model.getTaikhoan()), String.valueOf(model.getMatkhau())};
            Cursor cursor = db.rawQuery("SELECT * FROM User WHERE taikhoan=? AND matkhau=? AND trangthai=1", data);
            if (!cursor.moveToFirst()){
                check = false;
            }
        }else{
            String[] data = new String[]{String.valueOf(model.getTaikhoan())};
            Cursor cursor = db.rawQuery("SELECT * FROM User WHERE taikhoan=?", data);
            if (!cursor.moveToFirst()){
                check = false;
            }
        }
        return check;
    }


}
