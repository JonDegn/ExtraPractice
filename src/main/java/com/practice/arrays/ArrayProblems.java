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

    //   given a matrix MxN, if an element is 0, set its row and column to 0
    public static void zeroMatrix(int[][] matrix) {
//        Map<Integer,Boolean> rows = new HashMap<>(matrix.length);
//        Map<Integer,Boolean> cols = new HashMap<>(matrix[0].length);
//
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                if (matrix[i][j] == 0) {
//                    rows.put(i,true);
//                    cols.put(j,true);
//                    break;
//                }
//            }
//        }
//
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                if (rows.containsKey(i) || cols.containsKey(j)) {
//                    matrix[i][j] = 0;
//                }
//            }
//        }

        // time: O(mn) Space: O(mn)
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                    break;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    //    Given two arrays, write a function to compute their intersection.
    public static int[] intersection(int[] a1, int[] a2) {
        HashSet<Integer> set = new HashSet<>(a1.length);
        for (int i : a1) {
            set.add(i);
        }
        HashSet<Integer> set2 = new HashSet<>(a2.length);
        for (int i : a2) {
            if (set.contains(i)) {
                set2.add(i);
            }
        }
        int[] intersection = new int[set2.size()];
        int idx = 0;
        for (int i : set2) {
            intersection[idx++] = i;
        }
        return intersection;
    }

    //    Given two arrays, write a function to compute their intersection. arrays contain duplicates
    public static int[] intersectionII(int[] a1, int[] a2) {
        Map<Integer, Integer> map = new HashMap<>(a1.length);
        for (int i : a1) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i : a2) {
            if (map.containsKey(i)) {
                if (map.get(i) > 1) {
                    map.put(i, map.get(i) - 1);
                } else {
                    map.remove(i);
                }
                list.add(i);
            }
        }
        int[] intersection = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            intersection[i] = list.get(i);
        }
        return intersection;
    }

    //    Given a sorted array and a target value, return the index if the target is found. If not,
    //    return the index where it would be if it were inserted in order. You may assume no
    //    duplicates in the array
    public static int searchInsert(int[] a, int target) {
        int i = 0;
        int j = a.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (target > a[mid]) {
                i = mid + 1;
            } else if (target < a[mid]) {
                j = mid - 1;
            } else {
                return mid;
            }
        }
        return i;
    }

    //    There are two sorted arrays A and B of size m and n respectively. Find the median of the
    //    two sorted arrays. The overall run time complexity should be O(log (m+n)).
    public static double findMedianSortedArrays(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;

        if ((m + n) % 2 != 0) {
            return (double) findKth(a, b, (m + n) / 2, 0, m - 1, 0, n - 1);
        } else {
            return (findKth(a, b, (m + n) / 2, 0, m - 1, 0, n - 1)
                    + findKth(a, b, (m + n) / 2 - 1, 0, m - 1, 0, n - 1)) * 0.5;
        }

    }

    private static int findKth(int a[], int[] b, int k, int aStart, int aEnd, int bStart, int bEnd) {
        int aLen = aEnd - aStart + 1;
        int bLen = bEnd - bStart + 1;

        if (aLen == 0)
            return b[bStart + k];
        if (bLen == 0)
            return a[aStart + k];
        if (k == 0)
            return a[aStart] < b[bStart] ? a[aStart] : b[bStart];

        int aMid = aLen * k / (aLen + bLen);
        int bMid = k - aMid - 1;

        aMid = aMid + aStart;
        bMid = bMid + bStart;

        if (a[aMid] > b[bMid]) {
            k = k - (bMid - bStart + 1);
            aEnd = aMid;
            bStart = bMid + 1;
        } else {
            k = k - (aMid - aStart + 1);
            bEnd = bMid;
            aStart = aMid + 1;
        }
        return findKth(a, b, k, aStart, aEnd, bStart, bEnd);
    }

    //    https://leetcode.com/problems/array-partition-i/description/
    //    Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1),
    //    (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
    static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i += 2) {
            result += (Math.min(nums[i], nums[i + 1]));
        }
        return result;
    }

    //    https://leetcode.com/problems/reshape-the-matrix/description/
    //    You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing
    //    the row number and column number of the wanted reshaped matrix, respectively.
    //    The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing
    //    order as they were.
    //    If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix;
    //    Otherwise, output the original matrix.
    static int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length == 0 || nums.length * nums[0].length != r * c) return nums;
        int[][] newMatrix = new int[r][c];
        int rows = 0, cols = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                newMatrix[rows][cols] = nums[i][j];
                cols++;
                if (cols == c) {
                    rows++;
                    cols = 0;
                }
            }
        }
        return newMatrix;
    }

    //    https://leetcode.com/problems/island-perimeter/description/
    //    You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
    //    Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water,
    //    and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes"
    //    (water inside that isn't connected to the water around the island). One cell is a square with side length 1.
    //    The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
    static int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    perimeter += 4;
                    if (i > 0 && grid[i - 1][j] == 1) perimeter -= 2;
                    if (j > 0 && grid[i][j - 1] == 1) perimeter -= 2;
                }
            }
        }
        return perimeter;
    }

    //    https://leetcode.com/problems/next-greater-element-i/description/
    //    You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2.
    //    Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
    //    The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does
    //    not exist, output -1 for this number.
    static int[] nextGreaterElement(int[] findNums, int[] nums) {
        // Brute Force O(n^2)
//        Map<Integer, Integer> numIndices = new HashMap<>();
//
//        for (int i = 0; i < nums.length; i++) {
//            numIndices.put(nums[i], i);
//        }
//        for (int i = 0; i < findNums.length; i++) {
//            int num = findNums[i];
//            findNums[i] = -1;
//            for (int j = numIndices.get(num); j < nums.length; j++) {
//                if (nums[j] > num){
//                    findNums[i] = nums[j];
//                    break;
//                }
//            }
//        }
//        return findNums;

        // O(n)
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        for (int i = 0; i < findNums.length; i++) {
            findNums[i] = map.getOrDefault(findNums[i], -1);
        }
        return findNums;
    }

    //    https://leetcode.com/problems/single-number/description/
    //    Given an array of integers, every element appears twice except for one. Find that single one
    static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;

//        if (nums.length == 1) return nums[0];
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length; i += 2) {
//            if (nums[i] != nums[i + 1]) return nums[i];
//        }
//        return -1;
    }

    //    https://leetcode.com/problems/max-consecutive-ones/description/
    //    Given a binary array, find the maximum number of consecutive 1s in this array.
    static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int curRun = 0;
        for (int i : nums) {
            if (i == 0) {
                max = Math.max(max, curRun);
                curRun = 0;
            } else {
                curRun++;
            }
        }
        return Math.max(max, curRun);
    }

    //    https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
    //    Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
    //    Find all the elements of [1, n] inclusive that do not appear in this array.
    static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>(nums.length);
        boolean[] found = new boolean[nums.length];
        for (int i : nums) {
            found[i-1] = true;
        }
        for (int i = 0; i < found.length; i++) {
            if(!found[i])
                result.add(i+1);
        }
        return result;
    }
}
