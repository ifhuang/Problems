package leetcode;

public class RotateImage
{
	public void rotate(int[][] matrix)
	{
		if (matrix == null || matrix.length < 2)
			return;
		else
		{
			int row = matrix.length;
			int col = matrix[0].length;
			int[][] tmp = new int[row][col];
			for (int i = 0; i < row; i++)
				for (int j = 0; j < col; j++)
					tmp[i][j] = matrix[i][j];
			for (int i = 0; i < row; i++)
				for (int j = 0; j < col; j++)
					matrix[j][col - 1 - i] = tmp[i][j];
		}
	}
}