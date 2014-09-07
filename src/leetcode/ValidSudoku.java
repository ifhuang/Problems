package leetcode;

import java.util.HashSet;

public class ValidSudoku
{
	public boolean isValidSudoku(char[][] board)
	{
		for (int row = 0; row < 9; row++)
		{
			HashSet<Character> set = new HashSet<>();
			for (int col = 0; col < 9; col++)
			{
				if (board[row][col] != '.')
					if (!set.add(board[row][col]))
						return false;
			}
		}

		for (int col = 0; col < 9; col++)
		{
			HashSet<Character> set = new HashSet<>();
			for (int row = 0; row < 9; row++)
			{
				if (board[row][col] != '.')
					if (!set.add(board[row][col]))
						return false;
			}
		}

		for (int sub = 0; sub < 9; sub++)
		{
			HashSet<Character> set = new HashSet<>();
			int x = sub % 3;
			int y = sub / 3;
			for (int row = y * 3; row < y * 3 + 3; row++)
				for (int col = x * 3; col < x * 3 + 3; col++)
				{
					if (board[row][col] != '.')
						if (!set.add(board[row][col]))
							return false;
				}
		}
		return true;
	}
}
