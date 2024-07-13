package com.example.project_application_clothing.RecyclerView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_application_clothing.Controller.ProductController;
import com.example.project_application_clothing.Model.OderModel;
import com.example.project_application_clothing.Model.ProductModel;
import com.example.project_application_clothing.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Rcyview_Oder_ProductCancel extends RecyclerView.Adapter<Rcyview_Oder_ProductCancel.OderCancel_Holder>{
    private Context context;
    private List<ProductModel> listProduct;

    public Rcyview_Oder_ProductCancel(Context context, List<ProductModel> listProduct) {
        this.context = context;
        this.listProduct = listProduct;
    }

    @NonNull
    @Override
    public OderCancel_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = View.inflate(context, R.layout.rcyview_oder_product_cancel, null);
        Rcyview_Oder_ProductCancel.OderCancel_Holder holder = new Rcyview_Oder_ProductCancel.OderCancel_Holder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull OderCancel_Holder holder, int position) {
        ProductModel productModel = listProduct.get(position);

        Picasso.get().load(productModel.getAnhsp()).into(holder.img_oderCancel_cart);
        holder.ten_oderCancel_product.setText(productModel.getTensp());
        holder.theloai_oderCancel_product.setText(productModel.getTheloai());
        holder.gia_oderCancel_product.setText(productModel.getGiasp() + "$");
    }

    @Override
    public int getItemCount() {
        if (listProduct != null){
            return listProduct.size();
        }else{
            return 0;
        }
    }

    public class OderCancel_Holder extends RecyclerView.ViewHolder {
        ImageView img_oderCancel_cart;
        TextView ten_oderCancel_product, theloai_oderCancel_product, gia_oderCancel_product;
        public OderCancel_Holder(@NonNull View itemView) {
            super(itemView);
            img_oderCancel_cart = itemView.findViewById(R.id.img_oderCancel_cart);
            ten_oderCancel_product = itemView.findViewById(R.id.ten_oderCancel_product);
            theloai_oderCancel_product = itemView.findViewById(R.id.theloai_oderCancel_product);
            gia_oderCancel_product = itemView.findViewById(R.id.gia_oderCancel_product);
        }
    }
}
