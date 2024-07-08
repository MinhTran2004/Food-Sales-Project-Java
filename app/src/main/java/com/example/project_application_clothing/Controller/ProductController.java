package com.example.project_application_clothing.Controller;

import android.content.Context;

import com.example.project_application_clothing.DataBase.ProductApi;
import com.example.project_application_clothing.Model.ProductModel;

import java.util.List;

public class ProductController {
    Context context;
    public ProductController(Context context){
        this.context = context;
    }
    public boolean insertProduct(ProductModel productModel){
        ProductApi productApi = new ProductApi(context);
        return productApi.insertProduct(productModel);
    }
    public boolean deleteProduct(ProductModel productModel){
        ProductApi productApi = new ProductApi(context);
        return productApi.deleteProduct(productModel);
    }
    public boolean updateProduct(ProductModel productModel){
        ProductApi productApi = new ProductApi(context);
        return productApi.updateProduct(productModel);
    }
    public List<ProductModel> getAllProduct(){
        ProductApi productApi = new ProductApi(context);
        return productApi.getAllProduct();
    }
    public List<ProductModel> getAllProductByCategory(String category){
        ProductApi productApi = new ProductApi(context);
        return productApi.getAllProductByCategory(category);
    }
    public ProductModel getAllProductById (int id){
        ProductApi productApi = new ProductApi(context);
        return productApi.getAllProductById(id);
    }
}
