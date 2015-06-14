package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FlagDay {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt(), m = nextInt();
    int[] a = new int[n + 1];
    for (int i = 0; i < m; i++) {
      int x = nextInt(), y = nextInt(), z = nextInt();
      if (a[x] == 0 && a[y] == 0 & a[z] == 0) {
        a[x] = 1;
        a[y] = 2;
        a[z] = 3;
      } else if (a[x] != 0) {
        a[y] = a[x] + 1;
        if (a[y] > 3)
          a[y] -= 3;
        a[z] = a[x] + 2;
        if (a[z] > 3)
          a[z] -= 3;
      } else if (a[y] != 0) {
        a[x] = a[y] + 1;
        if (a[x] > 3)
          a[x] -= 3;
        a[z] = a[y] + 2;
        if (a[z] > 3)
          a[z] -= 3;
      } else {
        a[x] = a[z] + 1;
        if (a[x] > 3)
          a[x] -= 3;
        a[y] = a[z] + 2;
        if (a[y] > 3)
          a[y] -= 3;
      }
    }
    for (int i = 1; i <= n; i++)
      out.print(a[i] + " ");
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
