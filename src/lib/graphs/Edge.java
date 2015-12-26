package lib.graphs;

/**
 * A weighted edge in an {@link EdgeWeightedGraph}.
 * 
 * @author If
 *
 */
public class Edge implements Comparable<Edge> {

  private final int v;
  private final int w;
  private final double weight;

  public Edge(int v, int w, double weight) {
    this.v = v;
    this.w = w;
    this.weight = weight;
  }

  public double weight() {
    return weight;
  }

  public int either() {
    return v;
  }

  public int other(int vertex) {
    return vertex == v ? w : v;
  }

  @Override
  public int compareTo(Edge o) {
    return Double.compare(weight, o.weight);
  }

  public String toString() {
    return String.format("%d-%d %.5f", v, w, weight);
  }

  public static void main(String[] args) {
    Edge e = new Edge(12, 34, 5.67);
    System.out.println(e);
  }
}
