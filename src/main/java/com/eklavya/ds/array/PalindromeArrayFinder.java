package com.eklavya.ds.array;

/*
 * Problem Statement:
 * -------------------
 *
 * Given an array, identify if it is palindrome or not. E.g.
 * int[] input1 = [2,3,4,1,4,3,2] ------> is palindrome
 * int[] input1 = [1,2,2,1] ------> is palindrome
 * int[] input1 = [1,2,2,3] ------> is NOT a palindrome
 */

import com.eklavya.ds.utils.CommonUtils;
import com.eklavya.ds.utils.TestInputsUtils;

import java.util.Arrays;
import java.util.List;

public class PalindromeArrayFinder {

    /*
     * Solution
     * -----------
     * Essentially we need to compare first element with last, second with second last
     * and hence forth until we reach the middle. If we have successfully, then we have
     * a palindrome array. Here is how we are going to achieve this:
     *
     * Maintain two references 'forward', 'backward' such that:
     * 'forward' - starts from index 0 and moves forward, one step at a time
     * 'backward'- starts from index (length - 1) and moves backwards, one step at a time
     * At each step compare if the values are equal. If yes, then proceed otherwise return false.
     *
     * Time Complexity: O(n)
     *       We need to traverse the array for just half of its length (until mid point).
     *       Hence linear.
     * Space Complexity: O(1)
     *       We are maintaining two references
     *       Hence constant time.
     */
    public static boolean isArrayPalindrome (Integer[] inputArray){

        //Array null or empty.
        if (null == inputArray || inputArray.length == 0){
            return true;
        }

        int forward = 0;
        int backward = inputArray.length - 1;

        while (forward < backward){
            if (inputArray[forward] != inputArray[backward]){
                return false;
            }
            forward++;
            backward--;
        }
        return true;
    }

    public static void main(String[] args) {
        //Get test input int arrays which cover as much scenarios as possible.
        List<Integer []> testInputs = TestInputsUtils.getTestIntegerArrays();
        int counter = 1;
        Boolean output = false;

        CommonUtils.printTestSuiteStart();
        for (Integer[] input : testInputs){
            output = isArrayPalindrome(input);
            CommonUtils.printFormattedOutputResults(Arrays.toString(input), output.toString(), counter);
            counter ++;
        }
        CommonUtils.printTestSuiteEnd();
    }
}
