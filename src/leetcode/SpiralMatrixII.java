package leetcode;

// https://oj.leetcode.com/problems/spiral-matrix-ii/
public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
		int[][] ans = new int[n][n];
		if (n == 0)
			return ans;
		int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		int x = 0;
		int y = 0;
		int s = 0;
		ans[x][y] = 1;
		for (int i = 2; i <= n * n; i++) {
			if (!check(ans, x, y, d[s][0], d[s][1]))
				s = (s + 1) % 4;
			x += d[s][0];
			y += d[s][1];
			ans[x][y] = i;
		}
		return ans;
	}

	private boolean check(int[][] matrix, int x, int y, int a, int b) {
		int n = matrix.length;
		int newX = x + a;
		int newY = y + b;
		return newX >= 0 && newX < n && newY >= 0 && newY < n
				&& matrix[newX][newY] == 0;
	}
}