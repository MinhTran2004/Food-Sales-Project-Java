package com.example.project_application_clothing.RecyclerView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_application_clothing.Controller.ProductController;
import com.example.project_application_clothing.Model.OderModel;
import com.example.project_application_clothing.Model.ProductModel;
import com.example.project_application_clothing.R;

import java.util.ArrayList;
import java.util.List;

public class RcyView_OderCancel extends RecyclerView.Adapter<RcyView_OderCancel.OderCancel_Holder>{
    private Context context;
    private List<OderModel> listOder;
    private OderModel oderModel;
    private ProductController productController;
    private List<ProductModel> listProduct;
    private Rcyview_Oder_Product rcyview_oder_product;
    public RcyView_OderCancel(Context context, List<OderModel> listOder) {
        this.context = context;
        this.listOder = listOder;
    }
    @NonNull
    @Override
    public OderCancel_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = View.inflate(context, R.layout.rcyview_odercancel, null);
        RcyView_OderCancel.OderCancel_Holder holder = new OderCancel_Holder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull OderCancel_Holder holder, int position) {
        productController = new ProductController(context);
        oderModel = listOder.get(position);

        holder.text_oderCancel_tongtien.setText(oderModel.getTongtien());

        String magh = oderModel.getMagh();
        String[] arrMagh = magh.split(",");
        listProduct = new ArrayList<>();
        for (int i=0; i<arrMagh.length; i++){
            listProduct.add(productController.getAllProductById(Integer.parseInt(arrMagh[i])));
        }

        rcyview_oder_product = new Rcyview_Oder_Product(context, listProduct, "Cancel");
        holder.recyclerView_OderCancel_Product.setAdapter(rcyview_oder_product);
        holder.recyclerView_OderCancel_Product.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public int getItemCount() {
        if (listOder != null){
            return listOder.size();
        }else{
            return 0;
        }
    }

    public class OderCancel_Holder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView_OderCancel_Product;
        TextView text_oderCancel_tongtien;
        public OderCancel_Holder(@NonNull View itemView) {
            super(itemView);
            recyclerView_OderCancel_Product = itemView.findViewById(R.id.recyclerView_OderCancel_Product);
            text_oderCancel_tongtien = itemView.findViewById(R.id.text_oderCancel_tongtien);
        }
    }
}
