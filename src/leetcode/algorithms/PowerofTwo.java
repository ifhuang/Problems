package leetcode.algorithms;

public class PowerofTwo {
  public boolean isPowerOfTwo(int n) {
    int c = 0;
    for (int i = 0; i < 32; i++)
      if ((n & (1 << i)) > 0)
        c++;
    return c == 1 && n > 0;
  }
}
