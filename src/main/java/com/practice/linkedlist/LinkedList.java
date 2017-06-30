package com.practice.linkedlist;

public class LinkedList {

    // Add Two Numbers
    //
    // You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
    // order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
    // You may assume the two numbers do not contain any leading zero, except the number 0 itself.
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addNodes(l1, l2, false);
    }

    private static ListNode addNodes(ListNode l1, ListNode l2, boolean carryOver) {
        if (l1 == null && l2 == null) {
            if (carryOver) {
                return new ListNode(1);
            }
            return null;
        }
        if (l1 == null) {
            int result = l2.val  + (carryOver ? 1 : 0);
            if (result >= 10) {
                result %= 10;
                carryOver = true;
            } else {
                carryOver = false;
            }
            l2.val = result;
            l2.next = addNodes(null, l2.next, carryOver);
            return l2;
        }
        if (l2 == null) {
            int result = l1.val  + (carryOver ? 1 : 0);
            if (result >= 10) {
                result %= 10;
                carryOver = true;
            } else {
                carryOver = false;
            }
            l1.val = result;
            l1.next = addNodes(l1.next, null, carryOver);
            return l1;
        }
        l1.val = l1.val + l2.val + (carryOver ? 1 : 0);
        if (l1.val >= 10) {
            l1.val %= 10;
            carryOver = true;
        } else {
            carryOver = false;
        }
        l1.next = addNodes(l1.next, l2.next, carryOver);
        return l1;
    }
}
