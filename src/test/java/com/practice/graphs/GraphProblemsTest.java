package com.practice.graphs;

import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleDirectedGraph;
import org.junit.Assert;
import org.junit.Test;

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

}