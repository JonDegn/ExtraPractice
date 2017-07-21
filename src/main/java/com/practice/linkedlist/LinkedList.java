package com.practice.linkedlist;

public class LinkedList {

    // Add Two Numbers
    //
    // You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
    // order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
    // You may assume the two numbers do not contain any leading zero, except the number 0 itself.
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tempHead = new ListNode(0);
        ListNode i = l1, j = l2, currNode = tempHead;
        int carry = 0;
        while (i != null || j != null) {
            int x = (i != null) ? i.val : 0;
            int y = (j != null) ? j.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            currNode.next = new ListNode(sum % 10);
            currNode = currNode.next;
            if (i != null) i = i.next;
            if (j != null) j = j.next;
        }
        if (carry > 0) {
            currNode.next = new ListNode(carry);
        }
        return tempHead.next;
    }
    // O(max(m,n)) where m and n are the length of l1 and l2


    // Remove duplicates from an unsorted linked list
    public static void removeDuplicates(ListNode head) {
//        // O(n) with hashmap
//        Map<Integer,Integer> map = new HashMap<>();
//        ListNode curr = head;
//        ListNode prev = null;
//        while (curr != null) {
//            if (map.containsKey(curr.val)) {
//                prev.next = curr.next;
//            } else {
//                map.put(curr.val, 1);
//                prev = curr;
//            }
//            curr = curr.next;
//        }

        // O(n^2) with no extra buffer
        ListNode curr = head;
        ListNode runner;
        ListNode runnerPrev;
        while (curr != null) {
            runner = curr.next;
            runnerPrev = curr;
            while (runner != null) {
                if (curr.val == runner.val) {
                    runnerPrev.next = runner.next;
                } else {
                    runnerPrev = runner;
                }
                runner = runner.next;
            }
            curr = curr.next;
        }
    }


}
