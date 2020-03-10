package com.example.trab_01.adapters;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.trab_01.fragments.MainFragment;
import com.example.trab_01.fragments.MusicasFragment;
import com.example.trab_01.fragments.SobreNosFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new MainFragment();
                break;

            case 1:
                fragment = new MusicasFragment();
                break;
            case 2:
                fragment = new SobreNosFragment();
                break;
        }
        return fragment;
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String str = null;
        switch (position){
            case 0:
                str = "Principal";
                break;
            case 1:
                str = "Musicas";
                break;
            case 2:
                str = "Sobre Nós";
                break;
        }
        return str;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
