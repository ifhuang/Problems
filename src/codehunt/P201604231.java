package codehunt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P201604231 {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    float[] a = {7.5398f, 6.5398f, 1, 1};
    int[] b = Puzzle(a);
    out.println(b);
  }

  public static int[] Puzzle(float[] a) {
    int n = a.length;
    int[] index = new int[n];
    for (int i = 0; i < n; i++) {
      index[i] = i;
    }
    quickSort(a, 0, n, index);
    int[] ans = new int[n];
    for (int i = 1; i < n; i++) {
      if (a[i] == a[i - 1]) {
        ans[index[i]] = ans[index[i - 1]];
      } else {
        ans[index[i]] = i;
      }
    }
    return ans;
  }

  private static void quickSort(float[] c, int i, int j, int[] index) {
    if (i + 1 >= j) {
      return;
    }
    int k = partition(c, i, j, index);
    quickSort(c, i, k, index);
    quickSort(c, k + 1, j, index);
  }

  private static int partition(float[] c, int i, int j, int[] index) {
    int i1 = i;
    for (int i2 = i + 1; i2 < j; i2++) {
      if (c[i2] < c[i]) {
        i1++;
        swap(c, i1, i2, index);
      }
    }
    swap(c, i, i1, index);
    return i1;
  }

  private static void swap(float[] c, int i, int j, int[] index) {
    float t = c[i];
    c[i] = c[j];
    c[j] = t;
    int idx = index[i];
    index[i] = index[j];
    index[j] = idx;
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
