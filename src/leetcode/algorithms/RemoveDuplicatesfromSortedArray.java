package leetcode.algorithms;

// https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array/
public class RemoveDuplicatesfromSortedArray {
  // time O(n), space O(1)
  public int removeDuplicates(int[] nums) {
    int a = 0, b = 0;
    while (a < nums.length) {
      if (b == 0 || nums[a] != nums[b - 1]) {
        nums[b] = nums[a];
        b++;
        a++;
      } else {
        a++;
      }
    }
    return b;
  }
}
