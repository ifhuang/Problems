package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TheTwoRoutes {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt(), m = nextInt();
    boolean[][] g = new boolean[n][n];
    for (int i = 0; i < m; i++) {
      int u = nextInt() - 1;
      int v = nextInt() - 1;
      g[u][v] = g[v][u] = true;
    }
    int lenA = helper(g, true, n);
    int lenB = helper(g, false, n);
    if (lenA == -1 || lenB == -1) {
      out.println(-1);
    } else {
      out.println(Math.max(lenA, lenB) + 1);
    }
  }

  static int helper(boolean[][] g, boolean flag, int n) {
    boolean[] visit = new boolean[n];
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(0);
    int level = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int t = queue.poll();
        if (g[t][n - 1] == flag) {
          return level;
        }
        for (int j = 0; j < n; j++) {
          if (j != t && g[t][j] == flag && !visit[j]) {
            queue.offer(j);
            visit[j] = true;
          }
        }
      }
      level++;
    }
    return -1;
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
