package com.practice.stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

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

    @Test
    public void testMyQueue() {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        Assert.assertEquals(3, queue.size());
        Assert.assertEquals(1, queue.dequeue().longValue());
        queue.enqueue(4);
        Assert.assertEquals(2, queue.peek().longValue());
        Assert.assertEquals(2, queue.dequeue().longValue());
        Assert.assertEquals(3, queue.dequeue().longValue());
        Assert.assertEquals(4, queue.dequeue().longValue());
    }

    @Test
    public void testSortStack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.push(4);
        StackProblems.sortStack(stack);
        Assert.assertEquals(1, stack.pop().longValue());
        Assert.assertEquals(2, stack.pop().longValue());
        Assert.assertEquals(3, stack.pop().longValue());
        Assert.assertEquals(4, stack.pop().longValue());
    }
}