package demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class DijkstraTest {
    @Test
    void simpleGraph(){
        int n = 3;
        List<List<Dijkstra.Edge>> g = Dijkstra.newGraph(n);
        g.get(0).add(new Dijkstra.Edge(1, 5));
        g.get(0).add(new Dijkstra.Edge(2, 2));
        g.get(2).add(new Dijkstra.Edge(1, 1));
        int[] dist = Dijkstra.shortestPaths(n, (List)g, 0);
        assertArrayEquals(new int[]{0,3,2}, dist);
    }
}
