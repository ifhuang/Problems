package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Polyline {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    long[] x = new long[3];
    long[] y = new long[3];
    for (int i = 0; i < 3; i++) {
      x[i] = nextLong();
      y[i] = nextLong();
    }
    if (check1(x, y)) {
      out.println(1);
    } else if (check2(x, y)) {
      out.println(2);
    } else {
      out.println(3);
    }
  }

  static boolean check1(long[] x, long[] y) {
    return (x[0] == x[1] && x[0] == x[2]) || (y[0] == y[1] && y[0] == y[2]);
  }

  static boolean check2(long[] x, long[] y) {
    long[] t1 = {x[0], y[0], x[1], y[1], x[2], y[2]};
    long[] t2 = {x[0], y[0], x[2], y[2], x[1], y[1]};
    long[] t3 = {x[1], y[1], x[2], y[2], x[0], y[0]};
    long[] t4 = {y[0], x[0], y[1], x[1], y[2], x[2]};
    long[] t5 = {y[0], x[0], y[2], x[2], y[1], x[1]};
    long[] t6 = {y[1], x[1], y[2], x[2], y[0], x[0]};
    long[][] t = {t1, t2, t3, t4, t5, t6};
    for (int i = 0; i < 6; i++) {
      if (check2helper(t[i])) {
        return true;
      }
    }
    return false;
  }

  static boolean check2helper(long[] t) {
    if (t[0] == t[2]) {
      long min = Math.min(t[1], t[3]);
      long max = Math.max(t[1], t[3]);
      if (t[5] <= min || t[5] >= max) {
        return true;
      }
    }
    return false;
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
