package leetcode;

import java.util.Arrays;

public class NextPermutation
{
	public void nextPermutation(int[] num)
	{
		if (num == null || num.length < 2)
			return;
		int i = num.length - 1;
		for (; i > 0; i--)
		{
			if (num[i] > num[i - 1])
				break;
		}
		if (i == 0)
		{
			Arrays.sort(num);
			return;
		}
		int a = i - 1;
		int min = num[i];
		int minIndex = i;
		for (; i < num.length; i++)
		{
			if (num[i] < min && num[i] > num[a])
			{
				min = num[i];
				minIndex = i;
			}
		}
		int tmp = num[a];
		num[a] = num[minIndex];
		num[minIndex] = tmp;
		Arrays.sort(num, a + 1, num.length);
	}
}
