package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Boredom {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    in.readLine();
    String line = in.readLine();
    String[] part = line.split(" ");
    int max = 100001;
    int[] count = new int[max];
    for (String s : part)
      count[Integer.parseInt(s)]++;
    long[] dp = new long[max];
    dp[1] = count[1];
    for (int i = 2; i < max; i++)
      dp[i] = Math.max(dp[i - 1], dp[i - 2] + 1L * count[i] * i);
    out.println(dp[max - 1]);
    out.close();
    in.close();
  }
}
