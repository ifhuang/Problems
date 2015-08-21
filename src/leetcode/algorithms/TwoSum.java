package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

// https://oj.leetcode.com/problems/two-sum/
public class TwoSum {
  // time O(n), space O(n)
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int diff = target - nums[i];
      if (map.containsKey(diff))
        return new int[] {map.get(diff) + 1, i + 1};
      map.put(nums[i], i);
    }
    return null;
  }

  // time O(n^2), space O(1)
  public int[] twoSum2(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++)
      for (int j = i + 1; j < nums.length; j++)
        if (nums[i] + nums[j] == target)
          return new int[] {i + 1, j + 1};
    return null;
  }
}
