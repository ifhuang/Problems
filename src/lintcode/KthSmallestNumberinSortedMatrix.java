package lintcode;

import java.util.PriorityQueue;

// http://www.lintcode.com/en/problem/kth-smallest-number-in-sorted-matrix/
public class KthSmallestNumberinSortedMatrix {
  /**
   * @param matrix: a matrix of integers
   * @param k: an integer
   * @return: the kth smallest number in the matrix
   */
  public int kthSmallest(int[][] matrix, int k) {
    // write your code here
    int m = matrix.length;
    int n = matrix[0].length;
    boolean[][] visited = new boolean[m][n];
    PriorityQueue<Item> pq = new PriorityQueue<>();
    visited[0][0] = true;
    pq.offer(new Item(matrix[0][0], 0, 0));
    Item cur = null;
    while (k > 0) {
      cur = pq.poll();
      int x1 = cur.x;
      int y1 = cur.y + 1;
      if (check(visited, m, n, x1, y1)) {
        visited[x1][y1] = true;
        pq.offer(new Item(matrix[x1][y1], x1, y1));
      }
      int x2 = cur.x + 1;
      int y2 = cur.y;
      if (check(visited, m, n, x2, y2)) {
        visited[x2][y2] = true;
        pq.offer(new Item(matrix[x2][y2], x2, y2));
      }
      k--;
    }
    return cur.val;
  }

  private boolean check(boolean[][] visited, int m, int n, int x, int y) {
    return x >= 0 && x < m && y >= 0 && y < n && !visited[x][y];
  }

  class Item implements Comparable<Item> {
    int val;
    int x;
    int y;

    public Item(int val, int x, int y) {
      this.val = val;
      this.x = x;
      this.y = y;
    }

    @Override
    public int compareTo(Item item) {
      return val - item.val;
    }
  }
}
