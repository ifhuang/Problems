package hackercup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class SnakesandLadders {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static long mod = 1_000_000_007;

  static void solve() throws Exception {
    int T = nextInt();
    for (int t = 1; t <= T; t++) {
      int N = nextInt();
      List<Ladder> ladders = new ArrayList<>();
      for (int i = 0; i < N; i++) {
        ladders.add(new Ladder(nextLong(), nextLong()));
      }
      ladders.add(new Ladder(Long.MAX_VALUE, Long.MAX_VALUE));
      Collections.sort(ladders);
      long ans = 0;
      Stack<Ladder> stack = new Stack<>();
      for (Ladder ladder : ladders) {
        if (stack.isEmpty()) {
        } else if (stack.peek().h >= ladder.h) {
        } else {
          Map<Long, Stack<Ladder>> map = new HashMap<>();
          while (!stack.isEmpty() && stack.peek().h < ladder.h) {
            Ladder old = stack.pop();
            if (!map.containsKey(old.h)) {
              map.put(old.h, new Stack<>());
            }
            map.get(old.h).push(old);
          }
          for (long h : map.keySet()) {
            Stack<Ladder> compute = map.get(h);
            ans = (ans + com(compute)) % mod;
          }
        }
        if (ans < 0) {
          ans += mod;
        }
        stack.push(ladder);
      }
      out.println(String.format("Case #%d: %d", t, ans));
    }
  }

  static long com(Stack<Ladder> compute) {
    if (compute.size() <= 1) {
      return 0;
    }
    Ladder first = compute.pop();
    long buffer1 = (first.x * first.x) % mod;
    long buffer2 = first.x % mod;
    long ans = 0;
    long pre = 1;
    while (!compute.isEmpty()) {
      Ladder cur = compute.pop();
      long a = (pre * cur.x * cur.x) % mod;
      long b = buffer1 % mod;
      long c = (2 * cur.x * buffer2) % mod;
      ans = (ans + a + b - c) % mod;
      buffer1 = (buffer1 + cur.x * cur.x) % mod;
      buffer2 = (buffer2 + cur.x) % mod;
      pre++;
    }
    return ans;
  }

  public static void main(String args[]) {
    try {
      in = new BufferedReader(new InputStreamReader(System.in));
      // in = new BufferedReader(new FileReader(args[0]));
      out = new PrintWriter(new OutputStreamWriter(System.out));
      // out = new PrintWriter(args[1]);
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

  static String next() throws IOException {
    while (tok == null || !tok.hasMoreTokens()) {
      tok = new StringTokenizer(in.readLine());
    }
    return tok.nextToken();
  }

}


class Ladder implements Comparable<Ladder> {
  long x;
  long h;

  Ladder(long x, long h) {
    this.x = x;
    this.h = h;
  }

  @Override
  public int compareTo(Ladder o) {
    return Long.compare(x, o.x);
  }

  @Override
  public String toString() {
    return "Ladder [x=" + x + ", h=" + h + "]";
  }

}
