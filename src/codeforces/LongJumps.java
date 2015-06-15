package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class LongJumps {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt(), l = nextInt(), x = nextInt(), y = nextInt();
    int[] p = nextIntArray(n, 0);
    Set<Integer> set = new HashSet<>();
    set.add(x);
    set.add(y);
    Set<Integer> set2 = new HashSet<>();
    for (int pi : p) {
      if (pi == x)
        set.remove(x);
      if (pi == y)
        set.remove(y);
      if (set2.contains(pi - x))
        set.remove(x);
      if (set2.contains(pi - y))
        set.remove(y);
      set2.add(pi);
    }
    if (set.size() == 2)
      for (int i : set2) {
        int x1 = i + x;
        if (x1 < l && (set2.contains(x1 + y) || set2.contains(x1 - y))) {
          out.println(1);
          out.println(x1);
          return;
        }
        int x2 = i - x;
        if (x2 > 0 && (set2.contains(x2 + y) || set2.contains(x2 - y))) {
          out.println(1);
          out.println(x2);
          return;
        }
        int y1 = i + y;
        if (y1 < l && (set2.contains(y1 + x) || set2.contains(y1 - x))) {
          out.println(1);
          out.println(y1);
          return;
        }
        int y2 = i - y;
        if (y2 > 0 && (set2.contains(y2 + x) || set2.contains(y2 - x))) {
          out.println(1);
          out.println(y2);
          return;
        }
      }
    out.println(set.size());
    for (int i : set)
      out.print(i + " ");
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
