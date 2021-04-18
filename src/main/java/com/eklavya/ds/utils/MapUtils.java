package com.eklavya.ds.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapUtils {
    public static Map <String, Integer> getStringIntegerHashMap(){
        Map<String, Integer> stringIntegerMap = new HashMap<>(16);
        stringIntegerMap.put("Rajesh", 23);
        stringIntegerMap.put("Prakash", 45);
        stringIntegerMap.put("Mohan", 17);
        stringIntegerMap.put("Suresh", 31);
        stringIntegerMap.put("Pranjul", 25);
        return stringIntegerMap;
    }

    public static Map<String, String> getStringStringHashMap(){
        Map<String, String> stringStringMap = new HashMap<>(16);

        stringStringMap.put("E","Fun");
        stringStringMap.put("A","Daa");
        stringStringMap.put("B","Dbc");
        stringStringMap.put("C","Daaa");
        stringStringMap.put("D","Eef");

        return stringStringMap;
    }
}
