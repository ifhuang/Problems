package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PeterandSnowBlower {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    long x0 = nextLong();
    long y0 = nextLong();
    double maxd = 0;
    double mind = 1e100;
    long px = -1;
    long py = -1;
    long fx = -1;
    long fy = -1;
    for (int i = 0; i <= n; ++i) {
      long x = i == n ? fx : (nextLong() - x0);
      long y = i == n ? fy : (nextLong() - y0);
      double d = x * x + y * y;
      maxd = Math.max(maxd, d);
      mind = Math.min(mind, d);
      if (i > 0) {
        if ((px - x) * (-x) + (py - y) * (-y) > 0 && (x - px) * (-px) + (y - py) * (-py) > 0) {
          long a = y - py;
          long b = px - x;
          long c = -(a * x + b * y);
          mind = Math.min(mind, c * (double) c / (a * (double) a + b * (double) b));
        }
      } else {
        fx = x;
        fy = y;
      }
      px = x;
      py = y;
    }
    out.println(Math.PI * (maxd - mind));
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
