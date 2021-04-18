package com.eklavya.ds.strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StringComparator {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("One", "Two", "Three", "Twenty two", "Twenty");
        Collections.sort(list, stringComparator);
        System.out.println(list);
    }

    public static Comparator <String> stringComparator = (s1, s2) -> {
        int maxLengthToTraverse = Math.min(s1.length(),s2.length());
        for (int i=0; i<maxLengthToTraverse; i++){
             if (s1.charAt(i) == s2.charAt(i))
                 continue;
             if (s1.charAt(i) < s2.charAt(i)){
                 return -1;
             }else{
                 return 1;
             }
        }
        return s1.length() < s2.length() ? 1 : -1;
    };
}