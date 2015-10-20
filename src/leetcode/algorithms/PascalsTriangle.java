package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

// https://oj.leetcode.com/problems/pascals-triangle/
public class PascalsTriangle {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> ans = new ArrayList<>();
    if (numRows == 0) {
    } else if (numRows == 1) {
      List<Integer> list = new ArrayList<>();
      list.add(1);
      ans.add(list);
    } else {
      ans = generate(numRows - 1);
      List<Integer> last = ans.get(numRows - 2);
      List<Integer> list = new ArrayList<>();
      list.add(1);
      for (int i = 0; i < numRows - 2; i++)
        list.add(last.get(i) + last.get(i + 1));
      list.add(1);
      ans.add(list);
    }
    return ans;
  }

  public List<List<Integer>> generate2(int numRows) {
    List<List<Integer>> ans = new ArrayList<>();
    if (numRows == 0) {
      return ans;
    }
    List<Integer> list = new ArrayList<>();
    list.add(1);
    ans.add(list);
    for (int i = 1; i < numRows; i++) {
      List<Integer> pre = ans.get(i - 1);
      List<Integer> list2 = new ArrayList<>();
      list2.add(1);
      for (int j = 0; j < pre.size() - 1; j++) {
        list2.add(pre.get(j) + pre.get(j + 1));
      }
      list2.add(1);
      ans.add(list2);
    }
    return ans;
  }
}
