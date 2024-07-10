package com.example.project_application_clothing.Fragment;

import android.os.Bundle;
import android.util.Log;
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
import com.example.project_application_clothing.Model.ProductModel;
import com.example.project_application_clothing.Model.UserModel;
import com.example.project_application_clothing.R;
import com.example.project_application_clothing.RecyclerView.RcyView_OderCompleted;

import java.util.List;

public class Fragment_OderCompleted extends Fragment {
    RecyclerView recyclerView_Odercompleted;
    RcyView_OderCompleted rcyView_oderCompleted;
    OderController oderController;
    ProductController productController;
    List<OderModel> listOder;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = View.inflate(getContext(), R.layout.fragment_odercompleted, null);
        return v;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView_Odercompleted = view.findViewById(R.id.recyclerView_OderCompleted);

        oderController = new OderController(getContext());
        productController = new ProductController(getContext());

        UserModel userModel = new UserModel();
        userModel.setId(1);

        listOder = oderController.getAllOderCompleted(userModel);

        rcyView_oderCompleted = new RcyView_OderCompleted(getContext(), listOder);
        recyclerView_Odercompleted.setAdapter(rcyView_oderCompleted);
        recyclerView_Odercompleted.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }
}
