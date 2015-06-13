package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class OmNomandSpiders {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt(), m = nextInt(), k = nextInt();
    char[][] c = new char[n][m];
    for (int i = 0; i < n; i++)
      c[i] = next().toCharArray();
    int[] count = new int[m];
    for (int i = 1; i < n; i++)
      for (int j = 0; j < m; j++)
        switch (c[i][j]) {
          case 'U':
            if (i % 2 == 0)
              count[j]++;
            break;
          case 'L':
            if (j - i >= 0)
              count[j - i]++;
            break;
          case 'R':
            if (j + i < m)
              count[j + i]++;
            break;
          default:
            break;
        }
    for (int j = 0; j < m; j++)
      out.print(count[j] + " ");
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
