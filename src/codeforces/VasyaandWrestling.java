package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class VasyaandWrestling {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    List<Long> a = new ArrayList<>();
    List<Long> b = new ArrayList<>();
    long sa = 0;
    long sb = 0;
    boolean first = false;
    for (int i = 0; i < n; i++) {
      long t = nextLong();
      if (t > 0) {
        a.add(t);
        sa += t;
        first = true;
      } else {
        t = -t;
        b.add(t);
        sb += t;
        first = false;
      }
    }
    if (sa != sb)
      first = (sa > sb);
    else {
      int lex = check(a, b);
      if (lex != 0)
        first = (lex > 0);
    }
    out.println(first ? "first" : "second");
  }

  static int check(List<Long> a, List<Long> b) {
    for (int i = 0; i < a.size() && i < b.size(); i++)
      if (a.get(i) > b.get(i))
        return 1;
      else if (a.get(i) < b.get(i))
        return -1;
    if (a.size() > b.size())
      return 1;
    else if (a.size() < b.size())
      return -1;
    else
      return 0;
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
