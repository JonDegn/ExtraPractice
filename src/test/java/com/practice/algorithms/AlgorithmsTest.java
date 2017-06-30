package com.practice.algorithms;


import com.practice.linkedlist.LinkedList;
import org.junit.Assert;
import org.junit.Test;

public class AlgorithmsTest {

    @Test
    public void testTwoSum() {
        //Case 1
        int[] given = new int[]{2, 7, 11, 15};
        int target = 9;
        Assert.assertArrayEquals(new int[]{0, 1}, Algorithms.twoSum(given, target));
        //Case 2
        given = new int[]{3, 2, 4};
        target = 6;
        Assert.assertArrayEquals(new int[]{1, 2}, Algorithms.twoSum(given, target));
    }

    @Test
    public void testTwoSumII() {
        //Case 1
        int[] given = new int[]{2, 7, 11, 15};
        int target = 9;
        Assert.assertArrayEquals(new int[]{1, 2}, Algorithms.twoSumII(given, target));
        //Case 2
        given = new int[]{2, 3, 4};
        target = 6;
        Assert.assertArrayEquals(new int[]{1, 3}, Algorithms.twoSumII(given, target));
    }
}
