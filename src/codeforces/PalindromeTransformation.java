package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PalindromeTransformation {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt(), p = nextInt();
    char[] c = next().toCharArray();
    int[] d = new int[n / 2];
    int min = -1;
    int max = -1;
    int sum = 0;
    for (int i = 0; i < n / 2; i++) {
      d[i] = dis(c[i], c[n - 1 - i]);
      sum += d[i];
      if (d[i] > 0) {
        if (min == -1)
          min = i;
        max = i;
      }
    }
    if (min == -1) {
      out.println(0);
      return;
    }
    p--;
    if (p >= n / 2 && n % 2 == 0)
      p = n / 2 - 1 - (p - n / 2);
    else if (p > n / 2 && n % 2 == 1)
      p = n / 2 - (p - n / 2);
    int t1 = Math.abs(p - max) + Math.abs(max - min);
    int t2 = Math.abs(p - min) + Math.abs(min - max);
    out.println(Math.min(t1, t2) + sum);
  }

  static int dis(char a, char b) {
    if (a < b)
      return dis(b, a);
    return Math.min(a - b, 26 - (a - b));
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
