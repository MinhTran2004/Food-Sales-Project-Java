package com.example.project_application_clothing.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_application_clothing.Controller.OderController;
import com.example.project_application_clothing.Controller.ProductController;
import com.example.project_application_clothing.Model.OderModel;
import com.example.project_application_clothing.Model.UserModel;
import com.example.project_application_clothing.R;
import com.example.project_application_clothing.RecyclerView.RcyView_OderCancel;
import com.example.project_application_clothing.RecyclerView.RcyView_OderCompleted;

import java.util.List;

public class Fragment_OderCancel extends Fragment {
    RecyclerView recyclerView_OderCancel;
    RcyView_OderCancel rcyView_oderCancel;
    OderController oderController;
    ProductController productController;
    List<OderModel> listOder;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = View.inflate(getContext(), R.layout.fragment_odercancel, null);
        return v;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView_OderCancel = view.findViewById(R.id.recyclerView_OderCancel);

        oderController = new OderController(getContext());
        productController = new ProductController(getContext());

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("User", Context.MODE_PRIVATE);
        String makh = sharedPreferences.getString("id", null);
        String chucvu = sharedPreferences.getString("taikhoan", null);

        listOder = oderController.getAllOderCancel(makh, chucvu);

        rcyView_oderCancel = new RcyView_OderCancel(getContext(), listOder);
        recyclerView_OderCancel.setAdapter(rcyView_oderCancel);
        recyclerView_OderCancel.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }
}