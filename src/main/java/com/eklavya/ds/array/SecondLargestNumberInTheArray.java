package com.eklavya.ds.array;

/*
 * Problem Statement:
 * -------------------
 *
 * Given an array of int, identify the second largest element in the array. E.g.
 * int[] input1 = [2,3,4,1,0,10] ------> 2nd largest element = 4
 */

import com.eklavya.ds.utils.ArrayUtils;
import com.eklavya.ds.utils.CommonUtils;
import com.eklavya.ds.utils.TestInputsUtils;

import java.util.Arrays;
import java.util.List;

public class SecondLargestNumberInTheArray {

    /*
     * Solution
     * -----------
     * Maintain two int placeholders - one to store max value and the other to store second max.
     * Traverse through the array and for each element check if:
     *      1)  current element > second max
     *              if yes, check if it is greater than max as well.
     *                  if yes, secondMax = max and max = current element.
     *              else
     *                  secondMax = current element
     *
     * Time Complexity: O(n)
     *       We need to traverse the complete array.
     *       Hence linear.
     * Space Complexity: O(1)
     *       We are maintaining two references - max and secondMax.
     *       Hence constant time.
     */
    public static Integer findSecondLargestElementInArray (Integer[] input){

        if (ArrayUtils.nullOrEmpty(input))
            return null;

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int i=0; i<input.length; i++){
            if (input[i] > max2){
                if (input[i] > max1){
                    max2 = max1;
                    max1 = input[i];
                }else{
                    max2 = input[i];
                }
            }
        }
         return max2;
    }

    public static void main(String[] args) {
        //Get test input int arrays which cover as much scenarios as possible.
        List<Integer []> testInputs = TestInputsUtils.getTestIntegerArrays();
        int counter = 1;
        Integer output;

        CommonUtils.printTestSuiteStart();
        for (Integer[] input : testInputs){
            output = findSecondLargestElementInArray(input);
            CommonUtils.printFormattedOutputResults(Arrays.toString(input), output == null? "null" : output.toString(), counter);
            counter ++;
        }
        CommonUtils.printTestSuiteEnd();
    }
}
