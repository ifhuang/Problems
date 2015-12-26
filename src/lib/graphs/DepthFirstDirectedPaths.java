package lib.graphs;

import java.util.LinkedList;
import java.util.List;

/**
 * Finds paths from given source vertex to every other vertex in a directed graph.
 * 
 * @author If
 *
 */
public class DepthFirstDirectedPaths {
  private boolean[] marked;
  private int[] edgeTo;
  private final int s;

  public DepthFirstDirectedPaths(Digraph digraph, int s) {
    marked = new boolean[digraph.V()];
    edgeTo = new int[digraph.V()];
    this.s = s;
    dfs(digraph, s);
  }

  private void dfs(Digraph digraph, int s) {
    marked[s] = true;
    for (int t : digraph.adj(s)) {
      if (!marked[t]) {
        edgeTo[t] = s;
        dfs(digraph, t);
      }
    }
  }

  public boolean hasPathTo(int v) {
    return marked[v];
  }

  public Iterable<Integer> pathTo(int v) {
    if (!hasPathTo(v)) {
      return null;
    }
    List<Integer> path = new LinkedList<>();
    while (v != s) {
      path.add(0, v);
      v = edgeTo[v];
    }
    path.add(0, v);
    return path;
  }

  public static void main(String[] args) {
    Digraph d = new Digraph(4);
    d.addEdge(0, 1);
    d.addEdge(0, 2);
    d.addEdge(2, 3);
    d.addEdge(3, 0);
    DepthFirstDirectedPaths dfs = new DepthFirstDirectedPaths(d, 0);
    System.out.println(dfs.pathTo(3));
  }
}
