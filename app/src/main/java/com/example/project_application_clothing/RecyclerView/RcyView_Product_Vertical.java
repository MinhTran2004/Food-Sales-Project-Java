package com.example.project_application_clothing.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_application_clothing.Controller.CartController;
import com.example.project_application_clothing.Model.CartModel;
import com.example.project_application_clothing.Model.ProductModel;
import com.example.project_application_clothing.R;
import com.example.project_application_clothing.View.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RcyView_Product_Vertical extends RecyclerView.Adapter<RcyView_Product_Vertical.Product_Vertical_Holder>{
    Context context;
    List<ProductModel> list;
    CartController cartController;
    CartModel cartModel;
    LinearLayout home_vertical;


    public RcyView_Product_Vertical(Context context, List<ProductModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Product_Vertical_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = View.inflate(context, R.layout.rcyview_product_vertical, null);
        RcyView_Product_Vertical.Product_Vertical_Holder holder = new Product_Vertical_Holder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Product_Vertical_Holder holder, int position) {
        ProductModel productModel = list.get(position);

        Picasso.get().load(productModel.getAnhsp()).into(holder.img_product_vertical);
        holder.ten_product_vertical.setText(productModel.getTensp());
        holder.theloai_product_vertical.setText(productModel.getTheloai());
        holder.gia_product_vertical.setText(productModel.getGiasp());
        holder.luotmua_product_vertical.setText("Đã bán: " + productModel.getLuotmua());
        holder.home_vertical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Product.class);
                intent.putExtra("id", productModel.getId());
                intent.putExtra("anh", productModel.getAnhsp());
                intent.putExtra("ten", productModel.getTensp());
                intent.putExtra("theloai", productModel.getTheloai());
                intent.putExtra("gia", productModel.getGiasp());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (list != null){
            return list.size();
        }else {
            return 0;
        }
    }

    public class Product_Vertical_Holder extends RecyclerView.ViewHolder {
        TextView ten_product_vertical, theloai_product_vertical, gia_product_vertical, luotmua_product_vertical;
        ImageView img_product_vertical;
        LinearLayout home_vertical;
        public Product_Vertical_Holder(@NonNull View itemView) {
            super(itemView);
            img_product_vertical = itemView.findViewById(R.id.img_product_vertical);
            ten_product_vertical = itemView.findViewById(R.id.ten_product_vertical);
            theloai_product_vertical = itemView.findViewById(R.id.theloai_product_vertical);
            gia_product_vertical = itemView.findViewById(R.id.gia_product_vertical);
            luotmua_product_vertical = itemView.findViewById(R.id.luotmua_product_vertical);
            home_vertical = itemView.findViewById(R.id.home_vertical);

        }
    }
}
