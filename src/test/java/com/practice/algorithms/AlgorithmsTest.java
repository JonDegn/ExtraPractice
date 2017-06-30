package com.practice.algorithms;


import org.junit.Assert;
import org.junit.Test;

public class AlgorithmsTest {

    @Test
    public void TestTwoSum() {
        //Case 1
        int[] given = new int[]{2, 7, 11, 15};
        int target = 9;
        Assert.assertArrayEquals(new int[]{0, 1}, Algorithms.twoSum(given, target));
        //Case 2
        given = new int[]{3, 2, 4};
        target = 6;
        Assert.assertArrayEquals(new int[]{1, 2}, Algorithms.twoSum(given, target));
    }
}
