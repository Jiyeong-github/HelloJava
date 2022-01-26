package dev;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapArray {

    Map<String, List<String>> map = new HashMap<String, List<String>>();

    public void putString(String key, String value){
        List<String> list = map.get(key);
        if(list == null){
            list = new ArrayList<String>();
            map.put(key, list);
        }
        list.add(value);
    }
}
