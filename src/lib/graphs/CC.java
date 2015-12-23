package lib.graphs;

import java.util.HashMap;
import java.util.Map;

/**
 * Determining the connected components in an undirected graph.
 * 
 * @author If
 *
 */
public class CC {
  private boolean[] marked;
  private int[] id;
  private int count;
  private Map<Integer, Integer> size;

  public CC(Graph graph) {
    marked = new boolean[graph.V()];
    id = new int[graph.V()];
    count = 0;
    size = new HashMap<>();
    for (int i = 0; i < graph.V(); i++) {
      if (!marked[i]) {
        dfs(graph, i);
        count++;
      }
    }
  }

  private void dfs(Graph graph, int s) {
    marked[s] = true;
    id[s] = count;
    if (!size.containsKey(count)) {
      size.put(count, 0);
    }
    size.put(count, size.get(count) + 1);
    for (int t : graph.adj(s)) {
      if (!marked[t]) {
        dfs(graph, t);
      }
    }
  }

  public boolean connected(int v, int w) {
    return id[v] == id[w];
  }

  public int count() {
    return count;
  }

  public int id(int v) {
    return id[v];
  }

  public int size(int v) {
    return size.get(id[v]);
  }

  public static void main(String[] args) {
    Graph g = new Graph(5);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(2, 3);
    CC c = new CC(g);
    System.out.println(c.count());
  }
}
