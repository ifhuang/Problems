package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/summary-ranges/
public class SummaryRanges {
  public List<String> summaryRanges(int[] nums) {
    return helper(nums, 0);
  }

  private List<String> helper(int[] nums, int s) {
    if (s == nums.length) {
      return new ArrayList<>();
    }
    int j = s + 1;
    while (j < nums.length && nums[j] == nums[j - 1] + 1) {
      j++;
    }
    List<String> ans = new ArrayList<>();
    if (s == j - 1) {
      ans.add(nums[s] + "");
    } else {
      ans.add(nums[s] + "->" + nums[j - 1]);
    }
    ans.addAll(helper(nums, j));
    return ans;
  }
}
