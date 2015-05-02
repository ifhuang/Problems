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

public class DesignTutorialMakeItNondeterministic {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    List<Name> list = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      list.add(new Name(next(), i));
      list.add(new Name(next(), i));
    }
    Collections.sort(list);
    int[] p = nextIntArray(n, 0);
    int i = 0, j = 0;
    for (; i < n && j < 2 * n;)
      if (p[i] == list.get(j).i) {
        i++;
        j++;
      } else
        j++;
    out.println(i == n ? "YES" : "NO");
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


class Name implements Comparable<Name> {
  String s;
  int i;

  Name(String a, int j) {
    s = a;
    i = j;
  }

  @Override
  public int compareTo(Name o) {
    return s.compareTo(o.s);
  }
}
