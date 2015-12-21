package lib.graphs;

import java.util.Stack;

/**
 * Finds paths from given source vertex to every other vertex in an undirected graph.
 * 
 * @author If
 *
 */
public class DepthFirstPaths {
  private boolean[] marked;
  private int[] edgeTo;
  private final int s;

  public DepthFirstPaths(Graph graph, int s) {
    marked = new boolean[graph.V()];
    edgeTo = new int[graph.V()];
    this.s = s;
    dfs(graph, s);
  }

  private void dfs(Graph graph, int s) {
    marked[s] = true;
    for (int t : graph.adj(s)) {
      if (!marked[t]) {
        edgeTo[t] = s;
        dfs(graph, t);
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
    Stack<Integer> stack = new Stack<Integer>();
    while (v != s) {
      stack.push(v);
      v = edgeTo[v];
    }
    stack.push(v);
    return stack;
  }

  public static void main(String[] args) {
    Graph g = new Graph(4);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(2, 3);
    DepthFirstPaths d = new DepthFirstPaths(g, 0);
    System.out.println(d.pathTo(3));
  }
}
