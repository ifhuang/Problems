package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class VasyaandBasketball {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    long[] a = nextLongArray(n, 0);
    Arrays.sort(a);
    int m = nextInt();
    long[] b = nextLongArray(m, 0);
    Arrays.sort(b);
    long x = 3 * n;
    long y = 3 * m;
    long z = x - y;
    for (int i = 0, j = 0; i < n && j < m;) {
      long t = Math.min(a[i], b[j]);
      while (i < n && a[i] <= t)
        i++;
      while (j < m && b[j] <= t)
        j++;
      long xi = 3 * (n - i) + 2 * i;
      long yi = 3 * (m - j) + 2 * j;
      long zi = xi - yi;
      if (zi > z) {
        x = xi;
        y = yi;
        z = zi;
      }
    }
    if (2 * n - 2 * m > z) {
      x = 2 * n;
      y = 2 * m;
      z = x - y;
    }
    out.println(x + ":" + y);
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
