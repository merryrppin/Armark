package com.wmgf.armarkapp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.wmgf.armarkapp.fragments.Frg_Lista_Prom;

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
        return Frg_Lista_Prom.newInstance(position + 1);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}