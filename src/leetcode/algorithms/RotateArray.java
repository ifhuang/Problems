package leetcode.algorithms;

import java.util.Arrays;

// https://leetcode.com/problems/rotate-array/
public class RotateArray {
  public void rotate(int[] nums, int k) {
    int n = nums.length;
    int[] copy = Arrays.copyOf(nums, n);
    for (int i = 0; i < n; i++) {
      nums[(i + k) % n] = copy[i];
    }
  }

  public void rotate2(int[] nums, int k) {
    int n = nums.length;
    k %= n;
    reverse(nums, 0, n - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, n - 1);
  }

  private void reverse(int[] c, int i, int j) {
    while (i < j) {
      int t = c[i];
      c[i] = c[j];
      c[j] = t;
      i++;
      j--;
    }
  }
}
