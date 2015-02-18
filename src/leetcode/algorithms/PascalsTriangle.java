package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

// https://oj.leetcode.com/problems/pascals-triangle/
public class PascalsTriangle {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> ans = new ArrayList<>();
    if (numRows == 1) {
      List<Integer> list = new ArrayList<>();
      list.add(1);
      ans.add(list);
    } else if (numRows > 1) {
      List<List<Integer>> pre = generate(numRows - 1);
      ans.addAll(pre);
      List<Integer> last = pre.get(numRows - 2);
      List<Integer> list = new ArrayList<>();
      list.add(1);
      for (int i = 0; i < numRows - 2; i++)
        list.add(last.get(i) + last.get(i + 1));
      list.add(1);
      ans.add(list);
    }
    return ans;
  }
}
