package leetcode.algorithms;

import java.util.LinkedList;
import java.util.List;

// https://oj.leetcode.com/problems/permutations/
public class Permutations {
  // recursive
  public List<List<Integer>> permute(int[] nums) {
    return helper(nums, nums.length);
  }

  private List<List<Integer>> helper(int[] nums, int end) {
    List<List<Integer>> ans = new LinkedList<>();
    if (end == 0) {
      ans.add(new LinkedList<>());
      return ans;
    }
    List<List<Integer>> pre = helper(nums, end - 1);
    for (List<Integer> list : pre) {
      for (int i = 0; i <= list.size(); i++) {
        List<Integer> copy = new LinkedList<>(list);
        copy.add(i, nums[end - 1]);
        ans.add(copy);
      }
    }
    return ans;
  }

  // iterative
  public List<List<Integer>> permute2(int[] nums) {
    LinkedList<List<Integer>> ans = new LinkedList<>();
    ans.add(new LinkedList<>());
    for (int i = 0; i < nums.length; i++) {
      int size = ans.size();
      while (size-- > 0) {
        List<Integer> list = ans.pollFirst();
        for (int j = 0; j <= list.size(); j++) {
          List<Integer> copy = new LinkedList<>(list);
          copy.add(j, nums[i]);
          ans.add(copy);
        }
      }
    }
    return ans;
  }
}
