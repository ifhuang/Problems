package leetcode;

import java.util.Arrays;

public class MaximumSubarray
{
	public int maxSubArray(int[] A)
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

	public static void main(String[] args)
	{
		MaximumSubarray s = new MaximumSubarray();
		System.out.println(s.maxSubArray(new int[] { -1, 0, -2 }));
	}
}
