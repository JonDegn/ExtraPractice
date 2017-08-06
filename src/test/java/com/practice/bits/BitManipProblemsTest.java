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

    @Test
    public void testFindComplement() {
        Assert.assertEquals(2, BitManipProblems.findComplement(5));
        Assert.assertEquals(0, BitManipProblems.findComplement(1));
        Assert.assertEquals(1, BitManipProblems.findComplement(2));
    }
}