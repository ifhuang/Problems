package lib.graphs;

/**
 * Mark connected vertexes of given vertex of an undirected graph via recursive DFS.
 * 
 * @author If
 *
 */
public class DepthFirstSearch {

  private boolean[] marked;
  private int count;

  public DepthFirstSearch(Graph graph, int s) {
    marked = new boolean[graph.V()];
    count = 0;
    dfs(graph, s);
  }

  private void dfs(Graph graph, int s) {
    marked[s] = true;
    count++;
    for (int t : graph.adj(s)) {
      if (!marked[t]) {
        dfs(graph, t);
      }
    }
  }

  public int count() {
    return count;
  }

  public boolean marked(int v) {
    return marked[v];
  }

  public static void main(String[] args) {
    Graph g = new Graph(3);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    DepthFirstSearch d = new DepthFirstSearch(g, 0);
    System.out.println(d.count());
    System.out.println(d.marked(1));
  }
}
