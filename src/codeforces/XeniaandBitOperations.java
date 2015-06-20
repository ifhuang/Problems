package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class XeniaandBitOperations {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt(), m = nextInt();
    int len = 1 << n;
    int[][] a = new int[n + 1][];
    a[0] = nextIntArray(len, 0);
    for (int i = 1; i <= n; i++) {
      a[i] = new int[1 << (n - i)];
      for (int j = 0; j < a[i].length; j++)
        if (i % 2 == 1)
          a[i][j] = a[i - 1][j * 2] | a[i - 1][j * 2 + 1];
        else
          a[i][j] = a[i - 1][j * 2] ^ a[i - 1][j * 2 + 1];
    }
    for (int i = 0; i < m; i++) {
      int p = nextInt() - 1;
      int b = nextInt();
      a[0][p] = b;
      p /= 2;
      for (int j = 1; j <= n; j++, p /= 2)
        if (j % 2 == 1)
          a[j][p] = a[j - 1][p * 2] | a[j - 1][p * 2 + 1];
        else
          a[j][p] = a[j - 1][p * 2] ^ a[j - 1][p * 2 + 1];;
      out.println(a[n][0]);
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
