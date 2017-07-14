package com.practice.arrays;

import java.util.Arrays;

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
}
