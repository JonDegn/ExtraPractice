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

    //    https://leetcode.com/problems/invert-binary-tree/description/
    //    Invert a binary tree.
    static BinaryNode invertTree(BinaryNode root) {
        if (root != null) {
            BinaryNode temp = root.left;
            root.left = invertTree(root.right);
            root.right = invertTree(temp);
        }
        return root;
    }

    //    https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
    //    Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that
    //    their sum is equal to the given target.
    static boolean findTarget(BinaryNode root, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<BinaryNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryNode node = stack.pop();
            if (map.containsKey(node.val)) {
                return true;
            } else {
                map.put(k - node.val, node.val);
            }
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        return false;
    }

    //    https://leetcode.com/problems/convert-bst-to-greater-tree/description/
    //    Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is
    //    changed to the original key plus sum of all keys greater than the original key in BST.
    static BinaryNode convertBST(BinaryNode root) {
        convertBST(root, 0);
        return root;
    }

    private static int convertBST(BinaryNode root, int total) {
        if (root == null) return total;
        root.val += convertBST(root.right, total);
        total = convertBST(root.left, root.val);
        return total;
    }

    //    https://leetcode.com/problems/construct-string-from-binary-tree/description/
    //    You need to construct a string consists of parenthesis and integers from a binary tree with the preorder
    //    traversing way.
    //    The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty
    //    parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original
    //    binary tree.
    static String tree2str(BinaryNode t) {
        if (t == null)
            return "";
        if (t.left == null && t.right == null)
            return t.val + "";
        if (t.right == null) {
            return t.val + "(" + tree2str(t.left) + ")";
        }
        return t.val + "(" + tree2str(t.left) + ")" + "(" + tree2str(t.right) + ")";
    }


    static BinaryNode prev;
    static int min = Integer.MAX_VALUE;

    //    https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/
    //    Given a binary search tree with non-negative values, find the minimum absolute difference between values of
    //    any two nodes.
    static int getMinimumDifference(BinaryNode root) {
        inorder(root);
        return min;
    }

    private static void inorder(BinaryNode node) {
        if (node == null) return;
        inorder(node.left);
        if (prev != null) min = Math.min(min, node.val - prev.val);
        prev = node;
        inorder(node.right);
    }

    //    https://leetcode.com/problems/diameter-of-binary-tree/description/
    //    Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree
    //    is the length of the longest path between any two nodes in a tree. This path may or may not pass through the
    //    root.
    static int diameterOfBinaryTree(BinaryNode root) {
        if (root == null || (root.left == null && root.right == null)) return 0;
        Result result = getLength(root);
        return Math.max(result.longest, result.total);
    }

    static Result getLength(BinaryNode root) {
        int lLength = 0, lTotal = 0, rLength = 0, rTotal = 0;

        if (root.left != null) {
            Result lResult = getLength(root.left);
            lLength = lResult.longest + 1;
            lTotal = lResult.total;
        }
        if (root.right != null) {
            Result rResult = getLength(root.right);
            rLength = rResult.longest + 1;
            rTotal = rResult.total;
        }
        int maxTotal = Math.max(lTotal, rTotal);

        return new Result(Math.max(lLength, rLength), Math.max(maxTotal, lLength + rLength));
    }

}

class Result {
    public int longest;
    public int total;

    public Result(int l, int t) {
        this.longest = l;
        this.total = t;
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
