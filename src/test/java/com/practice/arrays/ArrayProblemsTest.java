package com.practice.arrays;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jonathondegn on 7/11/17.
 */
public class ArrayProblemsTest {
    @Test
    public void testRemoveElement() {
        int[] result = ArrayProblems.removeElement(new int[]{1, 4, 6, 5, 2, 3, 7, 1, 1}, 1);
        Assert.assertArrayEquals(new int[] {4,6,5,2,3,7}, result);
    }

}