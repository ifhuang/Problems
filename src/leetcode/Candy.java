package leetcode;

public class Candy
{
	public int candy(int[] ratings)
	{
		if (ratings == null)
			return 0;
		if (ratings.length == 1)
			return 1;
		if (ratings.length == 2 && ratings[0] == ratings[1])
			return 2;
		if (ratings.length == 2 && ratings[0] != ratings[1])
			return 3;

		int[] candy = new int[ratings.length];
		int i = 0;
		int asc = 0;
		int desc = 0;
		int start = 0;
		while (i < ratings.length - 1)
		{
			if (ratings[i] < ratings[i + 1])
			{
				if (desc == 0)
					;
				else
				{
					candy[i] = 1;
					for (int j = i - 1; j >= start; j--)
						candy[j] = ratings[j] == ratings[j + 1] ? 1
								: candy[j + 1] + 1;
					if (start > 0 && candy[start - 1] <= candy[start])
						candy[start - 1] = candy[start] + 1;
					start = i + 1;
					desc = 0;
				}
				asc = 1;
			}
			else if (ratings[i] > ratings[i + 1])
			{
				if (asc == 0)
					;
				else
				{
					if (start == 0)
						candy[start] = 1;
					else
						candy[start] = candy[start - 1] + 1;
					for (int j = start + 1; j < i; j++)
						candy[j] = ratings[j] == ratings[j - 1] ? 1
								: candy[j - 1] + 1;
					candy[i] = ratings[i] == ratings[i - 1] ? 2
							: candy[i - 1] + 1;
					start = i + 1;
					asc = 0;
				}
				desc = 1;
			}
			else
				;
			i++;
		}
		if (asc == 1)
		{
			if (start == 0)
				candy[start] = 1;
			else
				candy[start] = candy[start - 1] + 1;
			for (int j = start + 1; j <= i; j++)
				candy[j] = ratings[j] == ratings[j - 1] ? 1 : candy[j - 1] + 1;
		}
		else if (desc == 1)
		{
			candy[i] = 1;
			for (int j = i - 1; j >= start; j--)
				candy[j] = ratings[j] == ratings[j + 1] ? 1 : candy[j + 1] + 1;
			if (start > 0 && candy[start - 1] <= candy[start])
				candy[start - 1] = candy[start] + 1;
		}
		else if (asc == 0 && desc == 0)
		{
			int count = 1;
			for (int j = i; j >= start; j--)
				candy[j] = count;
		}

		int totalCandy = 0;
		for (int j = 0; j < candy.length; j++)
			totalCandy += candy[j];
		return totalCandy;
	}

	public static void main(String[] args)
	{
		Candy solution = new Candy();
		int[] ratings = new int[] { 1, 3, 4, 3, 2, 1 };
		System.out.println("" + solution.candy(ratings));
	}
}