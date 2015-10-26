package leetcode.algorithms;

// https://leetcode.com/problems/find-peak-element/
public class FindPeakElement {
  public int findPeakElement(int[] nums) {
    int low = 0, high = nums.length - 1;
    while (low < high) {
      int mid = (low + high) >>> 1;
      if (nums[mid] > nums[mid + 1]) {
        high = mid;
      } else {
        low = mid + 1;
      }
    }
    return low;
  }
}
