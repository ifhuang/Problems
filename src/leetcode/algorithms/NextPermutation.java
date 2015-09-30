package leetcode.algorithms;

// https://oj.leetcode.com/problems/next-permutation/
public class NextPermutation {
  // time O(n), space O(1)
  public void nextPermutation(int[] nums) {
    int n = nums.length;
    int i = n - 1;
    while (i > 0 && nums[i - 1] >= nums[i]) {
      i--;
    }
    if (i > 0) {
      int j = n - 1;
      while (j >= i && nums[i - 1] >= nums[j]) {
        j--;
      }
      swap(nums, i - 1, j);
    }
    int j = n - 1;
    while (i < j) {
      swap(nums, i, j);
      i++;
      j--;
    }
  }

  private void swap(int[] a, int i, int j) {
    int t = a[i];
    a[i] = a[j];
    a[j] = t;
  }
}
