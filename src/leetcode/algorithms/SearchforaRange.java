package leetcode.algorithms;

// https://oj.leetcode.com/problems/search-for-a-range/
public class SearchforaRange {
  // time O(logn), space O(1)
  public int[] searchRange(int[] nums, int target) {
    return new int[] {findLeft(nums, target), findRight(nums, target)};
  }

  private int findLeft(int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;
    while (low <= high) {
      int mid = (low + high) >>> 1;
      if (nums[mid] == target) {
        if (mid == low) {
          return low;
        }
        high = mid;
      } else if (nums[mid] > target) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return -1;
  }

  private int findRight(int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;
    while (low <= high) {
      int mid = (low + high) >>> 1;
      if (nums[mid] == target) {
        if (mid == low) {
          return nums[high] == target ? high : low;
        }
        low = mid;
      } else if (nums[mid] > target) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return -1;
  }
}
