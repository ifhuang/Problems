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

public class Megacity {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt(), s = nextInt();
    List<Location> list = new ArrayList<>();
    for (int i = 0; i < n; i++)
      list.add(new Location(nextInt(), nextInt(), nextInt()));
    Collections.sort(list);
    int i = 0;
    while (s < 1e6 && i < n) {
      s += list.get(i).k;
      i++;
    }
    if (s >= 1e6)
      out.println(list.get(i - 1).distance());
    else
      out.println(-1);
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


class Location implements Comparable<Location> {
  int x, y, k;

  Location(int x, int y, int k) {
    this.x = x;
    this.y = y;
    this.k = k;
  }

  @Override
  public int compareTo(Location o) {
    return (x * x + y * y) - (o.x * o.x + o.y * o.y);
  }

  public double distance() {
    return Math.sqrt(x * x + y * y);
  }
}
