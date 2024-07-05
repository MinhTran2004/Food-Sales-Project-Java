package com.example.project_application_clothing.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataHelper extends SQLiteOpenHelper {
    private static final int version = 1;
    private static final String name = "Database.db";

    public DataHelper(Context context){
        super(context, name, null, version);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String createUser = "CREATE TABLE \"User\" (\n" +
                "\t\"id\"\tINTEGER NOT NULL,\n" +
                "\t\"ten\"\tTEXT,\n" +
                "\t\"taikhoan\"\tTEXT,\n" +
                "\t\"matkhau\"\tTEXT,\n" +
                "\tPRIMARY KEY(\"id\")\n" +
                ");";
        String createProduct = "CREATE TABLE \"Product\" (\n" +
                "\t\"id\"\tINTEGER NOT NULL,\n" +
                "\t\"tensp\"\tTEXT,\n" +
                "\t\"giasp\"\tTEXT,\n" +
                "\t\"anhsp\"\tTEXT,\n" +
                "\t\"theloai\"\tTEXT,\n" +
                "\t\"luotmua\"\tTEXT,\n" +
                "\t\"yeuthich\"\tTEXT,\n" +
                "\tPRIMARY KEY(\"id\")\n" +
                ");";

        db.execSQL(createUser);
        db.execSQL(createProduct);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public String getDatabasePath(Context context) {
        return context.getDatabasePath(name).getAbsolutePath();
    }
}
