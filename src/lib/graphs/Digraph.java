package lib.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * An adjacency-lists representation of a directed graph.
 * 
 * @author If
 *
 */
public class Digraph {
  private final int V;
  private int E;
  private List<List<Integer>> adj;
  private int[] indegree;

  public Digraph(int V) {
    this.V = V;
    E = 0;
    adj = new ArrayList<>();
    for (int v = 0; v < V; v++) {
      adj.add(new ArrayList<>());
    }
    indegree = new int[V];
  }

  public int V() {
    return V;
  }

  public int E() {
    return E;
  }

  public void addEdge(int v, int w) {
    E++;
    adj.get(v).add(w);
    indegree[w]++;
  }

  public Iterable<Integer> adj(int v) {
    return adj.get(v);
  }

  public int outdegree(int v) {
    return adj.get(v).size();
  }

  public int indegree(int v) {
    return indegree[v];
  }

  public Digraph reverse() {
    Digraph reverse = new Digraph(V);
    for (int v = 0; v < V; v++) {
      for (int w : adj(v)) {
        reverse.addEdge(w, v);
      }
    }
    return reverse;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("V: ").append(V).append("\n");
    sb.append("E: ").append(E).append("\n");
    for (int v = 0; v < V; v++) {
      sb.append(v).append(":");
      for (int w : adj(v)) {
        sb.append(" ").append(w);
      }
      sb.append("\n");
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    Digraph d = new Digraph(3);
    d.addEdge(0, 1);
    d.addEdge(0, 2);
    System.out.println(d);
  }
}
