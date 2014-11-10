package leetcode;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix
{
	public List<Integer> spiralOrder(int[][] matrix)
	{
		List<Integer> list = new LinkedList<>();
		if (matrix == null || matrix.length == 0)
			return list;
		else
		{
			int x = 0;
			int y = 0;
			int m = matrix.length;
			int n = matrix[0].length;
			list.add(matrix[x][y]);
			matrix[x][y] = Integer.MAX_VALUE;
			int state = 0;
			int count = 2;
			int max = m * n;
			while (count <= max)
			{
				if (state == 0)
				{
					int x1 = x;
					int y1 = y + 1;
					if (check(matrix, x1, y1))
					{
						y++;
						list.add(matrix[x][y]);
						matrix[x][y] = Integer.MAX_VALUE;
						count++;
					}
					else
						state = (state + 1) % 4;
				}
				else if (state == 1)
				{
					int x1 = x + 1;
					int y1 = y;
					if (check(matrix, x1, y1))
					{
						x++;
						list.add(matrix[x][y]);
						matrix[x][y] = Integer.MAX_VALUE;
						count++;
					}
					else
						state = (state + 1) % 4;
				}
				else if (state == 2)
				{
					int x1 = x;
					int y1 = y - 1;
					if (check(matrix, x1, y1))
					{
						y--;
						list.add(matrix[x][y]);
						matrix[x][y] = Integer.MAX_VALUE;
						count++;
					}
					else
						state = (state + 1) % 4;
				}
				else if (state == 3)
				{
					int x1 = x - 1;
					int y1 = y;
					if (check(matrix, x1, y1))
					{
						x--;
						list.add(matrix[x][y]);
						matrix[x][y] = Integer.MAX_VALUE;
						count++;
					}
					else
						state = (state + 1) % 4;
				}
			}
			return list;
		}
	}

	private boolean check(int[][] result, int x, int y)
	{
		int m = result.length;
		int n = result[0].length;
		if (x >= m || y >= n || x < 0 || y < 0)
			return false;
		else if (result[x][y] == Integer.MAX_VALUE)
			return false;
		else
			return true;
	}

	public static void main(String[] args)
	{
		SpiralMatrix solution = new SpiralMatrix();
		int[][] a = new int[1][2];
		a[0][0] = 1;
		a[0][1] = 2;
		System.out.println(solution.spiralOrder(a));
	}
}