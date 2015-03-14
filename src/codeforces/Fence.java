package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Fence {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    String line = in.readLine();
    String[] part = line.split(" ");
    int n = Integer.parseInt(part[0]);
    int k = Integer.parseInt(part[1]);
    int[] preSum = new int[n + 1];
    line = in.readLine();
    part = line.split(" ");
    for (int i = 1; i <= n; i++)
      preSum[i] = preSum[i - 1] + Integer.parseInt(part[i - 1]);
    int ans = Integer.MAX_VALUE;
    int index = -1;
    for (int i = 1; i + k - 1 <= n; i++) {
      if (ans > preSum[i + k - 1] - preSum[i - 1]) {
        ans = preSum[i + k - 1] - preSum[i - 1];
        index = i;
      }
    }
    out.println(index);
    out.close();
    in.close();
  }
}
