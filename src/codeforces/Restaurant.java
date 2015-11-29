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

public class Restaurant {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    List<Rental> list = new ArrayList<>();
    while (n-- > 0) {
      list.add(new Rental(nextInt(), nextInt()));
    }
    Collections.sort(list);
    Rental preLeft = new Rental(0, 0);
    int ansLeft = 0;
    for (Rental rental : list) {
      if (rental.l > preLeft.r) {
        preLeft = rental;
        ansLeft++;
      }
    }
    Rental postRight = new Rental(Integer.MAX_VALUE, Integer.MAX_VALUE);
    int ansRight = 0;
    for (int i = list.size() - 1; i >= 0; i--) {
      Rental cur = list.get(i);
      if (cur.r < postRight.l) {
        postRight = cur;
        ansRight++;
      }
    }
    out.println(Math.max(ansLeft, ansRight));
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


class Rental implements Comparable<Rental> {
  int l;
  int r;

  Rental(int l, int r) {
    this.l = l;
    this.r = r;
  }

  @Override
  public int compareTo(Rental o) {
    return l == o.l ? r - o.r : l - o.l;
  }
}
