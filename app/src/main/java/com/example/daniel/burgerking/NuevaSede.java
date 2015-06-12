package com.example.daniel.burgerking;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

public class NuevaSede extends Fragment {

    Comunicador interfaz;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        interfaz = (Comunicador)activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nueva_sede, container, false);
    }

    public void retrieveInfoNuevaSede(){

        EditText nuevaSede = (EditText) getActivity().findViewById(R.id.nuevaSede);
        EditText latitud   = (EditText) getActivity().findViewById(R.id.latitud);
        EditText longitud  = (EditText) getActivity().findViewById(R.id.longitud);
        String[] content = new String[3];
        content[0] = nuevaSede.getText().toString();
        content[1] = latitud.getText().toString();
        content[2] = longitud.getText().toString();

        interfaz.sendContent(content);

    }

}