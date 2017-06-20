package com.maykon.guiaturistico.modelo;

import com.maykon.guiaturistico.R;

import java.util.HashMap;

public class MapFotos {

    private static HashMap<String, Integer> map;

    public static HashMap<String, Integer> getMap(){
        if(map==null || map.isEmpty()){
            popularMap();
        }
        return map;
    }

    private static void popularMap(){
        map = new HashMap<>();

        map.put("1",R.drawable.n01bokas);
        map.put("2",R.drawable.n02bokas);
        map.put("3",R.drawable.n03meuescritorio);
        map.put("4",R.drawable.n04meuescritorio);
        map.put("5",R.drawable.n05servidores);
        map.put("6",R.drawable.n06servidores);
        map.put("7",R.drawable.n07cic);
        map.put("8",R.drawable.n08cic);
        map.put("9",R.drawable.n09teatro);
        map.put("10",R.drawable.n10teatro);
        map.put("11",R.drawable.n11mercado);
        map.put("12",R.drawable.n12mercado);
        map.put("13",R.drawable.n13ponte);
        map.put("14",R.drawable.n14ponte);
        map.put("15",R.drawable.n15praca);
        map.put("16",R.drawable.n16praca);
        map.put("17",R.drawable.n17joaquina);
        map.put("18",R.drawable.n18joaquina);
    }
}
