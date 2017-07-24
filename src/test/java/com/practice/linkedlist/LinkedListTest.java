package com.practice.linkedlist;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LinkedListTest {
    @Test
    public void testAddTwoNumbers() {
        //Case 1
        ListNode<Integer> l1 = numToLinkedList(342);
        ListNode<Integer> l2 = numToLinkedList(465);
        ListNode<Integer> result = LinkedList.addTwoNumbers(l1, l2);

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
        ListNode<Integer> list = arrayToLinkedList(new Integer[]{1, 1});
        LinkedList.removeDuplicates(list);
        Assert.assertArrayEquals(new Integer[]{1}, linkedListToArray(list));

        list = arrayToLinkedList(new Integer[]{1, 2, 3, 3, 1});
        LinkedList.removeDuplicates(list);
        Assert.assertArrayEquals(new Integer[]{1, 2, 3}, linkedListToArray(list));

        list = arrayToLinkedList(new Integer[]{2, 1, 4, 3, 2, 1, 2, 1, 2, 1});
        LinkedList.removeDuplicates(list);
        Assert.assertArrayEquals(new Integer[]{2, 1, 4, 3}, linkedListToArray(list));
    }

    @Test
    public void testKthFromLast() {
        ListNode<Integer> list = arrayToLinkedList(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        ListNode<Integer> result = LinkedList.kthToLast(list, 0);
        Assert.assertNotNull(result);
        Assert.assertEquals(7, (long) result.val);

        result = LinkedList.kthToLast(list, 1);
        Assert.assertNotNull(result);
        Assert.assertEquals(6, (long) result.val);

        result = LinkedList.kthToLast(list, 7);
        Assert.assertNull(result);

        result = LinkedList.kthToLast(list, 6);
        Assert.assertNotNull(result);
        Assert.assertEquals(1, (long) result.val);

        result = LinkedList.kthToLast(list, 6);
        Assert.assertNotNull(result);
        Assert.assertEquals(1, (long) result.val);
    }

    @Test
    public void testDeleteNode() {
        ListNode<Integer> list = arrayToLinkedList(new Integer[]{1, 2, 3});
        Assert.assertTrue(LinkedList.deleteNode(list.next));
        Assert.assertArrayEquals(new Integer[]{1, 3}, linkedListToArray(list));

        list = arrayToLinkedList(new Integer[]{1, 2, 3});
        Assert.assertFalse(LinkedList.deleteNode(list.next.next));
        Assert.assertArrayEquals(new Integer[]{1, 2, 3}, linkedListToArray(list));

        list = arrayToLinkedList(new Integer[]{1, 2, 3});
        Assert.assertTrue(LinkedList.deleteNode(list));
        Assert.assertArrayEquals(new Integer[]{2, 3}, linkedListToArray(list));
    }

    @Test
    public void testPartition() {
        ListNode<Integer> list = arrayToLinkedList(new Integer[]{3, 5, 8, 5, 10, 2, 1});
        int target = 5;
        ListNode<Integer> result = LinkedList.partition(list, target);
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

    @Test
    public void testIsPalindrome() {
        ListNode<Integer> list = arrayToLinkedList(new Integer[]{1, 2, 1, 2, 1});
        Assert.assertTrue(LinkedList.isPalindrome(list));
        list = arrayToLinkedList(new Integer[]{1, 2, 1, 2, 2, 1});
        Assert.assertFalse(LinkedList.isPalindrome(list));
    }

    @Test
    public void testIsPalindromeRecursive() {
        ListNode<Integer> list = arrayToLinkedList(new Integer[]{1, 2, 1, 2, 1});
        Assert.assertTrue(LinkedList.isPalindromeRecursive(list));
        list = arrayToLinkedList(new Integer[]{1, 2, 1, 2, 2, 1});
        Assert.assertFalse(LinkedList.isPalindromeRecursive(list));
        list = arrayToLinkedList(new Integer[]{1, 2, 1, 2, 2, 1, 2, 1});
        Assert.assertTrue(LinkedList.isPalindromeRecursive(list));
    }

    @Test
    public void testIntersection() {
        ListNode<Integer> list1 = arrayToLinkedList(new Integer[]{1, 2, 3, 4, 5});
        ListNode<Integer> list2 = arrayToLinkedList(new Integer[]{1, 2});
        Assert.assertNull(LinkedList.intersection(list1, list2));
        list2.next.next = list1.next.next;
        ListNode<Integer> intersectingNode = LinkedList.intersection(list1, list2);
        Assert.assertEquals(3, intersectingNode.val.longValue());
    }

    //<editor-fold desc="Helper Functions">
    @Test
    public void testNumToLinkedList() {
        Assert.assertEquals(59483, linkedListToNum(numToLinkedList(59483)));
    }

    @Test
    public void testArrayToLinkedList() {
        Integer[] list = {1, 2, 3, 4};
        Assert.assertArrayEquals(list, linkedListToArray(arrayToLinkedList(list)));
    }

    // gets a number from a linked list where each node represents a digit.
    private int linkedListToNum(ListNode<Integer> n) {
        ListNode<Integer> node = n;
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
    private ListNode<Integer> numToLinkedList(int num) {
        ArrayList<ListNode<Integer>> nodes = new ArrayList<>();

        while (num > 0) {
            nodes.add(new ListNode<>(num % 10));
            num /= 10;
        }
        for (int i = 0; i < nodes.size() - 1; i++) {
            nodes.get(i).next = nodes.get(i + 1);
        }
        return nodes.get(0);
    }

    private <T> ListNode<T> arrayToLinkedList(T[] nums) {
        if (nums.length < 1) return null;
        ListNode<T> head = new ListNode<>(nums[0]);
        ListNode<T> n = head;
        for (int i = 1; i < nums.length; i++) {
            n.next = new ListNode<>(nums[i]);
            n = n.next;
        }
        return head;
    }

    private <T> T[] linkedListToArray(ListNode<T> list) {
        List<T> arrayList = new ArrayList<>();

        ListNode<T> curr = list;
        while (curr != null) {
            arrayList.add(curr.val);
            curr = curr.next;
        }

        Object[] result = new Object[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            result[i] = arrayList.get(i);
        }
        return (T[]) result;
    }
    //</editor-fold>
}
