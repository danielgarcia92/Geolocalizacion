package com.example.daniel.burgerking;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Publicidad extends ListFragment {

    private String[] MenuS;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        MenuS = new String[]{"Promociones","Sedes Medellin","Nueva Sede"};
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,MenuS));

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            MargenSuperior fragment1 = new MargenSuperior();
            fragmentTransaction.replace(R.id.frame1, fragment1).commit();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

            if (MenuS[position] == MenuS[0]) {
                FragmentManager fragmentManager1 = getFragmentManager();
                FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                Null fragment1 = new Null();
                fragmentTransaction1.replace(R.id.frame5, fragment1).commit();
                
                Promociones fragment = new Promociones();
                fragmentTransaction.replace(R.id.frame6, fragment).commit();
            }

            if (MenuS[position] == MenuS[1]) {

                FragmentManager fragmentManager1 = getFragmentManager();
                FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                FragmentManager fragmentManager2 = getFragmentManager();
                FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                FragmentManager fragmentManager3 = getFragmentManager();
                FragmentTransaction fragmentTransaction3 = fragmentManager3.beginTransaction();

                Null fragment = new Null();
                fragmentTransaction.replace(R.id.frame6, fragment).commit();
                Mapa fragment1 = new Mapa();
                fragmentTransaction1.replace(R.id.frame6, fragment1).commit();
                Null fragment2 = new Null();
                fragmentTransaction2.replace(R.id.frame5, fragment2).commit();
                Sedes fragment3 = new Sedes();
                fragmentTransaction3.replace(R.id.frame5, fragment3).commit();

            }

            if (MenuS[position] == MenuS[2]) {

                FragmentManager fragmentManager1 = getFragmentManager();
                FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                FragmentManager fragmentManager2 = getFragmentManager();
                FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();

                Null fragment = new Null();
                fragmentTransaction.replace(R.id.frame5, fragment).commit();
                Sedes fragment1 = new Sedes();
                fragmentTransaction1.replace(R.id.frame7, fragment1).commit();
                NuevaSede fragment2 = new NuevaSede();
                fragmentTransaction2.replace(R.id.frame6, fragment2).commit();

            }

        }

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){

            if (MenuS[position] == MenuS[0]) {
                Promociones fragment = new Promociones();
                fragmentTransaction.replace(R.id.frame2, fragment).commit();
            }

            if (MenuS[position] == MenuS[1]) {

                FragmentManager fragmentManager1 = getFragmentManager();
                FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                FragmentManager fragmentManager2 = getFragmentManager();
                FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                FragmentManager fragmentManager3 = getFragmentManager();
                FragmentTransaction fragmentTransaction3 = fragmentManager3.beginTransaction();

                Null fragment = new Null();
                fragmentTransaction.replace(R.id.frame2, fragment).commit();
                Mapa fragment1 = new Mapa();
                fragmentTransaction1.replace(R.id.frame2, fragment1).commit();
                Null fragment2 = new Null();
                fragmentTransaction2.replace(R.id.frame1, fragment2).commit();
                Sedes fragment3 = new Sedes();
                fragmentTransaction3.replace(R.id.frame1, fragment3).commit();

            }

            if (MenuS[position] == MenuS[2]) {

                FragmentManager fragmentManager1 = getFragmentManager();
                FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                FragmentManager fragmentManager2 = getFragmentManager();
                FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();

                Null fragment = new Null();
                fragmentTransaction.replace(R.id.frame1, fragment).commit();
                //Sedes fragment1 = new Sedes();
                //fragmentTransaction1.replace(R.id.frame7, fragment1).commit();
                NuevaSede fragment2 = new NuevaSede();
                fragmentTransaction2.replace(R.id.frame2, fragment2).commit();

            }

        }

    }

}