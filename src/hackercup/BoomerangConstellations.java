package hackercup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BoomerangConstellations {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int T = nextInt();
    for (int i = 1; i <= T; i++) {
      int N = nextInt();
      long[] x = new long[N];
      long[] y = new long[N];
      for (int j = 0; j < N; j++) {
        x[j] = nextLong();
        y[j] = nextLong();
      }
      long ans = 0;
      for (int p1 = 0; p1 < N; p1++) {
        Map<Long, Integer> map = new HashMap<>();
        for (int p2 = 0; p2 < N; p2++) {
          if (p1 != p2) {
            long d = (x[p1] - x[p2]) * (x[p1] - x[p2]) + (y[p1] - y[p2]) * (y[p1] - y[p2]);
            if (!map.containsKey(d)) {
              map.put(d, 0);
            }
            map.put(d, map.get(d) + 1);
          }
        }
        for (long d : map.keySet()) {
          long t = map.get(d);
          ans += (t - 1) * t / 2;
        }
      }
      out.println(String.format("Case #%d: %d", i, ans));
    }
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
