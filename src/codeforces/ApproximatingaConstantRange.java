package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ApproximatingaConstantRange {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    int[] a = nextIntArray(n, 0);
    out.println(helper(a));
  }

  static int helper(int[] a) {
    int n = a.length;
    int k = 2;
    int ans = 0;
    int i = 0, j = 0;
    Map<Integer, Integer> map = new HashMap<>();
    while (j < n) {
      int c = a[j];
      if (map.containsKey(c)) {
        map.put(c, map.get(c) + 1);
      } else {
        while (map.size() == k) {
          int old = a[i];
          int count = map.get(old);
          if (count == 1) {
            map.remove(old);
          } else {
            map.put(old, count - 1);
          }
          i++;
        }
        map.put(c, 1);
      }
      ans = Math.max(ans, j - i + 1);
      j++;
    }
    return ans;
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
