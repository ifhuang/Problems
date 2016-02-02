package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class WetSharkandFlowers {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    long p = nextLong();
    long[] l = new long[n];
    long[] r = new long[n];
    long[] a = new long[n];
    long[] b = new long[n];
    double[] c = new double[n];
    for (int i = 0; i < n; i++) {
      l[i] = nextLong();
      r[i] = nextLong();
      a[i] = r[i] - l[i] + 1;
      b[i] = r[i] / p - (l[i] - 1) / p;
      c[i] = (double) b[i] / a[i];
    }
    double ans = 0.;
    for (int i = 0; i < n - 1; i++) {
      double x = 1 - (1 - c[i]) * (1 - c[i + 1]);
      ans += x * 2000;
    }
    double y = 1 - (1 - c[n - 1]) * (1 - c[0]);
    ans += y * 2000;
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
