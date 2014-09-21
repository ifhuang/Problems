package leetcode;

import java.util.List;

public class Triangle
{
	public int minimumTotal(List<List<Integer>> triangle)
	{
		if (triangle == null)
			return 0;
		else if (triangle.size() == 0)
			return 0;
		else if (triangle.size() == 1)
			return triangle.get(0).get(0);
		else
		{
			int length = triangle.size();
			int[][] result = new int[length][length];
			result[0][0] = triangle.get(0).get(0);
			for (int i = 1; i < length; i++)
			{
				result[i][0] = result[i - 1][0] + triangle.get(i).get(0);
				for (int j = 1; j < i; j++)
				{
					result[i][j] = smaller(result[i - 1][j],
							result[i - 1][j - 1]) + triangle.get(i).get(j);
				}
				result[i][i] = result[i - 1][i - 1] + triangle.get(i).get(i);
			}
			return smallest(result[length - 1]);
		}
	}

	private int smaller(int i1, int i2)
	{
		return i1 < i2 ? i1 : i2;
	}

	private int smallest(int[] a)
	{
		int min = a[0];
		for (int i = 1; i < a.length; i++)
		{
			if (a[i] < min)
				min = a[i];
		}
		return min;
	}
}
