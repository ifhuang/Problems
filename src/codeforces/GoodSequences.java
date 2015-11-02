package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GoodSequences {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    int[] a = nextIntArray(n, 0);
    int max = a[n - 1] + 1;
    int[] p = helper(max);
    int[] dp = new int[max];
    for (int i = 0; i < n; i++) {
      int cur = a[i];
      int got = 0;
      while (cur > 1) {
        int prime = p[cur];
        while (cur % prime == 0) {
          cur /= prime;
        }
        got = Math.max(got, dp[prime]);
      }
      cur = a[i];
      while (cur > 1) {
        int prime = p[cur];
        while (cur % prime == 0) {
          cur /= prime;
        }
        dp[prime] = got + 1;
      }
    }
    int ans = 1;
    for (int i : dp) {
      ans = Math.max(ans, i);
    }
    out.println(ans);
  }

  static int[] helper(int n) {
    int[] p = new int[n];
    for (int i = 2; i < n; i++) {
      if (p[i] == 0) {
        for (int j = i; j < n; j += i) {
          p[j] = i;
        }
      }
    }
    return p;
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
