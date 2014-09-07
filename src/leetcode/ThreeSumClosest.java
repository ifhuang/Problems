package leetcode;

import java.util.Arrays;

public class ThreeSumClosest
{
	public int threeSumClosest(int[] num, int target)
	{
		if (num.length == 3)
			return num[0] + num[1] + num[2];
		Arrays.sort(num);
		int result = num[0] + num[1] + num[2];
		for (int i = 0; i < num.length - 2; i++)
		{
			int low = i + 1;
			int high = num.length - 1;
			while (low < high)
			{
				int sum = num[i] + num[low] + num[high];
				if (sum == target)
				{
					return sum;
				}
				else if (sum < target)
				{
					result = closer(result, sum, target);
					low++;
				}
				else
				{
					result = closer(result, sum, target);
					high--;
				}
			}
		}
		return result;
	}

	private int closer(int result, int sum, int target)
	{
		if (result == sum)
			return result;
		else
		{
			if (Math.abs(result - target) > Math.abs(sum - target))
			{
				return sum;
			}
			else
			{
				return result;
			}
		}
	}
}
