package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/best-meeting-point/
// A group of two or more people wants to meet and minimize the total travel distance. You are given
// a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group. The distance is
// calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
// For example, given three people living at (0,0), (0,4), and (2,2):
// The point (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6 is minimal. So
// return 6.
// Hint:
// Try to solve it in one dimension first. How can this solution apply to the two dimension case?
public class BestMeetingPoint {
  public int minTotalDistance(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    List<Integer> listI = new ArrayList<>();
    List<Integer> listJ = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          listI.add(i);
        }
      }
    }
    for (int j = 0; j < n; j++) {
      for (int i = 0; i < m; i++) {
        if (grid[i][j] == 1) {
          listJ.add(j);
        }
      }
    }
    return minTotalDistance(listI) + minTotalDistance(listJ);
  }

  private int minTotalDistance(List<Integer> grid) {
    int i = 0, j = grid.size() - 1, sum = 0;
    while (i < j) {
      sum += grid.get(j--) - grid.get(i++);
    }
    return sum;
  }
}
