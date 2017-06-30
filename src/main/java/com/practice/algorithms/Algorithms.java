package com.practice.algorithms;

import java.util.HashMap;

/**
 * Created by jonathondegn on 6/29/17.
 */
public class Algorithms {

    // Two Sum
    //
    // Given an array of integers, return indices of the two numbers such that they add up to a specific target.
    // You may assume that each input would have exactly one solution, and you may not use the same element twice.
    //
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            } else {
                map.put(target - nums[i], i);
            }
        }
        return null;
    }

    // Two Sum II - Input array is sorted
    //
    // Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a
    // specific target number.
    // The function twoSum should return indices of the two numbers such that they add up to the target, where index1
    // must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
    // You may assume that each input would have exactly one solution and you may not use the same element twice.    //
    public static int[] twoSumII(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        do {
            if (i >= j) {
                return null;
            }
            if (nums[i] + nums[j] < target) {
                i++;
            }
            if (nums[i] + nums[j] > target) {
                j--;
            }
        } while (nums[i] + nums[j] != target);
        return new int[]{i + 1, j + 1};
    }
}
