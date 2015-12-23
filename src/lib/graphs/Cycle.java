package lib.graphs;

import java.util.Stack;

/**
 * Determining whether an undirected graph has a cycle.
 * 
 * @author If
 *
 */
public class Cycle {

  private boolean[] marked;
  private int[] edgeTo;
  private boolean hasCycle;
  private Stack<Integer> cycle;

  public Cycle(Graph graph) {
    if (hasSelfLoop(graph)) {
      return;
    } else if (hasParallelEdges(graph)) {
      return;
    }

    marked = new boolean[graph.V()];
    edgeTo = new int[graph.V()];
    hasCycle = false;
    cycle = null;

    for (int v = 0; v < graph.V(); v++) {
      if (!marked[v]) {
        dfs(graph, v);
      }
    }
  }

  private boolean hasSelfLoop(Graph graph) {
    for (int v = 0; v < graph.V(); v++) {
      for (int w : graph.adj(v)) {
        if (w == v) {
          cycle = new Stack<>();
          cycle.push(w);
          cycle.push(w);
          return true;
        }
      }
    }
    return false;
  }

  private boolean hasParallelEdges(Graph graph) {
    marked = new boolean[graph.V()];
    for (int v = 0; v < graph.V(); v++) {
      for (int w : graph.adj(v)) {
        if (marked[w]) {
          cycle = new Stack<>();
          cycle.push(v);
          cycle.push(w);
          cycle.push(v);
          return true;
        }
        marked[w] = true;
      }
      for (int w : graph.adj(v)) {
        marked[w] = false;
      }
    }
    return false;
  }

  private void dfs(Graph graph, int s) {
    marked[s] = true;
    for (int t : graph.adj(s)) {
      if (cycle != null) {
        return;
      }
      if (!marked[t]) {
        edgeTo[t] = s;
        dfs(graph, t);
      } else if (edgeTo[s] != t) {
        hasCycle = true;
        cycle = new Stack<>();
        cycle.push(t);
        for (int v = s; v != t; v = edgeTo[v]) {
          cycle.push(v);
        }
        cycle.push(t);
      }
    }
  }

  public Iterable<Integer> cycle() {
    return cycle;
  }

  public boolean hasCycle() {
    return hasCycle;
  }

  public static void main(String[] args) {
    Graph g = new Graph(5);
    g.addEdge(0, 1);
    g.addEdge(1, 2);
    g.addEdge(2, 3);
    g.addEdge(3, 4);
    g.addEdge(4, 0);
    Cycle c = new Cycle(g);
    System.out.println(c.cycle());
  }
}
