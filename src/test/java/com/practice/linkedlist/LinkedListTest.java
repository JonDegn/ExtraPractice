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

    @Test
    public void testDeleteNode() {
        ListNode list = numToLinkedList(321);
        Assert.assertTrue(LinkedList.deleteNode(list.next));
        Assert.assertEquals(31, linkedListToNum(list));

        list = numToLinkedList(321);
        Assert.assertFalse(LinkedList.deleteNode(list.next.next));
        Assert.assertEquals(321, linkedListToNum(list));

        list = numToLinkedList(321);
        Assert.assertTrue(LinkedList.deleteNode(list));
        Assert.assertEquals(32, linkedListToNum(list));
    }

    @Test
    public void testPartition() {
        ListNode list = arrayToLinkedList(new int[]{3, 5, 8, 5, 10, 2, 1});
        int target = 5;
        ListNode result = LinkedList.partition(list, target);
        boolean seenTarget = false;
        while (result != null) {
            if (result.val < target) {
                if (seenTarget) {
                    Assert.fail();
                }
            } else {
                seenTarget = true;
            }
            result = result.next;
        }
    }

    // Helper functions

    @Test
    public void testNumToLinkedList() {
        Assert.assertEquals(59483, linkedListToNum(numToLinkedList(59483)));
    }

    @Test
    public void testArrayToLinkedList() {
        int[] list = {1, 2, 3, 4};
        Assert.assertArrayEquals(list, linkedListToArray(arrayToLinkedList(list)));
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

    private ListNode arrayToLinkedList(int[] nums) {
        if (nums.length < 1) return null;
        ListNode head = new ListNode(nums[0]);
        ListNode n = head;
        for (int i = 1; i < nums.length; i++) {
            n.next = new ListNode(nums[i]);
            n = n.next;
        }
        return head;
    }

    private int[] linkedListToArray(ListNode list) {
        List<Integer> arrayList = new ArrayList<>();

        ListNode curr = list;
        while (curr != null) {
            arrayList.add(curr.val);
            curr = curr.next;
        }
        int[] result = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            result[i] = arrayList.get(i);
        }
        return result;
    }
}
