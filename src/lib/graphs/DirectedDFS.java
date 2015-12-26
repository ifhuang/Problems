package lib.graphs;

/**
 * Mark connected vertexes of given vertex of a directed graph via recursive DFS.
 * 
 * @author If
 *
 */
public class DirectedDFS {

  private boolean[] marked;
  private int count;

  public DirectedDFS(Digraph digraph, int s) {
    marked = new boolean[digraph.V()];
    count = 0;
    dfs(digraph, s);
  }

  private void dfs(Digraph digraph, int s) {
    marked[s] = true;
    count++;
    for (int t : digraph.adj(s)) {
      if (!marked[t]) {
        dfs(digraph, t);
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
    Digraph digraph = new Digraph(4);
    digraph.addEdge(0, 1);
    digraph.addEdge(0, 2);
    digraph.addEdge(3, 1);
    DirectedDFS d = new DirectedDFS(digraph, 0);
    System.out.println(d.count());
    System.out.println(d.marked(1));
  }
}
