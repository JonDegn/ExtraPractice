package com.practice.arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by jonathondegn on 7/11/17.
 */
public class ArrayProblemsTest {
    @Test
    public void testRemoveElement() {
        int[] result = ArrayProblems.removeElement(new int[]{1, 4, 6, 5, 2, 3, 7, 1, 1}, 1);
        Assert.assertArrayEquals(new int[]{4, 6, 5, 2, 3, 7}, result);
    }

    @Test
    public void testMoveZeroes() {
        int[] nums = {0, 1, 0, 3, 12};
        ArrayProblems.moveZeroes(nums);
        Assert.assertArrayEquals(new int[]{1, 3, 12, 0, 0}, nums);
    }

    @Test
    public void testSummaryRanges() {
        int[] nums = {0, 1, 2, 4, 5, 7};
        List<String> ranges = ArrayProblems.summaryRanges(nums);
        Assert.assertEquals("0->2", ranges.get(0));
        Assert.assertEquals("4->5", ranges.get(1));
        Assert.assertEquals("7", ranges.get(2));
    }

    @Test
    public void testMerge() {
        int[] a = {0, 1, 2, 4, 5, 7, 0, 0, 0, 0, 0, 0, 0};
        int[] b = {4, 5, 6, 7, 9, 10, 15};

        ArrayProblems.merge(a, 6, b, 7);
        Assert.assertArrayEquals(new int[]{0, 1, 2, 4, 4, 5, 5, 6, 7, 7, 9, 10, 15}, a);
    }

    @Test
    public void isUnique() {
        Assert.assertTrue(ArrayProblems.isUnique("asdfjkl"));
        Assert.assertFalse(ArrayProblems.isUnique("asdfjkdl"));
        Assert.assertTrue(ArrayProblems.isUnique(""));
        Assert.assertTrue(ArrayProblems.isUnique("a"));
        Assert.assertFalse(ArrayProblems.isUnique("aa"));
        Assert.assertTrue(ArrayProblems.isUnique(null));
    }

    @Test
    public void testRotateMatrix() {
        char[][] matrix = {
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'}};
        ArrayProblems.rotateMatrix(matrix);
        Assert.assertArrayEquals(new char[][]{
                {'g', 'd', 'a'},
                {'h', 'e', 'b'},
                {'i', 'f', 'c'}}, matrix);

        char[][] matrix2 = {
                {'a', 'b'},
                {'c', 'd'}};
        ArrayProblems.rotateMatrix(matrix2);
        Assert.assertArrayEquals(new char[][]{
                {'c', 'a'},
                {'d', 'b'}}, matrix2);
    }

    @Test
    public void testZeroMatrix() {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}};
        ArrayProblems.zeroMatrix(matrix);
        Assert.assertArrayEquals(new int[][]{
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}}, matrix);

        int[][] matrix2 = {
                {0, 1},
                {1, 0}};
        ArrayProblems.zeroMatrix(matrix2);
        Assert.assertArrayEquals(new int[][]{
                {0, 0},
                {0, 0}}, matrix2);
    }

    @Test
    public void testIntersection() {
        int[] result = ArrayProblems.intersection(new int[]{1, 2, 3, 4, 5, 6}, new int[]{-1, 2, 4, 6, 17});
        Assert.assertArrayEquals(new int[]{2, 4, 6}, result);
        result = ArrayProblems.intersection(new int[]{1, 3, 5}, new int[]{2, 4, 6});
        Assert.assertArrayEquals(new int[]{}, result);
    }

    @Test
    public void testIntersectionII() {
        int[] result = ArrayProblems.intersectionII(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        Assert.assertArrayEquals(new int[]{2, 2}, result);
    }

    @Test
    public void testSearchInsert() {
        Assert.assertEquals(2, ArrayProblems.searchInsert(new int[]{1, 3, 5, 6}, 5));
        Assert.assertEquals(1, ArrayProblems.searchInsert(new int[]{1, 3, 5, 6}, 2));
        Assert.assertEquals(4, ArrayProblems.searchInsert(new int[]{1, 3, 5, 6}, 7));
        Assert.assertEquals(0, ArrayProblems.searchInsert(new int[]{1, 3, 5, 6}, 0));
    }

    @Test
    public void testFindMedianSortedArrays() {
        Assert.assertEquals(2.5, ArrayProblems.findMedianSortedArrays(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4}), 0.05);
        Assert.assertEquals(5, ArrayProblems.findMedianSortedArrays(new int[]{5, 6, 7, 8, 9}, new int[]{1, 2, 3, 4}), 0.05);
        Assert.assertEquals(2.5, ArrayProblems.findMedianSortedArrays(new int[]{}, new int[]{1, 2, 3, 4}), 0.05);
    }

    @Test
    public void testArrayPairSum() {
        Assert.assertEquals(4, ArrayProblems.arrayPairSum(new int[]{1, 4, 3, 2}));
    }

    @Test
    public void testMatrixReshape() {
        int[][] matrix = new int[][]{new int[]{1, 2}, new int[]{3, 4}};
        int[][] result = new int[][]{new int[]{1, 2, 3, 4}};

        Assert.assertArrayEquals(result, ArrayProblems.matrixReshape(matrix, 1, 4));
        Assert.assertArrayEquals(matrix, ArrayProblems.matrixReshape(matrix, 2, 4));
    }

    @Test
    public void testIslandPerimeter() {
        int[][] island = new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        Assert.assertEquals(16, ArrayProblems.islandPerimeter(island));
    }

}