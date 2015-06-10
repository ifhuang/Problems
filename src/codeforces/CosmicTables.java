package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CosmicTables {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt(), m = nextInt(), k = nextInt();
    int[][] b = new int[n][m];
    for (int i = 0; i < n; i++)
      b[i] = nextIntArray(m, 0);
    int[] r = new int[n];
    for (int i = 0; i < n; i++)
      r[i] = i;
    int[] c = new int[m];
    for (int j = 0; j < m; j++)
      c[j] = j;
    for (int i = 0; i < k; i++) {
      String s = next();
      if (s.equals("r"))
        swap(r, nextInt() - 1, nextInt() - 1);
      else if (s.equals("c"))
        swap(c, nextInt() - 1, nextInt() - 1);
      else {
        int x = r[nextInt() - 1];
        int y = c[nextInt() - 1];
        out.println(b[x][y]);
      }
    }
  }

  static void swap(int[] a, int i, int j) {
    int t = a[i];
    a[i] = a[j];
    a[j] = t;
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
