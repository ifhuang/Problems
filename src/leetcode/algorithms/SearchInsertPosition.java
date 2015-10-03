package leetcode.algorithms;

// https://oj.leetcode.com/problems/search-insert-position/
public class SearchInsertPosition {
  // time O(logn), space O(1)
  public int searchInsert(int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;
    while (low <= high) {
      int mid = (low + high) >>> 1;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return low;
  }
}
