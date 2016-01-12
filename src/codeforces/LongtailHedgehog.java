package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LongtailHedgehog {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static Graph graph;
  static long[] tail;

  static void solve() throws Exception {
    int n = nextInt(), m = nextInt();
    graph = new Graph(n);
    for (int i = 0; i < m; i++) {
      graph.addEdge(nextInt() - 1, nextInt() - 1);
    }
    tail = new long[n];
    for (int v = 0; v < n; v++) {
      comp(v);
    }
    long ans = 0;
    for (int v = 0; v < n; v++) {
      ans = Math.max(ans, (tail[v] + 1) * graph.degree(v));
    }
    out.println(ans);
  }

  static void comp(int v) {
    for (int w : graph.adj(v)) {
      if (w > v) {
        tail[w] = Math.max(tail[w], tail[v] + 1);
      }
    }
  }

  public static void main(String args[]) {
    try {
      in = new BufferedReader(new InputStreamReader(System.in));
      out = new PrintWriter(new OutputStreamWriter(System.out));
      solve();
      in.close();
      out.close();
    } catch (Throwable e) {
      e.printStackTrace();
      System.exit(1);
    }
  }

  static int nextInt() throws IOException {
    return Integer.parseInt(next());
  }

  static int[] nextIntArray(int len, int start) throws IOException {
    int[] a = new int[len];
    for (int i = start; i < len; i++)
      a[i] = nextInt();
    return a;
  }

  static long nextLong() throws IOException {
    return Long.parseLong(next());
  }

  static long[] nextLongArray(int len, int start) throws IOException {
    long[] a = new long[len];
    for (int i = start; i < len; i++)
      a[i] = nextLong();
    return a;
  }

  static String next() throws IOException {
    while (tok == null || !tok.hasMoreTokens()) {
      tok = new StringTokenizer(in.readLine());
    }
    return tok.nextToken();
  }

}


class Graph {
  private final int V;
  private int E;
  private List<List<Integer>> adj;

  public Graph(int V) {
    this.V = V;
    E = 0;
    adj = new ArrayList<>();
    for (int v = 0; v < V; v++) {
      adj.add(new ArrayList<>());
    }
  }

  public int V() {
    return V;
  }

  public int E() {
    return E;
  }

  public void addEdge(int v, int w) {
    E++;
    adj.get(v).add(w);
    adj.get(w).add(v);
  }

  public Iterable<Integer> adj(int v) {
    return adj.get(v);
  }

  public int degree(int v) {
    return adj.get(v).size();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("V: ").append(V).append("\n");
    sb.append("E: ").append(E).append("\n");
    for (int v = 0; v < V; v++) {
      sb.append(v).append(":");
      for (int w : adj(v)) {
        sb.append(" ").append(w);
      }
      sb.append("\n");
    }
    return sb.toString();
  }

}
