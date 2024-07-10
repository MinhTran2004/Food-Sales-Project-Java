package com.example.project_application_clothing.RecyclerView;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_application_clothing.Interface.InterfaceCheckOder;
import com.example.project_application_clothing.Model.ProductModel;
import com.example.project_application_clothing.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;


public class RcyView_CheckOder extends RecyclerView.Adapter<RcyView_CheckOder.CheckOder_Holder>{
    private Context context;
    private List<ProductModel> list;
    private InterfaceCheckOder interfaceCheckOder;
    private int tong = 0;

    public RcyView_CheckOder(Context context, List<ProductModel> list, InterfaceCheckOder interfaceCheckOder) {
        this.context = context;
        this.list = list;
        this.interfaceCheckOder = interfaceCheckOder;
    }

    @NonNull
    @Override
    public CheckOder_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = View.inflate(context, R.layout.rcyview_checkoder, null);
        RcyView_CheckOder.CheckOder_Holder holder = new CheckOder_Holder(v);
        return holder;
    }
    @Override
    public void onBindViewHolder(@NonNull CheckOder_Holder holder, int position) {
        ProductModel productModel = list.get(position);
        Picasso.get().load(productModel.getAnhsp()).into(holder.img_checkOder);
        holder.ten_checkOder.setText(productModel.getTensp());
        holder.theloai_checkOder.setText(productModel.getTheloai());
        holder.gia_checkOder.setText("$"+productModel.getGiasp());

        tong += Integer.valueOf(productModel.getGiasp());
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        String tongtien = decimalFormat.format(tong);
        interfaceCheckOder.getTongtien(tongtien);
    }
    @Override
    public int getItemCount() {
        if (list != null){
            return list.size();
        }else {
            return 0;
        }
    }
    public class CheckOder_Holder extends RecyclerView.ViewHolder {
        TextView ten_checkOder, theloai_checkOder, gia_checkOder;
        ImageView img_checkOder;
        public CheckOder_Holder(@NonNull View itemView) {
            super(itemView);
            ten_checkOder = itemView.findViewById(R.id.ten_checkOder);
            theloai_checkOder = itemView.findViewById(R.id.theloai_checkOder);
            gia_checkOder = itemView.findViewById(R.id.gia_checkOder);
            img_checkOder = itemView.findViewById(R.id.img_checkOder);
        }
    }
}
