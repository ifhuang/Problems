package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/missing-ranges/
// Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its
// missing ranges.
// For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74",
// "76->99"].
public class MissingRanges {
  public List<String> findMissingRanges(int[] nums, int lower, int upper) {
    int n = nums.length;
    int start = 0, end = 0;
    List<String> ans = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      start = i == 0 ? lower - 1 : end;
      end = i == n ? upper + 1 : nums[i];
      if (start + 1 >= end) {
      } else if (start + 2 == end) {
        ans.add(String.format("%d", start + 1));
      } else {
        ans.add(String.format("%d->%d", start + 1, end - 1));
      }
    }
    return ans;
  }
}
