package leetcode;

import java.util.Arrays;

public class LongestConsecutiveSequence
{
	public int longestConsecutive(int[] num)
	{
		if (num == null || num.length == 0)
			return 0;
		if (num.length == 1)
			return 1;
		Arrays.sort(num);
		int max = 1;
		int count = 1;
		for (int i = 1; i < num.length; i++)
			if (num[i] == num[i - 1])
				;
			else if (num[i] == num[i - 1] + 1)
				count++;
			else
			{
				max = max > count ? max : count;
				count = 1;
			}
		max = max > count ? max : count;
		return max;
	}

	public static void main(String[] args)
	{
		LongestConsecutiveSequence solution = new LongestConsecutiveSequence();
		int[] num = new int[] { 1, 2, 0, 1 };
		System.out.println("" + solution.longestConsecutive(num));
	}
}