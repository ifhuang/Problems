package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Queue;

public class SoldierandCards {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    Queue<Integer> a = new LinkedList<>();
    Queue<Integer> b = new LinkedList<>();
    Set<List<Queue<Integer>>> set = new HashSet<>();

    int n = nextInt();
    int k1 = nextInt();
    for (int i = 0; i < k1; i++) {
      int num = nextInt();
      a.offer(num);
    }
    int k2 = nextInt();
    for (int i = 0; i < k2; i++) {
      int num = nextInt();
      b.offer(num);
    }
    set.add(code(a, b));

    while (!a.isEmpty() && !b.isEmpty()) {
      int na = a.poll();
      int nb = b.poll();
      if (na > nb) {
        a.offer(nb);
        a.offer(na);
      } else {
        b.offer(na);
        b.offer(nb);
      }
      if (!set.add(code(a, b))) {
        out.println(-1);
        return;
      }
    }

    out.print(set.size() - 1);
    out.print(" ");
    out.println(a.isEmpty() ? 2 : 1);
  }

  static List<Queue<Integer>> code(Queue<Integer> a, Queue<Integer> b) {
    List<Queue<Integer>> list = new ArrayList<>();
    list.add(new LinkedList<>(a));
    list.add(new LinkedList<>(b));
    return list;
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
