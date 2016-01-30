package lib.graphs;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import lib.unionfind.UF;

/**
 * A data type for computing a minimum spanning tree in an edge-weighted graph.
 * 
 * @author If
 *
 */
public class KruskalMST {
  private Queue<Edge> mst;
  private double weight;

  public KruskalMST(EdgeWeightedGraph graph) {
    mst = new LinkedList<>();
    weight = 0.;
    PriorityQueue<Edge> pq = new PriorityQueue<>();
    for (Edge edge : graph.edges()) {
      pq.offer(edge);
    }
    UF uf = new UF(graph.V());
    while (!pq.isEmpty() && mst.size() < graph.V() - 1) {
      Edge edge = pq.poll();
      int v = edge.either();
      int u = edge.other(v);
      if (!uf.connected(v, u)) {
        uf.union(v, u);
        mst.offer(edge);
        weight += edge.weight();
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
    KruskalMST k = new KruskalMST(g);
    System.out.println(k.edges());
    System.out.println(k.weight());
  }
}
