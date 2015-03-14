package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FlippingGame {

  static int solve1(int[] a) {
    int oneAll = 0;
    int zero = 0;
    int one = 0;
    int diff = Integer.MIN_VALUE;
    for (int i = 0; i < a.length; i++) {
      if (a[i] == 0) {
        zero++;
      } else {
        oneAll++;
        one++;
      }
      if (zero - one > diff)
        diff = zero - one;
      if (zero - one < 0) {
        zero = 0;
        one = 0;
      }
    }
    return oneAll + diff;
  }

  static int solve2(int[] a) {
    int n = a.length;
    int[] preSum = new int[n + 1];
    for (int i = 1; i <= n; i++)
      preSum[i] = preSum[i - 1] + a[i - 1];
    int ans = Integer.MIN_VALUE;
    for (int i = 1; i <= n; i++)
      for (int j = i; j <= n; j++)
        ans =
            Math.max(ans, preSum[i - 1] + ((j - i + 1) - (preSum[j] - preSum[i - 1]))
                + (preSum[n] - preSum[j]));
    return ans;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    String line = in.readLine();
    int n = Integer.parseInt(line);
    int[] a = new int[n];
    line = in.readLine();
    String[] part = line.split(" ");
    for (int i = 0; i < n; i++)
      a[i] = Integer.parseInt(part[i]);
    out.println(solve2(a));
    out.close();
    in.close();
  }
}
