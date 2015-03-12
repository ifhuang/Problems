package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class GeorgeandJob {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    String line = in.readLine();
    String[] part = line.split(" ");
    int n = Integer.parseInt(part[0]);
    int m = Integer.parseInt(part[1]);
    int k = Integer.parseInt(part[2]);
    line = in.readLine();
    part = line.split(" ");
    long[] p = new long[n + 1];
    long[] preSum = new long[n + 1];
    for (int i = 1; i <= n; i++) {
      p[i] = Integer.parseInt(part[i - 1]);
      preSum[i] = preSum[i - 1] + p[i];
    }
    long[][] dp = new long[n + 1][k + 1];
    for (int i = m; i <= n; i++)
      for (int j = 1; j <= k; j++)
        dp[i][j] = Math.max(dp[i - m][j - 1] + preSum[i] - preSum[i - m], dp[i - 1][j]);
    out.println(dp[n][k]);
    out.close();
    in.close();
  }
}
