package leetcode;

import java.util.Arrays;

public class BestTimetoBuyandSellStock
{
	public int maxProfit(int[] prices)
	{
		if (prices == null || prices.length < 2)
			return 0;
		int[] growth = new int[prices.length];
		growth[0] = 0;
		for (int i = 1; i < growth.length; i++)
		{
			growth[i] = prices[i] - prices[i - 1];
		}
		return maxSubArray(growth);
	}

	private int maxSubArray(int[] A)
	{
		int high = A.length;
		if (high == 1)
		{
			return A[0];
		}
		else if (high == 2)
		{
			return Math.max(Math.max(A[0], A[1]), A[0] + A[1]);
		}
		int mid = high / 2;

		int maxLeft = maxSubArray(Arrays.copyOfRange(A, 0, mid));

		int maxRight = maxSubArray(Arrays.copyOfRange(A, mid + 1, high));

		int maxSumLeft = Integer.MIN_VALUE;
		int sumLeft = 0;
		for (int i = mid; i >= 0; i--)
		{
			sumLeft += A[i];
			if (sumLeft > maxSumLeft)
				maxSumLeft = sumLeft;
		}
		int maxSumRight = Integer.MIN_VALUE;
		int sumRight = 0;
		for (int i = mid; i < high; i++)
		{
			sumRight += A[i];
			if (sumRight > maxSumRight)
				maxSumRight = sumRight;
		}
		int maxMid = maxSumLeft + maxSumRight - A[mid];
		return Math.max(Math.max(maxLeft, maxRight), maxMid);
	}
}
