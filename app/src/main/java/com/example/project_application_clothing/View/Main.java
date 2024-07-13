package com.example.project_application_clothing.View;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.project_application_clothing.Fragment.Fragment_Home;
import com.example.project_application_clothing.Fragment.Fragment_Oder;
import com.example.project_application_clothing.Fragment.Fragment_Sreach;
import com.example.project_application_clothing.Fragment.Fragment_User;
import com.example.project_application_clothing.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Main extends AppCompatActivity {
    FrameLayout frameLayout;
    BottomNavigationView bottomNavigationView;
    Fragment_Home fragment_home;
    Fragment_Sreach fragment_sreach;
    Fragment_Oder fragment_oder;
    Fragment_User fragment_user;
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout = findViewById(R.id.frameLayout);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        fragment_home = new Fragment_Home();
        fragment_sreach = new Fragment_Sreach();
        fragment_oder = new Fragment_Oder();
        fragment_user = new Fragment_User();

        fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction().add(R.id.frameLayout, new Fragment_Home()).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.home){
                    fragmentManager.beginTransaction().replace(R.id.frameLayout, new Fragment_Home()).commit();
                }else if(menuItem.getItemId() == R.id.sreach){
                    fragmentManager.beginTransaction().replace(R.id.frameLayout, new Fragment_Sreach()).commit();
                } else if(menuItem.getItemId() == R.id.oder) {
                    fragmentManager.beginTransaction().replace(R.id.frameLayout, new Fragment_Oder()).commit();
                } else if(menuItem.getItemId() == R.id.user) {
                    fragmentManager.beginTransaction().replace(R.id.frameLayout, new Fragment_User()).commit();
                }
                return true;
            }
        });

    }
}