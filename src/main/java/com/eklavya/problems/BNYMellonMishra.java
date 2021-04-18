package com.eklavya.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class BNYMellonMishra {
    private List input1 = Arrays.asList(10,20,5,30,4,20,60);
    private List input2 = Arrays.asList(40,8,6,22,9,7,50);

    public static List<Integer> updateList(List<Integer> list){
        //Handling null case and other edge cases.
        if (null == list || list.size() <= 1){
            System.out.println("List can't be reduced further");
            return list;
        }

        List<Integer> reducedList = new ArrayList<>(list.size());
        reducedList.add(list.get(0));
        for (int i=1; i<=list.size() - 2; i++){
            if (list.get(i-1) > list.get(i) && list.get(i+1) > list.get(i)){
                continue;
            }else{
                reducedList.add(list.get(i));
            }
        }

        reducedList.add(list.get(list.size()-1));
        int reducedCount = reducedList.size();
        int originalCount = list.size();
        list = reducedList;
        if (reducedCount < originalCount){
            updateList (list);
        }
        return reducedList;
    }

    public static void main(String[] args) {
        System.out.println(new BNYMellonMishra().input1);
        System.out.println(updateList(new BNYMellonMishra().input1));
    }
}