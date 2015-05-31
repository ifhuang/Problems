package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class XORandOR {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    char[] a = next().toCharArray();
    char[] b = next().toCharArray();
    if (a.length != b.length) {
      out.println("NO");
      return;
    }
    int[][] count = new int[2][2];
    for (char c : a)
      count[0][c - '0']++;
    for (char c : b)
      count[1][c - '0']++;
    if (count[0][0] == count[1][0])
      out.println("YES");
    else if (count[0][0] > count[1][0]) {
      if (count[0][1] >= 1)
        out.println("YES");
      else
        out.println("NO");
    } else {
      if (count[0][1] > count[1][0] - count[0][0])
        out.println("YES");
      else
        out.println("NO");
    }
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
