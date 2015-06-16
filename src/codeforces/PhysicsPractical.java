package codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
// import java.io.InputStreamReader;
// import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class PhysicsPractical {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int max = 5000;
    int[] count = new int[max + 1];
    int n = nextInt();
    while (n-- > 0)
      count[nextInt()]++;
    int ans = Integer.MAX_VALUE;
    for (int i = 1; i <= max; i++) {
      int remove = 0;
      for (int j = 1; j < i; j++)
        remove += count[j];
      for (int j = i * 2 + 1; j <= max; j++)
        remove += count[j];
      ans = Math.min(ans, remove);
    }
    out.println(ans);
  }

  static void solve1() throws Exception {
    int n = nextInt();
    int[] c = new int[n];
    for (int i = 0; i < n; i++)
      c[i] = nextInt();
    Arrays.sort(c);
    int len = (n + 1) / 2;
    int ans = Integer.MAX_VALUE;

    for (int i = 0; i < len; i++) {
      int a = c[i] * 2;
      int ai = Arrays.binarySearch(c, i + 1, n, a);
      if (ai < 0)
        ai = -ai - 1;
      else
        while (ai < n && c[ai] == a)
          ai++;
      int ad = n - ai;
      int b = (c[n - 1 - i] + 1) / 2;
      int bi = Arrays.binarySearch(c, 0, n - i, b);
      if (bi < 0)
        bi = -bi - 2;
      else
        while (bi >= 0 && c[bi] == b)
          bi--;
      int bd = bi + 1;
      ans = Math.min(ans, Math.min(ad, bd) + i);
      if (ans == 0)
        break;
    }
    out.println(ans);
  }

  public static void main(String args[]) {
    try {
      // in = new BufferedReader(new InputStreamReader(System.in));
      // out = new PrintWriter(new OutputStreamWriter(System.out));
      in = new BufferedReader(new FileReader("input.txt"));
      out = new PrintWriter(new FileWriter("output.txt"));
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
