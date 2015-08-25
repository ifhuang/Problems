package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

// https://oj.leetcode.com/problems/zigzag-conversion/
public class ZigZagConversion {
  // time O(n), space O(n)
  public String convert(String s, int numRows) {
    List<StringBuilder> list = new ArrayList<>();
    for (int i = 0; i < numRows; i++) {
      list.add(new StringBuilder());
    }
    int i = -1;
    int d = 1;
    for (char c : s.toCharArray()) {
      i += d;
      list.get(i).append(c);
      if (numRows == 1) {
        d = 0;
      } else if (i == numRows - 1) {
        d = -1;
      } else if (i == 0) {
        d = 1;
      }
    }
    StringBuilder ans = new StringBuilder();
    for (StringBuilder sb : list) {
      ans.append(sb);
    }
    return ans.toString();
  }
}
