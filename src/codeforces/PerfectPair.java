package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PerfectPair {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    long x = nextLong(), y = nextLong(), m = nextLong();
    long a = Math.min(x, y);
    long b = Math.max(x, y);
    long i = 0;
    if (b >= m) {
      out.println(i);
      return;
    }
    if (a < 0) {
      if (b <= 0) {
        out.println(-1);
        return;
      }
      long t = Math.abs(a) / b;
      i += t;
      a += t * b;
    }
    while (true) {
      if (b >= m) {
        out.println(i);
        return;
      }
      long c = a + b;
      if (c <= a) {
        out.println(-1);
        return;
      }
      a = Math.min(b, c);
      b = Math.max(b, c);
      i++;
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
