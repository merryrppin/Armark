package com.wmgf.armarkapp;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;

import com.desarrollodroide.libraryfragmenttransactionextended.FragmentTransactionExtended;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.wmgf.armarkapp.fragments.login.FrgLogin;

public class LoginActivity extends Activity {
    private int optionSelected = 0;
    private FrgLogin frgLogin;
    public Fragment frgActual;
    private Context context;
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        inicializarVariables();
        colocarPrimerFragment();
    }

    private void inicializarVariables() {
        context = this;
        frgLogin = new FrgLogin();
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
