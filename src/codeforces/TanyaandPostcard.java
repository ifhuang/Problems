package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TanyaandPostcard {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    String s = in.readLine();
    String t = in.readLine();
    int[] scount = new int[256];
    for (int i = 0; i < s.length(); i++)
      scount[s.charAt(i)]++;
    int[] tcount = new int[256];
    for (int i = 0; i < t.length(); i++)
      tcount[t.charAt(i)]++;
    int a = 0;
    int b = 0;
    for (char c = 'a'; c <= 'z'; c++) {
      int s1 = scount[c];
      int s2 = scount[c + 'A' - 'a'];
      int t1 = tcount[c];
      int t2 = tcount[c + 'A' - 'a'];
      int min1 = Math.min(s1, t1);
      int min2 = Math.min(s2, t2);
      a += min1 + min2;
      s1 -= min1;
      t1 -= min1;
      s2 -= min2;
      t2 -= min2;
      b += Math.min(s1, t2) + Math.min(s2, t1);
    }
    out.print(a);
    out.print(' ');
    out.print(b);
    out.println();
    out.close();
    in.close();
  }
}
