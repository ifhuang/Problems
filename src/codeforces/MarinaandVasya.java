package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class MarinaandVasya {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt(), t = nextInt();
    char[] s1 = next().toCharArray();
    char[] s2 = next().toCharArray();
    LinkedList<Integer> same = new LinkedList<>();
    LinkedList<Integer> diff = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      if (s1[i] == s2[i]) {
        same.add(i);
      } else {
        diff.add(i);
      }
    }
    int y = diff.size();
    int low = (y + 1) / 2;
    if (t < low) {
      out.println(-1);
      return;
    }
    char[] s3 = new char[n];
    for (int i = 0; i < Math.max(y - t, 0); i++) {
      int i1 = diff.pollFirst();
      s3[i1] = s1[i1];
      int i2 = diff.pollFirst();
      s3[i2] = s2[i2];
    }
    for (int i = 0; i < t - Math.max(y - t, 0); i++) {
      if (!diff.isEmpty()) {
        int j = diff.pollFirst();
        s3[j] = getChar(s1[j], s2[j]);
      } else {
        int j = same.pollFirst();
        s3[j] = getChar(s1[j], s2[j]);
      }
    }
    while (!same.isEmpty()) {
      int j = same.pollFirst();
      s3[j] = s1[j];
    }
    for (char c : s3) {
      out.print(c);
    }
    out.println();
  }

  static char getChar(char a, char b) {
    for (char i = 'a'; i <= 'z'; i++) {
      if (i != a && i != b) {
        return i;
      }
    }
    return 'a';
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
