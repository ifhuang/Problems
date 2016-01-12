package codeforces.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class LongestkGoodSegment {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static int left, right;

  static void solve() throws Exception {
    int n = nextInt(), k = nextInt();
    int[] a = nextIntArray(n, 0);
    helper(a, k);
    out.println(left + " " + right);
  }

  static int helper(int[] s, int k) {
    int n = s.length;
    int ans = 0;
    int i = 0, j = 0;
    Map<Integer, Integer> map = new HashMap<>();
    while (j < n) {
      int c = s[j];
      if (map.containsKey(c)) {
        map.put(c, map.get(c) + 1);
      } else {
        while (map.size() == k) {
          int old = s[i];
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
      if (j - i + 1 > ans) {
        left = i + 1;
        right = j + 1;
        ans = j - i + 1;
      }
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
