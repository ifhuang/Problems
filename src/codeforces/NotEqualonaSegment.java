package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class NotEqualonaSegment {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt(), m = nextInt();
    int[] a = new int[n + 1];
    for (int i = 0; i < n; i++) {
      a[i] = nextInt();
    }

    int[] next = new int[n + 1];
    for (int i = 0; i < n;) {
      int j = i + 1;
      while (a[i] == a[j]) {
        j++;
      }
      for (int k = i; k < j; k++) {
        next[k] = j;
      }
      i = j;
    }

    for (int i = 0; i < m; i++) {
      int ans = 0;
      int l = nextInt(), r = nextInt(), x = nextInt();
      int lIndex = l - 1;
      int rIndex = r - 1;
      if (a[lIndex] == x) {
        int y = next[lIndex];
        ans = y <= rIndex ? y + 1 : -1;
      } else {
        ans = l;
      }

      out.println(ans);
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
