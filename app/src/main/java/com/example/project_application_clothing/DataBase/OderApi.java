package com.example.project_application_clothing.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.project_application_clothing.Model.OderModel;

import java.util.ArrayList;
import java.util.List;

public class OderApi {
    SQLiteDatabase db;
    DataHelper dataHelper;
    public OderApi(Context context){
        dataHelper = new DataHelper(context);
        db = dataHelper.getReadableDatabase();
    }
    public boolean insertOder(OderModel model){
        ContentValues values = new ContentValues();
        values.put("makh", model.getMakh());
        values.put("magh", model.getMagh());
        values.put("trangthai", model.getTrangthai());

        long check = db.insert("Oder", null, values);
        return check > 0;
    }
    public boolean deleteOder(OderModel model){
        String[] data = new String[]{String.valueOf(model.getId())};
        long check = db.delete("Oder", "id=?", data);
        return check > 0;
    }
    public boolean updateOder(OderModel model){
        String[] data = new String[]{String.valueOf(model.getId())};
        ContentValues values = new ContentValues();
        values.put("makh", model.getMakh());
        values.put("magh", model.getMagh());
        values.put("trangthai", model.getTrangthai());

        long check = db.update("Oder", values, "id=?", data);
        return check > 0;
    }
    public List<OderModel> getAllOderActive (){
        List<OderModel> list = new ArrayList<>();
        String[] data = new String[]{"Active"};
        Cursor c = db.rawQuery("SELECT * FROM Oder WHERE trangthai = ?", data);

        if (c.moveToFirst()){
            do {
                OderModel oderModel = new OderModel();
                oderModel.setId(c.getInt(0));
                oderModel.setMakh(c.getString(1));
                oderModel.setMagh(c.getString(2));
                oderModel.setTrangthai(c.getString(3));
                list.add(oderModel);
            }while (c.moveToNext());
        }
        return list;
    }
    public List<OderModel> getAllOderCompleted (){
        List<OderModel> list = new ArrayList<>();
        String[] data = new String[]{"Completed"};
        Cursor c = db.rawQuery("SELECT * FROM Oder WHERE trangthai = ?", data);

        if (c.moveToFirst()){
            do {
                OderModel oderModel = new OderModel();
                oderModel.setId(c.getInt(0));
                oderModel.setMakh(c.getString(1));
                oderModel.setMagh(c.getString(2));
                oderModel.setTrangthai(c.getString(3));
                list.add(oderModel);
            }while (c.moveToNext());
        }
        return list;
    }
    public List<OderModel> getAllOderCancel (){
        List<OderModel> list = new ArrayList<>();
        String[] data = new String[]{"Cancel"};
        Cursor c = db.rawQuery("SELECT * FROM Oder WHERE trangthai = ?", data);

        if (c.moveToFirst()){
            do {
                OderModel oderModel = new OderModel();
                oderModel.setId(c.getInt(0));
                oderModel.setMakh(c.getString(1));
                oderModel.setMagh(c.getString(2));
                oderModel.setTrangthai(c.getString(3));
                list.add(oderModel);
            }while (c.moveToNext());
        }
        return list;
    }
}
