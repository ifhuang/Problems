package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ORinMatrix {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int m = nextInt();
    int n = nextInt();
    int[][] B = new int[m][n];
    for (int i = 0; i < m; i++)
      B[i] = nextIntArray(n, 0);
    boolean[] row = new boolean[m];
    boolean[] col = new boolean[n];
    for (int i = 0; i < m; i++)
      for (int j = 0; j < n; j++)
        if (B[i][j] == 0)
          row[i] = col[j] = true;
    int[][] A = new int[m][n];
    for (int i = 0; i < m; i++)
      for (int j = 0; j < n; j++)
        A[i][j] = (row[i] || col[j] ? 0 : 1);
    for (int i = 0; i < m; i++)
      for (int j = 0; j < n; j++)
        if (B[i][j] == 1 && !check(A, i, j)) {
          out.println("NO");
          return;
        }
    out.println("YES");
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++)
        out.print(A[i][j] + " ");
      out.println();
    }
  }

  static boolean check(int[][] A, int i, int j) {
    int m = A.length;
    int n = A[0].length;
    for (int x = 0; x < m; x++)
      if (A[x][j] == 1)
        return true;
    for (int y = 0; y < n; y++)
      if (A[i][y] == 1)
        return true;
    return false;
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
