package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
  public List<Integer> majorityElement(int[] nums) {
    int[] n = new int[2];
    n[1] = 1;
    int[] c = new int[2];
    for (int i : nums) {
      int j = 0;
      for (; j < 2; j++)
        if (i == n[j]) {
          c[j]++;
          break;
        }
      if (j == 2) {
        j = 0;
        for (; j < 2; j++)
          if (c[j] == 0) {
            n[j] = i;
            c[j]++;
            break;
          }
        if (j == 2) {
          j = 0;
          for (; j < 2; j++)
            c[j]--;
        }
      }
    }
    c[0] = c[1] = 0;
    for (int i : nums)
      for (int j = 0; j < 2; j++)
        if (i == n[j])
          c[j]++;
    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < 2; i++)
      if (c[i] > nums.length / 3)
        ans.add(n[i]);
    return ans;
  }
}
