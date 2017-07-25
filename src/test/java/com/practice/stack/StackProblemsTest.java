package com.practice.stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jonathondegn on 7/24/17.
 */
public class StackProblemsTest {
    @Test
    public void testSetOfStacks() {
        SetOfStacks<Integer> stacks = new SetOfStacks<>(2);
        stacks.push(1);
        stacks.push(2);
        stacks.push(3);
        Assert.assertEquals(3, stacks.pop().longValue());
        Assert.assertEquals(2, stacks.pop().longValue());
        Assert.assertEquals(1, stacks.pop().longValue());
        stacks.push(1);
        stacks.push(2);
        stacks.push(3);
        Assert.assertEquals(2, stacks.popAt(0).longValue());
        Assert.assertEquals(3, stacks.pop().longValue());
        Assert.assertEquals(1, stacks.pop().longValue());

    }
}