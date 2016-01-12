package leetcode.algorithms;

// https://leetcode.com/problems/power-of-three/
public class PowerofThree {
  public boolean isPowerOfThree(int n) {
    return n > 0 && Math.pow(3, 32) % n == 0;
  }
}
