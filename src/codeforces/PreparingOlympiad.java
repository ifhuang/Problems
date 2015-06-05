package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PreparingOlympiad {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    long l = nextLong(), r = nextLong(), x = nextLong();
    long[] c = nextLongArray(n, 0);
    int ans = 0;
    for (int i = 0; i < (1 << n); i++) {
      List<Long> list = new ArrayList<>();
      for (int j = 0; j < n; j++) {
        int k = (1 << j) & i;
        if (k != 0)
          list.add(c[j]);
      }
      if (check(list, l, r, x))
        ans++;
    }
    out.println(ans);
  }

  static boolean check(List<Long> list, long l, long r, long x) {
    long min = Long.MAX_VALUE;
    long max = Long.MIN_VALUE;
    long ans = 0;
    for (long i : list) {
      min = Math.min(min, i);
      max = Math.max(max, i);
      ans += i;
    }
    return ans >= l && ans <= r && (max - min) >= x;
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
