package leetcode.algorithms;

// https://leetcode.com/problems/reverse-bits/
public class ReverseBits {
  // you need treat n as an unsigned value
  public int reverseBits(int n) {
    int ans = 0;
    for (int i = 0; i < 32; i++) {
      ans *= 2;
      if ((n & (1 << i)) != 0) {
        ans++;
      }
    }
    return ans;
  }
}
