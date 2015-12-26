package lib.graphs;

import java.util.LinkedList;
import java.util.List;

/**
 * Determining whether an undirected graph is bipartite or whether it has an odd-length cycle.
 * 
 * @author If
 *
 */
public class Bipartite {

  private boolean[] marked;
  private boolean[] color;
  private boolean isBipartite;
  private int[] edgeTo;
  private List<Integer> cycle;

  public Bipartite(Graph graph) {
    marked = new boolean[graph.V()];
    color = new boolean[graph.V()];
    isBipartite = true;
    edgeTo = new int[graph.V()];
    cycle = null;

    for (int v = 0; v < graph.V(); v++) {
      if (!marked[v]) {
        dfs(graph, v);
      }
    }
  }

  private void dfs(Graph graph, int s) {
    marked[s] = true;
    for (int t : graph.adj(s)) {
      if (cycle != null) {
        return;
      }
      if (!marked[t]) {
        color[t] = !color[s];
        edgeTo[t] = s;
        dfs(graph, t);
      } else if (color[t] == color[s]) {
        isBipartite = false;
        cycle = new LinkedList<>();
        cycle.add(0, t);
        for (int v = s; v != t; v = edgeTo[v]) {
          cycle.add(0, v);
        }
        cycle.add(0, t);
      }
    }
  }

  public boolean color(int v) {
    return color[v];
  }

  public boolean isBipartite() {
    return isBipartite;
  }

  public Iterable<Integer> oddCycle() {
    return cycle;
  }

  public static void main(String[] args) {
    Graph g = new Graph(5);
    g.addEdge(0, 1);
    g.addEdge(1, 2);
    g.addEdge(2, 3);
    g.addEdge(3, 4);
    g.addEdge(4, 0);
    Bipartite b = new Bipartite(g);
    System.out.println(b.isBipartite());
    System.out.println(b.oddCycle());
  }
}
