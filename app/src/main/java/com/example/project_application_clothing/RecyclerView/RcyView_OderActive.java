package com.example.project_application_clothing.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_application_clothing.Controller.OderController;
import com.example.project_application_clothing.Controller.ProductController;
import com.example.project_application_clothing.DataBase.CartApi;
import com.example.project_application_clothing.Model.OderModel;
import com.example.project_application_clothing.Model.ProductModel;
import com.example.project_application_clothing.Model.UserModel;
import com.example.project_application_clothing.R;

import java.util.ArrayList;
import java.util.List;

public class RcyView_OderActive extends RecyclerView.Adapter<RcyView_OderActive.OderActice_Holder>{
    private Context context;
    private List<OderModel> listOder;
    private List<ProductModel> listProduct;
    private ProductController productController;
    private OderController oderController;
    private Rcyview_Oder_ProductActive rcyview_oder_productActive;
    CartApi cartApi;
    public RcyView_OderActive(Context context, List<OderModel> listOder) {
        this.context = context;
        this.listOder = listOder;
    }
    @NonNull
    @Override
    public OderActice_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = View.inflate(context, R.layout.rcyview_oderactive, null);
        RcyView_OderActive.OderActice_Holder holder = new OderActice_Holder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull OderActice_Holder holder, int position) {
        OderModel oderModel = listOder.get(position);

        cartApi = new CartApi(context);
        productController = new ProductController(context);
        oderController = new OderController(context);
        String magh = oderModel.getMagh();
        String[] arrMagh = magh.split(",");

        listProduct = new ArrayList<>();
        for (int i=0; i< arrMagh.length; i++){
            listProduct.add(productController.getAllProductById(arrMagh[i]));
        }

        rcyview_oder_productActive = new Rcyview_Oder_ProductActive(context, listProduct);
        holder.recyclerView_OderAcitve_Product.setAdapter(rcyview_oder_productActive);
        holder.recyclerView_OderAcitve_Product.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));

        SharedPreferences sharedPreferences = context.getSharedPreferences("User", Context.MODE_PRIVATE);
        String makh = sharedPreferences.getString("id", null);
        String chucvu = sharedPreferences.getString("taikhoan", null);



        if (chucvu.equals("admin")){
            holder.btn_oderCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    oderController.updateOder(oderModel, "Cancel");
                    listOder.clear();
                    listOder = oderController.getAllOderActive(makh, chucvu);
                    notifyDataSetChanged();
                }
            });
            holder.btn_oderCompleted.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    oderController.updateOder(oderModel, "Completed");
                    listOder.clear();
                    listOder = oderController.getAllOderActive(makh, chucvu);
                    for (int i=0; i<arrMagh.length; i++){
                        cartApi.getCartById(arrMagh[i], context);
                    }
                    notifyDataSetChanged();
                }
            });
        }else {
            holder.btn_oderCancel.setVisibility(View.GONE);
            holder.btn_oderCompleted.setVisibility(View.GONE);
        }
    }
    @Override
    public int getItemCount() {
        if (listOder != null){
            return listOder.size();
        }else {
            return 0;
        }
    }
    public class OderActice_Holder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView_OderAcitve_Product;
        Button btn_oderCancel, btn_oderCompleted;
        TextView text_oderActive_tongtien;
        public OderActice_Holder(@NonNull View itemView) {
            super(itemView);
            recyclerView_OderAcitve_Product = itemView.findViewById(R.id.recyclerView_OderAcitve_Product);
            text_oderActive_tongtien = itemView.findViewById(R.id.text_oderActive_tongtien);
            btn_oderCancel = itemView.findViewById(R.id.btn_oderCancel);
            btn_oderCompleted = itemView.findViewById(R.id.btn_oderCompleted);
        }
    }
}
