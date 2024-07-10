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
import com.example.project_application_clothing.Model.OderModel;
import com.example.project_application_clothing.Model.UserModel;
import com.example.project_application_clothing.R;
import com.example.project_application_clothing.RecyclerView.RcyView_OderActive;

import java.util.List;

public class Fragment_OderActive extends Fragment {
    RecyclerView recyclerView_OderActive;
    OderController oderController;
    List<OderModel> listOder;
    RcyView_OderActive rcyView_oderActive;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = View.inflate(getContext(), R.layout.fragment_oderactive, null);
        return v;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView_OderActive = view.findViewById(R.id.recyclerView_OderAcitve);
        oderController = new OderController(getContext());

        UserModel userModel = new UserModel();
        userModel.setId(1);

        listOder = oderController.getAllOderActive(userModel);

        rcyView_oderActive = new RcyView_OderActive(getContext(), listOder);
        recyclerView_OderActive.setAdapter(rcyView_oderActive);
        recyclerView_OderActive.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }
}
