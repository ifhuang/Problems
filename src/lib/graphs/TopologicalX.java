package lib.graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Determining a topological order of a directed acyclic graph by non-recursive breath first search.
 * 
 * @author If
 *
 */
public class TopologicalX {
  private Queue<Integer> order;
  private int[] rank;

  public TopologicalX(Digraph digraph) {
    int[] indegree = new int[digraph.V()];
    for (int v = 0; v < digraph.V(); v++) {
      indegree[v] = digraph.indegree(v);
    }

    rank = new int[digraph.V()];
    order = new LinkedList<>();
    int count = 0;

    Queue<Integer> queue = new LinkedList<>();
    for (int v = 0; v < digraph.V(); v++) {
      if (indegree[v] == 0) {
        queue.offer(v);
      }
    }

    while (!queue.isEmpty()) {
      int v = queue.poll();
      order.offer(v);
      rank[v] = count++;
      for (int w : digraph.adj(v)) {
        indegree[w]--;
        if (indegree[w] == 0) {
          queue.offer(w);
        }
      }
    }

    if (count != digraph.V()) {
      order = null;
    }
  }

  public Iterable<Integer> order() {
    return order;
  }

  public boolean hasOrder() {
    return order != null;
  }

  public int rank(int v) {
    return hasOrder() ? rank[v] : -1;
  }

  public static void main(String[] args) {
    Digraph d = new Digraph(3);
    d.addEdge(0, 2);
    d.addEdge(1, 2);
    TopologicalX t = new TopologicalX(d);
    System.out.println(t.order());
  }
}
