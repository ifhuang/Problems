package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MikeandFrog {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    long m = nextLong();
    long h1 = nextLong(), a1 = nextLong();
    long x1 = nextLong(), y1 = nextLong();
    long h2 = nextLong(), a2 = nextLong();
    long x2 = nextLong(), y2 = nextLong();
    List<Long> list1 = new ArrayList<>();
    List<Long> list2 = new ArrayList<>();
    long t = 0;
    while (t <= 2 * m) {
      if (h1 == a1)
        list1.add(t);
      if (h2 == a2)
        list2.add(t);
      h1 = (x1 * h1 + y1) % m;
      h2 = (x2 * h2 + y2) % m;
      t++;
    }
    if (list1.isEmpty() || list2.isEmpty()) {
      out.println(-1);
      return;
    }
    long t1 = list1.get(0);
    long t2 = list2.get(0);
    long diff1 = list1.size() == 1 ? 0 : list1.get(1) - t1;
    long diff2 = list2.size() == 1 ? 0 : list2.get(1) - t2;
    for (int i = 0; i < 5000000; i++)
      if (t1 == t2) {
        out.println(t1);
        return;
      } else if (t1 < t2)
        t1 += diff1;
      else
        t2 += diff2;
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
