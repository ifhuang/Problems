package codejam;

import java.util.Scanner;

public class CubeIV
{
	static int S;
	static int[][] maze;
	static int r;
	static int d;
	static int now;
	static int x;
	static int y;
	static int tmpD;

	static void solve()
	{
		for (int i = 0; i < S; i++)
			for (int j = 0; j < S; j++)
			{
				now = maze[i][j];
				x = i;
				y = j;
				tmpD = 1;
				while (move())
					tmpD++;
				if (tmpD > d)
				{
					d = tmpD;
					r = maze[i][j];
				}
				else if (tmpD == d)
				{
					r = Math.min(r, maze[i][j]);
				}
			}
	}

	static boolean move()
	{
		if (x < S - 1)
		{
			int t = x + 1;
			if (maze[t][y] == now + 1)
			{
				x = t;
				now++;
				return true;
			}
		}
		// else
		// {
		// int t = 0;
		// if (maze[t][y] == now + 1)
		// {
		// x = t;
		// now++;
		// return true;
		// }
		// }

		if (y < S - 1)
		{
			int t = y + 1;
			if (maze[x][t] == now + 1)
			{
				y = t;
				now++;
				return true;
			}
		}
		// else
		// {
		// int t = 0;
		// if (maze[x][t] == now + 1)
		// {
		// y = t;
		// now++;
		// return true;
		// }
		// }

		if (x > 0)
		{
			int t = x - 1;
			if (maze[t][y] == now + 1)
			{
				x = t;
				now++;
				return true;
			}
		}
		// else
		// {
		// int t = S - 1;
		// if (maze[t][y] == now + 1)
		// {
		// x = t;
		// now++;
		// return true;
		// }
		// }

		if (y > 0)
		{
			int t = y - 1;
			if (maze[x][t] == now + 1)
			{
				y = t;
				now++;
				return true;
			}
		}
		// else
		// {
		// int t = S - 1;
		// if (maze[x][t] == now + 1)
		// {
		// y = t;
		// now++;
		// return true;
		// }
		// }

		return false;
	}

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		int k = 1;
		while (T-- > 0)
		{
			S = scanner.nextInt();
			maze = new int[S][S];
			for (int i = 0; i < S; i++)
				for (int j = 0; j < S; j++)
					maze[i][j] = scanner.nextInt();
			r = 0;
			d = 0;
			solve();
			System.out.println(String.format("Case #%d: %d %d", k++, r, d));
		}
		scanner.close();
	}
}
