package com.practice.linkedlist;

import com.practice.algorithms.Algorithms;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LinkedListTest {
    @Test
    public void testAddTwoNumbers() {
        //Case 1
        ListNode l1 = numToLinkedList(342);
        ListNode l2 = numToLinkedList(465);
        ListNode result = LinkedList.addTwoNumbers(l1, l2);

        Assert.assertEquals(807, linkedListToNum(result));

        //Case 2
        l1 = numToLinkedList(1);
        l2 = numToLinkedList(25);
        result = LinkedList.addTwoNumbers(l1, l2);

        Assert.assertEquals(26, linkedListToNum(result));

        //Case 3
        l1 = numToLinkedList(99999);
        l2 = numToLinkedList(1);
        result = LinkedList.addTwoNumbers(l1, l2);

        Assert.assertEquals(100000, linkedListToNum(result));
    }

    @Test
    public void testRemoveDuplicates() {
        ListNode list = numToLinkedList(11);
        LinkedList.removeDuplicates(list);
        Assert.assertEquals(1, linkedListToNum(list));

        list = numToLinkedList(13321);
        LinkedList.removeDuplicates(list);
        Assert.assertEquals(321, linkedListToNum(list));

        list = numToLinkedList(1212123412);
        LinkedList.removeDuplicates(list);
        Assert.assertEquals(3412, linkedListToNum(list));
    }

    @Test
    public void testKthFromLast() {
        ListNode list = numToLinkedList(7654321);
        ListNode result = LinkedList.kthToLast(list, 0);
        Assert.assertNotNull(result);
        Assert.assertEquals(7, result.val);

        list = numToLinkedList(7654321);
        result = LinkedList.kthToLast(list, 1);
        Assert.assertNotNull(result);
        Assert.assertEquals(6, result.val);

        list = numToLinkedList(7654321);
        result = LinkedList.kthToLast(list, 7);
        Assert.assertNull(result);

        list = numToLinkedList(7654321);
        result = LinkedList.kthToLast(list, 6);
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.val);

        list = numToLinkedList(321);
        result = LinkedList.kthToLast(list, 2);
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.val);
    }

    // Helper functions

    @Test
    public void testHelpers() {
        Assert.assertEquals(59483, linkedListToNum(numToLinkedList(59483)));
    }

    // gets a number from a linked list where each node represents a digit.
    private int linkedListToNum(ListNode n) {
        ListNode node = n;
        int multiplier = 1;
        int total = 0;
        while (node != null) {
            total += multiplier * node.val;
            multiplier *= 10;
            node = node.next;
        }
        return total;
    }

    // gets a linked list from a number
    private ListNode numToLinkedList(int num) {
        ArrayList<ListNode> nodes = new ArrayList<>();

        while (num > 0) {
            nodes.add(new ListNode(num % 10));
            num /= 10;
        }
        for (int i = 0; i < nodes.size() - 1; i++) {
            nodes.get(i).next = nodes.get(i + 1);
        }
        return nodes.get(0);
    }
}
