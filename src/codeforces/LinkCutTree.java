package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LinkCutTree {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    BigInteger l = new BigInteger(next());
    BigInteger r = new BigInteger(next());
    BigInteger k = new BigInteger(next());
    BigInteger t = BigInteger.ONE;
    int count = 0;
    while (t.compareTo(r) <= 0) {
      if (t.compareTo(l) >= 0) {
        count++;
        out.print(t + " ");
      }
      t = t.multiply(k);
    }
    if (count == 0) {
      out.println(-1);
    }
  }

  static void test() throws Exception {
    long l = nextLong(), r = nextLong(), k = nextLong();
    List<Long> list = new ArrayList<>();
    for (int i = 0; i < r; i++) {
      long cur = (long) Math.pow(k, i);
      if (cur <= r && cur >= l) {
        list.add(cur);
      } else if (cur > r) {
        break;
      }
    }
    out.println(list);
  }

  public static void main(String args[]) {
    try {
      in = new BufferedReader(new InputStreamReader(System.in));
      out = new PrintWriter(new OutputStreamWriter(System.out));
      // solve();
      test();
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
