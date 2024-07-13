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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_application_clothing.Controller.CartController;
import com.example.project_application_clothing.Interface.InterfaceCart;
import com.example.project_application_clothing.Model.CartModel;
import com.example.project_application_clothing.R;
import com.example.project_application_clothing.RecyclerView.RcyView_Cart;

import java.util.List;

public class Cart extends AppCompatActivity implements InterfaceCart {
    RecyclerView recyclerView_cart;
    RcyView_Cart rcyView_cart;
    CartController cartController;
    List<CartModel> list;
    TextView txt_tongtien;
    Button btn_cart;
    ImageView btn_return_cart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        recyclerView_cart = findViewById(R.id.recyclerView_cart);
        txt_tongtien = findViewById(R.id.txt_tongtien);
        btn_cart = findViewById(R.id.btn_cart);
        btn_return_cart = findViewById(R.id.btn_return_cart);
        cartController = new CartController(this);

        SharedPreferences sharedPreferences = getSharedPreferences("User", Context.MODE_PRIVATE);
        String makh = sharedPreferences.getString("id", null);

        list = cartController.getAllCart(makh);

        rcyView_cart = new RcyView_Cart(this, list, this, makh);
        recyclerView_cart.setAdapter(rcyView_cart);
        recyclerView_cart.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        btn_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Cart.this, CheckOder.class));
            }
        });
        btn_return_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Cart.this, Main.class));
            }
        });
    }

    @Override
    public void getPriceCart(String price) {
        txt_tongtien.setText(price);
    }
}