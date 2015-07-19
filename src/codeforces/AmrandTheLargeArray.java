package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class AmrandTheLargeArray {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    int[] a = nextIntArray(n + 1, 1);
    Map<Integer, LeftRightCount> map = new HashMap<>();
    for (int i = 1; i <= n; i++) {
      if (map.containsKey(a[i])) {
        LeftRightCount lrc = map.get(a[i]);
        lrc.right = i;
        lrc.count++;
      } else {
        LeftRightCount lrc = new LeftRightCount(i, i, 1);
        map.put(a[i], lrc);
      }
    }
    LeftRightCount ans = new LeftRightCount(0, 0, 0);
    for (LeftRightCount lrc : map.values()) {
      if (lrc.count > ans.count)
        ans = lrc;
      else if (lrc.count == ans.count && ((ans.right - ans.left)) > (lrc.right - lrc.left))
        ans = lrc;
    }
    out.println(ans.left + " " + ans.right);
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


class LeftRightCount {
  int left;
  int right;
  int count;

  LeftRightCount(int a, int b, int c) {
    left = a;
    right = b;
    count = c;
  }
}
