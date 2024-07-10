package com.example.project_application_clothing.RecyclerView;

import android.content.Context;
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
    private OderModel oderModel;
    private Rcyview_Oder_Product rcyview_oder_product;
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
        productController = new ProductController(context);
        oderController = new OderController(context);
        oderModel = listOder.get(position);

        String magh = oderModel.getMagh();
        String[] arrMagh = magh.split(",");

        listProduct = new ArrayList<>();
        for (int i=0; i< arrMagh.length; i++){
            listProduct.add(productController.getAllProductById(Integer.valueOf(arrMagh[i])));
        }

        rcyview_oder_product = new Rcyview_Oder_Product(context, listProduct, "Active");
        holder.recyclerView_OderAcitve_Product.setAdapter(rcyview_oder_product);
        holder.recyclerView_OderAcitve_Product.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));

        holder.btn_oderCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oderController.updateOder(oderModel, "Cancel");
                listOder.clear();
                UserModel userModel = new UserModel();
                userModel.setId(1);
                listOder = oderController.getAllOderActive(userModel);
                notifyDataSetChanged();
            }
        });
        holder.btn_oderCompleted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oderController.updateOder(oderModel, "Completed");
                listOder.clear();
                UserModel userModel = new UserModel();
                userModel.setId(1);
                listOder = oderController.getAllOderActive(userModel);
                notifyDataSetChanged();
            }
        });
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
