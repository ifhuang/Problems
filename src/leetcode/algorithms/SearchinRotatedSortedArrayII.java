package leetcode.algorithms;

// https://oj.leetcode.com/problems/search-in-rotated-sorted-array-ii/
public class SearchinRotatedSortedArrayII {
  public boolean search(int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;
    while (low <= high) {
      int mid = (low + high) >>> 1;
      if (nums[mid] == target) {
        return true;
      } else if (nums[low] < nums[mid]) {
        if (nums[low] <= target && target < nums[mid]) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      } else if (nums[low] > nums[mid]) {
        if (nums[high] >= target && target > nums[mid]) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      } else {
        low++;
      }
    }
    return false;
  }
}
