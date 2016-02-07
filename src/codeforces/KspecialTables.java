package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class KspecialTables {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt(), k = nextInt();
    int[][] a = new int[n][n];
    int num = 1;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < k - 1; j++) {
        a[i][j] = num++;
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = k - 1; j < n; j++) {
        a[i][j] = num++;
      }
    }
    int ans = 0;
    for (int i = 0; i < n; i++) {
      ans += a[i][k - 1];
    }
    out.println(ans);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        out.print(a[i][j] + " ");
      }
      out.println();
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
