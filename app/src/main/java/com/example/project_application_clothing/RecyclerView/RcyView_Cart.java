package com.example.project_application_clothing.RecyclerView;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_application_clothing.Controller.CartController;
import com.example.project_application_clothing.Controller.ProductController;
import com.example.project_application_clothing.Interface.InterfaceCart;
import com.example.project_application_clothing.Model.CartModel;
import com.example.project_application_clothing.Model.ProductModel;
import com.example.project_application_clothing.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RcyView_Cart extends RecyclerView.Adapter<RcyView_Cart.Cart_Holder>{
    private Context context;
    private CartModel cartModel;
    private ProductModel productModel;
    private List<CartModel> list;
    ProductController productController;
    CartController cartController;
    InterfaceCart interfaceCart;
    int tong = 0;
    public RcyView_Cart(Context context, List<CartModel> list, InterfaceCart interfaceCart) {
        this.context = context;
        this.list = list;
        this.interfaceCart = interfaceCart;
    }
    @NonNull
    @Override
    public Cart_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = View.inflate(context, R.layout.rcyview_cart, null);
        RcyView_Cart.Cart_Holder holder = new Cart_Holder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Cart_Holder holder, int position) {
        cartModel = list.get(position);

        cartController = new CartController(context);
        productController = new ProductController(context);
        productModel = productController.getAllProductById(Integer.valueOf(cartModel.getMasp()));

        Picasso.get().load(productModel.getAnhsp()).into(holder.img_Product_cart);
        holder.ten_Product_cart.setText(productModel.getTensp());
        holder.theloai_Product_cart.setText(productModel.getTheloai());
        holder.gia_Product_cart.setText(productModel.getGiasp());

        tong = tong + Integer.valueOf(productModel.getGiasp());
        interfaceCart.getPriceCart(String.valueOf(tong));
        holder.img_cart_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tong = 0;
                cartController.deleteCart(cartModel);
                list.clear();
                list = cartController.getAllCart(1);
                interfaceCart.getPriceCart(String.valueOf(tong));
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        if (list != null && list.size() > 0){
            return list.size();
        }else {
            return 0;
        }
    }

    public class Cart_Holder extends RecyclerView.ViewHolder {
        ImageView img_Product_cart, img_cart_delete;
        TextView ten_Product_cart, theloai_Product_cart, gia_Product_cart;
        public Cart_Holder(@NonNull View itemView) {
            super(itemView);
            img_cart_delete = itemView.findViewById(R.id.img_cart_delete);
            img_Product_cart = itemView.findViewById(R.id.img_Product_cart);
            ten_Product_cart = itemView.findViewById(R.id.ten_Product_cart);
            theloai_Product_cart = itemView.findViewById(R.id.theloai_Product_cart);
            gia_Product_cart = itemView.findViewById(R.id.gia_Product_cart);
        }
    }
}
