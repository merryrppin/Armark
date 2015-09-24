package com.wmgf.armarkapp.fragments.menuprincipal;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wmgf.armarkapp.R;


public class FrgListaProm extends Fragment {
        public static final String ARG_PAGE = "ARG_PAGE";

        private int mPage;

        public static FrgListaProm newInstance(int page) {
            Bundle args = new Bundle();
            args.putInt(ARG_PAGE, page);
            FrgListaProm fragment = new FrgListaProm();
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            mPage = getArguments().getInt(ARG_PAGE);
        }

        // Inflate the fragment layout we defined above for this fragment
        // Set the associated text for the title
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.frg_lista_prin, container, false);
            TextView tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            tvTitle.setText("Fragment #" + mPage);
            return view;
        }
    }
