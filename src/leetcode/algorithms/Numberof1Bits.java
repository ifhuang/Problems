package leetcode.algorithms;

// https://leetcode.com/problems/number-of-1-bits/
public class Numberof1Bits {
  // you need to treat n as an unsigned value
  public int hammingWeight(int n) {
    int count = 0;
    for (int i = 0; i < 32; i++) {
      if ((n & (1 << i)) != 0) {
        count++;
      }
    }
    return count;
  }

  public int hammingWeight2(int n) {
    int ans = 0;
    while (n != 0) {
      n = n & (n - 1);
      ans++;
    }
    return ans;
  }
}
