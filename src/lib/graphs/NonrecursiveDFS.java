package lib.graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Mark connected vertexes of given vertex of an undirected graph via non-recursive DFS.
 * 
 * @author If
 *
 */
public class NonrecursiveDFS {
  private boolean[] marked;
  private int count;

  public NonrecursiveDFS(Graph graph, int s) {
    marked = new boolean[graph.V()];
    count = 0;

    List<Iterator<Integer>> adjs = new ArrayList<>();
    for (int i = 0; i < graph.V(); i++) {
      adjs.add(graph.adj(i).iterator());
    }

    Stack<Integer> stack = new Stack<>();
    marked[s] = true;
    count++;
    stack.push(s);

    while (!stack.isEmpty()) {
      int v = stack.peek();
      Iterator<Integer> adj = adjs.get(v);
      if (adj.hasNext()) {
        int t = adj.next();
        if (!marked[t]) {
          marked[t] = true;
          count++;
          stack.push(t);
        }
      } else {
        stack.pop();
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
    NonrecursiveDFS n = new NonrecursiveDFS(g, 0);
    System.out.println(n.count());
    System.out.println(n.marked(1));
  }
}
