package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CommandLineArguments {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    char[] c = nextLine().toCharArray();
    int i = 0;
    while (i < c.length)
      if (c[i] == ' ')
        i++;
      else if (c[i] == '"') {
        int j = i + 1;
        while (c[j] != '"')
          j++;
        out.println("<" + new String(Arrays.copyOfRange(c, i + 1, j)) + ">");
        i = j + 1;
      } else {
        int j = i + 1;
        while (j < c.length && c[j] != ' ')
          j++;
        out.println("<" + new String(Arrays.copyOfRange(c, i, j)) + ">");
        i = j + 1;
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

  static String nextLine() throws IOException {
    tok = new StringTokenizer("");
    return in.readLine();
  }

}
