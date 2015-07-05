package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
  public List<String> summaryRanges(int[] nums) {
    return helper(nums, 0);
  }

  private List<String> helper(int[] nums, int s) {
    if (s == nums.length)
      return new ArrayList<>();
    int j = s + 1;
    for (; j < nums.length; j++)
      if (nums[j] != nums[j - 1] + 1)
        break;
    j--;
    List<String> ans = new ArrayList<>();
    if (s == j)
      ans.add(nums[s] + "");
    else
      ans.add(nums[s] + "->" + nums[j]);
    ans.addAll(helper(nums, j + 1));
    return ans;
  }
}
