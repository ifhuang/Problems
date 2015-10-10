package leetcode.algorithms;

// https://oj.leetcode.com/problems/sqrtx/
public class Sqrtx {
  public int mySqrt(int x) {
    int low = 1;
    int high = x;
    while (low <= high) {
      int mid = (low + high) >>> 1;
      int r = x / mid;
      if (r == mid) {
        return mid;
      } else if (r > mid) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return high;
  }

  public int mySqrt2(int x) {
    long r = x;
    while (r * r > x) {
      r = (r + (x / r)) / 2;
    }
    return (int) r;
  }
}
