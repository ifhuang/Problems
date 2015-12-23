package lib.graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Finds shortest paths from given source vertex to every other vertex in an undirected graph.
 * 
 * @author If
 *
 */
public class BreadthFirstPaths {

  private boolean[] marked;
  private int[] edgeTo;
  private int[] distTo;
  private final int s;

  public BreadthFirstPaths(Graph graph, int s) {
    marked = new boolean[graph.V()];
    edgeTo = new int[graph.V()];
    distTo = new int[graph.V()];
    this.s = s;
    bfs(graph, s);
  }

  private void bfs(Graph graph, int s) {
    Queue<Integer> queue = new LinkedList<>();
    marked[s] = true;
    edgeTo[s] = s;
    distTo[s] = 0;
    queue.offer(s);
    while (!queue.isEmpty()) {
      int v = queue.poll();
      for (int w : graph.adj(v)) {
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
    Stack<Integer> stack = new Stack<>();
    while (v != s) {
      stack.push(v);
      v = edgeTo[v];
    }
    stack.push(v);
    return stack;
  }

  public static void main(String[] args) {
    Graph g = new Graph(4);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(2, 3);
    BreadthFirstPaths b = new BreadthFirstPaths(g, 0);
    System.out.println(b.pathTo(3));
  }
}
