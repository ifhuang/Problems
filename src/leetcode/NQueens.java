package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://oj.leetcode.com/problems/n-queens/
public class NQueens {
	class Queen {
		int x;
		int y;

		Queen(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public List<String[]> solveNQueens(int n) {
		List<String[]> ans = new ArrayList<>();
		if (n == 1) {
			String[] s = new String[1];
			s[0] = "Q";
			ans.add(s);
			return ans;
		}
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
				if (finished(stack, n, ans)) {
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
		return ans;
	}

	private boolean check(Stack<Queen> stack, int x, int y) {
		for (Queen q : stack)
			if (q.x == x || q.y == y || Math.abs(q.x - x) == Math.abs(q.y - y))
				return false;
		return true;
	}

	private boolean finished(Stack<Queen> stack, int n, List<String[]> ans) {
		if (stack.size() < n)
			return false;
		String[] strs = new String[n];
		for (int i = 0; i < n; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < n; j++)
				if (j == stack.get(i).y)
					sb.append('Q');
				else
					sb.append('.');
			strs[i] = sb.toString();
		}
		ans.add(strs);
		return true;
	}
}
