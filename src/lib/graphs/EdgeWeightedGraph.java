package lib.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * An edge-weighted undirected graph.
 * 
 * @author If
 *
 */
public class EdgeWeightedGraph {
  private final int V;
  private int E;
  private List<List<Edge>> adj;

  public EdgeWeightedGraph(int V) {
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

  public void addEdge(Edge e) {
    int v = e.either();
    int w = e.other(v);
    adj.get(v).add(e);
    adj.get(w).add(e);
    E++;
  }

  public Iterable<Edge> adj(int v) {
    return adj.get(v);
  }

  public int degree(int v) {
    return adj.get(v).size();
  }

  public Iterable<Edge> edges() {
    List<Edge> list = new ArrayList<>();
    for (int v = 0; v < V; v++) {
      int selfLoops = 0;
      for (Edge e : adj(v)) {
        if (e.other(v) > v) {
          list.add(e);
        }
        // only add one copy of each self loop (self loops will be consecutive)
        else if (e.other(v) == v) {
          if (selfLoops % 2 == 0) {
            list.add(e);
          }
          selfLoops++;
        }
      }
    }
    return list;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("V: ").append(V).append("\n");
    sb.append("E: ").append(E).append("\n");
    for (int v = 0; v < V; v++) {
      sb.append(v).append(":");
      for (Edge w : adj(v)) {
        sb.append(" ").append(w);
      }
      sb.append("\n");
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    EdgeWeightedGraph e = new EdgeWeightedGraph(3);
    e.addEdge(new Edge(0, 1, 0.1));
    e.addEdge(new Edge(0, 2, 0.5));
    System.out.println(e);
  }
}
