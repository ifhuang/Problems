package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class StudentsandShoelaces {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt(), m = nextInt();
    boolean[][] g = new boolean[n][n];
    for (int i = 0; i < m; i++) {
      int a = nextInt() - 1;
      int b = nextInt() - 1;
      g[a][b] = g[b][a] = true;
    }
    int ans = 0;
    while (true) {
      Set<Integer> set = new HashSet<>();
      for (int i = 0; i < n; i++) {
        int d = 0;
        for (int j = 0; j < n; j++)
          if (g[i][j])
            d++;
        if (d == 1)
          set.add(i);
      }
      if (set.isEmpty())
        break;
      else {
        ans++;
        for (int i : set)
          for (int j = 0; j < n; j++)
            g[j][i] = g[i][j] = false;
      }
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
