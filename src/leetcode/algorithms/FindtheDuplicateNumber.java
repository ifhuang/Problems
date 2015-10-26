package leetcode.algorithms;

// https://leetcode.com/problems/find-the-duplicate-number/
public class FindtheDuplicateNumber {
  public int findDuplicate(int[] nums) {
    int low = 1, high = nums.length - 1;
    while (low <= high) {
      int mid = (low + high) >>> 1;
      int cnt = 0;
      for (int a : nums) {
        if (a <= mid) {
          ++cnt;
        }
      }
      if (cnt <= mid) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return low;
  }

  public int findDuplicate2(int[] nums) {
    int n = nums.length;
    int slow = n;
    int fast = n;
    do {
      slow = nums[slow - 1];
      fast = nums[nums[fast - 1] - 1];
    } while (slow != fast);
    slow = n;
    while (slow != fast) {
      slow = nums[slow - 1];
      fast = nums[fast - 1];
    }
    return slow;
  }
}
