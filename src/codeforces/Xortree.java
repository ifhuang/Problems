package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Xortree {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static List<List<Integer>> g;
  static int[] init;
  static int[] goal;
  static List<Integer> ans;

  static void solve() throws Exception {
    int n = nextInt();
    g = new ArrayList<>(n);
    for (int i = 0; i < n; i++)
      g.add(new ArrayList<>());
    for (int i = 0; i < n - 1; i++) {
      int u = nextInt() - 1;
      int v = nextInt() - 1;
      g.get(u).add(v);
      g.get(v).add(u);
    }
    init = nextIntArray(n, 0);
    goal = nextIntArray(n, 0);
    ans = new ArrayList<>();
    dfs(0, -1, 0, 0, 0);
    out.println(ans.size());
    for (int i : ans)
      out.println(i + 1);
  }

  static void dfs(int now, int parent, int level, int op0, int op1) {
    init[now] ^= (level % 2 == 0 ? op0 : op1);
    if (init[now] != goal[now]) {
      init[now] = goal[now];
      ans.add(now);
      if (level % 2 == 0)
        op0 ^= 1;
      else
        op1 ^= 1;
    }
    for (int child : g.get(now))
      if (child != parent)
        dfs(child, now, level + 1, op0, op1);
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
