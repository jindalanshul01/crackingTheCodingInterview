package com.eklavya.ds.array;

/*
 * Problem Statement:
 * -------------------
 *
 * Given an array of integers, rearrange the array elements such that
 * all even numbers are on the left hand side and all odd on the right.
 * E.g.
 * Input  --> [3,4,9,12,2,9,7]
 * Output --> [2,4,12,9,3,9,7]
 * Ordering doesn't matter as long as primary requirement is fulfilled.
 * Algorithm should be O(n) time complexity and O(1) space complexity
 */

import com.eklavya.ds.utils.ArrayUtils;
import com.eklavya.ds.utils.CommonUtils;
import com.eklavya.ds.utils.TestInputsUtils;

import java.util.Arrays;
import java.util.List;

public class ArrangeEvenAndOddNumbersInArray {

    /*
    * Maintain two index locations, left and right.
    * left is initialized with the first element in the array
    * right is initialized with the last element in the array
    * Traverse the array from left to right, checking at each left location
    *   1) If the value is even, then move forward.
    *   2) If the value is odd, then replace with the rightmost even number.
    *   3) Continue steps 1 and 2 until left and right are equal.
    *
    * Time Complexity: O(n)
    *       We need just one pass of the array to be able to rearrange
    *       all evens towards left and all odds towards right. Hence linear.
    * Space Complexity: O(1)
    *       We need only 3 variables - left, right and temp. Hence constant.
    */
    public static Integer[] arrangeEvenAndOddNumbersInArray(Integer[] input){

        // Null and empty check.
        if (null == input || input.length == 0){
            return input;
        }

        int left = 0;
        int right = input.length-1;
        int temp = 0;

        while(left < right){
            /* If element is even, then move forward. Else, need to swap it with the rightmost odd element*/
            if (input[left] % 2 == 0){
                left ++;
            }else{
                /* Keep on decrementing 'right' until one of the following conditions are met:
                *   1) find an even number which needs to be swapped with corresponding odd number on its left
                *   2) 'right' < 'left'
                * */
                while ( (input[right] % 2 != 0) && (right > left) ){
                    right --;
                }
                if (input[right] % 2 == 0){
                    temp = input[left];
                    input[left] = input [right];
                    input[right] = temp;
                    left ++;
                    right --;
                }
            }
        }
        return input;
    }

    public static void main(String[] args) {
        List<Integer[]> testInputs = TestInputsUtils.getTestIntegerArrays(); //Get test inputs which cover different scenarios
        Integer[] inputCopy = null;
        Integer[] output = null;
        int counter = 1;

        CommonUtils.printTestSuiteStart();
        for (Integer[] input : testInputs){
            inputCopy = ArrayUtils.copyArray(input);  //Create an array copy of original.
            output = arrangeEvenAndOddNumbersInArray(input); //Holds state of array after in place modifications are done to input array
            CommonUtils.printFormattedOutputResults(Arrays.toString(inputCopy), Arrays.toString(output), counter);
            counter ++;
        }
        CommonUtils.printTestSuiteEnd();
    }
}