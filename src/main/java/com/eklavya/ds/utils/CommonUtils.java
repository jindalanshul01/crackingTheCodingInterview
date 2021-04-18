package com.eklavya.ds.utils;

import java.util.Arrays;

public class CommonUtils {
    public static void printFormattedOutputResults (String input, String output, int testCaseNo){
        System.out.println("Test Case: "+testCaseNo);
        System.out.println("-----------------------------");
        System.out.println("Input: --> " + input);
        System.out.println("Output:--> " + output);
        System.out.println();
    }

    public static void printTestSuiteStart (){
        System.out.println();
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("| Test suite starts |");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println();
    }

    public static void printTestSuiteEnd (){
        System.out.println();
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("| Test suite ends |");
        System.out.println("-------------------------------------------------------------------------");
    }

    public static boolean isBlank(String str) {
        return (str == null || str.trim().isEmpty());
    }
}
