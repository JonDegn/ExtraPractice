package com.practice.bits;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jonathondegn on 8/5/17.
 */
public class BitManipProblemsTest {

    @Test
    public void testHammingDistance() {
        Assert.assertEquals(2, BitManipProblems.hammingDistance(1, 4));
    }
}