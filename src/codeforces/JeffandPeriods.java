package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class JeffandPeriods {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    int[] a = nextIntArray(n, 0);
    int max = 100000;
    Item[] items = new Item[max + 1];
    Set<Integer> not = new HashSet<>();
    Set<Integer> all = new HashSet<>();
    for (int i = 0; i < n; i++) {
      all.add(a[i]);
      if (!not.contains(a[i]))
        if (items[a[i]] == null)
          items[a[i]] = new Item(i, 0);
        else if (items[a[i]].diff == 0) {
          items[a[i]].diff = i - items[a[i]].pre;
          items[a[i]].pre = i;
        } else {
          int nd = i - items[a[i]].pre;
          if (nd != items[a[i]].diff) {
            not.add(a[i]);
            items[a[i]] = null;
          } else
            items[a[i]].pre = i;
        }
    }
    out.println(all.size() - not.size());
    for (int i = 1; i <= max; i++)
      if (items[i] != null)
        out.println(i + " " + items[i].diff);
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


class Item {
  int pre;
  int diff;

  Item(int a, int b) {
    pre = a;
    diff = b;
  }
}
