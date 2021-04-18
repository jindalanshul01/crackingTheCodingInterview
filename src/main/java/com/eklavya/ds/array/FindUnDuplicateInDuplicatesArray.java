package com.eklavya.ds.array;

import com.eklavya.ds.utils.ArrayUtils;
import com.eklavya.ds.utils.CommonUtils;
import com.eklavya.ds.utils.TestInputsUtils;

import java.util.Arrays;
import java.util.List;

/*
 * Problem Statement:
 * -------------------
 *
 * Given an array of duplicate integers, find an element that does not have
 * a duplicate. It is known that there is just one such element.
 * E.g.
 * Input  --> [3,3,12,12,2,9,9]
 * Output --> 2
 * Algorithm should be O(n) time complexity and O(1) space complexity
 */
public class FindUnDuplicateInDuplicatesArray {

    /* We are going to make use of XOR operator which has a property such that a number n
    * n ^ n == 0
    * n ^ 0 == n
    * We XOR all elements in the array and since all but one elements are duplicates, we
    * get the result as element which is not.
    *
    * Time Complexity: O(n)
    *       We need just one pass of the array to be able to identify un-duplicated number.
    *       Hence linear.
    * Space Complexity: O(1)
    *       We need only 1 variable1 to store result.
    *       Hence constant.
    */
    public static int findUnDuplicateInArrayOfDuplicates(Integer[] arrayOfDuplicates){
        int result = 0;

        //Null check
        if (null == arrayOfDuplicates || arrayOfDuplicates.length == 0)
            return result;

        for (int i=0; i<arrayOfDuplicates.length; i++){
            result = result ^ arrayOfDuplicates[i];
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer[]> testInputs = TestInputsUtils.getTestIntegerArraysWithDuplicatedValues(); //Get test inputs which cover different scenarios
        Integer[] inputCopy = null;
        Integer output = 0;
        int counter = 1;

        CommonUtils.printTestSuiteStart();
        for (Integer[] input : testInputs){
            inputCopy = ArrayUtils.copyArray(input);  //Create an array copy of original.
            output = findUnDuplicateInArrayOfDuplicates(input); //Holds state of array after in place modifications are done to input array
            CommonUtils.printFormattedOutputResults(Arrays.toString(inputCopy), output.toString(), counter);
            counter ++;
        }
        CommonUtils.printTestSuiteEnd();
    }
}
