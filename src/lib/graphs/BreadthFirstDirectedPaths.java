package lib.graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Finds shortest paths from given source vertex to every other vertex in a directed graph.
 * 
 * @author If
 *
 */
public class BreadthFirstDirectedPaths {

  private boolean[] marked;
  private int[] edgeTo;
  private int[] distTo;
  private final int s;

  public BreadthFirstDirectedPaths(Digraph digraph, int s) {
    marked = new boolean[digraph.V()];
    edgeTo = new int[digraph.V()];
    distTo = new int[digraph.V()];
    this.s = s;
    bfs(digraph, s);
  }

  private void bfs(Digraph digraph, int s) {
    Queue<Integer> queue = new LinkedList<>();
    marked[s] = true;
    edgeTo[s] = s;
    distTo[s] = 0;
    queue.offer(s);
    while (!queue.isEmpty()) {
      int v = queue.poll();
      for (int w : digraph.adj(v)) {
        if (!marked[w]) {
          marked[w] = true;
          edgeTo[w] = v;
          distTo[w] = distTo[v] + 1;
          queue.offer(w);
        }
      }
    }
  }

  public int distTo(int v) {
    if (!hasPathTo(v)) {
      return -1;
    }
    return distTo[v];
  }

  public boolean hasPathTo(int v) {
    return marked[v];
  }

  public Iterable<Integer> pathTo(int v) {
    if (!hasPathTo(v)) {
      return null;
    }
    List<Integer> path = new LinkedList<>();
    while (v != s) {
      path.add(0, v);
      v = edgeTo[v];
    }
    path.add(0, v);
    return path;
  }

  public static void main(String[] args) {
    Digraph digraph = new Digraph(4);
    digraph.addEdge(0, 1);
    digraph.addEdge(0, 2);
    digraph.addEdge(2, 3);
    digraph.addEdge(3, 0);
    BreadthFirstDirectedPaths b = new BreadthFirstDirectedPaths(digraph, 0);
    System.out.println(b.pathTo(3));
  }
}
