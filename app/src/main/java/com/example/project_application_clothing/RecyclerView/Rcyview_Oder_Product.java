package com.example.project_application_clothing.RecyclerView;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_application_clothing.Model.ProductModel;
import com.example.project_application_clothing.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Rcyview_Oder_Product extends RecyclerView.Adapter<Rcyview_Oder_Product.oderProduct_Holder>{
    private Context context;
    private List<ProductModel> listProduct;
    private String trangthai;

    public Rcyview_Oder_Product(Context context, List<ProductModel> listProduct, String trangthai) {
        this.context = context;
        this.listProduct = listProduct;
        this.trangthai = trangthai;
    }

    @NonNull
    @Override
    public oderProduct_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = View.inflate(context, R.layout.rcyview_oder_product, null);
        Rcyview_Oder_Product.oderProduct_Holder holder = new oderProduct_Holder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull oderProduct_Holder holder, int position) {
        ProductModel productModel = listProduct.get(position);

        Picasso.get().load(productModel.getAnhsp()).into(holder.img_oder_cart);
        holder.ten_oder_product.setText(productModel.getTensp());
        holder.theloai_oder_product.setText(productModel.getTheloai());
        holder.gia_oder_product.setText(productModel.getGiasp() + "$");
        holder.trangthai_oder_product.setText(trangthai);

        if (trangthai == "Completed"){
            ViewGroup.LayoutParams params = holder.trangthai_oder_product.getLayoutParams();
            params.width = 250;
            holder.trangthai_oder_product.setLayoutParams(params);
        }else if (trangthai == "Cancel"){
            ViewGroup.LayoutParams params = holder.trangthai_oder_product.getLayoutParams();
            params.width = 250;
            holder.trangthai_oder_product.setLayoutParams(params);
            holder.trangthai_oder_product.setTextColor(Color.parseColor("#f22c27"));
        }

    }

    @Override
    public int getItemCount() {
        if (listProduct != null){
            return listProduct.size();
        }else{
            return 0;
        }
    }

    public class oderProduct_Holder extends RecyclerView.ViewHolder {
        ImageView img_oder_cart;
        TextView ten_oder_product, theloai_oder_product, gia_oder_product, trangthai_oder_product;
        LinearLayout layout_trangthai;
        public oderProduct_Holder(@NonNull View itemView) {
            super(itemView);
            layout_trangthai = itemView.findViewById(R.id.layout_trangthai);
            img_oder_cart = itemView.findViewById(R.id.img_oder_cart);
            ten_oder_product = itemView.findViewById(R.id.ten_oder_product);
            theloai_oder_product = itemView.findViewById(R.id.theloai_oder_product);
            gia_oder_product = itemView.findViewById(R.id.gia_oder_product);
            trangthai_oder_product = itemView.findViewById(R.id.trangthai_oder_product);
        }
    }
}
