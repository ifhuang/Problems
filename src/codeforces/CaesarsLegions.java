package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CaesarsLegions {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int MOD = 100000000;
    int n1 = nextInt(), n2 = nextInt(), k1 = nextInt(), k2 = nextInt();
    int[][][] dp = new int[n1 + 1][n2 + 1][2];
    for (int i = 0; i <= n1; i++) {
      for (int j = 0; j <= n2; j++) {
        if (i == 0 && j == 0) {
          dp[0][0][0] = dp[0][0][1] = 1;
        } else {
          for (int k = 1; k <= Math.min(k1, i); k++) {
            dp[i][j][0] = (dp[i][j][0] + dp[i - k][j][1]) % MOD;
          }
          for (int k = 1; k <= Math.min(k2, j); k++) {
            dp[i][j][1] = (dp[i][j][1] + dp[i][j - k][0]) % MOD;
          }
        }
      }
    }
    out.println((dp[n1][n2][0] + dp[n1][n2][1]) % MOD);
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
