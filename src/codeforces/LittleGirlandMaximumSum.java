package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LittleGirlandMaximumSum {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    int q = nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++)
      a[i] = nextInt();
    Arrays.sort(a);
    int[] count = new int[n + 1];
    for (int i = 0; i < q; i++) {
      count[nextInt() - 1]++;
      count[nextInt()]--;
    }
    int[] f = new int[n];
    for (int i = 0, t = 0; i < n; i++) {
      t += count[i];
      f[i] = t;
    }
    Arrays.sort(f);
    long ans = 0;
    for (int i = n - 1; i >= 0; i--)
      ans += (long) a[i] * (long) f[i];
    out.println(ans);
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
