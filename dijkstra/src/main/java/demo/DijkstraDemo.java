package demo;

import java.util.*;

public class DijkstraDemo {
    public static void main(String[] args) {
        int n = 5;
        List<List<Dijkstra.Edge>> g = Dijkstra.newGraph(n);
        addEdge(g,0,1,4); addEdge(g,0,2,1);
        addEdge(g,2,1,2); addEdge(g,1,3,1);
        addEdge(g,2,3,5); addEdge(g,3,4,3);

        int[] dist = Dijkstra.shortestPaths(n, (List)g, 0);
        System.out.println("Distances from 0: " + Arrays.toString(dist));
    }
    static void addEdge(List<List<Dijkstra.Edge>> g, int u, int v, int w){
        g.get(u).add(new Dijkstra.Edge(v,w));
        // Directed graph; add reverse for undirected
    }
}
