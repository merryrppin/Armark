package com.wmgf.armarkapp;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

import com.desarrollodroide.libraryfragmenttransactionextended.FragmentTransactionExtended;
import com.wmgf.armarkapp.fragments.Frg_Login;
import com.wmgf.armarkapp.fragments.Frg_Registrarse;
import com.wmgf.armarkapp.fragments.Frg_ResetearContrasena;

public class LoginActivity extends Activity {
    private int optionSelected = 0;
    private View.OnClickListener onClickResetearPass, onClickRegistrarse;
    private Frg_Login frgLogin;
    private Frg_Registrarse frgRegistrarse;
    private Frg_ResetearContrasena frg_resetearContrasena;
    private Fragment frgActual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        inicializarVariables();
        colocarPrimerFragment();
    }

    private void inicializarVariables() {
        onClickResetearPass = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTransition(frgActual, frg_resetearContrasena);
            }
        };
        onClickRegistrarse = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTransition(frgActual, frgRegistrarse);
            }
        };
        frgLogin = new Frg_Login();
        frgRegistrarse = new Frg_Registrarse();
        frg_resetearContrasena = new Frg_ResetearContrasena();
    }

    private void colocarPrimerFragment() {
        //Add first fragment
        frgActual = frgLogin;
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(R.id.fragment_place, frgLogin);
        fragmentTransaction.commit();
    }

    public void addTransition(Fragment frgInicial, Fragment frgFinal) {
        frgActual = frgFinal;
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        FragmentTransactionExtended fragmentTransactionExtended = new FragmentTransactionExtended(this, fragmentTransaction, frgInicial, frgFinal, R.id.fragment_place);
        fragmentTransactionExtended.addTransition(optionSelected);
        fragmentTransactionExtended.commit();
    }

    @Override
    public void onBackPressed() {
        if(frgActual != frgLogin) addTransition(frgActual, frgLogin);
        super.onBackPressed();
    }

}
