package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class DivisibilitybyEight {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < 125; i++)
      set.add(i * 8);
    char[] c = next().toCharArray();
    for (int i = 0; i < c.length; i++) {
      int a = (c[i] - '0');
      if (set.contains(a)) {
        out.println("YES");
        out.println(a);
        return;
      }
      for (int j = i + 1; j < c.length; j++) {
        int b = (c[i] - '0') * 10 + (c[j] - '0');
        if (set.contains(b)) {
          out.println("YES");
          out.println(b);
          return;
        }
        for (int k = j + 1; k < c.length; k++) {
          int t = (c[i] - '0') * 100 + (c[j] - '0') * 10 + (c[k] - '0');
          if (set.contains(t)) {
            out.println("YES");
            out.println(t);
            return;
          }
        }
      }
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
