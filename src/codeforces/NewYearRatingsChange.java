package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class NewYearRatingsChange {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    List<Rating> list = new ArrayList<>();
    for (int i = 0; i < n; i++)
      list.add(new Rating(i, nextLong(), 0));
    Collections.sort(list, new Comparator<Rating>() {
      @Override
      public int compare(Rating o1, Rating o2) {
        return (int) (o1.r - o2.r);
      }
    });
    for (int i = 0; i < n; i++)
      if (i == 0 || (list.get(i).r > list.get(i - 1).v))
        list.get(i).v = list.get(i).r;
      else
        list.get(i).v = list.get(i - 1).v + 1;
    Collections.sort(list, new Comparator<Rating>() {
      @Override
      public int compare(Rating o1, Rating o2) {
        return o1.i - o2.i;
      }
    });
    for (int i = 0; i < n; i++)
      out.print(list.get(i).v + " ");
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


class Rating {
  int i;
  long r;
  long v;

  Rating(int a, long b, long c) {
    i = a;
    r = b;
    v = c;
  }
}
