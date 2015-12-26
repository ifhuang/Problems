package lib.graphs;


/**
 * Determining a topological order of a directed acyclic graph by recursive depth first search.
 * 
 * @author If
 *
 */
public class Topological {
  private Iterable<Integer> order;
  private int[] rank;

  public Topological(Digraph digraph) {
    order = null;
    rank = new int[digraph.V()];
    DirectedCycle directedCycle = new DirectedCycle(digraph);
    if (!directedCycle.hasCycle()) {
      DepthFirstOrder depthFirstOrder = new DepthFirstOrder(digraph);
      order = depthFirstOrder.reversePost();
      int index = 0;
      for (int v : order) {
        rank[v] = index++;
      }
    }
  }

  public boolean hasOrder() {
    return order != null;
  }

  public Iterable<Integer> order() {
    return order;
  }

  public int rank(int v) {
    return hasOrder() ? rank[v] : -1;
  }

  public static void main(String[] args) {
    Digraph d = new Digraph(3);
    d.addEdge(0, 2);
    d.addEdge(1, 2);
    Topological t = new Topological(d);
    System.out.println(t.order());
  }
}
