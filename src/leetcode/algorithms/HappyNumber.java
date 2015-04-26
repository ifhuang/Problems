package leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

  public boolean isHappy(int n) {
    Set<Integer> set = new HashSet<>();
    while (!set.contains(n)) {
      set.add(n);
      n = next(n);
    }
    return n == 1;
  }

  private int next(int n) {
    int ans = 0;
    while (n != 0) {
      int x = n % 10;
      ans += x * x;
      n /= 10;
    }
    return ans;
  }

}
