package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class IlyaandQueries {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    String s = in.readLine();
    int n = s.length();
    int[] preSum = new int[n + 1];
    for (int i = 2; i <= n; i++)
      preSum[i] = preSum[i - 1] + (s.charAt(i - 1) == s.charAt(i - 2) ? 1 : 0);
    int m = Integer.parseInt(in.readLine());
    while (m-- > 0) {
      String[] part = in.readLine().split(" ");
      int i = Integer.parseInt(part[0]);
      int j = Integer.parseInt(part[1]);
      out.println(preSum[j] - preSum[i]);
    }
    out.close();
    in.close();
  }
}
