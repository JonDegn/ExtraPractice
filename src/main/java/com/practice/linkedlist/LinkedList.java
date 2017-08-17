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

    //  delete y in middle of list with only access to that y
    static <T> boolean deleteNode(ListNode<T> n) {
        if (n == null || n.next == null) return false;

        n.val = n.next.val;
        n.next = n.next.next;
        return true;
    }

    // partition so that all nodes <x come before all nodes >=x
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
        return isPalindromeRecursive(head, length).x;
    }

    private static <T> Tuple<Boolean, ListNode<T>> isPalindromeRecursive(ListNode<T> node, int length) {
        if (node == null || length <= 0) {
            return new Tuple<>(true, node);
        } else if (length == 1) {
            return new Tuple<>(true, node.next);
        }
        Tuple<Boolean, ListNode<T>> tuple = isPalindromeRecursive(node.next, length - 2);

        if (!tuple.x || tuple.y == null) {
            return tuple;
        }

        tuple.x = tuple.y.val.equals(node.val);
        tuple.y = tuple.y.next;
        return tuple;
    }

    private static <T> int listLength(ListNode<T> head) {
        int length;
        for (length = 0; head != null; head = head.next, length++) ;
        return length;
    }

    // Find the point where two linked lists intersect
    static <T> ListNode<T> intersection(ListNode<T> list1, ListNode<T> list2) {
        Tuple<Integer, ListNode<T>> countAndTail1 = getCountAndTail(list1);
        Tuple<Integer, ListNode<T>> countAndTail2 = getCountAndTail(list2);

        if (!countAndTail1.y.equals(countAndTail2.y))
            return null;

        int diffInLength = Math.abs(countAndTail1.x - countAndTail2.x);
        if (countAndTail1.x > countAndTail2.x) {
            while (diffInLength-- > 0) {
                list1 = list1.next;
            }
        } else {
            while (diffInLength-- > 0) {
                list2 = list2.next;
            }
        }

        while (list1 != list2) {
            list1 = list1.next;
            list2 = list2.next;
        }

        return list1;
    }

    static <T> Tuple<Integer, ListNode<T>> getCountAndTail(ListNode<T> head) {
        if (head == null) return new Tuple<>(0, head);
        int length;
        for (length = 1; head.next != null; head = head.next, length++) ;
        return new Tuple<>(length, head);
    }

    // find the beginning of the loop
    static <T> ListNode<T> findLoopBeginning(ListNode<T> head) {
        ListNode<T> fastPointer = head;
        ListNode<T> slowPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
            if (slowPointer == fastPointer) {
                break;
            }
        }
        if (fastPointer == null || fastPointer.next == null) {
            return null;
        }

        slowPointer = head;
        while (fastPointer != slowPointer) {
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }
        return fastPointer;
    }

//    static ListNode<Integer> prev;
    //    https://leetcode.com/problems/reverse-linked-list/description/
    //    Reverse a singly linked list.
    static <T> ListNode<T> reverseList(ListNode<T> head) {
        if (head == null) return head;
        ListNode<T> prev = head;
        ListNode<T> curr = head.next;
        head.next = null;
        while (curr != null) {
            ListNode<T> next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}