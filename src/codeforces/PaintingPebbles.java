package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PaintingPebbles {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    int k = nextInt();
    int[][] c = new int[n][k];
    int[] a = new int[n];
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      a[i] = nextInt();
      min = Math.min(min, a[i]);
      max = Math.max(max, a[i]);
    }
    if (max - min > k)
      out.println("NO");
    else {
      out.println("YES");
      for (int i = 0; i < n; i++) {
        int x = a[i] % k;
        for (int j = 0; j < k; j++)
          c[i][j] = a[i] / k + (j < x ? 1 : 0);
      }
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < k; j++)
          for (int x = 0; x < c[i][j]; x++) {
            out.print(j + 1);
            out.print(" ");
          }
        out.println();
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
