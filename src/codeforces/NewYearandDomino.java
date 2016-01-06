package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class NewYearandDomino {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int h = nextInt(), w = nextInt();
    char[][] c = new char[h][w];
    for (int i = 0; i < h; i++) {
      c[i] = next().toCharArray();
    }
    int q = nextInt();
    int[][] dp1 = new int[h][w];
    for (int i = 0; i < h; i++) {
      for (int j = 1; j < w; j++) {
        if (c[i][j - 1] == '.' && c[i][j] == '.') {
          dp1[i][j] = dp1[i][j - 1] + 1;
        } else {
          dp1[i][j] = dp1[i][j - 1];
        }
      }
    }
    int[][] dp2 = new int[h][w];
    for (int j = 0; j < w; j++) {
      for (int i = 1; i < h; i++) {
        if (c[i - 1][j] == '.' && c[i][j] == '.') {
          dp2[i][j] = dp2[i - 1][j] + 1;
        } else {
          dp2[i][j] = dp2[i - 1][j];
        }
      }
    }
    while (q-- > 0) {
      int r1 = nextInt(), c1 = nextInt();
      int r2 = nextInt(), c2 = nextInt();
      long ans = 0;
      for (int i = r1 - 1; i < r2; i++) {
        ans += dp1[i][c2 - 1] - dp1[i][c1 - 1];
      }
      for (int j = c1 - 1; j < c2; j++) {
        ans += dp2[r2 - 1][j] - dp2[r1 - 1][j];
      }
      out.println(ans);
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
