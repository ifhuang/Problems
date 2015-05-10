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

public class BigSegment {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    List<Segment> list = new ArrayList<>();
    for (int i = 1; i <= n; i++)
      list.add(new Segment(nextInt(), nextInt(), i));
    Collections.sort(list);
    for (int i = 1; i < n; i++)
      if (list.get(i).l < list.get(0).l || list.get(i).r > list.get(0).r) {
        out.println(-1);
        return;
      }
    out.println(list.get(0).i);
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


class Segment implements Comparable<Segment> {
  int l;
  int r;
  int i;

  Segment(int a, int b, int c) {
    l = a;
    r = b;
    i = c;
  }

  @Override
  public int compareTo(Segment o) {
    return l == o.l ? o.r - r : l - o.l;
  }
}
