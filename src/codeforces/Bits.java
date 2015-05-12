package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Bits {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    while (n-- > 0) {
      long l = nextLong();
      int lc = count(l);
      long r = nextLong();
      int rc = count(r);
      long c = construct(l, r);
      int cc = count(c);
      List<Bit> list = new ArrayList<>();
      list.add(new Bit(l, lc));
      list.add(new Bit(r, rc));
      list.add(new Bit(c, cc));
      Collections.sort(list);
      out.println(list.get(0).a);
    }
  }

  static int count(long x) {
    int c = 0;
    for (int i = 0; i < 64; i++)
      if ((x & (1L << i)) > 0)
        c++;
    return c;
  }

  static long construct(long x, long y) {
    long c = 0;
    for (int i = 63; i >= 0; i--) {
      long a = (x & (1L << i));
      long b = (y & (1L << i));
      if (a == b)
        c = c * 2 + (a == 0 ? 0 : 1);
      else {
        c *= 2;
        while (i-- > 0)
          c = c * 2 + 1;
        break;
      }
    }
    return c;
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


class Bit implements Comparable<Bit> {
  long a;
  int c;

  Bit(long x, int y) {
    a = x;
    c = y;
  }

  @Override
  public int compareTo(Bit o) {
    return (int) (c == o.c ? a - o.a : o.c - c);
  }
}
