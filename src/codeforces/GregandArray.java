package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class GregandArray {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt(), m = nextInt(), k = nextInt();
    long[] a = new long[n];
    for (int i = 0; i < n; i++)
      a[i] = nextLong();
    int[][] op = new int[m][3];
    for (int i = 0; i < m; i++)
      for (int j = 0; j < 3; j++)
        op[i][j] = nextInt();
    long[] c1 = new long[m + 1];
    for (int i = 0; i < k; i++) {
      c1[nextInt() - 1]++;
      c1[nextInt()]--;
    }
    long[] f1 = new long[m];
    long t = 0;
    for (int i = 0; i < m; i++) {
      t += c1[i];
      f1[i] = t;
    }
    long[] c2 = new long[n + 1];
    for (int i = 0; i < m; i++) {
      c2[op[i][0] - 1] += f1[i] * op[i][2];
      c2[op[i][1]] -= f1[i] * op[i][2];
    }
    long[] f2 = new long[n];
    t = 0;
    for (int i = 0; i < n; i++) {
      t += c2[i];
      f2[i] = t;
      a[i] += f2[i];
    }
    for (int i = 0; i < n; i++)
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

  static long nextLong() throws IOException {
    return Long.parseLong(next());
  }

  static double nextDouble() throws IOException {
    return Double.parseDouble(next());
  }

  static BigInteger nextBigInteger() throws IOException {
    return new BigInteger(next());
  }

  static String next() throws IOException {
    while (tok == null || !tok.hasMoreTokens()) {
      tok = new StringTokenizer(in.readLine());
    }
    return tok.nextToken();
  }

  static String nextLine() throws IOException {
    tok = new StringTokenizer("");
    return in.readLine();
  }

}
