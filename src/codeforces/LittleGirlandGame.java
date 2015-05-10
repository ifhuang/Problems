package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LittleGirlandGame {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    char[] s = next().toCharArray();
    int[] c = new int[26];
    for (char si : s)
      c[si - 'a']++;
    boolean first = true;
    while (true) {
      if (check(c))
        break;
      else {
        int i = 0;
        for (; i < 26; i++)
          if (c[i] > 0) {
            c[i]--;
            if (!check(c))
              break;
            else {
              c[i]++;
            }
          }
        first = !first;
        if (i == 26)
          break;
      }
    }
    out.println(first ? "First" : "Second");
  }

  static boolean check(int[] c) {
    int odd = 0;
    for (int ci : c)
      if (ci % 2 == 1)
        odd++;
    return odd <= 1;
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
