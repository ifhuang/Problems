package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ExtractNumbers {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    String s = next() + ",a";
    String[] p = s.split(",|;");
    StringBuilder a = new StringBuilder();
    StringBuilder b = new StringBuilder();
    for (int i = 0; i < p.length - 1; i++) {
      String pi = p[i];
      if (check(pi)) {
        a.append(pi);
        a.append(",");
      } else {
        b.append(pi);
        b.append(",");
      }
    }
    if (a.length() == 0) {
      out.println("-");
    } else {
      a.deleteCharAt(a.length() - 1);
      out.println("\"" + a + "\"");
    }
    if (b.length() == 0) {
      out.println("-");
    } else {
      b.deleteCharAt(b.length() - 1);
      out.println("\"" + b + "\"");
    }
  }

  static boolean check(String s) {
    if (s.length() == 0) {
      return false;
    }
    for (char c : s.toCharArray()) {
      if (c < '0' || c > '9') {
        return false;
      }
    }
    if (s.length() > 1 && s.charAt(0) == '0') {
      return false;
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
