package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class ReplaceToMakeRegularBracketSequence {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    char[] c = next().toCharArray();
    Stack<Character> stack = new Stack<Character>();
    int ans = 0;
    for (char ci : c) {
      if ("([<{".indexOf(ci) != -1) {
        stack.push(ci);
      } else {
        if (stack.isEmpty()) {
          out.println("Impossible");
          return;
        }
        char st = stack.peek();
        if ((st == '(' && ci == ')') || (st == '[' && ci == ']') || (st == '<' && ci == '>')
            || (st == '{' && ci == '}')) {
          ;
        } else {
          ans++;
        }
        stack.pop();
      }
    }
    if (!stack.isEmpty()) {
      out.println("Impossible");
    } else {
      out.println(ans);
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
