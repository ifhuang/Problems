package leetcode;

import java.util.HashSet;
import java.util.Stack;

import leetcode.util.Pair;

public class SudokuSolver
{
	public void solveSudoku(char[][] board)
	{
		Stack<Pair> stack = new Stack<>();
		int flag = 0;
		char old = '1';
		for (int row = 0; row < 9; row++)
			for (int col = 0; col < 9; col++)
			{
				if (board[row][col] == '.')
				{
					char c = '1';
					if (flag == 1)
					{
						c = old;
						flag = 0;
					}
					for (; c <= '9'; c++)
					{
						board[row][col] = c;
						if (check(board, row, col))
							break;
					}
					if (c <= '9')
					{
						stack.push(new Pair(row, col, c));
					}
					else
					{
						board[row][col] = '.';
						Pair pair = stack.pop();
						row = pair.x;
						col = pair.y;
						old = pair.c;
						while (old == '9')
						{
							board[row][col] = '.';
							pair = stack.pop();
							row = pair.x;
							col = pair.y;
							old = pair.c;
						}
						board[row][col] = '.';
						old++;
						if (col == 0)
						{
							col = 9;
							row--;
						}
						else
						{
							col--;
						}
						flag = 1;
					}
				}
			}
	}

	private boolean check(char[][] board, int row, int col)
	{
		HashSet<Character> set = new HashSet<>();
		for (int colindex = 0; colindex < 9; colindex++)
		{
			if (board[row][colindex] != '.')
				if (!set.add(board[row][colindex]))
					return false;
		}
		set.clear();

		for (int rowindex = 0; rowindex < 9; rowindex++)
		{
			if (board[rowindex][col] != '.')
				if (!set.add(board[rowindex][col]))
					return false;
		}
		set.clear();

		for (int rowindex = row / 3 * 3; rowindex < row / 3 * 3 + 3; rowindex++)
			for (int colindex = col / 3 * 3; colindex < col / 3 * 3 + 3; colindex++)
				if (board[rowindex][colindex] != '.')
					if (!set.add(board[rowindex][colindex]))
						return false;
		return true;
	}
}
