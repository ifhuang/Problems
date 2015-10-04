package leetcode.algorithms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

// https://oj.leetcode.com/problems/permutations-ii/
public class PermutationsII {
  // recursive
  public List<List<Integer>> permuteUnique(int[] nums) {
    return new LinkedList<>(helper(nums, nums.length));
  }

  private Set<List<Integer>> helper(int[] nums, int end) {
    Set<List<Integer>> ans = new HashSet<>();
    if (end == 0) {
      ans.add(new LinkedList<>());
      return ans;
    }
    Set<List<Integer>> pre = helper(nums, end - 1);
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
  public List<List<Integer>> permuteUnique2(int[] nums) {
    Set<List<Integer>> ans = new HashSet<>();
    ans.add(new LinkedList<>());
    for (int i = 0; i < nums.length; i++) {
      int size = ans.size();
      LinkedList<List<Integer>> ansList = new LinkedList<>(ans);
      ans.clear();
      while (size-- > 0) {
        List<Integer> list = ansList.pollFirst();
        for (int j = 0; j <= list.size(); j++) {
          List<Integer> copy = new LinkedList<>(list);
          copy.add(j, nums[i]);
          ans.add(copy);
        }
      }
    }
    return new LinkedList<>(ans);
  }
}
