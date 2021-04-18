package com.eklavya.ds.utils;

import java.util.ArrayList;
import java.util.List;

public class TestInputsUtils {

    public static List<String> getTestStringList(){
        List<String> list = new ArrayList<>(10);
        list.add(null);
        list.add("");
        list.add("    ");
        list.add("abc(qw{hg})");
        list.add("xyz[pqr{}(zab)");
        list.add(")))))");
        list.add("((()))");
        list.add("(((");
        list.add("[");
        return list;
    }

    public static List<Integer []> getTestIntegerArrays(){
        List<Integer []> list = new ArrayList<>(10);
        list.add(null); //null
        list.add(new Integer[] {}); //empty array
        list.add(new Integer[] {11,2,33,4,0}); //random array of positive integers
        list.add(new Integer[] {-1,-2,13,40,0,0,-7}); //random array of positive and negative integers
        list.add(new Integer[] {2,4,6,8,10,12,4}); //only even numbers
        list.add(new Integer[] {1,3,9,11,3,5,33,7}); //only odd numbers
        list.add(new Integer[] {2,3,8,11,6,5,38,19}); //random array with alternating even odd sequence
        list.add(new Integer[] {2,3,8,11,8,3,2}); //palindrome array - odd numbered
        list.add(new Integer[] {2,3,3,2}); //palindrome array - even numbered
        return list;
    }

    public static List<Integer []> getTestIntegerArraysWithDuplicatedValues(){
        List<Integer []> list = new ArrayList<>(10);
        list.add(null); //null
        list.add(new Integer[] {}); //empty array
        list.add(new Integer[] {11,22,11,22}); //All duplicates. No anomaly
        list.add(new Integer[] {-1,-1,-2,-2,10,10}); //Duplicates are -ves and 0s
        list.add(new Integer[] {22,22,6,6,10,10,4}); //Positive case scenario and just one non-duplicate
        list.add(new Integer[] {11,11,11,11,33,5,33,7}); //Two non-duplicate numbers
        return list;
    }

    public static List<Node> getTestLists(){
        List<Node> list = new ArrayList<>(10);
        list.add(null); //null list
        list.add(LinkedListUtils.randomListWithNodes(1)); //list with just one node
        list.add(LinkedListUtils.randomListWithNodes(5)); //list with odd number of nodes
        list.add(LinkedListUtils.randomListWithNodes(6)); //list with even number of nodes
        list.add(LinkedListUtils.randomListWithNodes(7)); //random list
        list.add(LinkedListUtils.randomListWithNodes(2)); //random list
        list.add(LinkedListUtils.randomListWithNodes(3)); //random list
        return list;
    }

    public static List<String> getTestBinaryStringList(){
        List<String> list = new ArrayList<>(10);
        list.add(null);
        list.add("");
        list.add("    ");
        list.add("111111111");
        list.add("00000000");
        list.add("10101010");
        list.add("11110000");
        list.add("11010101");
        list.add("0101010100");
        return list;
    }
}