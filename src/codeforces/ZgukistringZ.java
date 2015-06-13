package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ZgukistringZ {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    char[] a = next().toCharArray();
    int[] ca = count(a);
    char[] b = next().toCharArray();
    int[] cb = count(b);
    char[] c = next().toCharArray();
    int[] cc = count(c);
    int tb1 = Integer.MAX_VALUE;
    for (int i = 0; i < 26; i++)
      if (cb[i] > 0)
        tb1 = Math.min(tb1, ca[i] / cb[i]);
    int nb = 0;
    int nc = 0;
    int max = 0;
    for (int i = 0; i <= tb1; i++) {
      int tc1 = Integer.MAX_VALUE;
      for (int j = 0; j < 26; j++)
        if (cc[j] > 0)
          tc1 = Math.min(tc1, (ca[j] - cb[j] * i) / cc[j]);
      if (i + tc1 > max) {
        nb = i;
        nc = tc1;
        max = i + tc1;
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < nb; i++)
      sb.append(b);
    for (int i = 0; i < nc; i++)
      sb.append(c);
    for (int i = 0; i < 26; i++)
      for (int j = 0; j < ca[i] - cb[i] * nb - cc[i] * nc; j++)
        sb.append((char) ('a' + i));
    out.println(sb);
  }

  static int[] count(char[] a) {
    int[] count = new int[26];
    for (char ai : a)
      count[ai - 'a']++;
    return count;
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
