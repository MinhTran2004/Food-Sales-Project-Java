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

public class Rcyview_Oder_ProductActive extends RecyclerView.Adapter<Rcyview_Oder_ProductActive.OderProductActive_Holder>{
    private Context context;
    private List<ProductModel> listProduct;

    public Rcyview_Oder_ProductActive(Context context, List<ProductModel> listProduct) {
        this.context = context;
        this.listProduct = listProduct;
    }

    @NonNull
    @Override
    public OderProductActive_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = View.inflate(context, R.layout.rcyview_oder_product_active, null);
        Rcyview_Oder_ProductActive.OderProductActive_Holder holder = new OderProductActive_Holder(v);
        return holder;
    }
    @Override
    public void onBindViewHolder(@NonNull OderProductActive_Holder holder, int position) {
        ProductModel productModel = listProduct.get(position);

        Picasso.get().load(productModel.getAnhsp()).into(holder.img_oder_cart);
        holder.ten_oder_product.setText(productModel.getTensp());
        holder.theloai_oder_product.setText(productModel.getTheloai());
        holder.gia_oder_product.setText(productModel.getGiasp() + "$");
    }
    @Override
    public int getItemCount() {
        if (listProduct != null){
            return listProduct.size();
        }else{
            return 0;
        }
    }

    public class OderProductActive_Holder extends RecyclerView.ViewHolder {
        ImageView img_oder_cart;
        TextView ten_oder_product, theloai_oder_product, gia_oder_product, trangthai_oder_product;
        LinearLayout layout_trangthai;
        public OderProductActive_Holder(@NonNull View itemView) {
            super(itemView);
            img_oder_cart = itemView.findViewById(R.id.img_oderActive_cart);
            ten_oder_product = itemView.findViewById(R.id.ten_oderActive_product);
            theloai_oder_product = itemView.findViewById(R.id.theloai_oderActive_product);
            gia_oder_product = itemView.findViewById(R.id.gia_oderActive_product);
        }
    }
}
