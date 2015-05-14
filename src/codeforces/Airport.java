package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Airport {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt(), m = nextInt();
    int[] a = nextIntArray(m, 0);
    Arrays.sort(a);
    int[] b = Arrays.copyOf(a, m);
    int max = 0;
    for (int i = 0; i < n; i++)
      max += maxHelper(a);
    out.print(max + " ");
    int min = 0;
    for (int i = 0; i < n; i++)
      min += minHelper(b);
    out.print(min + "\n");
  }

  static int maxHelper(int[] a) {
    int max = -1;
    int maxI = -1;
    for (int i = 0; i < a.length; i++)
      if (a[i] > max) {
        max = a[i];
        maxI = i;
      }
    a[maxI]--;
    return max;
  }

  static int minHelper(int[] a) {
    int min = 1001;
    int minI = -1;
    for (int i = 0; i < a.length; i++)
      if (a[i] > 0 && a[i] < min) {
        min = a[i];
        minI = i;
      }
    a[minI]--;
    return min;
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
