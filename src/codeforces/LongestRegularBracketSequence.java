package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class LongestRegularBracketSequence {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    String line = in.readLine();
    int n = line.length();
    int[] dp = new int[n];
    for (int i = n - 2; i >= 0; i--) {
      char a = line.charAt(i);
      if (a == '(') {
        int pre = i + dp[i + 1] + 1;
        if (pre < n) {
          char b = line.charAt(pre);
          if (b == ')') {
            dp[i] = dp[i + 1] + 2;
            if (pre + 1 < n)
              dp[i] += dp[pre + 1];
          }
        }
      }
    }
    int ans = 0;
    int count = 0;
    for (int i : dp)
      if (i > ans) {
        ans = i;
        count = 1;
      } else if (i == ans)
        count++;
    if (ans == 0)
      out.println("0 1");
    else
      out.println(ans + " " + count);
    out.close();
    in.close();
  }
}
