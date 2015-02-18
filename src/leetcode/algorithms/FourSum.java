package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://oj.leetcode.com/problems/4sum/
public class FourSum {
  public List<List<Integer>> fourSum(int[] num, int target) {
    Arrays.sort(num);
    Set<List<Integer>> set = new HashSet<>();
    for (int i = 0; i < num.length - 3; i++)
      for (int j = i + 1; j < num.length - 2; j++)
        for (int k = j + 1, m = num.length - 1; k < m;) {
          int r = target - num[i] - num[j];
          int s = num[k] + num[m];
          if (r == s) {
            List<Integer> list = new ArrayList<>();
            list.add(num[i]);
            list.add(num[j]);
            list.add(num[k]);
            list.add(num[m]);
            set.add(list);
            k++;
            m--;
          } else if (r > s)
            k++;
          else
            m--;
        }
    return new ArrayList<>(set);
  }
}
