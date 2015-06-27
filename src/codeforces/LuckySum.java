package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LuckySum {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    long l = nextLong(), r = nextLong();
    List<Long> list = gen(10);
    long ans = 0;
    for (int i = 0; i < list.size() - 1; i++) {
      long cl = Math.max(list.get(i) + 1, l);
      long cr = Math.min(list.get(i + 1), r);
      if (cl <= cr)
        ans += (cr - cl + 1) * list.get(i + 1);
    }
    out.println(ans);
  }

  static List<Long> gen(int n) {
    long[][] a = new long[n + 1][];
    a[0] = new long[] {0};
    for (int i = 1; i <= n; i++) {
      a[i] = new long[a[i - 1].length * 2];
      for (int j = 0; j < a[i].length; j += 2) {
        a[i][j] = a[i - 1][j / 2] * 10 + 4;
        a[i][j + 1] = a[i - 1][j / 2] * 10 + 7;
      }
    }
    List<Long> list = new ArrayList<>();
    for (int i = 0; i <= n; i++)
      for (int j = 0; j < a[i].length; j++)
        list.add(a[i][j]);
    return list;
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
