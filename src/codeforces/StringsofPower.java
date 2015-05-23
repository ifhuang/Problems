package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StringsofPower {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    String s = next();
    String h = "heavy";
    String m = "metal";
    List<Integer> lh = new ArrayList<>();
    List<Integer> lm = new ArrayList<>();
    for (int i = 0; i + 5 <= s.length(); i++) {
      String sub = s.substring(i, i + 5);
      if (sub.equals(h))
        lh.add(i);
      else if (sub.equals(m))
        lm.add(i);
    }
    int i = 0;
    int j = 0;
    long ans = 0;
    while (i < lh.size() && j < lm.size())
      if (lh.get(i) > lm.get(j))
        j++;
      else {
        ans += lm.size() - j;
        i++;
      }
    out.println(ans);
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
