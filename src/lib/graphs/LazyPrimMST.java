package lib.graphs;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * A data type for computing a minimum spanning tree in an edge-weighted graph.
 * 
 * @author If
 *
 */
public class LazyPrimMST {
  private boolean[] marked;
  private PriorityQueue<Edge> pq;
  private Queue<Edge> mst;
  private double weight;

  public LazyPrimMST(EdgeWeightedGraph graph) {
    marked = new boolean[graph.V()];
    pq = new PriorityQueue<>();
    mst = new LinkedList<>();
    weight = 0.;

    for (int v = 0; v < graph.V(); v++) {
      if (!marked[v]) {
        prim(graph, v);
      }
    }
  }

  private void prim(EdgeWeightedGraph graph, int s) {
    scan(graph, s);
    while (!pq.isEmpty()) {
      Edge edge = pq.poll();
      int v = edge.either();
      int u = edge.other(v);
      if (marked[v] && marked[u]) {
        continue;
      }
      mst.offer(edge);
      weight += edge.weight();
      if (!marked[v]) {
        scan(graph, v);
      }
      if (!marked[u]) {
        scan(graph, u);
      }
    }
  }

  private void scan(EdgeWeightedGraph graph, int v) {
    marked[v] = true;
    for (Edge edge : graph.adj(v)) {
      if (!marked[edge.other(v)]) {
        pq.offer(edge);
      }
    }
  }

  public Iterable<Edge> edges() {
    return mst;
  }

  public double weight() {
    return weight;
  }

  public static void main(String[] args) {
    EdgeWeightedGraph g = new EdgeWeightedGraph(4);
    g.addEdge(new Edge(0, 1, 0.1));
    g.addEdge(new Edge(0, 2, 0.2));
    g.addEdge(new Edge(1, 2, 0.05));
    g.addEdge(new Edge(1, 3, 0.1));
    LazyPrimMST l = new LazyPrimMST(g);
    System.out.println(l.edges());
    System.out.println(l.weight());
  }
}
