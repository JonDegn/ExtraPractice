package com.practice.arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

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
        int[] nums = {0,1,2,4,5,7};
        List<String> ranges = ArrayProblems.summaryRanges(nums);
        Assert.assertEquals("0->2", ranges.get(0));
        Assert.assertEquals("4->5", ranges.get(1));
        Assert.assertEquals("7", ranges.get(2));
    }

}