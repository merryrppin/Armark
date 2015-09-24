package com.wmgf.armarkapp.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.wmgf.armarkapp.fragments.menuprincipal.FrgListaPrincipal;

/**
 * Created by WMGF on 20/09/2015.
 */
public class AdapterLista extends FragmentPagerAdapter {
    private int page_count = 1;
    private String tabTitles[];

    public AdapterLista(FragmentManager fm, String[] arrayTabs) {
        super(fm);
        tabTitles = arrayTabs;
        page_count = tabTitles.length;
    }

    @Override
    public int getCount() {
        return page_count;
    }

    @Override
    public Fragment getItem(int position) {
        //return FrgListaProm.newInstance(position + 1);
        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                return new FrgListaPrincipal();
            case 1: // Fragment # 0 - This will show FirstFragment different title
                return new FrgListaPrincipal();
            case 2: // Fragment # 1 - This will show SecondFragment
                return new FrgListaPrincipal();
            case 3: // Fragment
                return new FrgListaPrincipal();
            case 4: // Fragment
                return new FrgListaPrincipal();
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}