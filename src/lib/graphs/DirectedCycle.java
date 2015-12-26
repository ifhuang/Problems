package lib.graphs;

import java.util.LinkedList;
import java.util.List;

/**
 * Determining whether a directed graph has a cycle.
 * 
 * @author If
 *
 */
public class DirectedCycle {

  private boolean[] marked;
  private int[] edgeTo;
  private boolean[] onStack;
  private List<Integer> cycle;

  public DirectedCycle(Digraph digraph) {
    marked = new boolean[digraph.V()];
    edgeTo = new int[digraph.V()];
    onStack = new boolean[digraph.V()];
    cycle = null;

    for (int v = 0; v < digraph.V(); v++) {
      if (!marked[v] && cycle == null) {
        dfs(digraph, v);
      }
    }
  }

  private void dfs(Digraph digraph, int s) {
    marked[s] = true;
    onStack[s] = true;
    for (int t : digraph.adj(s)) {
      if (cycle != null) {
        return;
      }
      if (!marked[t]) {
        edgeTo[t] = s;
        dfs(digraph, t);
      } else if (onStack[t]) {
        cycle = new LinkedList<>();
        cycle.add(0, t);
        for (int v = s; v != t; v = edgeTo[v]) {
          cycle.add(0, v);
        }
        cycle.add(0, t);
      }
    }
    onStack[s] = false;
  }

  public Iterable<Integer> cycle() {
    return cycle;
  }

  public boolean hasCycle() {
    return cycle != null;
  }

  public static void main(String[] args) {
    Digraph d = new Digraph(5);
    d.addEdge(0, 1);
    d.addEdge(1, 2);
    d.addEdge(2, 3);
    d.addEdge(3, 4);
    d.addEdge(4, 0);
    DirectedCycle c = new DirectedCycle(d);
    System.out.println(c.cycle());
  }
}
