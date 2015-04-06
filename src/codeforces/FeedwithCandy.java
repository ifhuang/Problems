package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Random;
import java.util.StringTokenizer;

public class FeedwithCandy {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    int x = nextInt();
    int[][] data = new int[n][3];
    for (int i = 0; i < n; i++)
      for (int j = 0; j < 3; j++)
        data[i][j] = nextInt();
    int ans = 0;
    for (int s = 0; s < 2; s++) {
      int ss = s;
      int xx = x;
      boolean[] v = new boolean[n];
      int count = 0;
      while (true) {
        int max = -1;
        int maxi = -1;
        for (int i = 0; i < n; i++)
          if (!v[i] && data[i][0] == ss && data[i][1] <= xx && data[i][2] > max) {
            max = data[i][2];
            maxi = i;
          }
        if (max == -1)
          break;
        count++;
        v[maxi] = true;
        xx += max;
        ss = 1 - ss;
      }
      ans = Math.max(ans, count);
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

  static double nextDouble() throws IOException {
    return Double.parseDouble(next());
  }

  static double[] nextDoubleArray(int len, int start) throws IOException {
    double[] a = new double[len];
    for (int i = start; i < len; i++)
      a[i] = nextDouble();
    return a;
  }

  static BigInteger nextBigInteger() throws IOException {
    return new BigInteger(next());
  }

  static String next() throws IOException {
    while (tok == null || !tok.hasMoreTokens()) {
      tok = new StringTokenizer(in.readLine());
    }
    return tok.nextToken();
  }

  static String nextLine() throws IOException {
    tok = new StringTokenizer("");
    return in.readLine();
  }

  static void shuffleArray(long[] array) {
    Random random = new Random();
    for (int i = array.length - 1; i > 0; i--) {
      int index = random.nextInt(i + 1);
      long temp = array[index];
      array[index] = array[i];
      array[i] = temp;
    }
  }

  static boolean hasNext() throws IOException {
    while (tok == null || !tok.hasMoreTokens()) {
      String s = in.readLine();
      if (s == null) {
        return false;
      }
      tok = new StringTokenizer(s);
    }
    return true;
  }

}
