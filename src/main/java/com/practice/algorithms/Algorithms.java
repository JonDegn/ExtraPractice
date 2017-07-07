package com.practice.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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

    // Two Sum III - Data structure design
    //
    // Design and implement a TwoSum class. It should support the following operations:
    // add and find.
    // add - Add the number to an internal data structure. find - Find if there exists any
    // pair of numbers which sum is equal to the value.
    public class TwoSum {
        HashMap<Integer, Integer> numbers = new HashMap<>();

        public void add(int num) {
            if (numbers.containsKey(num)) {
                numbers.put(num, numbers.get(num) + 1);
            } else {
                numbers.put(num, 1);
            }
        }

        public boolean find(int num) {
            for (int i : numbers.keySet()) {
                int target = num - i;
                if (numbers.containsKey(target)) {
                    if (i == target && numbers.get(target) < 2) {
                        continue;
                    }
                    return true;
                }
            }
            return false;
        }
    }

    // Three Sum
    //
    // Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
    // Find all unique triplets in the array which gives the sum of zero.
    // Note: Elements in a triplet (a,b,c) must be in non-descending order. (ie, a  b  c)
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (nums == null || nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] > nums[i - 1]) {
                int j = i + 1;
                int k = nums.length - 1;

                while (j < k) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        j++;
                        k--;

                        while (j < k && nums[j] == nums[j - 1])
                            j++;
                        while (j < k && nums[k] == nums[k + 1])
                            k--;
                    } else if (nums[i] + nums[j] + nums[k] < 0) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        }
        return result;
    }
    // O(n^2)
}
