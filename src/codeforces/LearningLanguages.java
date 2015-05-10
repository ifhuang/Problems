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
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class LearningLanguages {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    int m = nextInt();
    boolean[][] lang = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      int k = nextInt();
      for (int j = 0; j < k; j++)
        lang[i][nextInt() - 1] = true;
    }
    for (int i = 0; i < n; i++) {
      Queue<Integer> queue = new LinkedList<>();
      for (int j = 0; j < m; j++)
        if (lang[i][j])
          queue.offer(j);
      while (!queue.isEmpty()) {
        int t = queue.poll();
        for (int k = 0; k < n; k++)
          if (k != i && lang[k][t])
            for (int q = 0; q < m; q++)
              if (lang[k][q] && !lang[i][q]) {
                lang[i][q] = true;
                queue.offer(q);
              }
      }
    }

    int ans = 0;
    Set<List<Boolean>> set = new HashSet<>();
    for (int i = 0; i < n; i++)
      if (check(lang[i]))
        set.add(convert(lang[i]));
      else
        ans++;
    if (set.size() == 0)
      out.println(ans);
    else
      out.println(ans + set.size() - 1);
  }

  static boolean check(boolean[] b) {
    for (boolean bi : b)
      if (bi)
        return true;
    return false;
  }

  static List<Boolean> convert(boolean[] b) {
    List<Boolean> list = new ArrayList<>();
    for (boolean bi : b)
      list.add(bi);
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
