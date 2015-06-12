package com.example.daniel.burgerking;

import android.app.Fragment;
import android.database.Cursor;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import static com.google.android.gms.common.api.GoogleApiClient.Builder;

public class Sedes extends Fragment {

    private GoogleMap map;
    private CameraUpdate cameraUpdate;

    private GoogleApiClient mGoogleApiClient;
    private Location mLastLocation;
    private LocationRequest mLocationRequest;
    private LatLng currentLocation;

    private boolean newLocationReady = false;

    DataBaseManager manager = MainActivity.getManager();
    private Cursor   cursor;
    private ListView lista;
    private TextView sede;
    private TextView latitud;
    private TextView longitud;
    private SimpleCursorAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sedes, container,false);

        lista = (ListView) rootView.findViewById(R.id.listaSedes);
        String[] from = new String[]{manager.CN_NAME,manager.CN_LAT,manager.CN_LON};
        int[] to = new int[]{R.id.nuevaSedeT,R.id.latitudT,R.id.longitudT};

        cursor = manager.cargarCursorContactos();
        adapter = new SimpleCursorAdapter(getActivity(),R.layout.list_item,cursor,from,to);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                sede =(TextView)view.findViewById(R.id.nuevaSedeT);
                String s1 = sede.getText().toString();
                latitud =(TextView)view.findViewById(R.id.latitudT);
                String s2 = latitud.getText().toString();
                Double lat = Double.parseDouble(s2);
                longitud =(TextView)view.findViewById(R.id.longitudT);
                String s3 = longitud.getText().toString();
                Double lon = Double.parseDouble(s3);

                LatLng Slatlon = new LatLng(lat,lon);

                map = ((MapFragment)getFragmentManager().findFragmentById(R.id.map)).getMap();
                map.addMarker(new MarkerOptions().position(Slatlon).title(s1).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

                map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                cameraUpdate = CameraUpdateFactory.newLatLngZoom(Slatlon, 16);
                map.animateCamera(cameraUpdate);

                //buildGoogleApiclient();
               //createLocationRequest();
            }
        });

        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                latitud =(TextView)view.findViewById(R.id.latitudT);
                String s4 = latitud.getText().toString();
                manager.eliminar_latitud(s4);

                Toast.makeText(getActivity(),"Borrado :",Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        return rootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        MapFragment f = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        if (f != null){
            getFragmentManager().beginTransaction().remove(f).commit();
        }
    }

    public void retrieveInfoSedes(){

    }

    public void receiveData2Sedes(String[] content){
        //Toast.makeText(getActivity(),"Llegó contenido :",Toast.LENGTH_SHORT).show();
    }

}