package com.practice.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class ArrayProblems {

    //    Given an array and a value, remove all instances of that value in place and return the
    //    new length. (Note: The order of elements can be changed. It doesn’t matter what you
    //    leave beyond the new length.)
    //    Just returning new array
    public static int[] removeElement(int[] a, int elem) {
        int idxToReplace = 0, idxToScan = 0;

        while (idxToScan < a.length) {
            if (a[idxToScan] != elem) { // don't increment replacing index if it is equal to elem
                a[idxToReplace] = a[idxToScan];
                idxToReplace++;
            }
            idxToScan++;
        }
        return Arrays.copyOf(a, idxToReplace);
    }

    //    Given an array nums, write a function to move all 0’s to the end of it while maintaining
    //    the relative order of the non-zero elements.
    public static void moveZeroes(int[] nums) {
        int idxToScan = 0, idxToReplace = 0;

        while (idxToScan < nums.length) {
            if (nums[idxToScan] == 0) {
                idxToScan++;
            } else {
                nums[idxToReplace] = nums[idxToScan];
                idxToReplace++;
                idxToScan++;
            }
        }
        while (idxToReplace < nums.length) {
            nums[idxToReplace] = 0;
            idxToReplace++;
        }
    }

    //    Given a sorted integer array without duplicates, return the summary of its ranges for
    //    consecutive numbers
    public static List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();

        if (nums == null || nums.length < 1) {
            return ranges;
        }
        if (nums.length == 1) {
            ranges.add(nums[0] + "");
        }

        int rangeStart = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                if (i == nums.length - 1) {
                    ranges.add(nums[rangeStart] + "->" + nums[i]);
                }
            }
            if (nums[i] != nums[i - 1] + 1) {
                //add range to ranges
                if (i - rangeStart > 1) {
                    ranges.add(nums[rangeStart] + "->" + nums[i - 1]);
                } else {
                    ranges.add(nums[rangeStart] + "");
                }
                if (i == nums.length - 1) {
                    ranges.add(nums[i] + "");
                }
                rangeStart = i;
            }
        }

        return ranges;
    }
}
