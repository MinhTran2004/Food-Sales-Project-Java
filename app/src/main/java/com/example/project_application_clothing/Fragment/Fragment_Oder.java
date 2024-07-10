package com.example.project_application_clothing.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.project_application_clothing.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class Fragment_Oder extends Fragment {
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    Fragment_Oder_Main fragment_oder_main;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_oder, container, false);
        return v;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabLayout = view.findViewById(R.id.tabLayout);
        viewPager2 = view.findViewById(R.id.viewpager2);
        fragment_oder_main = new Fragment_Oder_Main(getActivity());

        viewPager2.setAdapter(fragment_oder_main);

        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int i) {
                switch (i){
                    case 0: tab.setText("Active"); break;
                    case 1: tab.setText("Completed"); break;
                    case 2: tab.setText("Cancel"); break;
                }
            }
        }).attach();
    }
}
