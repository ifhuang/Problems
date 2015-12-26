package lib.graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

/**
 * Determining depth-first search ordering of the vertices in a directed graph.
 * 
 * @author If
 *
 */
public class DepthFirstOrder {
  private boolean[] marked;
  private int[] pre;
  private int[] post;
  private Queue<Integer> preorder;
  private Queue<Integer> postorder;
  private int preCounter;
  private int postCounter;

  public DepthFirstOrder(Digraph digraph) {
    marked = new boolean[digraph.V()];
    pre = new int[digraph.V()];
    post = new int[digraph.V()];
    preorder = new LinkedList<>();
    postorder = new LinkedList<>();
    preCounter = 0;
    postCounter = 0;
    for (int v = 0; v < digraph.V(); v++) {
      if (!marked[v]) {
        dfs(digraph, v);
      }
    }
  }

  private void dfs(Digraph digraph, int v) {
    marked[v] = true;
    pre[v] = preCounter++;
    preorder.offer(v);
    for (int w : digraph.adj(v)) {
      if (!marked[w]) {
        dfs(digraph, w);
      }
    }
    post[v] = postCounter++;
    postorder.offer(v);
  }

  public Iterable<Integer> post() {
    return postorder;
  }

  public int post(int v) {
    return post[v];
  }

  public Iterable<Integer> pre() {
    return preorder;
  }

  public int pre(int v) {
    return pre[v];
  }

  public Iterable<Integer> reversePost() {
    List<Integer> reverse = new LinkedList<>();
    for (int v : postorder) {
      reverse.add(0, v);
    }
    return reverse;
  }

  public static void main(String[] args) {
    Digraph d = new Digraph(5);
    d.addEdge(0, 1);
    d.addEdge(1, 2);
    d.addEdge(2, 3);
    d.addEdge(3, 4);
    d.addEdge(4, 0);
    DepthFirstOrder c = new DepthFirstOrder(d);
    System.out.println(c.pre());
    System.out.println(c.post());
  }
}
