package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SerejaandContests {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int x = nextInt(), k = nextInt();
    boolean[] r = new boolean[x + 1];
    r[x] = true;
    for (int i = 0; i < k; i++) {
      int a = nextInt();
      if (a == 1) {
        int b = nextInt();
        int c = nextInt();
        r[b] = r[c] = true;
      } else {
        int b = nextInt();
        r[b] = true;
      }
    }
    int t = 0;
    int min = 0;
    int max = 0;
    for (int i = 1; i <= x; i++) {
      if (!r[i])
        t++;
      else {
        min += (t + 1) / 2;
        max += t;
        t = 0;
      }
    }
    out.println(min + " " + max);
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
