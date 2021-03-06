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

public class Constellation {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    List<ConstellationCoordinates> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list.add(new ConstellationCoordinates(nextLong(), nextLong(), i + 1));
    }
    Collections.sort(list);
    int i = 0, j = 1;
    for (int k = 2; k < n; k++) {
      if (!check(list, i, j, k)) {
        out.println(list.get(i).i + " " + list.get(j).i + " " + list.get(k).i);
        return;
      }
    }
  }

  static boolean check(List<ConstellationCoordinates> list, int i, int j, int k) {
    ConstellationCoordinates ci = list.get(i);
    ConstellationCoordinates cj = list.get(j);
    ConstellationCoordinates ck = list.get(k);
    if (ci.x == cj.x && ci.x == ck.x) {
      return true;
    }
    if (ci.y == cj.y && ci.y == ck.y) {
      return true;
    }
    if ((cj.x - ci.x) * (ck.y - ci.y) == (ck.x - ci.x) * (cj.y - ci.y)) {
      return true;
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


class ConstellationCoordinates implements Comparable<ConstellationCoordinates> {
  long x;
  long y;
  int i;

  ConstellationCoordinates(long x, long y, int i) {
    this.x = x;
    this.y = y;
    this.i = i;
  }

  @Override
  public int compareTo(ConstellationCoordinates o) {
    return x == o.x ? Long.compare(y, o.y) : Long.compare(x, o.x);
  }
}
