package leetcode;

import java.util.Stack;

public class SurroundedRegions
{
	class Pair
	{
		int x;
		int y;

		public Pair(int x1, int y1)
		{
			x = x1;
			y = y1;
		}
	}

	public void solve(char[][] board)
	{
		if (board == null)
			return;
		int x = board.length;
		if (x < 2)
			return;
		int y = board[0].length;
		if (y < 2)
			return;

		Stack<Pair> stack = new Stack<>();
		for (int i = 0; i < x; i++)
			for (int j = 0; j < y; j++)
				if (board[i][j] == 'O'
						&& (i == 0 || i == x - 1 || j == 0 || j == y - 1))
				{
					board[i][j] = '+';
					if (i > 0)
						stack.push(new Pair(i - 1, j));
					if (i < x - 1)
						stack.push(new Pair(i + 1, j));
					if (j > 0)
						stack.push(new Pair(i, j - 1));
					if (j < y - 1)
						stack.push(new Pair(i, j + 1));
					while (!stack.isEmpty())
					{
						Pair pair = stack.pop();
						if (board[pair.x][pair.y] != 'O')
							continue;
						board[pair.x][pair.y] = '+';
						if (pair.x > 0)
							stack.push(new Pair(pair.x - 1, pair.y));
						if (pair.x < x - 1)
							stack.push(new Pair(pair.x + 1, pair.y));
						if (pair.y > 0)
							stack.push(new Pair(pair.x, pair.y - 1));
						if (pair.y < y - 1)
							stack.push(new Pair(pair.x, pair.y + 1));
					}
				}

		for (int i = 0; i < x; i++)
			for (int j = 0; j < y; j++)
				if (board[i][j] == 'O')
					board[i][j] = 'X';
				else if (board[i][j] == '+')
					board[i][j] = 'O';
	}

	public static void main(String[] args)
	{
		SurroundedRegions solution = new SurroundedRegions();
		char[][] board = new char[3][3];
		board[0][0] = 'X';
		board[0][1] = 'X';
		board[0][2] = 'X';
		board[1][0] = 'X';
		board[1][1] = 'O';
		board[1][2] = 'X';
		board[2][0] = 'O';
		board[2][1] = 'X';
		board[2][2] = 'X';
		solution.solve(board);
		System.out.println();
	}

}