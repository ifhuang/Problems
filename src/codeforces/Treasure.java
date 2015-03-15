package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public class Treasure {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    String s = nextLine();
    int left = 0;
    List<Integer> list = new ArrayList<>();
    int i = s.length() - 1;
    int right = 0;
    while (i >= 0) {
      char c = s.charAt(i);
      if (c == '#')
        break;
      else if (c == ')')
        right++;
      else {
        if (right == 0) {
          out.println(-1);
          return;
        }
        right--;
      }
      i--;
    }
    i = 0;
    while (i < s.length()) {
      char c = s.charAt(i);
      if (c == '(')
        left++;
      else if (c == ')') {
        if (left == 0) {
          out.println(-1);
          return;
        }
        left--;
      } else {
        if (left == 0) {
          out.println(-1);
          return;
        }
        left--;
        list.add(1);
      }
      i++;
    }
    if (left > 0 && list.isEmpty())
      out.println(-1);
    else {
      for (int j = 0; j < list.size() - 1; j++)
        out.println(list.get(j));
      out.println(list.get(list.size() - 1) + left);
    }
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
