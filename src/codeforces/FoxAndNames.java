package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class FoxAndNames {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    char[][] c = new char[n][];
    for (int i = 0; i < n; i++)
      c[i] = next().toCharArray();
    Map<Character, List<Character>> graph = new HashMap<>();
    for (char i = 'a'; i <= 'z'; i++)
      graph.put(i, new ArrayList<>());
    int[] count = new int[26];
    for (int i = 0; i < n - 1; i++)
      for (int j = i + 1; j < n; j++) {
        int k = 0;
        for (; k < Math.min(c[i].length, c[j].length); k++)
          if (c[i][k] != c[j][k]) {
            graph.get(c[i][k]).add(c[j][k]);
            count[c[j][k] - 'a']++;
            break;
          }
        if (k == c[j].length && c[i].length > c[j].length) {
          out.println("Impossible");
          return;
        }
      }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 26; i++) {
      int j = 0;
      for (; j < 26; j++)
        if (count[j] == 0) {
          count[j] = -1;
          char ci = (char) ('a' + j);
          for (char cii : graph.get(ci))
            count[cii - 'a']--;
          sb.append(ci);
          break;
        }
      if (j == 26) {
        out.println("Impossible");
        return;
      }
    }
    out.println(sb);
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
