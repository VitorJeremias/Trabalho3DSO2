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
    }
}
