package com.practice.graphs;

import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

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

}

class Vertex {
    int val;
    boolean visited;

    Vertex(int val) {
        this.val = val;
    }
}
