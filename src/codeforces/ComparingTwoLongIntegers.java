package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ComparingTwoLongIntegers {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    char[] a = next().toCharArray();
    char[] b = next().toCharArray();
    int ai = 0;
    while (ai < a.length && a[ai] == '0') {
      ai++;
    }
    int bi = 0;
    while (bi < b.length && b[bi] == '0') {
      bi++;
    }
    int al = a.length - ai;
    int bl = b.length - bi;
    if (al > bl) {
      out.println(">");
    } else if (al < bl) {
      out.println("<");
    } else {
      for (int i = 0; i < al; i++) {
        if (a[ai + i] > b[bi + i]) {
          out.println(">");
          return;
        } else if (a[ai + i] < b[bi + i]) {
          out.println("<");
          return;
        }
      }
      out.println("=");
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
