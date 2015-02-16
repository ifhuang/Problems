package leetcode;

import java.util.List;

// https://oj.leetcode.com/problems/triangle/
public class Triangle {
  public int minimumTotal(List<List<Integer>> triangle) {
    int n = triangle.size();
    int[] pre = new int[n];
    int[] now = null;
    pre[0] = triangle.get(0).get(0);
    if (n == 1)
      return pre[0];
    for (int i = 1; i < n; i++) {
      now = new int[n];
      now[0] = triangle.get(i).get(0) + pre[0];
      for (int j = 1; j < i; j++)
        now[j] = triangle.get(i).get(j) + Math.min(pre[j], pre[j - 1]);
      now[i] = triangle.get(i).get(i) + pre[i - 1];
      pre = now;
    }
    int min = now[0];
    for (int i = 1; i < n; i++)
      min = Math.min(min, now[i]);
    return min;
  }
}
