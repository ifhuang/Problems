package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class DimaandSequence {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    int[] a = nextIntArray(n, 0);
    long[] c = new long[100];
    for (int ai : a) {
      int count = 1;
      while (ai != 1)
        if (ai % 2 == 0)
          ai /= 2;
        else {
          ai = (ai - 1) / 2;
          count++;
        }
      c[count]++;
    }
    long ans = 0;
    for (long ci : c)
      if (ci > 1)
        ans += combination(2, ci);
    out.println(ans);
  }

  static long combination(long up, long down) {
    if (down - up < up)
      return combination(down - up, down);
    long a = 1L;
    for (long i = 1L; i <= up; i++) {
      a *= down + 1L - i;
      a /= i;
    }
    return a;
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
