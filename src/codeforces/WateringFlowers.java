package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class WateringFlowers {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    long x1 = nextLong(), y1 = nextLong();
    long x2 = nextLong(), y2 = nextLong();
    long[] d1 = new long[n + 1];
    long[] d2 = new long[n + 1];
    for (int i = 0; i < n; i++) {
      long x = nextLong(), y = nextLong();
      d1[i + 1] = (x - x1) * (x - x1) + (y - y1) * (y - y1);
      d2[i + 1] = (x - x2) * (x - x2) + (y - y2) * (y - y2);
    }
    long ans = Long.MAX_VALUE;
    for (int i = 0; i < n + 1; i++) {
      long r1 = d1[i];
      long r2 = 0;
      for (int j = 0; j < n + 1; j++) {
        if (d1[j] > r1) {
          r2 = Math.max(r2, d2[j]);
        }
      }
      ans = Math.min(ans, r1 + r2);
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
