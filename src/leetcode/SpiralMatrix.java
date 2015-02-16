package leetcode;

import java.util.ArrayList;
import java.util.List;

// https://oj.leetcode.com/problems/spiral-matrix/
public class SpiralMatrix {
  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> ans = new ArrayList<>();
    if (matrix.length == 0)
      return ans;
    int rB = 0;
    int rE = matrix.length - 1;
    int cB = 0;
    int cE = matrix[0].length - 1;
    while (rB <= rE && cB <= cE) {
      for (int i = cB; i <= cE; i++)
        ans.add(matrix[rB][i]);
      rB++;
      for (int i = rB; i <= rE; i++)
        ans.add(matrix[i][cE]);
      cE--;
      if (rB <= rE)
        for (int i = cE; i >= cB; i--)
          ans.add(matrix[rE][i]);
      rE--;
      if (cB <= cE)
        for (int i = rE; i >= rB; i--)
          ans.add(matrix[i][cB]);
      cB++;
    }
    return ans;
  }
}
