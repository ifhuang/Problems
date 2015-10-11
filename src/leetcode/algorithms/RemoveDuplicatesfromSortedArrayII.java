package leetcode.algorithms;

// https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
public class RemoveDuplicatesfromSortedArrayII {
  public int removeDuplicates(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int num = nums[0];
    int c = 1;
    int t = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == num) {
        if (c == 1) {
          nums[t++] = nums[i];
          c++;
        }
      } else {
        nums[t++] = nums[i];
        num = nums[i];
        c = 1;
      }
    }
    return t;
  }

  public int removeDuplicates2(int[] nums) {
    int i = 0;
    for (int num : nums) {
      if (i < 2 || num > nums[i - 2]) {
        nums[i++] = num;
      }
    }
    return i;
  }
}
