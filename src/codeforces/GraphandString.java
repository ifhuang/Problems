package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GraphandString {

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
    char[] ans = new char[n];
    for (int i = 0; i < n; i++) {
      int count = 0;
      for (int j = i + 1; j < n; j++) {
        if (!g[i][j]) {
          count++;
        }
      }
      if (count == 0) {
        if (ans[i] == '\0') {
          ans[i] = 'b';
        }
      } else {
        if (ans[i] == '\0') {
          ans[i] = 'a';
        }
        for (int j = i + 1; j < n; j++) {
          if (!g[i][j] && ans[j] == '\0') {
            ans[j] = ans[i] == 'a' ? 'c' : 'a';
          }
        }
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        boolean flag = true;
        if (ans[i] == 'a' && ans[j] == 'c') {
          flag = false;
        }
        if (ans[i] == 'c' && ans[j] == 'a') {
          flag = false;
        }
        if (g[i][j] != flag) {
          out.println("No");
          return;
        }
      }
    }
    out.println("Yes");
    out.println(new String(ans));
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
