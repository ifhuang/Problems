package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ChainReaction {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    int max = 1000000;
    int[] b = new int[max + 1];
    for (int i = 0; i < n; i++) {
      int a = nextInt();
      b[a] = nextInt();
    }
    int[] dp = new int[max + 1];
    dp[0] = b[0] > 0 ? 1 : 0;
    int ans = 0;
    for (int i = 1; i <= max; i++) {
      if (b[i] == 0) {
        dp[i] = dp[i - 1];
      } else {
        dp[i] = b[i] >= i ? 1 : dp[i - b[i] - 1] + 1;
      }
      ans = Math.max(ans, dp[i]);
    }
    out.println(n - ans);
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
