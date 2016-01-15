package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GenasCode {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    String[] a = new String[n];
    for (int i = 0; i < n; i++) {
      a[i] = next();
    }
    for (String ai : a) {
      if (ai.equals("0")) {
        out.println(0);
        return;
      }
    }
    int len = 0;
    String pre = "1";
    for (String ai : a) {
      if (check(ai)) {
        len += ai.length() - 1;
      } else {
        pre = ai;
      }
    }
    StringBuilder sb = new StringBuilder();
    sb.append(pre);
    for (int i = 0; i < len; i++) {
      sb.append(0);
    }
    out.println(sb);
  }

  static boolean check(String ai) {
    int one = 0;
    int zero = 0;
    int other = 0;
    char[] c = ai.toCharArray();
    for (char ci : c) {
      if (ci == '1') {
        one++;
      } else if (ci == '0') {
        zero++;
      } else {
        other++;
      }
    }
    return other == 0 && one == 1;
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
