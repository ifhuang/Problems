package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://oj.leetcode.com/problems/4sum/
public class FourSum {
  // time O(n^3), space O(1)
  public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    Set<List<Integer>> ans = new HashSet<>();
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        for (int x = j + 1, y = n - 1; x < y;) {
          int sum = nums[i] + nums[j] + nums[x] + nums[y];
          if (sum == target) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            list.add(nums[j]);
            list.add(nums[x]);
            list.add(nums[y]);
            ans.add(list);
            x++;
            y--;
          } else if (sum > target) {
            y--;
          } else {
            x++;
          }
        }
      }
    }
    return new ArrayList<>(ans);
  }
}
