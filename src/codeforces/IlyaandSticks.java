package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Random;
import java.util.Stack;
import java.util.StringTokenizer;

public class IlyaandSticks {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int max = 1000000;
    long[] count = new long[max + 1];
    int n = nextInt();
    for (int i = 0; i < n; i++)
      count[nextInt()]++;
    long ans = 0;
    Stack<Long> s = new Stack<Long>();
    boolean[] flag = new boolean[max + 1];
    for (int i = max; i > 0; i--) {
      long c = count[i] % 2;
      if (c > 0)
        if (count[i] > 1 || !flag[i]) {
          count[i - 1]++;
          flag[i - 1] = true;
        }
      if (count[i] >= 2 && !s.isEmpty()) {
        ans += s.pop() * i;
        count[i] -= 2;
      }
      long a = count[i] / 4;
      ans += a * i * i;
      long b = count[i] % 4 / 2;
      if (b > 0)
        if (s.isEmpty())
          s.push((long) i);
        else
          ans += s.pop() * i;
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

}
