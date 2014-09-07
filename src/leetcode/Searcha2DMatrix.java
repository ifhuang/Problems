package leetcode;

public class Searcha2DMatrix
{
	public boolean searchMatrix(int[][] matrix, int target)
	{
		if (matrix == null)
			return false;
		int m = matrix.length;
		if (m == 0)
			return false;
		if (matrix[0] == null)
			return false;
		int n = matrix[0].length;
		if (n == 0)
			return false;
		int low = 0;
		int high = m * n - 1;
		while (low <= high)
		{
			int mid = low + (high - low) / 2;
			int row = mid / n;
			int col = mid % n;
			if (matrix[row][col] == target)
			{
				return true;
			}
			else if (matrix[row][col] > target)
			{
				high = mid - 1;
			}
			else
			{
				low = mid + 1;
			}
		}
		return false;
	}
}
