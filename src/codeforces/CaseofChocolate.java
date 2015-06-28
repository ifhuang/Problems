package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class CaseofChocolate {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    Set<Integer> set = new HashSet<>();
    TreeMap<Integer, List<Integer>> map = new TreeMap<>();
    int n = nextInt(), q = nextInt();
    List<Integer> list = new ArrayList<>();
    list.add(0);
    list.add(0);
    map.put(n + 1, list);
    for (int i = 0; i < q; i++) {
      int x = nextInt(), y = nextInt();
      String s = next();
      if (set.contains(x)) {
        out.println(0);
        continue;
      }
      set.add(x);
      List<Integer> old = map.get(map.higherKey(x));
      if (s.equals("U")) {
        out.println(y - old.get(0));
        List<Integer> now = new ArrayList<Integer>();
        now.add(old.get(0));
        now.add(old.get(1));
        map.put(x, now);
        old.set(1, x);
      } else {
        out.println(x - old.get(1));
        List<Integer> now = new ArrayList<Integer>();
        now.add(y);
        now.add(old.get(1));
        map.put(x, now);
      }
    }
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
