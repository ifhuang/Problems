package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class DimaandTextMessages {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    StringBuilder sb = new StringBuilder();
    sb.append("<3");
    for (int i = 0; i < n; i++)
      sb.append(next()).append("<3");
    char[] s = sb.toString().toCharArray();
    char[] c = next().toCharArray();
    int i = 0, j = 0;
    while (i < s.length && j < c.length)
      if (s[i] == c[j]) {
        i++;
        j++;
      } else if (check(c[j]))
        j++;
      else
        break;
    out.println(i == s.length ? "yes" : "no");
  }

  static boolean check(char c) {
    if (c >= '0' && c <= '9')
      return true;
    if (c >= 'a' && c <= 'z')
      return true;
    if (c == '<' || c == '>')
      return true;
    return false;
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
