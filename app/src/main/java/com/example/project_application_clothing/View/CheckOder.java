package com.example.project_application_clothing.View;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_application_clothing.Controller.CartController;
import com.example.project_application_clothing.Controller.OderController;
import com.example.project_application_clothing.Controller.ProductController;
import com.example.project_application_clothing.Fragment.Fragment_Home;
import com.example.project_application_clothing.Interface.InterfaceCheckOder;
import com.example.project_application_clothing.Model.CartModel;
import com.example.project_application_clothing.Model.OderModel;
import com.example.project_application_clothing.Model.ProductModel;
import com.example.project_application_clothing.R;
import com.example.project_application_clothing.RecyclerView.RcyView_CheckOder;

import java.util.ArrayList;
import java.util.List;

public class CheckOder extends AppCompatActivity implements InterfaceCheckOder {
    ImageView img_left_checkoder;
    TextView txt_tongtien_checkOder;
    Button btn_thanhtoan_checkOder;
    RecyclerView recyclerView_checkOder;
    CartController cartController;
    ProductController productController;
    OderController oderController;
    List<CartModel> listCart;
    List<ProductModel> listProduct;
    RcyView_CheckOder rcyView_checkOder;
    OderModel oderModel;
    String arrMagh = "";
    String tong = "0";
    FragmentManager fm;
    Fragment_Home fragment_home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_oder);

        img_left_checkoder = findViewById(R.id.img_left_checkoder);
        btn_thanhtoan_checkOder = findViewById(R.id.btn_thanhtoan_checkOder);
        txt_tongtien_checkOder = findViewById(R.id.txt_tongtien_checkOder);
        recyclerView_checkOder = findViewById(R.id.recyclerView_checkOder);

        SharedPreferences sharedPreferences = getSharedPreferences("User", Context.MODE_PRIVATE);
        String makh = sharedPreferences.getString("id", null);

        fragment_home = new Fragment_Home();
        fm = getSupportFragmentManager();
        img_left_checkoder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CheckOder.this, Cart.class));
            }
        });
        cartController = new CartController(CheckOder.this);
        productController = new ProductController(CheckOder.this);
        oderController = new OderController(CheckOder.this);

        listCart = cartController.getAllCart(makh);
        listProduct = new ArrayList<>();

        for (int i=0; i < listCart.size(); i++){
            String masp =  listCart.get(i).getMasp();
            arrMagh += listCart.get(i).getId() + ",";
            listProduct.add(productController.getAllProductById(masp));
        }

        rcyView_checkOder = new RcyView_CheckOder(CheckOder.this, listProduct, this);
        recyclerView_checkOder.setAdapter(rcyView_checkOder);
        recyclerView_checkOder.setLayoutManager(new LinearLayoutManager(CheckOder.this, LinearLayoutManager.VERTICAL, false));

        btn_thanhtoan_checkOder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oderModel = new OderModel();
                String magh =  arrMagh.substring(0, arrMagh.length() -1);
                oderModel.setMakh(makh);
                oderModel.setMagh(magh);
                oderModel.setTongtien(tong);
                oderModel.setTrangthai("Active");

                if (oderController.insertOder(oderModel)){
                    listCart = cartController.getAllCart(makh);
                    for (int i=0; i < listCart.size(); i++){
                        CartModel cartModel = listCart.get(i);
                        cartController.updateCart(cartModel);
                    }
                    startActivity(new Intent(CheckOder.this, Main.class));
                }
            }
        });
    }

    @Override
    public void getTongtien(String tongtien) {
        btn_thanhtoan_checkOder.setText("Mua hàng - $" + tongtien);
        txt_tongtien_checkOder.setText("$"+tongtien);
        tong = tongtien;
    }
}