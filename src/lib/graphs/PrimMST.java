package lib.graphs;

import java.util.LinkedList;
import java.util.Queue;

import lib.sorting.IndexMinPQ;

/**
 * A data type for computing a minimum spanning tree in an edge-weighted graph.
 * 
 * @author If
 *
 */
public class PrimMST {
  private Edge[] edgeTo;
  private double[] distTo;
  private boolean[] marked;
  private IndexMinPQ<Double> pq;
  private Queue<Edge> mst;
  private double weight;

  public PrimMST(EdgeWeightedGraph graph) {
    edgeTo = new Edge[graph.V()];
    distTo = new double[graph.V()];
    marked = new boolean[graph.V()];
    pq = new IndexMinPQ<>(graph.V());
    mst = new LinkedList<>();
    weight = 0.;
    for (int v = 0; v < graph.V(); v++) {
      distTo[v] = Double.POSITIVE_INFINITY;
    }

    for (int v = 0; v < graph.V(); v++) {
      if (!marked[v]) {
        prim(graph, v);
      }
    }

    for (int v = 0; v < edgeTo.length; v++) {
      Edge e = edgeTo[v];
      if (e != null) {
        mst.offer(e);
        weight += e.weight();
      }
    }
  }

  private void prim(EdgeWeightedGraph G, int s) {
    distTo[s] = 0.0;
    pq.insert(s, distTo[s]);
    while (!pq.isEmpty()) {
      int v = pq.delMin();
      scan(G, v);
    }
  }

  private void scan(EdgeWeightedGraph G, int v) {
    marked[v] = true;
    for (Edge e : G.adj(v)) {
      int w = e.other(v);
      if (marked[w]) {
        continue;
      }
      if (e.weight() < distTo[w]) {
        distTo[w] = e.weight();
        edgeTo[w] = e;
        if (pq.contains(w)) {
          pq.decreaseKey(w, distTo[w]);
        } else {
          pq.insert(w, distTo[w]);
        }
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
    PrimMST p = new PrimMST(g);
    System.out.println(p.edges());
    System.out.println(p.weight());
  }
}
