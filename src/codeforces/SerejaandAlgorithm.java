package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class SerejaandAlgorithm {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    char[] c = next().toCharArray();
    int[][] count = new int[c.length + 1][3];
    for (int i = 0; i < c.length; i++)
      for (int j = 0; j < 3; j++)
        count[i + 1][j] = count[i][j] + (c[i] == 'x' + j ? 1 : 0);
    int m = nextInt();
    while (m-- > 0) {
      int l = nextInt();
      int r = nextInt();
      int d = r - l + 1;
      if (d < 3)
        out.println("YES");
      else {
        int[] a = new int[3];
        for (int i = 0; i < 3; i++)
          a[i] = d / 3 + (i < d % 3 ? 1 : 0);
        Arrays.sort(a);
        int[] b = new int[3];
        for (int i = 0; i < 3; i++)
          b[i] = count[r][i] - count[l - 1][i];
        Arrays.sort(b);
        if (check(a, b))
          out.println("YES");
        else
          out.println("NO");
      }
    }
  }

  static boolean check(int[] a, int[] b) {
    for (int i = 0; i < a.length; i++)
      if (a[i] != b[i])
        return false;
    return true;
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
