package com.example.project_application_clothing.View;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project_application_clothing.Controller.CartController;
import com.example.project_application_clothing.Model.CartModel;
import com.example.project_application_clothing.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;

public class Product extends AppCompatActivity {
    ImageView img_product;
    TextView txt_ten_product, txt_theloai_product, txt_gia_product;
    Button btn_product;
    CartController cartController;

    CartModel cartModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        img_product = findViewById(R.id.img_product);
        txt_ten_product = findViewById(R.id.txt_ten_product);
        txt_theloai_product = findViewById(R.id.txt_theloai_product);
        txt_gia_product = findViewById(R.id.txt_gia_product);
        btn_product = findViewById(R.id.btn_product);

        cartController = new CartController(this);

        Intent intent = getIntent();
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        String giasp = decimalFormat.format(Integer.valueOf(intent.getStringExtra("gia")));

        Picasso.get().load(intent.getStringExtra("anh")).into(img_product);
        txt_ten_product.setText(intent.getStringExtra("ten"));
        txt_theloai_product.setText(intent.getStringExtra("theloai"));
        txt_gia_product.setText("$" + giasp);

        btn_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartController.insertCart(Integer.valueOf(intent.getStringExtra("id")), "1");
//                Log.d("TAG", "onClick: " + intent.getStringExtra("id"));
            }
        });
    }
}