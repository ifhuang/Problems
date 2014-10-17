package leetcode;

public class UniquePathsII
{
	public int uniquePathsWithObstacles(int[][] obstacleGrid)
	{
		if (obstacleGrid == null)
			return 0;
		int x = obstacleGrid.length;
		if (x == 0)
			return 0;
		int y = obstacleGrid[0].length;
		if (y == 0)
			return 0;
		if (obstacleGrid[0][0] == 1 || obstacleGrid[x - 1][y - 1] == 1)
			return 0;

		obstacleGrid[0][0] = 1 - obstacleGrid[0][0];
		for (int i = 1; i < y; i++)
			if (obstacleGrid[0][i - 1] == 0)
				obstacleGrid[0][i] = 0;
			else
				obstacleGrid[0][i] = 1 - obstacleGrid[0][i];
		for (int i = 1; i < x; i++)
			if (obstacleGrid[i - 1][0] == 0)
				obstacleGrid[i][0] = 0;
			else
				obstacleGrid[i][0] = 1 - obstacleGrid[i][0];
		for (int i = 1; i < x; i++)
			for (int j = 1; j < y; j++)
				if (obstacleGrid[i][j] == 1)
					obstacleGrid[i][j] = 0;
				else
					obstacleGrid[i][j] = obstacleGrid[i - 1][j]
							+ obstacleGrid[i][j - 1];
		return obstacleGrid[x - 1][y - 1];
	}
}