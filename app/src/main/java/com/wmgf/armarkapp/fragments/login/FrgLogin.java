package com.wmgf.armarkapp.fragments.login;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wmgf.armarkapp.LoginActivity;
import com.wmgf.armarkapp.MenuPrincipalActivity;
import com.wmgf.armarkapp.R;

import android.widget.Button;
import android.widget.Toast;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;


/**
 * Created by WMGF on 22/09/2015.
 */
public class FrgLogin extends Fragment {

    private FrgRegistrarse frgRegistrarse;
    private FrgResetearContrasena frg_resetearContrasena;
    private TwitterLoginButton loginButton;
    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frg_login, container, false);
        context = getActivity().getApplicationContext();
        inicializarButtonTwitter(view);
        inicializarVariables(view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void inicializarVariables(View view) {
        Button btn_frg_login_btnIngresar = (Button) view.findViewById(R.id.btn_frg_login_btnIngresar);
        Button btn_frg_login_btnRegistrarse = (Button) view.findViewById(R.id.btn_frg_login_btnRegistrarse);
        Button btn_frg_login_btnResetearContrasena = (Button) view.findViewById(R.id.btn_frg_login_btnResetearContrasena);
        frgRegistrarse = new FrgRegistrarse();
        frg_resetearContrasena = new FrgResetearContrasena();
        View.OnClickListener onClickResetearPass = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "frg_resetearContrasena", Toast.LENGTH_SHORT).show();
                ((LoginActivity) getActivity()).addTransition(((LoginActivity) getActivity()).frgActual, frg_resetearContrasena);
            }
        };
        View.OnClickListener onClickRegistrarse = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "frgRegistrarse", Toast.LENGTH_SHORT).show();
                ((LoginActivity) getActivity()).addTransition(((LoginActivity) getActivity()).frgActual, frg_resetearContrasena);
            }
        };
        View.OnClickListener onClickIngresar = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarLogin();
            }
        };
        btn_frg_login_btnRegistrarse.setOnClickListener(onClickRegistrarse);
        btn_frg_login_btnResetearContrasena.setOnClickListener(onClickResetearPass);
        btn_frg_login_btnIngresar.setOnClickListener(onClickIngresar);
    }

    private void inicializarButtonTwitter(View view) {
        loginButton = (TwitterLoginButton) view.findViewById(R.id.btn_login_twitter);
        loginButton.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                Toast.makeText(context, "SUCCES: " + result.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void failure(TwitterException exception) {
                Toast.makeText(context, "failure: " + exception.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void validarLogin() {
        boolean validarLogin = true;
        if (validarLogin) {
            Intent act = new Intent(context, MenuPrincipalActivity.class);
            startActivity(act);
            getActivity().finish();
        }
    }
}
