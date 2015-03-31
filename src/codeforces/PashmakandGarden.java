package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Random;
import java.util.StringTokenizer;

public class PashmakandGarden {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int x1 = nextInt();
    int y1 = nextInt();
    int x2 = nextInt();
    int y2 = nextInt();
    if (x1 == x2 && y1 != y2) {
      int x3 = x1 + (y2 - y1);
      int y3 = y1;
      int x4 = x3;
      int y4 = y2;
      out.println(x3 + " " + y3 + " " + x4 + " " + y4);
    } else if (y1 == y2 && x1 != x2) {
      int x3 = x1;
      int y3 = y1 + (x2 - x1);
      int x4 = x2;
      int y4 = y3;
      out.println(x3 + " " + y3 + " " + x4 + " " + y4);
    } else if (x1 == x2 && y1 == y2)
      out.println(-1);
    else if (Math.abs(x1 - x2) == Math.abs(y1 - y2)) {
      int x3 = x1;
      int y3 = y2;
      int x4 = x2;
      int y4 = y1;
      out.println(x3 + " " + y3 + " " + x4 + " " + y4);
    } else
      out.println(-1);
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

}
