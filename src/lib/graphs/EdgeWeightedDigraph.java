package lib.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * An edge-weighted directed graph.
 * 
 * @author If
 *
 */
public class EdgeWeightedDigraph {
  private final int V;
  private int E;
  private List<List<DirectedEdge>> adj;
  private int[] indegree;

  public EdgeWeightedDigraph(int V) {
    this.V = V;
    E = 0;
    adj = new ArrayList<>();
    indegree = new int[V];
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

  public void addEdge(DirectedEdge e) {
    int v = e.from();
    int w = e.to();
    adj.get(v).add(e);
    E++;
    indegree[w]++;
  }

  public Iterable<DirectedEdge> adj(int v) {
    return adj.get(v);
  }

  public int outdegree(int v) {
    return adj.get(v).size();
  }

  public int indegree(int v) {
    return indegree[v];
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("V: ").append(V).append("\n");
    sb.append("E: ").append(E).append("\n");
    for (int v = 0; v < V; v++) {
      sb.append(v).append(":");
      for (DirectedEdge w : adj(v)) {
        sb.append(" ").append(w);
      }
      sb.append("\n");
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    EdgeWeightedDigraph e = new EdgeWeightedDigraph(3);
    e.addEdge(new DirectedEdge(0, 1, 0.1));
    e.addEdge(new DirectedEdge(0, 2, 0.5));
    System.out.println(e);
  }
}
