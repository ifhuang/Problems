package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GargariandBishops {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    long[][] a = new long[n][n];
    for (int i = 0; i < n; i++)
      a[i] = nextLongArray(n, 0);
    long[][] d = new long[2 * n - 1][2];
    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++) {
        d[n - 1 - i + j][0] += a[i][j];
        d[i + j][1] += a[i][j];
      }
    long[][] ans = new long[3][2];
    ans[0][0] = ans[0][1] = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++) {
        long t = d[n - 1 - i + j][0] + d[i + j][1] - a[i][j];
        int x = (i + j) % 2;
        if (t > ans[0][x]) {
          ans[0][x] = t;
          ans[1][x] = i + 1;
          ans[2][x] = j + 1;
        }
      }
    out.println(ans[0][0] + ans[0][1]);
    out.println(ans[1][0] + " " + ans[2][0] + " " + ans[1][1] + " " + ans[2][1]);
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
