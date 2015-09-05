package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
  // time O(n^2), space O(1)
  public List<List<Integer>> threeSum(int[] nums) {
    int n = nums.length;
    Arrays.sort(nums);
    List<List<Integer>> ans = new ArrayList<>();
    int i = -1;
    while (i < n - 2) {
      i++;
      while (i - 1 >= 0 && i < n - 2 && nums[i] == nums[i - 1]) {
        i++;
      }
      if (i >= n - 2 || nums[i] > 0) {
        break;
      }
      int j = i + 1;
      int k = n - 1;
      while (j < k) {
        if (nums[i] + nums[j] + nums[k] == 0) {
          List<Integer> list = new ArrayList<>();
          list.add(nums[i]);
          list.add(nums[j]);
          list.add(nums[k]);
          ans.add(list);
          j++;
          while (j < k && nums[j] == nums[j - 1]) {
            j++;
          }
          k--;
          while (j < k && nums[k] == nums[k + 1]) {
            k--;
          }
        } else if (nums[i] + nums[j] + nums[k] < 0) {
          j++;
          while (j < k && nums[j] == nums[j - 1]) {
            j++;
          }
        } else {
          k--;
          while (j < k && nums[k] == nums[k + 1]) {
            k--;
          }
        }
      }
    }
    return ans;
  }
}
