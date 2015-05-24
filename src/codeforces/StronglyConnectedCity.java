package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class StronglyConnectedCity {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt(), m = nextInt();
    char[] cn = next().toCharArray();
    char[] cm = next().toCharArray();
    char[][][] c = new char[n][m][2];
    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++) {
        c[i][j][0] = cn[i];
        c[i][j][1] = cm[j];
      }
    boolean[][] b = new boolean[n][m];
    dfs(c, b, 0, 0, n, m);
    out.println(check(b, n, m) ? "YES" : "NO");
  }

  static void dfs(char[][][] c, boolean[][] b, int x, int y, int n, int m) {
    int[][] d = { {0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    String s = "<>^v";
    for (int i = 0; i < 2; i++) {
      int index = s.indexOf(c[x][y][i]);
      int nx = x + d[index][0];
      int ny = y + d[index][1];
      if (nx >= 0 && nx < n && ny >= 0 && ny < m && !b[nx][ny]) {
        b[nx][ny] = true;
        dfs(c, b, nx, ny, n, m);
      }
    }
  }

  static boolean check(boolean[][] b, int n, int m) {
    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++)
        if (!b[i][j])
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
