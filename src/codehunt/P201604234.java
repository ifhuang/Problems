package codehunt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P201604234 {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    String[] b = Puzzle(4);
    out.println(b);
  }

  public static String[] Puzzle(int n) {
    // the Strings contain only parentheses
    List<String> list = generateParenthesis(n);
    String[] ans = new String[list.size()];
    for (int i = 0; i < ans.length; i++) {
      ans[i] = list.get(i);
    }
    return ans;
  }

  private static List<String> generateParenthesis(int n) {
    List<String> ans = new ArrayList<String>();
    backtrack(ans, "", 0, 0, n);
    return ans;
  }

  private static void backtrack(List<String> ans, String now, int open, int close, int max) {
    if (open + close == max * 2) {
      ans.add(now);
      return;
    }
    if (open < max) {
      backtrack(ans, now + "(", open + 1, close, max);
    }
    if (open > close) {
      backtrack(ans, now + ")", open, close + 1, max);
    }
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
