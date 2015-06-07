package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class VasyaandPublicTransport {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int c1 = nextInt(), c2 = nextInt(), c3 = nextInt(), c4 = nextInt();
    int n = nextInt(), m = nextInt();
    int[] a = nextIntArray(n, 0);
    int[] b = nextIntArray(m, 0);
    int ans = Math.min(c4, 2 * c3);
    int t1 = 0;
    for (int ai : a)
      t1 += Math.min(ai * c1, c2);
    t1 = Math.min(t1, c3);
    int t2 = 0;
    for (int bi : b)
      t2 += Math.min(bi * c1, c2);
    t2 = Math.min(t2, c3);
    ans = Math.min(ans, t1 + t2);
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
