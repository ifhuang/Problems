package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FoxandCross {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    char[][] c = new char[n][n];
    for (int i = 0; i < n; i++)
      c[i] = next().toCharArray();
    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
        if (!check(c, i, j, n)) {
          out.println("NO");
          return;
        }
    out.println("YES");
  }

  static boolean check(char[][] c, int i, int j, int n) {
    if (c[i][j] == '#') {
      int[][] d = { {0, 0}, {1, 0}, {2, 0}, {1, 1}, {1, -1}};
      for (int k = 0; k < d.length; k++) {
        int x = i + d[k][0];
        int y = j + d[k][1];
        if (x >= 0 && x < n && y >= 0 && y < n && c[x][y] == '#')
          c[x][y] = '.';
        else
          return false;
      }
    }
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
