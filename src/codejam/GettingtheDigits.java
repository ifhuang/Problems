package codejam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GettingtheDigits {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static int[][] map;
  static int[] count;
  static boolean flag;
  static StringBuilder sb;
  static String ans;

  static void solve() throws Exception {
    init();
    int T = nextInt();
    for (int t = 1; t <= T; t++) {
      char[] c = next().toCharArray();
      count = new int[26];
      flag = false;
      sb = new StringBuilder();
      ans = "";
      for (char ci : c) {
        count[ci - 'A']++;
      }
      backtrack(0);
      out.println(String.format("Case #%d: %s", t, ans));
    }
  }

  static void init() {
    String[] s = {"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"};
    map = new int[s.length][26];
    for (int i = 0; i < s.length; i++) {
      for (char ci : s[i].toCharArray()) {
        map[i][ci - 'A']++;
      }
    }
  }

  static void backtrack(int start) {
    if (flag) {
      return;
    }
    if (check0()) {
      flag = true;
      ans = sb.toString();
      return;
    }
    for (int i = start; i < 10; i++) {
      if (check1(i)) {
        sub(i);
        backtrack(i);
        add(i);
      }
    }
  }

  static boolean check0() {
    for (int c : count) {
      if (c != 0) {
        return false;
      }
    }
    return true;
  }

  static boolean check1(int c) {
    for (int i = 0; i < 26; i++) {
      if (count[i] < map[c][i]) {
        return false;
      }
    }
    return true;
  }

  static void sub(int c) {
    for (int i = 0; i < 26; i++) {
      count[i] -= map[c][i];
    }
    sb.append(c);
  }

  static void add(int c) {
    for (int i = 0; i < 26; i++) {
      count[i] += map[c][i];
    }
    sb.deleteCharAt(sb.length() - 1);
  }

  public static void main(String args[]) {
    try {
      in = new BufferedReader(new InputStreamReader(System.in));
      // in = new BufferedReader(new FileReader(args[0]));
      out = new PrintWriter(new OutputStreamWriter(System.out));
      // out = new PrintWriter(args[1]);
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

  static double nextDouble() throws IOException {
    return Double.parseDouble(next());
  }

  static double[] nextDoubleArray(int len, int start) throws IOException {
    double[] a = new double[len];
    for (int i = start; i < len; i++)
      a[i] = nextDouble();
    return a;
  }

  static String next() throws IOException {
    while (tok == null || !tok.hasMoreTokens()) {
      tok = new StringTokenizer(in.readLine());
    }
    return tok.nextToken();
  }

}
