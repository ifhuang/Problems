package leetcode.algorithms;

import java.util.Arrays;

public class RotateArray {
  public void rotate(int[] nums, int k) {
    int n = nums.length;
    int[] copy = Arrays.copyOf(nums, n);
    for (int i = 0; i < n; i++)
      nums[(i + k) % n] = copy[i];
  }
}
