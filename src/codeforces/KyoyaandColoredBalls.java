package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class KyoyaandColoredBalls {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    long MOD = 1000000007;
    int N = 1000;
    int k = nextInt();
    int[] c = nextIntArray(k, 0);
    int sum = 0;
    for (int i = 0; i < k; i++)
      sum += c[i];
    long ans = 1;
    long[][] bc = bc(N, MOD);
    for (int i = k - 1; i > 0; i--) {
      ans = ans * bc[sum - 1][c[i] - 1] % MOD;
      sum -= c[i];
    }
    out.println(ans);
  }

  static long[][] bc(int n, long mod) {
    long[][] bc = new long[n][n];
    for (int i = 0; i < n; i++) {
      bc[i][0] = bc[i][i] = 1;
      for (int j = 1; j < i; j++)
        bc[i][j] = (bc[i - 1][j - 1] + bc[i - 1][j]) % mod;
    }
    return bc;
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
