package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SecretCombination {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    char[] c = next().toCharArray();
    String ans = new String(c);
    for (int i = 0; i < n; i++) {
      String s = trans(c, i, n);
      if (ans.compareTo(s) > 0)
        ans = s;
    }
    out.println(ans);
  }

  static String trans(char[] c, int i, int n) {
    char[] d = new char[n];
    for (int j = 0; j < n; j++)
      d[j] = c[(j + i) % n];
    int diff = d[0] - '0';
    for (int j = 0; j < n; j++) {
      int e = d[j] - '0';
      d[j] = (char) (e >= diff ? d[j] - diff : d[j] + 10 - diff);
    }
    return new String(d);
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
