package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NQueens
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

	public List<String[]> solveNQueens(int n)
	{
		List<String[]> list = new ArrayList<>();
		if (n == 0)
			return list;
		if (n == 1)
		{
			String[] s = new String[1];
			s[0] = "Q";
			list.add(s);
			return list;
		}
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
				{
					check[x][y] = 1;
					String[] s = new String[n];
					for (int i = 0; i < n; i++)
					{
						StringBuilder sb = new StringBuilder();
						for (int j = 0; j < n; j++)
							if (check[i][j] == 1)
								sb.append("Q");
							else
								sb.append(".");
						s[i] = sb.toString();
					}
					list.add(s);
					check[x][y] = 0;
				}
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
		return list;
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
		NQueens solution = new NQueens();
		System.out.println(solution.solveNQueens(4));
	}
}