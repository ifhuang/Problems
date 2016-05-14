package codejam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CloseMatch {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static char[] C;
  static char[] J;
  static char[] CJ;
  static int[] CJNum;
  static int ansZ;
  static int ansX;
  static int ansY;

  static void solve() throws Exception {
    int T = nextInt();
    for (int t = 1; t <= T; t++) {
      C = next().toCharArray();
      J = next().toCharArray();
      CJ = new char[C.length + J.length];
      for (int i = 0; i < C.length; i++) {
        CJ[i] = C[i];
      }
      for (int i = 0; i < J.length; i++) {
        CJ[C.length + i] = J[i];
      }
      CJNum = new int[CJ.length];
      for (int i = 0; i < CJ.length; i++) {
        CJNum[i] = CJ[i] - '0';
      }
      ansZ = Integer.MAX_VALUE;
      ansX = Integer.MAX_VALUE;
      ansY = Integer.MAX_VALUE;
      dfs(-1);
      String sx = ansX + "";
      while (sx.length() < C.length) {
        sx = "0" + sx;
      }
      String sy = ansY + "";
      while (sy.length() < J.length) {
        sy = "0" + sy;
      }
      out.println(String.format("Case #%d: %s %s", t, sx, sy));
    }
  }

  static void dfs(int s) {
    int cur = s + 1;
    while (cur < CJNum.length && CJ[cur] != '?') {
      cur++;
    }
    if (cur == CJNum.length) {
      int x = 0;
      for (int i = 0; i < C.length; i++) {
        x *= 10;
        x += CJNum[i];
      }
      int y = 0;
      for (int i = 0; i < J.length; i++) {
        y *= 10;
        y += CJNum[C.length + i];
      }
      int z = Math.abs(x - y);
      if (z < ansZ) {
        ansZ = z;
        ansX = x;
        ansY = y;
      } else if (z == ansZ) {
        if (x < ansX) {
          ansX = x;
          ansY = y;
        } else if (x == ansX) {
          if (y < ansY) {
            ansY = y;
          }
        }
      }
      return;
    }
    for (int i = 0; i < 10; i++) {
      CJNum[cur] = i;
      dfs(cur);
    }
  }

  public static void main(String args[]) {
    try {
      in = new BufferedReader(new InputStreamReader(System.in));
      // in = new BufferedReader(new FileReader(args[0]));
      out = new PrintWriter(new OutputStreamWriter(System.out));
      // out = new PrintWriter(args[1]);
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

  static double nextDouble() throws IOException {
    return Double.parseDouble(next());
  }

  static double[] nextDoubleArray(int len, int start) throws IOException {
    double[] a = new double[len];
    for (int i = start; i < len; i++)
      a[i] = nextDouble();
    return a;
  }

  static String next() throws IOException {
    while (tok == null || !tok.hasMoreTokens()) {
      tok = new StringTokenizer(in.readLine());
    }
    return tok.nextToken();
  }

}
