package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MikeandFeet {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    int[] a = new int[n + 2];
    for (int i = 1; i <= n; i++)
      a[i] = nextInt();
    int[] l = new int[n + 2];
    for (int i = 1; i <= n; i++) {
      int j = i - 1;
      while (a[j] >= a[i])
        j = l[j];
      l[i] = j;
    }
    int[] r = new int[n + 2];
    for (int i = n; i >= 1; i--) {
      int j = i + 1;
      while (a[j] >= a[i])
        j = r[j];
      r[i] = j;
    }
    int[] dp = new int[n + 2];
    for (int i = 1; i <= n; i++) {
      int len = r[i] - l[i] - 1;
      dp[len] = Math.max(dp[len], a[i]);
    }
    for (int i = n - 1; i >= 1; i--)
      dp[i] = Math.max(dp[i], dp[i + 1]);
    for (int i = 1; i <= n; i++)
      out.print(dp[i] + " ");
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
