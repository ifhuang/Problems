package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class GCDTable {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    int[] g = nextIntArray(n * n, 0);
    TreeMap<Integer, Integer> map = new TreeMap<>();
    for (int i : g) {
      if (map.containsKey(i)) {
        map.put(i, map.get(i) + 1);
      } else {
        map.put(i, 1);
      }
    }
    int[] ans = new int[n];
    for (int i = n - 1; i >= 0; i--) {
      int k = map.lastKey();
      int v = map.get(k);
      ans[i] = k;
      v--;
      if (v == 0) {
        map.remove(k);
      } else {
        map.put(k, v);
      }
      for (int j = i + 1; j < n; j++) {
        int k2 = gcd(ans[i], ans[j]);
        int v2 = map.get(k2);
        v2 -= 2;
        if (v2 == 0) {
          map.remove(k2);
        } else {
          map.put(k2, v2);
        }
      }
    }
    for (int a : ans) {
      out.print(a + " ");
    }
  }

  static int gcd(int a, int b) {
    while (b > 0) {
      int t = a % b;
      a = b;
      b = t;
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
