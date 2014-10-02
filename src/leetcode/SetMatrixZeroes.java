package leetcode;

public class SetMatrixZeroes
{
	public void setZeroes(int[][] matrix)
	{
		if (matrix == null || matrix.length < 1)
			return;
		else
		{
			int row = matrix.length;
			int[] stubR = new int[row];
			int col = matrix[0].length;
			int[] stubC = new int[col];
			for (int i = 0; i < row; i++)
				for (int j = 0; j < col; j++)
					if (matrix[i][j] == 0)
					{
						stubR[i] = 1;
						stubC[j] = 1;
					}
			for (int k = 0; k < row; k++)
				if (stubR[k] == 1)
					for (int j = 0; j < col; j++)
						matrix[k][j] = 0;
			for (int k = 0; k < col; k++)
				if (stubC[k] == 1)
					for (int i = 0; i < row; i++)
						matrix[i][k] = 0;
		}
	}
}