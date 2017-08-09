package com.practice.graphs;

import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleDirectedGraph;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
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