package leetcode.algorithms;

// https://oj.leetcode.com/problems/remove-element/
public class RemoveElement {
  // time O(n), space O(1)
  public int removeElement(int[] nums, int val) {
    int a = 0, b = 0;
    while (a < nums.length) {
      if (nums[a] != val) {
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
