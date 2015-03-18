package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

public class ErrorCorrectSystem {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    String s = nextLine();
    String t = nextLine();
    int d = 0;
    Map<Pair, Integer> map = new HashMap<>();
    Map<Character, Integer> mapA = new HashMap<>();
    Map<Character, Integer> mapB = new HashMap<>();
    int a = -1;
    int b = -1;
    boolean flag2 = false;
    boolean flag1 = false;
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) != t.charAt(i)) {
        d++;
        if (!flag2) {
          char a1 = s.charAt(i);
          char b1 = t.charAt(i);
          Pair p1 = new Pair(a1, b1);
          Pair p2 = new Pair(b1, a1);
          if (map.containsKey(p2)) {
            a = map.get(p2) + 1;
            b = i + 1;
            flag2 = true;
          } else {
            map.put(p1, i);
            if (!flag1) {
              if (mapA.containsKey(b1)) {
                a = mapA.get(b1) + 1;
                b = i + 1;
                flag1 = true;
              } else if (mapB.containsKey(a1)) {
                a = mapB.get(a1) + 1;
                b = i + 1;
                flag1 = true;
              }
              mapA.put(a1, i);
              mapB.put(b1, i);
            }
          }
        }
      }
    }
    if (flag2)
      d -= 2;
    else if (flag1)
      d--;
    out.println(d);
    out.println(a + " " + b);
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


class Pair {
  char a;
  char b;

  public Pair(char a1, char b1) {
    a = a1;
    b = b1;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + a;
    result = prime * result + b;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Pair other = (Pair) obj;
    if (a != other.a)
      return false;
    if (b != other.b)
      return false;
    return true;
  }

}
