package com.example.daniel.burgerking;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Promociones extends Fragment {

    private String[] MenuCombos;
    private String[] MenuEnsaladas;
    private String[] MenuWraps;
    private String[] MenuPrecio;

    int[] flags = new int[]{
            R.drawable.logo,
            R.drawable.logo,
            R.drawable.logo,
            R.drawable.logo
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        MenuWraps     = new String[]{"Mexicano Crispy","Mexicano Grill","Cesar Crispy","Cesar Grill"};
        MenuCombos    = new String[]{"Tender Grill","BK Stacker","Whopper","Nugget"};
        MenuEnsaladas = new String[]{"Mexicana Crispy","Mexicana Grill","Cesar Crispy","Cesar Grill"};
        MenuPrecio    = new String[]{"$13,500","$16,900","$16,900","$17,900"};

        List<HashMap<String,String>> aListCombos = new ArrayList<HashMap<String,String>>();
        List<HashMap<String,String>> aListEnsaladas = new ArrayList<HashMap<String,String>>();
        List<HashMap<String,String>> aListWraps = new ArrayList<HashMap<String,String>>();

        for(int i=0;i<4;i++){
            int j=i+1;
            HashMap<String, String> hmCombos = new HashMap<String,String>();
            hmCombos.put("Combos", "Combo "+j+": "  + MenuCombos[i]);
            hmCombos.put("Precios","Precio : "    + MenuPrecio[i]);
            hmCombos.put("flag", Integer.toString (flags[i]) );
            aListCombos.add(hmCombos);
        }

        for(int i=0;i<4;i++){
            int j=i+1;
            HashMap<String, String> hmEnsaladas = new HashMap<String,String>();
            hmEnsaladas.put("Combos", "Ensalada "+j+": "  + MenuEnsaladas[i]);
            hmEnsaladas.put("Precios","Precio : "    + MenuPrecio[i]);
            hmEnsaladas.put("flag", Integer.toString (flags[i]) );
            aListEnsaladas.add(hmEnsaladas);
        }

        for(int i=0;i<4;i++){
            int j=i+1;
            HashMap<String, String> hmWraps = new HashMap<String,String>();
            hmWraps.put("Combos", "Wrap "+j+": "  + MenuWraps[i]);
            hmWraps.put("Precios","Precio : "    + MenuPrecio[i]);
            hmWraps.put("flag", Integer.toString (flags[i]) );
            aListWraps.add(hmWraps);
        }

        String[] from = { "flag","Combos","Precios" };
        int[] to = {R.id.flag, R.id.Combos,R.id.Ensaladas};

        View v = inflater.inflate(R.layout.fragment_promociones, container,false);
        ListView listCombos    = (ListView)v.findViewById(R.id.listViewCombos);
        ListView listEnsaladas = (ListView)v.findViewById(R.id.listViewEnsaladas);
        ListView listWraps     = (ListView)v.findViewById(R.id.listViewWraps);
        SimpleAdapter adapterWraps     = new SimpleAdapter(getActivity().getBaseContext(), aListWraps, R.layout.listview_layout, from, to);
        SimpleAdapter adapterCombos    = new SimpleAdapter(getActivity().getBaseContext(), aListCombos, R.layout.listview_layout, from, to);
        SimpleAdapter adapterEnsaladas = new SimpleAdapter(getActivity().getBaseContext(), aListEnsaladas, R.layout.listview_layout, from, to);
        listCombos.setAdapter(adapterCombos);
        listEnsaladas.setAdapter(adapterEnsaladas);
        listWraps.setAdapter(adapterWraps);
        return v;

    }

}