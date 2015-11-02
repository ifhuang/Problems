package atcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class StringArrangement {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    char[] c = next().toCharArray();
    int len = 26;
    int[] count = new int[len];
    for (char ci : c) {
      count[ci - 'a']++;
    }
    int max = Integer.MIN_VALUE;
    int maxIndex = -1;
    for (int i = 0; i < len; i++) {
      if (max < count[i]) {
        max = count[i];
        maxIndex = i;
      }
    }
    int other = 0;
    for (int i = 0; i < len; i++) {
      if (i != maxIndex) {
        other += count[i];
      }
    }
    if (max > other + 1) {
      out.println(-1);
      return;
    }
    int pre = -1;
    for (int i = 0; i < c.length; i++) {
      for (int j = 0; j < len; j++) {
        if (count[j] > 0 && j != pre && check(count, j, len)) {
          count[j]--;
          pre = j;
          break;
        }
      }
      char x = (char) (pre + 'a');
      out.print(x);
    }
    out.println();
  }

  static boolean check(int[] count, int i, int len) {
    int max = Integer.MIN_VALUE;
    int maxIndex = -1;
    for (int j = 0; j < len; j++) {
      int val = count[j];
      if (j == i) {
        val--;
      }
      if (max < val) {
        max = val;
        maxIndex = j;
      }
    }
    int other = 0;
    for (int j = 0; j < count.length; j++) {
      if (j != maxIndex) {
        other += count[j];
      }
      if (j == i) {
        other--;
      }
    }
    return max <= other + 1;
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
