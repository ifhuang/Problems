package lib.graphs;

/**
 * Computing the transitive closure of a directed graph.
 * 
 * @author If
 *
 */
public class TransitiveClosure {
  private DirectedDFS[] tc;

  public TransitiveClosure(Digraph digraph) {
    tc = new DirectedDFS[digraph.V()];
    for (int v = 0; v < digraph.V(); v++) {
      tc[v] = new DirectedDFS(digraph, v);
    }
  }

  public boolean reachable(int v, int w) {
    return tc[v].marked(w);
  }

  public static void main(String[] args) {
    Digraph d = new Digraph(3);
    d.addEdge(0, 2);
    d.addEdge(1, 2);
    TransitiveClosure t = new TransitiveClosure(d);
    System.out.println(t.reachable(0, 1));
    System.out.println(t.reachable(1, 0));
    System.out.println(t.reachable(0, 2));
  }
}
