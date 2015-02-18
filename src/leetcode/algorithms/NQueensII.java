package leetcode.algorithms;

import java.util.Stack;

// https://oj.leetcode.com/problems/n-queens-ii/
public class NQueensII {
  class Queen {
    int x;
    int y;

    Queen(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public int totalNQueens(int n) {
    int total = 0;
    if (n == 1)
      return 1;
    Stack<Queen> stack = new Stack<>();
    int x = 0;
    int y = 0;
    stack.push(new Queen(x, y));
    x++;
    while (x != 0 || y < n) {
      while (y < n && !check(stack, x, y))
        y++;
      if (y < n) {
        stack.push(new Queen(x, y));
        if (stack.size() == n) {
          total++;
          stack.pop();
          y++;
        } else {
          x++;
          y = 0;
        }
      } else {
        Queen pre = stack.pop();
        x = pre.x;
        y = pre.y + 1;
      }
    }
    return total;
  }

  private boolean check(Stack<Queen> stack, int x, int y) {
    for (Queen q : stack)
      if (q.x == x || q.y == y || Math.abs(q.x - x) == Math.abs(q.y - y))
        return false;
    return true;
  }
}
