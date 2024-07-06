package com.example.project_application_clothing.RecyclerView;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_application_clothing.Model.CategoryModel;
import com.example.project_application_clothing.Model.ProductModel;
import com.example.project_application_clothing.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RcyView_Category_Vertical extends RecyclerView.Adapter<RcyView_Category_Vertical.Category_Hodel>{
    private List<CategoryModel> list;
    private Context context;

    public RcyView_Category_Vertical( Context context, List<CategoryModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Category_Hodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = View.inflate(context, R.layout.rcyview_category, null);
        RcyView_Category_Vertical.Category_Hodel hodel = new Category_Hodel(v);
        return hodel;
    }

    @Override
    public void onBindViewHolder(@NonNull Category_Hodel holder, int position) {
        CategoryModel categoryModel = list.get(position);
        if (categoryModel.getAnh() != 0){
            Picasso.get().load(categoryModel.getAnh()).into(holder.img_category);
            holder.name_category.setText(categoryModel.getTen());
        }else{
            holder.img_category.setVisibility(View.GONE);
            holder.name_category.setText(categoryModel.getTen());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Category_Hodel extends RecyclerView.ViewHolder {
        ImageView img_category;
        TextView name_category;
        public Category_Hodel(@NonNull View itemView) {
            super(itemView);
            img_category = itemView.findViewById(R.id.img_category);
            name_category = itemView.findViewById(R.id.name_category);
        }
    }
}
