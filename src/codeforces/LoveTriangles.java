package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LoveTriangles {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static List<Edge> zeroList, oneList;
  static int[] parent, size;
  static List<List<Integer>> graph;
  static boolean[] visit, color;

  static void solve() throws Exception {
    int mod = 1000000007;
    int n = nextInt(), m = nextInt();
    zeroList = new ArrayList<>();
    oneList = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      int a = nextInt() - 1, b = nextInt() - 1, c = nextInt();
      if (c == 0)
        zeroList.add(new Edge(a, b));
      else
        oneList.add(new Edge(a, b));
    }
    parent = new int[n];
    size = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = i;
      size[i] = 1;
    }
    for (Edge e : oneList)
      join(e.f, e.t);
    graph = new ArrayList<>();
    for (int i = 0; i < n; i++)
      graph.add(new ArrayList<>());
    for (Edge e : zeroList) {
      graph.get(find(e.f)).add(find(e.t));
      graph.get(find(e.t)).add(find(e.f));
    }
    visit = new boolean[n];
    color = new boolean[n];
    int c = 0;
    for (int i = 0; i < n; i++)
      if (find(i) == i && !visit[i])
        if (!dfs(i, false)) {
          out.println(0);
          return;
        } else
          c++;
    int ans = 1;
    for (int i = 0; i < c - 1; i++)
      ans = (ans * 2) % mod;
    out.println(ans);
  }

  static int find(int a) {
    return a == parent[a] ? a : (parent[a] = find(parent[a]));
  }

  static void join(int a, int b) {
    int ap = find(a), bp = find(b);
    if (ap == bp)
      return;
    if (size[ap] < size[bp]) {
      int t = ap;
      ap = bp;
      bp = t;
    }
    parent[bp] = ap;
    size[ap] += size[bp];
  }

  static boolean dfs(int a, boolean c) {
    if (visit[a])
      return color[a] == c;
    visit[a] = true;
    color[a] = c;
    for (int b : graph.get(a))
      if (!dfs(b, !c))
        return false;
    return true;
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


class Edge {
  int f;
  int t;

  Edge(int a, int b) {
    f = a;
    t = b;
  }
}
