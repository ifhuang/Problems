package leetcode.algorithms;

import java.util.LinkedList;
import java.util.List;

// https://oj.leetcode.com/problems/gray-code/
public class GrayCode {
  public List<Integer> grayCode(int n) {
    List<Integer> ans = new LinkedList<>();
    if (n == 0)
      ans.add(0);
    else {
      List<Integer> pre = grayCode(n - 1);
      int len = pre.size();
      for (int i = 0; i < len; i++)
        ans.add(pre.get(i));
      int base = (int) Math.pow(2, n - 1);
      for (int i = 0; i < len; i++)
        ans.add(base + pre.get(len - i - 1));
    }
    return ans;
  }
}
