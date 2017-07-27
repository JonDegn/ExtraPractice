package com.practice.algorithms;


import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Random;

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

    @Test
    public void testTwoSumIII() {
        Algorithms a = new Algorithms();

        Algorithms.TwoSum twoSum = a.new TwoSum();
        twoSum.add(2);
        twoSum.add(3);
        twoSum.add(4);
        twoSum.add(7);
        twoSum.add(11);
        twoSum.add(15);
        Assert.assertTrue(twoSum.find(9));
        Assert.assertTrue(twoSum.find(6));
        Assert.assertFalse(twoSum.find(1));
        Assert.assertFalse(twoSum.find(100));
        Assert.assertFalse(twoSum.find(8));
    }

    @Test
    public void testThreeSum() {
        List<List<Integer>> result = Algorithms.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        Assert.assertArrayEquals(new Integer[]{-1, -1, 2}, result.get(0).toArray());
        Assert.assertArrayEquals(new Integer[]{-1, 0, 1}, result.get(1).toArray());
    }

    @Test
    public void testGraph() {
        //not really a test, just prints results
        Random r = new Random();
        Algorithms.graph(() -> r.nextInt(6) + r.nextInt(6) + 2, 2, 12, 10000);
    }

    @Test
    public void testMorse() {
        //not really a test, just prints results
        List<String> results = Algorithms.morse(5, "");
        results.forEach(System.out::println);
    }

    @Test
    public void testFourSum() {
        List<List<Integer>> results = Algorithms.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        Assert.assertArrayEquals(new Integer[]{-2, -1, 1, 2}, results.get(0).toArray());
        Assert.assertArrayEquals(new Integer[]{-2, 0, 0, 2}, results.get(1).toArray());
        Assert.assertArrayEquals(new Integer[]{-1, 0, 0, 1}, results.get(2).toArray());
    }

    @Test
    public void testThreeSumClosest() {
        int result = Algorithms.threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
        Assert.assertEquals(2, result);

        result = Algorithms.threeSumClosest(new int[]{-1, 2, 1, -4}, 2);
        Assert.assertEquals(2, result);

        result = Algorithms.threeSumClosest(new int[]{-4, 0, 0, 0}, 0);
        Assert.assertEquals(0, result);
    }

    @Test
    public void testMinSubArrayLen() {
        int result = Algorithms.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
        Assert.assertEquals(2, result);

        result = Algorithms.minSubArrayLen(7, new int[]{2, 3, 1});
        Assert.assertEquals(0, result);

        result = Algorithms.minSubArrayLen(7, new int[]{1, 2, 1, 1, 1, 1, 1, 7});
        Assert.assertEquals(1, result);
    }

    @Test
    public void testRemoveDuplicates() {
        int[] result = Algorithms.removeDuplicates(new int[]{1, 1, 2});
        Assert.assertArrayEquals(new int[]{1, 2}, result);
    }

    @Test
    public void testRemoveDuplicatesII() {
        int[] result = Algorithms.removeDuplicatesII(new int[]{1, 1, 1, 2, 2, 5, 5, 5, 5, 5, 7, 8});
        Assert.assertArrayEquals(new int[]{1, 1, 2, 2, 5, 5, 7, 8}, result);
    }

    @Test
    public void testMaxArea() {
        int result = Algorithms.maxArea(new int[]{3, 5, 7, 5, 6, 5, 9, 5});
        Assert.assertEquals(30, result);
    }

    @Test
    public void testCandy() {
        // 1, 2, 3, 1, 2, 1, 3, 2, 1
        int result = Algorithms.candy(new int[]{3, 5, 7, 5, 6, 5, 9, 5, 4});
        Assert.assertEquals(1 + 2 + 3 + 1 + 2 + 1 + 3 + 2 + 1, result);

        // 1, 2, 3, 1, 1, 1, 2
        result = Algorithms.candy(new int[]{3, 5, 7, 5, 5, 5, 9});
        Assert.assertEquals(1 + 2 + 3 + 1 + 1 + 1 + 2, result);
    }

    @Test
    public void testTrap() {
        //       +
        //   +   ++ +
        // + ++ ++++++
        int result = Algorithms.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        Assert.assertEquals(6, result);
    }

    @Test
    public void testLargestPalindromeProduct() {
        Assert.assertEquals(9, Algorithms.largestPalindrome(1));
        Assert.assertEquals(987, Algorithms.largestPalindrome(2));
    }
}
