package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class JerrysProtest {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    int[] a = nextIntArray(n, 0);
    int max = 5000;
    int[] d = new int[max * 2];
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        d[Math.abs(a[i] - a[j])]++;
      }
    }
    int[] post = new int[max * 2];
    for (int i = max * 2 - 2; i >= 0; i--) {
      post[i] = post[i + 1] + d[i];
    }
    long x = 0;
    for (int i = 0; i < max; i++) {
      for (int j = 0; j < max; j++) {
        x += (long) d[i] * d[j] * post[i + j + 1];
      }
    }
    long t = n * (n - 1) / 2;
    double ans = (double) x / (t * t * t);
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
