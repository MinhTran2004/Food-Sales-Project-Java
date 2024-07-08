package com.example.project_application_clothing.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_application_clothing.Controller.ProductController;
import com.example.project_application_clothing.Interface.InterfaceHome;
import com.example.project_application_clothing.Model.CategoryModel;
import com.example.project_application_clothing.Model.ProductModel;
import com.example.project_application_clothing.R;
import com.example.project_application_clothing.RecyclerView.RcyView_Category_Vertical;
import com.example.project_application_clothing.RecyclerView.RcyView_Product_Horiztal;
import com.example.project_application_clothing.RecyclerView.RcyView_Product_Vertical;
import com.example.project_application_clothing.View.Cart;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Home extends Fragment implements InterfaceHome {
    RecyclerView recyclerView_product_hozital, recyclerView_product_vertical, recyclerView_category_hozital;
    RcyView_Product_Horiztal rcyView_product_horiztal;
    RcyView_Category_Vertical rcyView_category_vertical;
    RcyView_Product_Vertical rcyView_product_vertical;
    List<CategoryModel> listCategory;
    List<ProductModel> listHorizon;
    List<ProductModel> listVertical;
    ProductController productController;
    ImageView img_Cart;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        recyclerView_product_hozital = view.findViewById(R.id.recyclerView_product_hozital);
        recyclerView_product_vertical = view.findViewById(R.id.recyclerView_product_vertical);
        recyclerView_category_hozital = view.findViewById(R.id.recyclerView_category_hozital);
        img_Cart = view.findViewById(R.id.img_Cart);

        img_Cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), Cart.class));
            }
        });

        productController = new ProductController(getContext());
        listHorizon =  productController.getAllProduct();
        listVertical =  productController.getAllProduct();

//        product_horiztal
        rcyView_product_horiztal = new RcyView_Product_Horiztal(getContext(), listHorizon);
        recyclerView_product_hozital.setAdapter(rcyView_product_horiztal);
        recyclerView_product_hozital.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

//        category
        listCategory = new ArrayList<>();
        listCategory.add(new CategoryModel(1 ,"All"));
        listCategory.add(new CategoryModel(2, R.drawable.hamburger, "Hamburger"));
        listCategory.add(new CategoryModel(3, R.drawable.pizza, "Pizza"));
        listCategory.add(new CategoryModel(4, R.drawable.meat, "Meat"));
        listCategory.add(new CategoryModel(5, R.drawable.noodles, "Noodles"));
        listCategory.add(new CategoryModel(6, R.drawable.cake, "Dessert"));
        listCategory.add(new CategoryModel(7, R.drawable.drink, "Drink"));
        listCategory.add(new CategoryModel(8, R.drawable.vegetable, "Vegetable"));

        rcyView_category_vertical = new RcyView_Category_Vertical(getContext(), listCategory, this);
        recyclerView_category_hozital.setAdapter(rcyView_category_vertical);
        recyclerView_category_hozital.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

//        product_vertical
        rcyView_product_vertical = new RcyView_Product_Vertical(getContext(), listVertical);
        recyclerView_product_vertical.setAdapter(rcyView_product_vertical);
        recyclerView_product_vertical.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        return v;
    }

    @Override
    public void OnGetProductByName(String category) {
        productController = new ProductController(getContext());
        listVertical = productController.getAllProductByCategory(category);

        rcyView_product_vertical = new RcyView_Product_Vertical(getContext(), listVertical);
        recyclerView_product_vertical.setAdapter(rcyView_product_vertical);
        recyclerView_product_vertical.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }
}


