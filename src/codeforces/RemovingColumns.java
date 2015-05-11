package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RemovingColumns {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt(), m = nextInt();
    char[][] c = new char[n][m];
    StringBuilder[] s = new StringBuilder[n];
    for (int i = 0; i < n; i++) {
      c[i] = next().toCharArray();
      s[i] = new StringBuilder();
    }
    for (int j = 0; j < m; j++)
      check(c, s, j);
    out.println(m - s[0].length());
  }

  static boolean check(char[][] c, StringBuilder[] s, int index) {
    StringBuilder[] ss = new StringBuilder[s.length];
    for (int i = 0; i < s.length; i++) {
      ss[i] = new StringBuilder(s[i]);
      ss[i].append(c[i][index]);
    }
    int i = 1;
    for (; i < s.length; i++)
      if (ss[i].toString().compareTo(ss[i - 1].toString()) < 0)
        break;
    if (i == s.length) {
      for (int j = 0; j < s.length; j++)
        s[j] = ss[j];
      return true;
    } else
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
