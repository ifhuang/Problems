package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class OnceAgain {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    int T = nextInt();
    int[] a = nextIntArray(n, 0);
    
    int m = 301;
    long[][] mat = new long[m + 1][m + 1];
    for (int i = 0; i < n; i++) {
      long[][] next = new long[m + 1][m + 1];
      for (int j = 0; j <= m; j++)
        System.arraycopy(mat[j], 0, next[j], 0, m + 1);
      for (int last = 0; last <= a[i]; last++) {
        for (int first = 0; first <= last; first++) {
          next[first][a[i]] = Math.max(next[first][a[i]], mat[first][last] + 1);
        }
      }
      mat = next;
    }
    long[][] res = matrixPow(mat, T);
    long ans = 0;
    for (int i = 0; i <= m; i++) {
      for (int j = 0; j <= m; j++) {
        ans = Math.max(ans, res[i][j]);
      }
    }
    out.println(ans);
  }

  static long[][] matrixPow(long[][] m, int T) {
    if (T == 1)
      return m;
    else if (T % 2 == 0) {
      long[][] A1 = matrixPow(m, T / 2);
      return matrixMultiply(A1, A1);
    } else
      return matrixMultiply(m, matrixPow(m, T - 1));
  }

  static long[][] matrixMultiply(long[][] a, long[][] b) {
    int n = a.length;
    long[][] c = new long[n][n];
    for (int i = 0; i < n; i++)
      for (int j = i; j < n; j++)
        for (int k = j; k < n; k++) {
          if (a[i][j] == 0 || a[j][k] == 0)
            continue;
          c[i][k] = Math.max(c[i][k], a[i][j] + b[j][k]);
        }
    return c;
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
