package com.practice.graphs;

import com.practice.linkedlist.Tuple;
import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import java.util.*;

public class GraphProblems {

    // given a directed graph, determine if there is a route between two nodes
    static <V extends Vertex, E extends DefaultEdge> boolean searchDFS(V from, V to, DirectedGraph<V, E> graph) {
        for (Vertex v : graph.vertexSet()) {
            v.visited = false;
        }

        Stack<V> stack = new Stack<>();
        stack.push(from);
        while (!stack.isEmpty()) {
            V v = stack.pop();
            if (v.visited) continue;
            v.visited = true;
            if (v.equals(to)) {
                return true;
            }
            Set<E> edges = graph.outgoingEdgesOf(v);
            for (E e : edges) {
                stack.push(graph.getEdgeTarget(e));
            }
        }
        return false;
    }

    // given a directed graph, determine if there is a route between two nodes
    static <V extends Vertex, E extends DefaultEdge> boolean searchBFS(V from, V to, DirectedGraph<V, E> graph) {
        for (Vertex v : graph.vertexSet()) {
            v.visited = false;
        }

        Queue<V> queue = new ArrayDeque<>();
        queue.add(from);
        while (!queue.isEmpty()) {
            V v = queue.remove();
            if (v.visited) continue;
            v.visited = true;
            if (v.equals(to)) {
                return true;
            }
            Set<E> edges = graph.outgoingEdgesOf(v);
            for (E e : edges) {
                queue.add(graph.getEdgeTarget(e));
            }
        }
        return false;
    }

    //given a sorted array with unique elements, create an algorithm that will create a bst with minimal height
    static BinaryNode createMinimalBST(int[] nums) {
        return createMinimalBST(nums, 0, nums.length - 1);
    }

    static BinaryNode createMinimalBST(int[] nums, int start, int end) {
        if (start > end) return null;
        int midIdx = (end + start) / 2;
        BinaryNode binaryNode = new BinaryNode(nums[midIdx]);
        binaryNode.left = createMinimalBST(nums, start, midIdx - 1);
        binaryNode.right = createMinimalBST(nums, midIdx + 1, end);
        return binaryNode;
    }

    //    https://leetcode.com/problems/merge-two-binary-trees/description/
    //    Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees
    //    are overlapped while the others are not.
    //    You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values
    //    up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
    static BinaryNode mergeTrees(BinaryNode t1, BinaryNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    //    https://leetcode.com/problems/average-of-levels-in-binary-tree/description/
    //    Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
    static List<Double> averageOfLevels(BinaryNode root) {
        Map<Integer, Tuple<Long, Integer>> map = new HashMap<>();
        List<Double> averages = new ArrayList<>();

        if (root != null) getByLevel(root, 0, map);
        int level = 0;
        while (map.containsKey(level)) {
            Tuple<Long, Integer> totalNum = map.get(level);
            averages.add((double) totalNum.x / totalNum.y);
            level++;
        }
        return averages;

        //using queue
//        List<Double> result = new ArrayList<>();
//        Queue<BinaryNode> queue = new LinkedList<>();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            long sum = 0, count = 0;
//            Queue<BinaryNode> temp = new LinkedList<>();
//            while (!queue.isEmpty()) {
//                BinaryNode n = queue.remove();
//                sum += n.val;
//                count++;
//                if (n.left != null) temp.add(n.left);
//                if (n.right != null) temp.add(n.right);
//            }
//            queue = temp;
//            result.add(sum * 1.0 / count);
//        }
//        return result;
    }

    static void getByLevel(BinaryNode node, int level, Map<Integer, Tuple<Long, Integer>> map) {
        if (node.left != null) getByLevel(node.left, level + 1, map);
        if (node.right != null) getByLevel(node.right, level + 1, map);
        if (map.containsKey(level)) {
            Tuple<Long, Integer> totalNum = map.get(level);
            totalNum.x += node.val;
            totalNum.y++;
        } else {
            map.put(level, new Tuple<>((long) node.val, 1));
        }

    }

    //    https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
    //    Given a binary tree, find its maximum depth.
    //    The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
    static int maxDepth(BinaryNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}

class BinaryNode {
    BinaryNode left;
    BinaryNode right;
    int val;

    BinaryNode(int val) {
        this.val = val;
    }

    void insert(int num) {
        if (num < val) {
            if (left == null) {
                left = new BinaryNode(num);
            } else {
                left.insert(num);
            }
        } else {
            if (right == null) {
                right = new BinaryNode(num);
            } else {
                right.insert(num);
            }
        }
    }

    void inOrderPrint() {
        if (left != null)
            left.inOrderPrint();
        System.out.println(val);
        if (right != null)
            right.inOrderPrint();
    }

    void breadthFirstPrint() {
        Queue<BinaryNode> q = new ArrayDeque<>();
        q.add(this);
        while (q.size() > 0) {
            BinaryNode node = q.remove();
            System.out.println(node.val);
            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);

        }
    }
}

class Vertex {
    int val;
    boolean visited;

    Vertex(int val) {
        this.val = val;
    }
}
