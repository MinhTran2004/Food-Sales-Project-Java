package com.example.project_application_clothing.View;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_application_clothing.Controller.CartController;
import com.example.project_application_clothing.Controller.ProductController;
import com.example.project_application_clothing.Interface.InterfaceCheckOder;
import com.example.project_application_clothing.Model.CartModel;
import com.example.project_application_clothing.Model.ProductModel;
import com.example.project_application_clothing.R;
import com.example.project_application_clothing.RecyclerView.RcyView_CheckOder;

import java.util.ArrayList;
import java.util.List;

public class CheckOder extends AppCompatActivity implements InterfaceCheckOder {
    TextView txt_tongtien_checkOder;
    Button btn_tongtien_checkOder;
    RecyclerView recyclerView_checkOder;
    CartController cartController;
    ProductController productController;
    List<CartModel> listCart;
    List<ProductModel> listProduct;
    RcyView_CheckOder rcyView_checkOder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_oder);

        btn_tongtien_checkOder = findViewById(R.id.btn_tongtien_checkOder);
        txt_tongtien_checkOder = findViewById(R.id.txt_tongtien_checkOder);
        recyclerView_checkOder = findViewById(R.id.recyclerView_checkOder);

        cartController = new CartController(CheckOder.this);
        productController = new ProductController(CheckOder.this);

        listCart = cartController.getAllCart(1);
        listProduct = new ArrayList<>();
        for (int i=0; i < listCart.size(); i++){
            String masp =  listCart.get(i).getMasp();
            listProduct.add(productController.getAllProductById(Integer.valueOf(masp)));
        }

        Log.d("TAG", "onCreate: " + listProduct.size());

        rcyView_checkOder = new RcyView_CheckOder(CheckOder.this, listProduct, this);
        recyclerView_checkOder.setAdapter(rcyView_checkOder);
        recyclerView_checkOder.setLayoutManager(new LinearLayoutManager(CheckOder.this, LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void getTongtien(String tongtien) {
        btn_tongtien_checkOder.setText("Mua hàng - $" + tongtien);
        txt_tongtien_checkOder.setText("$"+tongtien);
    }
}