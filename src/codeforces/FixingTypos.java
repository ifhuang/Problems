package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FixingTypos {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    char[] c = next().toCharArray();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < c.length; i++)
      if (i >= 2 && c[i] == sb.charAt(sb.length() - 1) && c[i] == sb.charAt(sb.length() - 2))
        ;
      else
        sb.append(c[i]);
    c = sb.toString().toCharArray();
    sb = new StringBuilder();
    for (int i = 0; i < c.length; i++)
      if (i >= 3 && c[i] == sb.charAt(sb.length() - 1)
          && sb.charAt(sb.length() - 2) == sb.charAt(sb.length() - 3))
        ;
      else
        sb.append(c[i]);
    out.println(sb);
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
