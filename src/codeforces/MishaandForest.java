package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MishaandForest {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    int[] degree = new int[n];
    int[] s = new int[n];
    int[] q = new int[n];
    int p1 = 0;
    for (int i = 0; i < n; i++) {
      degree[i] = nextInt();
      s[i] = nextInt();
      if (degree[i] < 2)
        q[p1++] = i;
    }
    int[] x = new int[n];
    int[] y = new int[n];
    int p2 = 0;
    while (p1 > 0) {
      p1--;
      int i = q[p1];
      if (degree[i] == 0)
        continue;
      x[p2] = i;
      y[p2] = s[i];
      p2++;
      degree[s[i]]--;
      s[s[i]] ^= i;
      if (degree[s[i]] < 2)
        q[p1++] = s[i];
    }
    out.println(p2);
    for (int i = 0; i < p2; i++)
      out.println(x[i] + " " + y[i]);
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
