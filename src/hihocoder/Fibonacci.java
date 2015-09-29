package hihocoder;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fibonacci {
  static Scanner in;
  static PrintWriter out;

  static void solve() {
    int n = in.nextInt();
    int[] a = new int[n + 1];
    for (int i = 1; i <= n; i++)
      a[i] = in.nextInt();
    List<Integer> fibonacci = getF();
    BigInteger[] dp = new BigInteger[fibonacci.size() + 1];
    dp[0] = BigInteger.ONE;
    for (int i = 1; i < dp.length; i++)
      dp[i] = BigInteger.ZERO;
    BigInteger ans = BigInteger.ZERO;
    for (int i = 1; i <= n; i++)
      for (int j = fibonacci.size() - 1; j >= 1; j--) {
        if (a[i] == fibonacci.get(j)) {
          ans = ans.add(dp[j - 1]);
          dp[j] = dp[j].add(dp[j - 1]);
        }
      }
    BigInteger mod = new BigInteger("1000000007");
    out.println(ans.mod(mod));
  }

  static List<Integer> getF() {
    List<Integer> list = new ArrayList<Integer>();
    list.add(0);
    list.add(1);
    list.add(1);
    for (int i = 3;; i++) {
      list.add(list.get(i - 1) + list.get(i - 2));
      if (list.get(i) > 100000)
        break;
    }
    return list;
  }

  public static void main(String[] args) {
    in = new Scanner(System.in);
    out = new PrintWriter(System.out);
    solve();
    out.close();
    in.close();
  }
}
