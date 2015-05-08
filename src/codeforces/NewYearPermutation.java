package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class NewYearPermutation {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    int[] p = nextIntArray(n, 0);
    char[][] c = new char[n][n];
    for (int i = 0; i < n; i++)
      c[i] = next().toCharArray();

    for (int i = 0; i < n; i++) {
      Queue<Integer> queue = new LinkedList<>();
      queue.offer(i);
      boolean[] v = new boolean[n];
      while (!queue.isEmpty()) {
        int j = queue.poll();
        for (int k = 0; k < n; k++)
          if (c[j][k] == '1' && !v[k]) {
            v[k] = true;
            queue.add(k);
          }
      }
      for (int j = 0; j < n; j++)
        if (v[j])
          c[i][j] = '1';
    }

    for (int i = n; i >= 1; i--) {
      int j = 0;
      for (; j < n; j++)
        if (p[j] == i)
          break;
      for (int k = n - 1; k > j; k--)
        if (c[j][k] == '1' && p[k] < p[j]) {
          int t = p[k];
          p[k] = p[j];
          p[j] = t;
          break;
        }
    }

    for (int i = 0; i < n; i++)
      out.print(p[i] + " ");
    out.println();
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
