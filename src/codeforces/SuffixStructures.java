package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SuffixStructures {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {

    char[] s = next().toCharArray();
    int[] sn = new int[26];
    for (int i = 0; i < s.length; i++)
      sn[s[i] - 'a']++;

    char[] t = next().toCharArray();
    int[] tn = new int[26];
    for (int i = 0; i < t.length; i++)
      tn[t[i] - 'a']++;

    for (int i = 0; i < 26; i++)
      if (sn[i] < tn[i]) {
        out.println("need tree");
        return;
      }

    if (s.length == t.length) {
      out.println("array");
      return;
    }

    int j = 0;
    for (int i = 0; i < s.length && j < t.length;) {
      if (s[i] == t[j]) {
        i++;
        j++;
      } else {
        i++;
      }
    }

    if (j == t.length) {
      out.println("automaton");
      return;
    }

    out.println("both");
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
