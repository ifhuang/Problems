package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Random;
import java.util.StringTokenizer;

public class DZYLovesSequences {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    long[] a = new long[n];
    for (int i = 0; i < n; i++)
      a[i] = nextLong();
    long[] left = new long[n];
    left[0] = 1;
    for (int i = 1; i < n; i++)
      left[i] = a[i] > a[i - 1] ? left[i - 1] + 1 : 1;
    long[] right = new long[n];
    right[n - 1] = 1;
    for (int i = n - 2; i >= 0; i--)
      right[i] = a[i + 1] > a[i] ? right[i + 1] + 1 : 1;
    long ans = 0;
    for (int i = 0; i < n; i++) {
      ans = Math.max(ans, left[i]);
      ans = Math.max(ans, right[i]);
      if (i > 0 && a[i] <= a[i - 1])
        ans = Math.max(ans, left[i - 1] + 1);
      if (i < n - 1 && a[i] >= a[i + 1])
        ans = Math.max(ans, right[i + 1] + 1);
      if (i > 0 && i < n - 1 && a[i + 1] - a[i - 1] >= 2)
        ans = Math.max(ans, left[i - 1] + 1 + right[i + 1]);
    }
    out.println(ans);
  }

  public static void main(String args[]) {
    try {
      in = new BufferedReader(new InputStreamReader(System.in));
      out = new PrintWriter(new OutputStreamWriter(System.out));
      // in = new BufferedReader(new FileReader("input.in"));
      // out = new PrintWriter(new FileWriter("output.out"));
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

  static long nextLong() throws IOException {
    return Long.parseLong(next());
  }

  static double nextDouble() throws IOException {
    return Double.parseDouble(next());
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
