package leetcode.algorithms;

// https://leetcode.com/problems/missing-number/
public class MissingNumber {
  public int missingNumber(int[] nums) {
    int res = nums.length;
    for (int i = 0; i < nums.length; i++) {
      res ^= i;
      res ^= nums[i];
    }
    return res;
  }
}
