package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PhoneNumbers2 {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    int[] max = new int[3];
    List<List<String>> list = new ArrayList<>();
    list.add(new ArrayList<>());
    list.add(new ArrayList<>());
    list.add(new ArrayList<>());
    for (int i = 0; i < n; i++) {
      int s = nextInt();
      String name = next();
      int[] t = new int[3];
      for (int j = 0; j < s; j++)
        t[check(next())]++;
      for (int j = 0; j < 3; j++)
        if (t[j] == max[j])
          list.get(j).add(name);
        else if (t[j] > max[j]) {
          max[j] = t[j];
          list.get(j).clear();
          list.get(j).add(name);
        }
    }
    out.print("If you want to call a taxi, you should call: ");
    out.println(print(list.get(0)));
    out.print("If you want to order a pizza, you should call: ");
    out.println(print(list.get(1)));
    out.print("If you want to go to a cafe with a wonderful girl, you should call: ");
    out.println(print(list.get(2)));
  }

  static int check(String s) {
    String[] p = s.split("-");
    String s1 = p[0] + p[1] + p[2];
    int i = 1;
    for (; i < 6; i++)
      if (s1.charAt(i) != s1.charAt(0))
        break;
    if (i == 6)
      return 0;
    i = 1;
    for (; i < 6; i++)
      if (s1.charAt(i) >= s1.charAt(i - 1))
        break;
    if (i == 6)
      return 1;
    return 2;
  }

  static String print(List<String> list) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < list.size() - 1; i++)
      sb.append(list.get(i)).append(", ");
    sb.append(list.get(list.size() - 1)).append(".");
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
