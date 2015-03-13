package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Puzzles {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    String line = in.readLine();
    String[] part = line.split(" ");
    int n = Integer.parseInt(part[0]);
    int m = Integer.parseInt(part[1]);
    int[] p = new int[m];
    line = in.readLine();
    part = line.split(" ");
    for (int i = 0; i < m; i++)
      p[i] = Integer.parseInt(part[i]);
    Arrays.sort(p);
    int ans = Integer.MAX_VALUE;
    for (int i = 0; i + n <= m; i++)
      ans = Math.min(ans, p[i + n - 1] - p[i]);
    out.println(ans);
    out.close();
    in.close();
  }
}
