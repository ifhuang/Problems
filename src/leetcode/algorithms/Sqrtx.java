package leetcode.algorithms;

// https://oj.leetcode.com/problems/sqrtx/
public class Sqrtx {
  public int sqrt(int x) {
    int low = 1;
    int high = x;
    int ans = 0;
    while (low <= high) {
      int mid = (low + high) >>> 1;
      if (mid <= x / mid) {
        ans = mid;
        low = mid + 1;
      } else
        high = mid - 1;
    }
    return ans;
  }
}
