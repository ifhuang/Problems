package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GuestFromthePast {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    long n = nextLong();
    long a = nextLong(), b = nextLong(), c = nextLong();
    long ans = 0;

    long n1 = n;
    long ans1 = helperA(n1, a);
    n1 -= ans1 * a;
    ans1 += helperB(n1, b, c);

    long n2 = n;
    long ans2 = helperB(n2, b, c);
    n2 -= ans2 * (b - c);
    ans2 += helperA(n2, a);

    ans = Math.max(ans1, ans2);

    out.println(ans);
  }

  static long helperA(long n, long a) {
    return n / a;
  }

  static long helperB(long n, long b, long c) {
    return n < b ? 0 : 1 + (n - b) / (b - c);
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
