package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class AntsinLeaves {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    List<List<Integer>> tree = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      tree.add(new ArrayList<>());
    }
    for (int i = 0; i < n - 1; i++) {
      int u = nextInt() - 1;
      int v = nextInt() - 1;
      tree.get(u).add(v);
      tree.get(v).add(u);
    }
    int ans = 0;
    for (int son : tree.get(0)) {
      List<Integer> depths = new ArrayList<>();
      dfs(tree, depths, son, 1, 0);
      Collections.sort(depths);
      int pre = 0;
      for (int depth : depths) {
        if (pre < depth) {
          pre = depth;
        } else {
          pre++;
        }
      }
      ans = Math.max(ans, pre);
    }
    out.println(ans);
  }

  static void dfs(List<List<Integer>> tree, List<Integer> depths, int v, int d, int pre) {
    boolean isLeaf = true;
    for (int u : tree.get(v)) {
      if (u != pre) {
        isLeaf = false;
        dfs(tree, depths, u, d + 1, v);
      }
    }
    if (isLeaf) {
      depths.add(d);
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
