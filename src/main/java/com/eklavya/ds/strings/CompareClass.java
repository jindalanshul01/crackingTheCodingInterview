package com.eklavya.ds.strings;

public class CompareClass {
    public static String compareStrings(String firstString, String secondString, String thirdString) {
        String s1 = null;
        String s2 = null;
        String s3 = null;
        if (firstString.compareTo(secondString) < 1 && firstString.compareTo(thirdString) < 1){
            s1 = firstString;
            if (secondString.compareTo(thirdString) < 1){
                s2=secondString;
                s3=thirdString;
            }else{
                s2=thirdString;
                s3=secondString;
            }
        }else if (secondString.compareTo(firstString) < 1 && secondString.compareTo(thirdString) < 1){
            s1 = secondString;
            if (firstString.compareTo(thirdString) < 1){
                s2=firstString;
                s3=thirdString;
            }else{
                s2=thirdString;
                s3=firstString;
            }
        }else{

            s1 = thirdString;
            if (firstString.compareTo(secondString) < 1){
                s2=firstString;

                s3=secondString;
            }else{

                s2=secondString;
                s3=firstString;
            }
        }
        return s1+s2+s3;
    }
}