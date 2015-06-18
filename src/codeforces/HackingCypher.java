package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class HackingCypher {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    char[] c = next().toCharArray();
    int a = nextInt(), b = nextInt();
    int[] pre = new int[c.length + 1];
    for (int i = 0; i < c.length; i++)
      pre[i + 1] = (pre[i] * 10 + (c[i] - '0')) % a;
    int[] post = new int[c.length + 1];
    for (int i = c.length - 1, j = 1; i >= 0; i--, j = j * 10 % b)
      post[i] = ((c[i] - '0') * j + post[i + 1]) % b;
    for (int i = 1; i < c.length; i++)
      if (pre[i] == 0 && post[i] == 0 && c[i] != '0') {
        out.println("YES");
        out.println(new String(c, 0, i));
        out.println(new String(c, i, c.length - i));
        return;
      }
    out.println("NO");
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
