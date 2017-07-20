package com.practice.arrays;

import java.util.*;

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

    //    Given two sorted integer arrays A and B, merge B into A as one sorted array.
    public static void merge(int a[], int m, int b[], int n) {
        while (m > 0 && n > 0) {
            if (a[m - 1] > b[n - 1]) {
                a[m + n - 1] = a[m - 1];
                m--;
            } else {
                a[m + n - 1] = b[n - 1];
                n--;
            }
        }
        while (n > 0) {
            a[m + n - 1] = b[n - 1];
            n--;
        }
    }

    //    Is Unique
    //    Determine if a string has all unique characters
    public static boolean isUnique(String s) {
        // O(n) using hashmap
        HashMap<Character, Integer> map = new HashMap<>();
        if (s == null || s.length() < 2) return true;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                return false;
            }
            map.put(s.charAt(i), 1);
        }
        return true;
        //--------
        // O(n) using bit (boolean) map. This expects ASCII characters only
//        boolean[] ascii = new boolean[256];
//        if (s == null || s.length() < 2) return true;
//        for (int i = 0; i < s.length(); i++) {
//            if (ascii[s.charAt(i)]) return false;
//            ascii[s.charAt(i)] = true;
//        }
//        return true;

        //--------
        // O(n log n)  Sorting string, then looping through
//        if (s == null || s.length() < 2) return true;
//        char[] chars = s.toCharArray();
//        Arrays.sort(chars);
//        for (int i = 1; i < chars.length; i++) {
//            if (chars[i] == chars[i - 1]) {
//                return false;
//            }
//        }
//        return true;
    }

    //   rotate a matrix in place
    public static void rotateMatrix(char[][] matrix) {
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix.length - 1;
        while (top < bottom && left < right) {
            for (int i = 0; i <= (right - left) / 2; i++) {
                char temp = matrix[bottom - i][left];
                matrix[bottom - i][left] = matrix[bottom][right - i];
                matrix[bottom][right - i] = matrix[top + i][right];
                matrix[top + i][right] = matrix[top][left + i];
                matrix[top][left + i] = temp;
            }
            top++;
            bottom--;
            left++;
            right--;
        }
    }
}
