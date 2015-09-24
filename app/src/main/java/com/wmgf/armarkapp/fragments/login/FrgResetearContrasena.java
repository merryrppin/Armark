package com.wmgf.armarkapp.fragments.login;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wmgf.armarkapp.R;

/**
 * Created by WMGF on 22/09/2015.
 */
public class FrgResetearContrasena extends Fragment {
    private Context context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frg_resetearcontrasena, container, false);
        context = getActivity().getApplicationContext();
        return view;
    }
}
