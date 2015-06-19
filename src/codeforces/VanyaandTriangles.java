package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class VanyaandTriangles {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    int[] x = new int[n];
    int[] y = new int[n];
    for (int i = 0; i < n; i++) {
      x[i] = nextInt();
      y[i] = nextInt();
    }
    long ans = (long) n * (n - 1) * (n - 2) / 6;
    for (int i = 0; i < n; i++) {
      Map<List<Integer>, Integer> map = new HashMap<>();
      for (int j = i + 1; j < n; j++) {
        int dx = x[j] - x[i];
        int dy = y[j] - y[i];
        int g = gcd(dx, dy);
        List<Integer> list = new ArrayList<>();
        list.add(dx / g);
        list.add(dy / g);
        if (map.containsKey(list))
          map.put(list, map.get(list) + 1);
        else
          map.put(list, 1);
      }
      for (List<Integer> list : map.keySet()) {
        int m = map.get(list);
        if (map.get(list) > 1)
          ans -= (long) m * (m - 1) / 2;
      }
    }
    out.println(ans);
  }

  static int gcd(int a, int b) {
    while (b != 0) {
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
