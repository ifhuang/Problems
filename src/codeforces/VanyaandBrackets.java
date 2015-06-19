package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class VanyaandBrackets {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    StringBuilder sb = new StringBuilder();
    sb.append("1*").append(next()).append("*1");
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < sb.length(); i++)
      if (sb.charAt(i) == '*')
        list.add(i);
    long ans = 0;
    for (int i = 0; i < list.size(); i++)
      for (int j = i + 1; j < list.size(); j++) {
        String pre = sb.substring(0, list.get(i) + 1);
        String mid = sb.substring(list.get(i) + 1, list.get(j));
        String post = sb.substring(list.get(j));
        StringBuilder sb2 = new StringBuilder();
        long t = eval(sb2.append(pre).append(eval(mid)).append(post).toString());
        ans = Math.max(ans, t);
      }
    out.println(ans);
  }

  static long eval(String s) {
    s = s + "+";
    long ans = 0;
    long num = 0;
    long base = 1;
    for (char c : s.toCharArray())
      if (c == '+') {
        base *= num;
        ans += base;
        num = 0;
        base = 1;
      } else if (c == '*') {
        base *= num;
        num = 0;
      } else
        num = 10 * num + (c - '0');
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
