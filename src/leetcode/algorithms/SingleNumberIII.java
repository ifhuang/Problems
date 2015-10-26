package leetcode.algorithms;

// https://leetcode.com/problems/single-number-iii/
public class SingleNumberIII {
  public int[] singleNumber(int[] nums) {
    int t = 0;
    for (int num : nums) {
      t ^= num;
    }
    t &= -t;
    int[] ans = {0, 0};
    for (int num : nums) {
      if ((num & t) == 0) {
        ans[0] ^= num;
      } else {
        ans[1] ^= num;
      }
    }
    return ans;
  }
}
