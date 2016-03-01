package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FarRelativesBirthdayCake {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    char[][] cake = new char[n][n];
    for (int i = 0; i < n; i++) {
      cake[i] = next().toCharArray();
    }
    long ans = 0;
    for (int i = 0; i < n; i++) {
      long c = 0;
      for (int j = 0; j < n; j++) {
        if (cake[i][j] == 'C') {
          c++;
        }
      }
      ans += c * (c - 1) / 2;
    }
    for (int j = 0; j < n; j++) {
      long c = 0;
      for (int i = 0; i < n; i++) {
        if (cake[i][j] == 'C') {
          c++;
        }
      }
      ans += c * (c - 1) / 2;
    }
    out.println(ans);
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
