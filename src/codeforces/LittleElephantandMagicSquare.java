package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LittleElephantandMagicSquare {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int[][] m = new int[3][3];
    for (int i = 0; i < 3; i++)
      m[i] = nextIntArray(3, 0);
    int ab = m[0][2] + m[1][2];
    int ac = m[1][0] + m[1][2];
    for (int a = 1; a <= 100000; a++) {
      m[0][0] = a;
      m[1][1] = ab - a;
      m[2][2] = ac - a;
      if (check(m)) {
        print(m);
        return;
      }
    }
  }

  static boolean check(int[][] m) {
    int x = m[0][0] + m[1][1] + m[2][2];
    if (x != m[0][2] + m[1][1] + m[2][0])
      return false;
    for (int i = 0; i < 3; i++) {
      int y = 0;
      for (int j = 0; j < 3; j++)
        y += m[i][j];
      if (x != y)
        return false;
    }
    for (int j = 0; j < 3; j++) {
      int y = 0;
      for (int i = 0; i < 3; i++)
        y += m[i][j];
      if (x != y)
        return false;
    }
    return true;
  }

  static void print(int[][] m) {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++)
        out.print(m[i][j] + " ");
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
