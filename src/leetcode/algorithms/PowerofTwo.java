package leetcode.algorithms;

// https://leetcode.com/problems/power-of-two/
public class PowerofTwo {
  public boolean isPowerOfTwo(int n) {
    int c = 0;
    for (int i = 0; i < 32; i++) {
      if ((n & (1 << i)) > 0) {
        c++;
      }
    }
    return c == 1 && n > 0;
  }

  public boolean isPowerOfTwo2(int n) {
    return n > 0 && (n & (n - 1)) == 0;
  }
}
