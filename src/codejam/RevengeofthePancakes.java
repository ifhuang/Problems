package codejam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RevengeofthePancakes {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int T = nextInt();
    for (int t = 1; t <= T; t++) {
      char[] c = next().toCharArray();
      int ans = 0;
      while (true) {
        // find the most right '-'
        int r = c.length - 1;
        while (r >= 0 && c[r] == '+') {
          r--;
        }
        // all '+'
        if (r == -1) {
          break;
        }
        // flip the left '+'
        if (c[0] == '+') {
          int l = 0;
          while (l < c.length && c[l] == '+') {
            c[l] = '-';
            l++;
          }
          ans++;
        }
        // flip
        for (int i = 0, j = r; i <= j; i++, j--) {
          char ci = c[i];
          char cj = c[j];
          c[j] = ci == '+' ? '-' : '+';
          if (i < j) {
            c[i] = cj == '+' ? '-' : '+';
          }
        }
        ans++;
      }
      out.println(String.format("Case #%d: %d", t, ans));
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
