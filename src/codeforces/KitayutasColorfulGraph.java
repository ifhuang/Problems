package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class KitayutasColorfulGraph {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt(), m = nextInt();
    boolean[][][] g = new boolean[m][n][n];
    for (int i = 0; i < m; i++) {
      int a = nextInt(), b = nextInt(), c = nextInt();
      g[c - 1][a - 1][b - 1] = true;
      g[c - 1][b - 1][a - 1] = true;
    }
    for (int i = 0; i < m; i++)
      for (int j = 0; j < n; j++) {
        Queue<Integer> queue = new LinkedList<>();
        for (int k = 0; k < n; k++)
          if (k != j && g[i][j][k])
            queue.offer(k);
        while (!queue.isEmpty()) {
          int t = queue.poll();
          for (int k = 0; k < n; k++)
            if (k != j && !g[i][j][k] && g[i][t][k]) {
              g[i][j][k] = true;
              g[i][k][j] = true;
              queue.offer(k);
            }
        }
      }
    int q = nextInt();
    for (int i = 0; i < q; i++) {
      int a = nextInt() - 1;
      int b = nextInt() - 1;
      int v1 = Math.min(a, b);
      int v2 = Math.max(a, b);
      int c = 0;
      for (int j = 0; j < m; j++)
        if (g[j][v1][v2])
          c++;
      out.println(c);
    }
  }

  static void dfs(int i, int c) {

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
