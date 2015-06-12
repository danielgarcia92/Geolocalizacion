package com.example.daniel.burgerking;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.wifi.p2p.WifiP2pManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.wallet.NotifyTransactionStatusRequest;


public class MainActivity extends ActionBarActivity implements Comunicador {

    static private DataBaseManager manager;

    NuevaSede frag1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = new DataBaseManager(this);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            Publicidad fragment2 = new Publicidad();
            fragmentTransaction.replace(R.id.frame2, fragment2).commit();
        }

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            MargenSuperior fragment1 = new MargenSuperior();
            fragmentTransaction.replace(R.id.frame3, fragment1).commit();

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public static DataBaseManager getManager() {
        return manager;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void Agregar (View view) {

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            frag1 = (NuevaSede) getFragmentManager().findFragmentById(R.id.frame2);

            FragmentManager fragmentManager5 = getFragmentManager();
            FragmentTransaction fragmentTransaction5 = fragmentManager5.beginTransaction();
            Null fragment5 = new Null();
            fragmentTransaction5.replace(R.id.frame1, fragment5).commit();

        }

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            frag1 = (NuevaSede) getFragmentManager().findFragmentById(R.id.frame6);

            FragmentManager fragmentManager5 = getFragmentManager();
            FragmentTransaction fragmentTransaction5 = fragmentManager5.beginTransaction();
            Null fragment5 = new Null();
            fragmentTransaction5.replace(R.id.frame5, fragment5).commit();

        }
        frag1.retrieveInfoNuevaSede();
    }

    @Override
    public void onBackPressed() {

        FragmentManager fragmentManager1 = getFragmentManager();
        FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
        FragmentManager fragmentManager2 = getFragmentManager();
        FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            MargenSuperior fragment1 = new MargenSuperior();
            fragmentTransaction1.replace(R.id.frame1, fragment1).commit();
            Publicidad fragment2 = new Publicidad();
            fragmentTransaction2.replace(R.id.frame2, fragment2).commit();
        }

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            super.onBackPressed();
        }

    }

    @Override
    public void sendContent(String[] content) {
            manager.insertar(content[0], content[1], content[2]);
            Toast.makeText(this, "Agregado con éxito :", Toast.LENGTH_SHORT).show();
    }

}