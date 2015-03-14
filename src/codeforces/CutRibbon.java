package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class CutRibbon {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    String line = in.readLine();
    String[] part = line.split(" ");
    int n = Integer.parseInt(part[0]);
    int[] num = new int[3];
    num[0] = Integer.parseInt(part[1]);
    num[1] = Integer.parseInt(part[2]);
    num[2] = Integer.parseInt(part[3]);
    int[] dp = new int[n + 1];
    dp[0] = 1;
    for (int i = 0; i < n + 1; i++)
      for (int j : num)
        if (i >= j && dp[i - j] != 0)
          dp[i] = Math.max(dp[i], dp[i - j] + 1);
    out.println(dp[n] - 1);
    out.close();
    in.close();
  }
}
