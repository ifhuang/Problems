package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GuessthePermutation {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    int[][] a = new int[n][n];
    for (int i = 0; i < n; i++) {
      a[i] = nextIntArray(n, 0);
    }
    int[] ans = new int[n];
    for (int i = 0; i < n; i++) {
      int max = 0;
      for (int r = 0; r < n; r++) {
        max = Math.max(max, a[r][i]);
      }
      for (int c = 0; c < n; c++) {
        max = Math.max(max, a[i][c]);
      }
      ans[i] = max;
    }
    for (int i = 0; i < n; i++) {
      if (ans[i] == n - 1) {
        ans[i] = n;
        break;
      }
    }
    for (int i = 0; i < n; i++) {
      out.print(ans[i] + " ");
    }
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
