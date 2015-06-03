package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ValeraandTubes {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt(), m = nextInt(), k = nextInt();
    List<XY> list = new ArrayList<>();
    for (int i = 1; i <= n; i++)
      if (i % 2 == 0)
        for (int j = 1; j <= m; j++)
          list.add(new XY(i, j));
      else
        for (int j = m; j >= 1; j--)
          list.add(new XY(i, j));
    int x = 0;
    for (int i = 0; i < k; i++)
      if (i == k - 1) {
        out.print(m * n - x);
        while (x < m * n) {
          out.print(" " + list.get(x).x + " " + list.get(x).y);
          x++;
        }
      } else {
        out.print(2);
        out.print(" " + list.get(x).x + " " + list.get(x).y);
        x++;
        out.print(" " + list.get(x).x + " " + list.get(x).y);
        x++;
        out.println();
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


class XY {
  int x;
  int y;

  XY(int a, int b) {
    x = a;
    y = b;
  }
}
