package leetcode;

import java.util.Arrays;

// https://oj.leetcode.com/problems/3sum-closest/
public class ThreeSumClosest
{
	public int threeSumClosest(int[] num, int target)
	{
		Arrays.sort(num);
		int diff = Integer.MAX_VALUE;
		int ans = 0;
		for (int i = 0; i < num.length - 2; i++)
			for (int j = i + 1, k = num.length - 1; j < k;)
			{
				int sum = num[i] + num[j] + num[k];
				if (sum == target)
					return target;
				else if (sum > target)
				{
					if (sum - target < diff)
					{
						diff = sum - target;
						ans = sum;
					}
					k--;
				}
				else
				{
					if (target - sum < diff)
					{
						diff = target - sum;
						ans = sum;
					}
					j++;
				}
			}
		return ans;
	}
}
