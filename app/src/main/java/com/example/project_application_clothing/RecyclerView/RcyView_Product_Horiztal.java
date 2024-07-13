package com.example.project_application_clothing.RecyclerView;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_application_clothing.Model.ProductModel;
import com.example.project_application_clothing.R;
import com.example.project_application_clothing.View.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RcyView_Product_Horiztal extends RecyclerView.Adapter<RcyView_Product_Horiztal.Product_Hozital_Holder> {
    private List<ProductModel> list;
    private Context context;

    public RcyView_Product_Horiztal(Context context, List<ProductModel> list){
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public Product_Hozital_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = View.inflate(context, R.layout.rcyview_product_hozital, null);
        RcyView_Product_Horiztal.Product_Hozital_Holder holder = new Product_Hozital_Holder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Product_Hozital_Holder holder, int position) {
        ProductModel productModel = list.get(position);

        Picasso.get().load(productModel.getAnhsp()).into(holder.img_product_horizon);
        holder.ten_product_horizon.setText(productModel.getTensp());
        holder.theloai_product_horizon.setText(productModel.getTheloai());
        holder.gia_product_horizon.setText(productModel.getGiasp());
        holder.luotmua_product_horizon.setText("Đã bán: " + productModel.getLuotmua());
        holder.home_horizontal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Product.class);
                intent.putExtra("masp", String.valueOf(productModel.getId()));
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

    public class Product_Hozital_Holder extends RecyclerView.ViewHolder {
        TextView ten_product_horizon, theloai_product_horizon, gia_product_horizon, luotmua_product_horizon;
        ImageView img_product_horizon;
        LinearLayout home_horizontal;
        public Product_Hozital_Holder(@NonNull View itemView) {
            super(itemView);
            img_product_horizon = itemView.findViewById(R.id.img_product_horizon);
            ten_product_horizon = itemView.findViewById(R.id.ten_product_horizon);
            theloai_product_horizon = itemView.findViewById(R.id.theloai_product_horizon);
            gia_product_horizon = itemView.findViewById(R.id.gia_product_horizon);
            luotmua_product_horizon = itemView.findViewById(R.id.luotmua_product_horizon);

            home_horizontal = itemView.findViewById(R.id.home_horizontal);
        }
    }


}
