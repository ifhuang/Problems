package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import lib.graphs.Graph;

public class HamiltonianSpanningTree {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static long ans;

  static void solve() throws Exception {
    int n = nextInt();
    long x = nextLong(), y = nextLong();
    Graph graph = new Graph(n);
    for (int i = 0; i < n - 1; i++) {
      graph.addEdge(nextInt() - 1, nextInt() - 1);
    }
    ans = 0;
    if (x == y) {
      ans = x * (n - 1);
    } else if (x > y) {
      ans = y * (n - 1);
      for (int i = 0; i < n; i++) {
        if (graph.degree(i) == n - 1) {
          ans += x - y;
          break;
        }
      }
    } else {
      dfs(graph, 0, -1);
      ans = x * ans + (n - 1 - ans) * y;
    }
    out.println(ans);
  }

  static boolean dfs(Graph graph, int cur, int par) {
    int edge = 2;
    for (int x : graph.adj(cur)) {
      if (x != par) {
        boolean y = dfs(graph, x, cur);
        if (edge > 0 && y) {
          edge--;
          ans++;
        }
      }
    }
    return edge > 0;
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
