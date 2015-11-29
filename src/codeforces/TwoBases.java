package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TwoBases {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt(), b = nextInt();
    int[] x = nextIntArray(n, 0);
    long ans1 = 0;
    long b1 = 1;
    for (int i = n - 1; i >= 0; i--, b1 *= b) {
      ans1 += b1 * x[i];
    }
    int m = nextInt(), c = nextInt();
    int[] y = nextIntArray(m, 0);
    long ans2 = 0;
    long b2 = 1;
    for (int i = m - 1; i >= 0; i--, b2 *= c) {
      ans2 += b2 * y[i];
    }
    if (ans1 > ans2) {
      out.println(">");
    } else if (ans1 < ans2) {
      out.println("<");
    } else {
      out.println("=");
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
