package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Cards {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    char[] c = next().toCharArray();
    int[] count = new int[3];
    for (char ci : c) {
      count["BGR".indexOf(ci)]++;
    }
    StringBuilder sb = new StringBuilder();
    if (check(count[1], count[2], count[0])) {
      sb.append("B");
    }
    if (check(count[0], count[2], count[1])) {
      sb.append("G");
    }
    if (check(count[0], count[1], count[2])) {
      sb.append("R");
    }
    out.println(sb);
  }

  static boolean check(int x, int y, int z) {
    if (x == 0) {
      if (y == 0) {
        return true;
      } else if (y == 1) {
        return false;
      } else {
        return z > 0;
      }
    }
    if (y == 0) {
      if (x == 0) {
        return true;
      } else if (x == 1) {
        return false;
      } else {
        return z > 0;
      }
    }
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
