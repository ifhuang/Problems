package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class HarmonyAnalysis {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int k = nextInt();
    if (k == 0) {
      out.println("+");
    } else {
      boolean[][] b = f(k);
      for (int i = 0; i < b.length; i++) {
        for (int j = 0; j < b.length; j++) {
          out.print(b[i][j] ? "+" : "*");
        }
        out.println();
      }
    }
  }

  static boolean[][] f(int k) {
    int base = 1 << k;
    boolean[][] b = new boolean[base][base];
    if (k == 1) {
      b[0][0] = true;
      b[0][1] = true;
      b[1][0] = true;
      b[1][1] = false;
    } else {
      boolean[][] pre = f(k - 1);
      boolean[][] reverse = reverse(pre);
      for (int i = 0; i < base; i++) {
        for (int j = 0; j < base / 2; j++) {
          b[i][j] = pre[i / 2][j];
        }
        for (int j = base / 2; j < base; j++) {
          if (i % 2 == 0) {
            b[i][j] = pre[i / 2][j - base / 2];
          } else {
            b[i][j] = reverse[i / 2][j - base / 2];
          }
        }
      }
    }
    return b;
  }

  static boolean[][] reverse(boolean[][] pre) {
    boolean[][] r = new boolean[pre.length][pre.length];
    for (int i = 0; i < r.length; i++) {
      for (int j = 0; j < r.length; j++) {
        r[i][j] = !pre[i][j];
      }
    }
    return r;
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
