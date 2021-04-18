package com.eklavya.ds.array;

//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution,
// and you may not use the same element twice. You can return the answer in any order.

//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Output: Because nums[0] + nums[1] == 9, we return [0, 1].

// 7 -> 0, 2 -> 1, -2 -> 2, -6 -> 3

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TwoSum {

    //Idea is to maintain a HashMap, with key as the number and value its index.
    //We traverse through the array, one element at a time and get its complement by subtracting the
    //number from the target. We, then, look up for this complement on the hash map.
    //If the complement is found, we have our result and break out.
    public int[] twoSum(int[] nums, int target) {
        int[] resultIndices = {-1,-1};
        Map<Integer, Integer> complementMap = new HashMap<>();
        Integer complementIndex;
        int complement;
        for (int i=0; i<nums.length; i++) {
            complement = target - nums[i];

            if (Objects.nonNull(complementIndex = complementMap.get(complement))) {
                resultIndices[0] = i;
                resultIndices[1] = complementIndex;
                break;
            } else {
                complementMap.put(nums[i], i);
            }
        }
        return resultIndices;
    }

    public static void main(String[] args) {
        int[] testInput = {1,7,11,15,12,2};
        int testTarget = 9;
        int[] result;
        TwoSum test = new TwoSum();
        result = test.twoSum(testInput, testTarget);
        System.out.println(result[0] + ", " + result[1]);
    }
}

