package com.eklavya.problems;

import java.util.*;

public class GetMaxOccurrencesOfSubstring {
    String inputString = "abcde";
    private static int minLength = 2;
    private static int maxLength = 4;
    private static int maxOccurrence = 26;

    //Create all distinct substrings and find the one with maximum recurrences.
    public static int findMaxRecurrenceCount(String inputString){
        Map<String, Integer> stringMap = new HashMap<>();
        String substring = null;
        int value = 0;
        for (int i=0; i<= inputString.length(); i++){
            for (int j=i+1; j<inputString.length(); j++){
                substring = inputString.substring(i,j);
                //Add only substrings where minlength and maxlength conditions are met.
                if (substring.length() >= minLength && substring.length() <= maxLength){
                    if (stringMap.containsKey(substring)){
                        value = stringMap.get(substring);
                        stringMap.put(substring, ++value);
                    }else{
                        stringMap.put(substring,1);
                    }
                }
            }
        }

        //Get max value.
        Optional<Map.Entry<String, Integer>> maxEntry = stringMap.entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue)
                );

        return maxEntry.get().getValue();
    }


}
