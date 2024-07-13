package com.example.project_application_clothing.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

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
                "\t\"trangthai\"\tTEXT,\n" +
                "\tPRIMARY KEY(\"id\")\n" +
                ");";
        String createProduct = "CREATE TABLE \"Product\" (\n" +
                "\t\"id\"\tINTEGER NOT NULL,\n" +
                "\t\"tensp\"\tTEXT,\n" +
                "\t\"giasp\"\tTEXT,\n" +
                "\t\"anhsp\"\tTEXT,\n" +
                "\t\"theloai\"\tTEXT,\n" +
                "\t\"luotmua\"\tTEXT,\n" +
                "\t\"trangthai\"\tTEXT,\n" +
                "\tPRIMARY KEY(\"id\")\n" +
                ");";
        String createCart = "CREATE TABLE \"Cart\" (\n" +
                "\t\"id\"\tINTEGER NOT NULL,\n" +
                "\t\"makh\"\tTEXT,\n" +
                "\t\"masp\"\tTEXT,\n" +
                "\t\"soluong\"\tTEXT,\n" +
                "\t\"trangthai\"\tTEXT,\n" +
                "\tPRIMARY KEY(\"id\"),\n" +
                "\tFOREIGN KEY(\"masp\") REFERENCES \"Product\"(\"id\"),\n" +
                "\tFOREIGN KEY(\"makh\") REFERENCES \"User\"(\"id\")\n" +
                ");";

        String createOder = "CREATE TABLE \"Oder\" (\n" +
                "\t\"id\"\tINTEGER NOT NULL,\n" +
                "\t\"makh\"\tTEXT,\n" +
                "\t\"magh\"\tTEXT,\n" +
                "\t\"tongtien\"\tTEXT,\n" +
                "\t\"trangthai\"\tTEXT,\n" +
                "\tPRIMARY KEY(\"id\"),\n" +
                "\tFOREIGN KEY(\"magh\") REFERENCES \"Cart\"(\"id\"),\n" +
                "\tFOREIGN KEY(\"makh\") REFERENCES \"User\"(\"id\")\n" +
                ");";

        String insertUser = "INSERT INTO User (id, ten, taikhoan, matkhau, trangthai) VALUES " +
                "(1, 'Admin', 'admin', '123', '1')," +
                "(2, 'Minh', 'minh@gmail.com', '123', '1')";

        String insertProduct = "INSERT INTO Product (id, tensp, giasp, anhsp, theloai, luotmua, trangthai) VALUES " +
                "(1, 'Hamburger 1', 23000, 'https://www.tastingtable.com/img/gallery/the-unexpected-number-of-cows-a-single-burgers-meat-could-come-from/l-intro-1652635534.jpg', 'Hamburger', '0', '1')," +
                "(2, 'Hamburger 2', 17000, 'https://images.rawpixel.com/image_800/cHJpdmF0ZS9sci9pbWFnZXMvd2Vic2l0ZS8yMDIzLTA4L3Jhd3BpeGVsb2ZmaWNlMV9idXJnZXJfb25fYV93b29kZW5fYm9hcmRfcmVhbF9waG90b19pc29sYXRlZF9vbl85MTExNjAwMC00MzkyLTQxNTctOWVkOC0yMTFiMWRkYmYwMjZfMS5qcGc.jpg', 'Hamburger', '0', '1')," +
                "(3, 'Hamburger 3', 20000, 'https://images.rawpixel.com/image_800/cHJpdmF0ZS9sci9pbWFnZXMvd2Vic2l0ZS8yMDI0LTAxL3Jhd3BpeGVsX29mZmljZV80MV9waG90b19jbG9zZV91cF9vZl9kZWxpY2lvdXNfYnVyZ2VyX2luX3RoZV9zdF9jNGU1Y2RjNy0wMTg4LTQzYmQtYjMxNC1lZjE4NTc5ZTVmYjRfMS5qcGc.jpg', 'Hamburger', '0', '1')," +
                "(4, 'Hamburger 4', 13000, 'https://images.rawpixel.com/image_700/cHJpdmF0ZS9sci9pbWFnZXMvd2Vic2l0ZS8yMDIzLTA4L3Jhd3BpeGVsX29mZmljZV8yNV8zZF9jaGVlc2VfYnVyZ2VyXzdlZjcyYjcyLTk2MGItNDIwMC04NzViLTZmODIxMThjOTdmYV8xLmpwZw.jpg', 'Hamburger', '0', '1')," +
                "(5, 'Hamburger 5', 30000, 'https://content.jdmagicbox.com/comp/chennai/u6/044pxx44.xx44.190802191247.w4u6/catalogue/omr-burgers-sholinganallur-chennai-fast-food-delivery-services-xsghgjqmtc.jpg', 'Hamburger', '0', '1')," +
                "(6, 'Pizza 1', 23000, 'https://img.freepik.com/free-photo/top-view-pepperoni-pizza-with-mushroom-sausages-bell-pepper-olive-corn-black-wooden_141793-2158.jpg', 'Pizza', '0', '1')," +
                "(7, 'Pizza 2', 17000, 'https://e1.pxfuel.com/desktop-wallpaper/646/123/desktop-wallpaper-olive-pizza-fast-food-food-lahmacun.jpg', 'Pizza', '0', '1')," +
                "(8, 'Pizza 3', 20000, 'https://assets.tmecosys.com/image/upload/t_web767x639/img/recipe/ras/Assets/2caca97b-77f6-48e7-837d-62642c0c9861/Derivates/12591894-e010-4a02-b04e-2627d8374298.jpg', 'Pizza', '0', '1')," +
                "(9, 'Pizza 4', 13000, 'https://vnvinaphone.vn/wp-content/uploads/2021/11/Veggie-mania.jpg', 'Pizza', '0', '1')," +
                "(10, 'Pizza 5', 30000, 'https://pastaparadise.com.vn/wp-content/uploads/2021/09/Banh-Pizza.jpg', 'Pizza', '0', '1')," +
                "(11, 'Noodles 1', 23000, 'https://img.freepik.com/free-photo/authentic-italian-pasta_24972-2334.jpg', 'Noodles', '0', '1')," +
                "(12, 'Noodles 2', 17000, 'https://t3.ftcdn.net/jpg/04/28/66/58/360_F_428665823_eVnQawJvCREXknWgvaEV8KXEQqk4Wlr1.jpg', 'Noodles', '0', '1')," +
                "(13, 'Noodles 3', 20000, 'https://www.crushpixel.com/big-static7/preview4/bowl-instant-noodle-121785.jpg', 'Noodles', '0', '1')," +
                "(14, 'Noodles 4', 13000, 'https://c.ndtvimg.com/2023-08/g2fc7edg_noodles_625x300_11_August_23.jpg', 'Noodles', '0', '1')," +
                "(15, 'Noodles 5', 30000, 'https://w0.peakpx.com/wallpaper/593/833/HD-wallpaper-noodles-vegy-food-foods-foody-lover.jpg', 'Noodles', '0', '1')," +
                "(16, 'Cake 1', 23000, 'https://thanhcongflower.com/wp-content/uploads/2024/03/z5209253601488_3973439bf9677188840823415623f3d7-300x300.jpg', 'Cake', '0', '1')," +
                "(17, 'Cake 2', 17000, 'https://tienthanh.edu.vn/banh-sinh-nhat-nho-don-gian/imager_22_22087_700.jpg', 'Cake', '0', '1')," +
                "(18, 'Cake 3', 20000, 'https://static.hotdeal.vn/images/1588/1587653/60x60/355684-banh-kem-bap-pho-mai-dac-biet-20x8cm-tai-gia-bao-bakery.jpg', 'Cake', '0', '1')," +
                "(19, 'Cake 4', 13000, 'https://daylambanh.edu.vn/wp-content/uploads/2019/08/banh-kem-bap-thom-ngot-600x400.jpg', 'Cake', '0', '1')," +
                "(20, 'Cake 5', 30000, 'https://bizweb.dktcdn.net/100/004/714/articles/banh-kem-bap-1.png?v=1638935434667', 'Cake', '0', '1')";

        db.execSQL(createUser);
        db.execSQL(createProduct);
        db.execSQL(createOder);
        db.execSQL(createCart);
        db.execSQL(insertUser);
        db.execSQL(insertProduct);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
//    public String getDatabasePath(Context context) {
//        return context.getDatabasePath(name).getAbsolutePath();
//    }
}
