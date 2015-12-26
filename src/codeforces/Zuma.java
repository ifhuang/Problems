package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Zuma {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static int ans;

  static void solve() throws Exception {
    int n = nextInt();
    int[] c = nextIntArray(n, 0);
    int[][] dp = new int[n][n];
    for (int len = 1; len <= n; len++) {
      for (int begin = 0, end = len - 1; end < n; begin++, end++) {
        if (len == 1) {
          dp[begin][end] = 1;
        } else {
          dp[begin][end] = 1 + dp[begin + 1][end];
          if (c[begin] == c[begin + 1]) {
            dp[begin][end] = Math.min(dp[begin][end], 1 + (len == 2 ? 0 : dp[begin + 2][end]));
          }
          for (int i = begin + 2; i <= end; i++) {
            if (c[begin] == c[i]) {
              dp[begin][end] =
                  Math.min(dp[begin][end], dp[begin + 1][i - 1] + (i == end ? 0 : dp[i + 1][end]));
            }
          }
        }
      }
    }
    out.println(dp[0][n - 1]);
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
