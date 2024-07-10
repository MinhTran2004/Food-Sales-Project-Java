package com.example.project_application_clothing.Fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class Fragment_Oder_Main extends FragmentStateAdapter {
    public Fragment_Oder_Main(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return new Fragment_OderActive();
            case 1: return new Fragment_OderCompleted();
            case 2: return new Fragment_OderCancel();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
