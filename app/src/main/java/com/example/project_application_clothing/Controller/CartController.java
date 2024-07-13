package com.example.project_application_clothing.Controller;

import android.content.Context;

import com.example.project_application_clothing.DataBase.CartApi;
import com.example.project_application_clothing.Model.CartModel;
import com.example.project_application_clothing.Model.ProductModel;

import java.util.List;

public class CartController {
    Context context;

    public CartController(Context context) {
        this.context = context;
    }
    public boolean insertCart(String id, String makh){
        CartApi cartApi = new CartApi(context);
        return cartApi.insertCart(id, makh);
    }
    public boolean deleteCart(CartModel cartModel){
        CartApi cartApi = new CartApi(context);
        return cartApi.deleteCart(cartModel);
    }
    public boolean updateCart(CartModel cartModel){
        CartApi cartApi = new CartApi(context);
        return cartApi.updateCart(cartModel);
    }
    public List<CartModel> getAllCart(String makh){
        CartApi cartApi = new CartApi(context);
        return cartApi.getAllCart(makh);
    }



}
