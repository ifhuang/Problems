package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MakePalindrome {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    char[] s = next().toCharArray();
    int len = 26;
    char base = 'a';
    int[] count = new int[len];
    for (char si : s) {
      count[si - base]++;
    }
    int i = 0;
    while (i < len && count[i] % 2 == 0) {
      i++;
    }
    if (s.length % 2 == 1) {
      while (i < len && count[i] % 2 == 0) {
        i++;
      }
    }
    int j = len - 1;
    while (j >= 0 && count[j] % 2 == 0) {
      j--;
    }
    while(i < j) {
      count[i]++;
      count[j]--;
      while (i < len && count[i] % 2 == 0) {
        i++;
      }
      while (j >= 0 && count[j] % 2 == 0) {
        j--;
      }
    }
    out.println(print(count));
  }

  static String print(int[] count) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < count.length; i++) {
      for (int j = 0; j < count[i] / 2; j++) {
        char c = (char) ('a' + i);
        sb.append(c);
      }
    }
    for (int i = 0; i < count.length; i++) {
      if (count[i] % 2 == 1) {
        char c = (char) ('a' + i);
        sb.append(c);
      }
    }
    for (int i = count.length - 1; i >= 0; i--) {
      for (int j = 0; j < count[i] / 2; j++) {
        char c = (char) ('a' + i);
        sb.append(c);
      }
    }
    return sb.toString();
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
