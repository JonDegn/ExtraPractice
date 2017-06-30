package com.practice.linkedlist;

import com.practice.algorithms.Algorithms;
import org.junit.Assert;
import org.junit.Test;

public class LinkedListTest {
    @Test
    public void testAddTwoNumbers() {
        //Case 1
        ListNode ones1 = new ListNode(2);
        ListNode tens1 = new ListNode(4);
        ListNode hundreds1 = new ListNode(3);
        ones1.next = tens1;
        tens1.next = hundreds1;
        ListNode ones2 = new ListNode(5);
        ListNode tens2 = new ListNode(6);
        ListNode hundreds2 = new ListNode(4);
        ones2.next = tens2;
        tens2.next = hundreds2;
        ListNode listNode = LinkedList.addTwoNumbers(ones1, ones2);
        Assert.assertEquals(7,listNode.val);
        Assert.assertEquals(0,listNode.next.val);
        Assert.assertEquals(8,listNode.next.next.val);
    }
}
