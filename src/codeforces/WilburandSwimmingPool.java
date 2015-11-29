package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class WilburandSwimmingPool {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    int[][] a = new int[n][2];
    for (int i = 0; i < n; i++) {
      a[i] = nextIntArray(2, 0);
    }
    if (n == 1) {
      out.println(-1);
    } else if (n == 2 && (a[0][0] == a[1][0] || a[0][1] == a[1][1])) {
      out.println(-1);
    } else {
      for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
          if (a[i][0] != a[j][0] && a[i][1] != a[j][1]) {
            int x = Math.abs(a[i][0] - a[j][0]);
            int y = Math.abs(a[i][1] - a[j][1]);
            out.println(x * y);
            return;
          }
        }
      }
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
