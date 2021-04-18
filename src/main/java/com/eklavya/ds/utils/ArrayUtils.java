package com.eklavya.ds.utils;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayUtils {
    public static <E> String printArray (E[] input){
        //Null check
        if (null == input)
            return "null";

        //Empty Array check
        int iMax = input.length - 1;
        if (iMax == -1)
            return "[]";

        //Normal array elements print
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i=0; ; i++){
            sb.append(input[i]);
            if (i == iMax)
                return sb.append(']').toString();
            sb.append(", ");
        }
    }

    public static <T> T[] copyArray (T[] input){
        //Null check
        if (null == input)
            return null;

        //Empty Array check
        if (input.length == 0)
            return input;

        //Normal array copy
        Class inputClass = input.getClass();
        T[] copyArray = (inputClass == Object[].class)
                ? (T[]) new Object[input.length]
                : (T[]) Array.newInstance(inputClass.getComponentType(), input.length);
        for (int i=0; i<input.length; i++){
            copyArray[i] = input[i];
        }
        return copyArray;
    }

    public static <E> boolean nullOrEmpty (E[] input){
        boolean result = false;
        if (null == input || 0 == input.length){
            result = true;
        }
        return result;
    }
}
