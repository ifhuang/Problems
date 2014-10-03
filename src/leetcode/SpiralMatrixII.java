package leetcode;

public class SpiralMatrixII
{
	public int[][] generateMatrix(int n)
	{
		int[][] result = new int[n][n];
		if (n < 1)
			return result;
		else if (n == 1)
		{
			result[0][0] = 1;
			return result;
		}
		else
		{
			int x = 0;
			int y = 0;
			result[x][y] = 1;
			int state = 0;
			int count = 2;
			int max = n * n;
			while (count <= max)
			{
				if (state == 0)
				{
					int x1 = x;
					int y1 = y + 1;
					if (check(result, x1, y1))
					{
						y++;
						result[x][y] = count;
						count++;
					}
					else
						state = (state + 1) % 4;
				}
				else if (state == 1)
				{
					int x1 = x + 1;
					int y1 = y;
					if (check(result, x1, y1))
					{
						x++;
						result[x][y] = count;
						count++;
					}
					else
						state = (state + 1) % 4;
				}
				else if (state == 2)
				{
					int x1 = x;
					int y1 = y - 1;
					if (check(result, x1, y1))
					{
						y--;
						result[x][y] = count;
						count++;
					}
					else
						state = (state + 1) % 4;
				}
				else if (state == 3)
				{
					int x1 = x - 1;
					int y1 = y;
					if (check(result, x1, y1))
					{
						x--;
						result[x][y] = count;
						count++;
					}
					else
						state = (state + 1) % 4;
				}
			}
			return result;
		}
	}

	private boolean check(int[][] result, int x, int y)
	{
		int n = result.length;
		if (x >= n || y >= n || x < 0 || y < 0)
			return false;
		else if (result[x][y] != 0)
			return false;
		else
			return true;
	}
}