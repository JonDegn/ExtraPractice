package com.practice.graphs;

import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleDirectedGraph;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jonathondegn on 7/25/17.
 */
public class GraphProblemsTest {
    @Test
    public void testSearch() {
        DirectedGraph<Vertex, DefaultEdge> g = new SimpleDirectedGraph<>(DefaultEdge.class);
        Vertex vertex1 = new Vertex(1);
        Vertex vertex2 = new Vertex(2);
        Vertex vertex3 = new Vertex(3);
        Vertex vertex4 = new Vertex(4);
        Vertex vertex5 = new Vertex(5);

        g.addVertex(vertex1);
        g.addVertex(vertex2);
        g.addVertex(vertex3);
        g.addVertex(vertex4);
        g.addVertex(vertex5);

        g.addEdge(vertex1, vertex2);
        g.addEdge(vertex2, vertex3);
        g.addEdge(vertex2, vertex5);
        g.addEdge(vertex5, vertex1);
        g.addEdge(vertex3, vertex4);

        //DFS
        Assert.assertTrue(GraphProblems.searchDFS(vertex1, vertex4, g));
        Assert.assertTrue(GraphProblems.searchDFS(vertex2, vertex1, g));
        Assert.assertFalse(GraphProblems.searchDFS(vertex4, vertex3, g));
        //BFS
        Assert.assertTrue(GraphProblems.searchBFS(vertex1, vertex4, g));
        Assert.assertTrue(GraphProblems.searchBFS(vertex2, vertex1, g));
        Assert.assertFalse(GraphProblems.searchBFS(vertex4, vertex3, g));
    }

    @Test
    public void testCreateMinimalBST() {
        BinaryNode minimalBST = GraphProblems.createMinimalBST(new int[]{1, 2, 3, 4, 5, 6, 7});
        minimalBST.inOrderPrint();
    }

    @Test
    public void testMergeTrees() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(5);

        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(1);
        list2.add(3);
        list2.add(null);
        list2.add(4);
        list2.add(null);
        list2.add(7);
        GraphProblems.mergeTrees(createTree(list), createTree(list2)).inOrderPrint();
    }

    @Test
    public void testAverageOfLevels() {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(9);
        list.add(20);
        list.add(null);
        list.add(null);
        list.add(15);
        list.add(7);
        List<Double> result = GraphProblems.averageOfLevels(createTree(list));
        Assert.assertEquals(3, result.size());
        Assert.assertEquals(3.0, result.get(0), 0.01);
        Assert.assertEquals(14.5, result.get(1), 0.01);
        Assert.assertEquals(11.0, result.get(2), 0.01);
    }

    @Test
    public void testMaxDepth() {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(9);
        list.add(20);
        list.add(null);
        list.add(null);
        list.add(15);
        list.add(7);

        Assert.assertEquals(3, GraphProblems.maxDepth(createTree(list)));
    }

    @Test
    public void testInvertTree() {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(2);
        list.add(7);
        list.add(1);
        list.add(3);
        list.add(6);
        list.add(9);
        BinaryNode tree = GraphProblems.invertTree(createTree(list));
        tree.breadthFirstPrint();

    }

    @Test
    public void testFindTarget() {
        List<Integer> list = new LinkedList<>(Arrays.asList(5, 3, 6, 2, 4, null, 7));
        List<Integer> list2 = new LinkedList<>(Arrays.asList(5, 3, 6, 2, 4, null, 7));

        Assert.assertTrue(GraphProblems.findTarget(createTree(list), 9));
        Assert.assertFalse(GraphProblems.findTarget(createTree(list2), 28));
    }

    @Test
    public void testConvertBST() {
        List<Integer> list = new LinkedList<>(Arrays.asList(5, 2, 13));
        BinaryNode node = GraphProblems.convertBST(createTree(list));
        node.inOrderPrint();
    }

    @Test
    public void testTree2str() {
        List<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> list2 = new LinkedList<>(Arrays.asList(1, 2, 3, null, 4));
        System.out.println(GraphProblems.tree2str(createTree(list)));
        System.out.println(GraphProblems.tree2str(createTree(list2)));
    }

    @Test
    public void testFindMinimumDifference() {
        List<Integer> list = new LinkedList<>(Arrays.asList(1, null, 3, null, 2));
        BinaryNode tree = createTree(list);
        int min = GraphProblems.getMinimumDifference(tree);
        Assert.assertEquals(1, min);
    }

    @Test
    public void testDiameterOfBinaryTree() {
        List<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        BinaryNode tree = createTree(list);
        Assert.assertEquals(3, GraphProblems.diameterOfBinaryTree(tree));
        GraphProblems.max = 0;
        List<Integer> list2 = new LinkedList<>(Arrays.asList(1, 2));
        BinaryNode tree2 = createTree(list2);
        Assert.assertEquals(1, GraphProblems.diameterOfBinaryTree(tree2));
    }

    @Test
    public void testIsSubtree() {
        Assert.assertTrue(GraphProblems.isSubtree(
                createTree(new LinkedList<>(Arrays.asList(3, 4, 5, 1, 2))),
                createTree(new LinkedList<>(Arrays.asList(4, 1, 2)))
        ));
        Assert.assertFalse(GraphProblems.isSubtree(
                createTree(new LinkedList<>(Arrays.asList(3, 4, 5, 1, 2, null, null, null, null, 0))),
                createTree(new LinkedList<>(Arrays.asList(4, 1, 2)))
        ));
        Assert.assertTrue(GraphProblems.isSubtree(
                createTree(new LinkedList<>(Arrays.asList(4, 4, 5, 1, 2))),
                createTree(new LinkedList<>(Arrays.asList(4, 1, 2)))
        ));
    }

    @Test
    public void testPathSum() {
        Assert.assertEquals(3, GraphProblems.pathSum(createTree(new LinkedList<>(Arrays.asList(10, 5, -3, 3, 2, null, 11, 3, -2, null, 1))), 8));
    }

    @Test
    public void testTrie() {
        Trie t = new Trie();
        t.insert("hello");
        Assert.assertTrue(t.search("hello"));
        Assert.assertFalse(t.search("hel"));
        Assert.assertTrue(t.startsWith("h"));
        Assert.assertTrue(t.startsWith("hel"));
    }

    // helper functions

    private BinaryNode createTree(List<Integer> nums) {
        BinaryNode root = new BinaryNode(nums.remove(0));
        while (nums.size() != 0) createChildren(root, nums);
        return root;
    }

    private void createChildren(BinaryNode node, List<Integer> nums) {
        if (nums.size() == 0) return;
        if (node == null) return;

        if (node.left != null) {
            createChildren(node.left, nums);
        } else {
            Integer val = nums.remove(0);
            node.left = val != null ? new BinaryNode(val) : null;
        }
        if (nums.size() == 0) return;

        if (node.right != null) {
            createChildren(node.right, nums);
        } else {
            Integer val = nums.remove(0);
            node.right = val != null ? new BinaryNode(val) : null;
        }
    }

}