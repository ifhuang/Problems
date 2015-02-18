package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://oj.leetcode.com/problems/subsets-ii/
public class SubsetsII {
  public List<List<Integer>> subsetsWithDup(int[] num) {
    Arrays.sort(num);
    return subsetHelper(num, num.length - 1);
  }

  private List<List<Integer>> subsetHelper(int[] num, int i) {
    Set<List<Integer>> ans = new HashSet<>();
    if (i == 0) {
      List<Integer> list = new ArrayList<>();
      ans.add(list);
      list = new ArrayList<>();
      list.add(num[0]);
      ans.add(list);
    } else {
      List<List<Integer>> pre = subsetHelper(num, i - 1);
      ans.addAll(pre);
      for (List<Integer> list : pre) {
        List<Integer> copy = new ArrayList<>(list);
        copy.add(num[i]);
        ans.add(copy);
      }
    }
    return new ArrayList<>(ans);
  }
}
