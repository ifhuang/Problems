package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

// https://oj.leetcode.com/problems/gray-code/
public class GrayCode {
  public List<Integer> grayCode(int n) {
    if (n == 0) {
      List<Integer> ans = new ArrayList<>();
      ans.add(0);
      return ans;
    }
    List<Integer> pre = grayCode(n - 1);
    int base = 1 << (n - 1);
    List<Integer> ans = new ArrayList<>(pre);
    for (int i = pre.size() - 1; i >= 0; i--) {
      ans.add(base + pre.get(i));
    }
    return ans;
  }
}
