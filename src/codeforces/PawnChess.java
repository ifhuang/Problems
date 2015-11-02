package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PawnChess {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = 8;
    char[][] c = new char[n][n];
    for (int i = 0; i < n; i++) {
      c[i] = next().toCharArray();
    }
    int a = helperA(c, n);
    int b = helperB(c, n);
    out.println(a <= b ? "A" : "B");
  }

  static int helperA(char[][] c, int n) {
    int a = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (c[i][j] == 'W') {
          int k = i - 1;
          for (; k >= 0; k--) {
            if (c[k][j] != '.') {
              break;
            }
          }
          if (k == -1) {
            a = i;
            return a;
          }
        }
      }
    }
    return a;
  }

  static int helperB(char[][] c, int n) {
    int b = 0;
    for (int i = n - 1; i >= 0; i--) {
      for (int j = n - 1; j >= 0; j--) {
        if (c[i][j] == 'B') {
          int k = i + 1;
          for (; k < n; k++) {
            if (c[k][j] != '.') {
              break;
            }
          }
          if (k == n) {
            b = n - 1 - i;
            return b;
          }
        }
      }
    }
    return b;
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
