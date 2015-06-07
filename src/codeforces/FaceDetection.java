package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FaceDetection {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt(), m = nextInt();
    char[][] c = new char[n][m];
    for (int i = 0; i < n; i++)
      c[i] = next().toCharArray();
    char[] face = "face".toCharArray();
    Arrays.sort(face);
    int ans = 0;
    for (int i = 0; i < n - 1; i++)
      for (int j = 0; j < m - 1; j++) {
        char[] sq = {c[i][j], c[i + 1][j], c[i][j + 1], c[i + 1][j + 1]};
        Arrays.sort(sq);
        if (check(face, sq))
          ans++;
      }
    out.println(ans);
  }

  static boolean check(char[] a, char[] b) {
    for (int i = 0; i < a.length; i++)
      if (a[i] != b[i])
        return false;
    return true;
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
