package demo;

import java.util.*;

public class Dijkstra {
    public static class Edge {
        public final int to;
        public final int w;
        public Edge(int to, int w){ this.to = to; this.w = w; }
    }

    public static int[] shortestPaths(int n, List<List<Edge>> g, int src){
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{src, 0});
        boolean[] vis = new boolean[n];
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int u = cur[0], d = cur[1];
            if (vis[u]) continue;
            vis[u] = true;
            for(Edge e : g.get(u)){
                if (d + e.w < dist[e.to]){
                    dist[e.to] = d + e.w;
                    pq.add(new int[]{e.to, dist[e.to]});
                }
            }
        }
        return dist;
    }

    public static List<List<Edge>> newGraph(int n){
        List<List<Edge>> g = new ArrayList<>(n);
        for(int i=0;i<n;i++) g.add(new ArrayList<>());
        return g;
    }
}
