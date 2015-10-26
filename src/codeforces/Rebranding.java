package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Rebranding {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt(), m = nextInt();
    char[] c = next().toCharArray();
    Map<Character, Character> from = new HashMap<>();
    for (int i = 0; i < m; i++) {
      char a = next().charAt(0);
      char b = next().charAt(0);
      if (a == b) {
        continue;
      }
      boolean fa = true;
      boolean fb = true;
      for (char key : from.keySet()) {
        if (from.get(key) == a) {
          from.put(key, b);
          fa = false;
        } else if (from.get(key) == b) {
          from.put(key, a);
          fb = false;
        }
      }
      if (fa) {
        from.put(a, b);
      }
      if (fb) {
        from.put(b, a);
      }
    }
    for (int i = 0; i < n; i++) {
      if (from.containsKey(c[i])) {
        c[i] = from.get(c[i]);
      }
    }
    out.println(new String(c));
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
