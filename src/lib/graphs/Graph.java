package lib.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * An adjacency-lists representation of an undirected graph.
 * 
 * @author If
 *
 */
public class Graph {
  private final int V;
  private int E;
  private List<List<Integer>> adj;

  public Graph(int V) {
    this.V = V;
    E = 0;
    adj = new ArrayList<>();
    for (int v = 0; v < V; v++) {
      adj.add(new ArrayList<>());
    }
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
    adj.get(w).add(v);
  }

  public Iterable<Integer> adj(int v) {
    return adj.get(v);
  }

  public int degree(int v) {
    return adj.get(v).size();
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
    Graph g = new Graph(3);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    System.out.println(g);
  }
}
