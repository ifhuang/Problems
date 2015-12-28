package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class VikaandSquares {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    long[] a = nextLongArray(n, 0);
    long min = Long.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      if (a[i] < min) {
        min = a[i];
      }
    }
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (a[i] == min) {
        list.add(i);
      }
    }
    int len = list.size();
    for (int i = 0; i < len; i++) {
      list.add(list.get(i) + n);
    }
    long ans = 0;
    for (int i = 0; i < len; i++) {
      ans = Math.max(ans, list.get(i + 1) - list.get(i) - 1);
    }
    ans += min * n;
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
