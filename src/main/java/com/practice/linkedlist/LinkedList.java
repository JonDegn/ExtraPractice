package com.practice.linkedlist;

import java.util.Stack;

class LinkedList {

    // Add Two Numbers
    //
    // You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
    // order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
    // You may assume the two numbers do not contain any leading zero, except the number 0 itself.
    static ListNode<Integer> addTwoNumbers(ListNode<Integer> l1, ListNode<Integer> l2) {
        ListNode<Integer> tempHead = new ListNode<>(0);
        ListNode<Integer> i = l1, j = l2, currNode = tempHead;
        int carry = 0;
        while (i != null || j != null) {
            int x = (i != null) ? i.val : 0;
            int y = (j != null) ? j.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            currNode.next = new ListNode<>(sum % 10);
            currNode = currNode.next;
            if (i != null) i = i.next;
            if (j != null) j = j.next;
        }
        if (carry > 0) {
            currNode.next = new ListNode<>(carry);
        }
        return tempHead.next;
    }
    // O(max(m,n)) where m and n are the length of l1 and l2

    // Remove duplicates from an unsorted linked list
    static <T> void removeDuplicates(ListNode<T> head) {
//        // O(n) with hashmap
//        Map<Integer,Integer> map = new HashMap<>();
//        ListNode<T> curr = head;
//        ListNode<T> prev = null;
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
        ListNode<T> curr = head;
        ListNode<T> runner;
        ListNode<T> runnerPrev;
        while (curr != null) {
            runner = curr.next;
            runnerPrev = curr;
            while (runner != null) {
                if (curr.val.equals(runner.val)) {
                    runnerPrev.next = runner.next;
                } else {
                    runnerPrev = runner;
                }
                runner = runner.next;
            }
            curr = curr.next;
        }
    }

    // return kth to last element in linked list
    static <T> ListNode<T> kthToLast(ListNode<T> list, int k) {
        if (list == null || k < 0) return null;

        ListNode<T> kth = list;
        ListNode<T> curr = list;

        for (int i = 0; i < k; i++) {
            if (curr.next == null) {
                return null;
            }
            curr = curr.next;
        }

        while (curr.next != null) {
            curr = curr.next;
            kth = kth.next;
        }

        return kth;
    }

    //  delete node in middle of list with only access to that node
    static <T> boolean deleteNode(ListNode<T> n) {
        if (n == null || n.next == null) return false;

        n.val = n.next.val;
        n.next = n.next.next;
        return true;
    }

    // partition so that all nodes <result come before all nodes >=result
    static ListNode<Integer> partition(ListNode<Integer> n, int x) {
        ListNode<Integer> head = n;
        ListNode<Integer> tail = n;

        while (n != null) {
            ListNode<Integer> next = n.next;
            if (n.val < x) {
                n.next = head;
                head = n;
            } else {
                tail.next = n;
                tail = n;
            }
            n = next;
        }
        tail.next = null;
        return head;
    }

    // Check if a linked list is a palindrome
    static <T> boolean isPalindrome(ListNode<T> head) {
        Stack<T> nodeStack = new Stack<>();

        ListNode<T> curr = head;
        while (curr != null) {
            nodeStack.add(curr.val);
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            if (!nodeStack.pop().equals(curr.val)) {
                return false;
            }
            curr = curr.next;
        }
        return true;
    }

    // Check if a linked list is a palindrome recursively
    static <T> boolean isPalindromeRecursive(ListNode<T> head) {
        int length = listLength(head);
        return isPalindromeRecursive(head, length).result;
    }

    private static <T> Result<T> isPalindromeRecursive(ListNode<T> node, int length) {
        if (node == null || length <= 0) {
            return new Result<>(true, node);
        } else if (length == 1) {
            return new Result<>(true, node.next);
        }
        Result<T> result = isPalindromeRecursive(node.next, length - 2);

        if (!result.result || result.node == null) {
            return result;
        }

        result.result = result.node.val.equals(node.val);
        result.node = result.node.next;
        return result;
    }

    private static <T> int listLength(ListNode<T> head) {
        int length;
        for (length = 0; head != null; head = head.next, length++) ;
        return length;
    }

    static <T> ListNode<T> intersection(ListNode<T> list1, ListNode<T> list2) {
        ListNode<T> cur = list2;
        while (list1 != null) {
            while (cur != null) {
                if (list1 == cur) {
                    return cur;
                }
                cur = cur.next;
            }
            cur = list2;
            list1 = list1.next;
        }
        return null;
    }

}

class Result<T> {
    public boolean result;
    public ListNode<T> node;

    public Result(boolean result, ListNode<T> node) {
        this.result = result;
        this.node = node;
    }
}