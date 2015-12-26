package lib.graphs;

/**
 * Determining the strong components in a directed graph.
 * 
 * @author If
 *
 */
public class KosarajuSharirSCC {
  private boolean[] marked;
  private int[] id;
  private int count;

  public KosarajuSharirSCC(Digraph digraph) {
    DepthFirstOrder dfs = new DepthFirstOrder(digraph.reverse());

    marked = new boolean[digraph.V()];
    id = new int[digraph.V()];
    count = 0;

    for (int v : dfs.reversePost()) {
      if (!marked[v]) {
        dfs(digraph, v);
        count++;
      }
    }
  }

  private void dfs(Digraph digraph, int v) {
    marked[v] = true;
    id[v] = count;
    for (int w : digraph.adj(v)) {
      if (!marked[w]) {
        dfs(digraph, w);
      }
    }
  }

  public int count() {
    return count;
  }

  public int id(int v) {
    return id[v];
  }

  public boolean stronglyConnected(int v, int w) {
    return id[v] == id[w];
  }

  public static void main(String[] args) {
    Digraph d = new Digraph(5);
    d.addEdge(0, 1);
    d.addEdge(1, 2);
    d.addEdge(2, 0);
    d.addEdge(3, 4);
    d.addEdge(4, 3);
    KosarajuSharirSCC k = new KosarajuSharirSCC(d);
    System.out.println(k.count());
  }
}
