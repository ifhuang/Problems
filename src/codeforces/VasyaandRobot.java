package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class VasyaandRobot {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt(), l = nextInt(), r = nextInt(), Ql = nextInt(), Qr = nextInt();
    int[] w = nextIntArray(n, 0);
    int[] left = new int[n + 1];
    for (int i = 1; i <= n; i++)
      left[i] = left[i - 1] + w[i - 1];
    int[] right = new int[n + 1];
    for (int i = n - 1; i >= 0; i--)
      right[i] = right[i + 1] + w[i];
    int ans = Integer.MAX_VALUE;
    for (int k = 0; k <= n; k++) {
      int t = l * left[k] + r * right[k];
      if (2 * k < n)
        t += (n - 2 * k - 1) * Qr;
      if (2 * k > n)
        t += (2 * k - n - 1) * Ql;
      ans = Math.min(ans, t);
    }
    out.println(ans);
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
