package leetcode.algorithms;

// https://oj.leetcode.com/problems/first-missing-positive/
public class FirstMissingPositive {
  // time O(n), space O(1)
  public int firstMissingPositive(int[] nums) {
    int n = nums.length;
    for (int i = 0; i < n;) {
      int index = nums[i] - 1;
      if (nums[i] > 0 && nums[i] < n && nums[index] != nums[i]) {
        swap(nums, index, i);
      } else {
        i++;
      }
    }
    for (int i = 0; i < n; i++) {
      if (nums[i] != i + 1) {
        return i + 1;
      }
    }
    return n + 1;
  }

  private void swap(int[] nums, int i, int j) {
    int t = nums[i];
    nums[i] = nums[j];
    nums[j] = t;
  }
}
