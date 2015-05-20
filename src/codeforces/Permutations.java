package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Permutations {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt(), m = nextInt();
    List<String> list = gen(n);
    List<String> ans = cal(list);
    Collections.sort(ans);
    char[] c = ans.get(m - 1).toCharArray();
    for (int i = 0; i < c.length; i++)
      out.print(c[i] + " ");
  }

  static List<String> gen(int n) {
    List<String> ans = new ArrayList<>();
    if (n == 1) {
      StringBuilder sb = new StringBuilder("1");
      ans.add(sb.toString());
    } else {
      List<String> pre = gen(n - 1);
      for (String p : pre)
        for (int i = 0; i <= p.length(); i++) {
          StringBuilder sb = new StringBuilder(p);
          sb.insert(i, n);
          ans.add(sb.toString());
        }
    }
    return ans;
  }

  static List<String> cal(List<String> list) {
    List<String> ans = new ArrayList<>();
    int max = 0;
    for (String s : list) {
      char[] c = s.toCharArray();
      int sum = 0;
      for (int i = 0; i < c.length; i++)
        for (int j = i; j < c.length; j++) {
          char min = '9';
          for (int k = i; k <= j; k++)
            min = (char) Math.min(min, c[k]);
          sum += min - '0';
          if (sum == max)
            ans.add(s);
          else if (sum > max) {
            max = sum;
            ans = new ArrayList<>();
            ans.add(s);
          }
        }
    }
    return ans;
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
