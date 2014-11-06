package leetcode;

import java.util.Stack;

public class NQueensII
{
	class Pair
	{
		int x;
		int y;

		Pair(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
	}

	public int totalNQueens(int n)
	{
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		int count = 0;
		int[][] check = new int[n][n];
		int x = 0;
		int y = 0;
		check[x][y] = 1;
		Pair pair = new Pair(x, y);
		Stack<Pair> stack = new Stack<>();
		stack.push(pair);
		x++;
		while (true)
		{
			if (y == n)
			{
				if (x == 0)
					break;
				pair = stack.pop();
				x = pair.x;
				y = pair.y;
				check[x][y] = 0;
			}
			else if (check(check, x, y))
			{
				if (x == n - 1)
					count++;
				else
				{
					check[x][y] = 1;
					pair = new Pair(x, y);
					stack.push(pair);
					x++;
					y = -1;
				}
			}
			y++;
		}
		return count;
	}

	private boolean check(int[][] check, int x, int y)
	{
		for (int i = 1; i <= x; i++)
			if (check[x - i][y] == 1)
				return false;
			else if (y - i >= 0 && check[x - i][y - i] == 1)
				return false;
			else if (y + i < check.length && check[x - i][y + i] == 1)
				return false;
		return true;
	}

	public static void main(String[] args)
	{
		NQueensII solution = new NQueensII();
		System.out.println("" + solution.totalNQueens(5));
	}
}