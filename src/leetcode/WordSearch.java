package leetcode;

import java.util.Stack;

public class WordSearch
{
	class Three
	{
		int x;
		int y;
		int z;

		public Three(int x1, int y1, int z1)
		{
			x = x1;
			y = y1;
			z = z1;
		}
	}

	public boolean exist(char[][] board, String word)
	{
		if (board == null)
			return false;
		int x = board.length;
		if (x == 0)
			return false;
		int y = board[0].length;
		if (y == 0)
			return false;

		Stack<Three> stack = new Stack<>();
		for (int i = 0; i < x; i++)
			for (int j = 0; j < y; j++)
				if (board[i][j] == word.charAt(0))
				{
					if (word.length() == 1)
						return true;
					stack.push(new Three(i, j, 0));
					boolean ans = check(stack, i, j, x, y, word, board);
					if (ans)
						return true;
				}
		return false;
	}

	private boolean check(Stack<Three> stack, int i, int j, int x, int y,
			String word, char[][] board)
	{
		int[][] d = new int[4][2];
		d[0][0] = 1;
		d[1][0] = -1;
		d[2][1] = 1;
		d[3][1] = -1;
		int index = 1;
		boolean[][] used = new boolean[x][y];
		used[i][j] = true;
		while (!stack.isEmpty())
		{
			if (stack.peek().z > 3)
			{
				Three three = stack.pop();
				used[three.x][three.y] = false;
				if (stack.isEmpty())
					break;
				i = stack.peek().x;
				j = stack.peek().y;
				stack.peek().z++;
				index--;
				continue;
			}
			int i1 = i + d[stack.peek().z][0];
			int j1 = j + d[stack.peek().z][1];
			if (i1 < 0 || i1 >= x || j1 < 0 || j1 >= y || used[i1][j1])
			{
				stack.peek().z++;
				continue;
			}
			if (word.charAt(index) == board[i1][j1])
			{
				index++;
				if (index == word.length())
					return true;
				i = i1;
				j = j1;
				used[i][j] = true;
				stack.push(new Three(i, j, 0));
			}
			else
			{
				stack.peek().z++;
			}
		}
		return false;
	}

	public static void main(String[] args)
	{
		WordSearch solution = new WordSearch();
		char[][] board = new char[3][3];
		board[0][0] = 'c';
		board[0][1] = 'a';
		board[0][2] = 'a';
		board[1][0] = 'a';
		board[1][1] = 'a';
		board[1][2] = 'a';
		board[2][0] = 'b';
		board[2][1] = 'c';
		board[2][2] = 'd';
		String word = "aab";
		boolean ans = solution.exist(board, word);
		System.out.println("" + ans);
	}
}