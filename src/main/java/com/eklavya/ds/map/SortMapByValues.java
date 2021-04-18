package com.eklavya.ds.map;

import com.eklavya.ds.utils.MapUtils;

import java.util.*;

public class SortMapByValues {

    public static void main(String[] args) {
        demoSortHashMapByValues();
    }

    public static HashMap<String, Integer> sortByValues (Map<String, Integer> origMap){
        HashMap<String, Integer> sortedMapByValues = new LinkedHashMap<>();

        //Get all map entries into a linked list.
        List<Map.Entry<String, Integer>> mapEntriesList = new LinkedList<>(origMap.entrySet());
        //Sort the list of map entries using a custom comparator.
        Collections.sort(mapEntriesList, Comparator.comparing(Map.Entry::getValue));
        //List sorted, store all entries into a LinkedHashMap and return.
        for (Map.Entry<String, Integer> entry : mapEntriesList) {
            sortedMapByValues.put(entry.getKey(), entry.getValue());
        }
        return sortedMapByValues;
    }

    public static void demoSortHashMapByValues(){
        Map<String, Integer> origMap = MapUtils.getStringIntegerHashMap();
        System.out.println("Original Map:");
        System.out.println(origMap);
        Map<String, Integer> sortedByValueMap = sortByValues(origMap);
        System.out.println("Sorted By Values Map: ");
        System.out.println(sortedByValueMap);
    }
}
