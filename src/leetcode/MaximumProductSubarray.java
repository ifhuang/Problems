package leetcode;

import java.util.Arrays;

public class MaximumProductSubarray
{
	public int maxProduct(int[] A)
	{
		if (A == null || A.length == 0)
			return 0;
		else if (A.length == 1)
			return A[0];
		else
		{
			int length = A.length;
			int low = 0;
			for (; low < length; low++)
				if (A[low] != 0)
					break;
			if (low == length)
				return 0;
			int max = 0;
			int high = low + 1;
			for (; high < length;)
				if (A[high] != 0)
					high++;
				else
				{
					max = Math.max(max, maxP(Arrays.copyOfRange(A, low, high)));
					max = Math.max(max,
							maxProduct(Arrays.copyOfRange(A, high, A.length)));
					break;
				}
			return Math.max(max, maxP(Arrays.copyOfRange(A, low, high)));
		}
	}

	private int maxP(int[] A)
	{
		if (A == null || A.length == 0)
			return 0;
		else if (A.length == 1)
			return A[0];
		else
		{
			int product = 1;
			for (int i = 0; i < A.length; i++)
				product *= A[i];
			if (product > 0)
				return product;
			else
			{
				int i = 0;
				for (; i < A.length; i++)
					if (A[i] < 0)
						break;
				int j = A.length - 1;
				for (; j >= 0; j--)
					if (A[j] < 0)
						break;
				if (i == A.length)
					return maxP(Arrays.copyOfRange(A, 0, j));
				else if (j == 0)
					return maxP(Arrays.copyOfRange(A, i + 1, A.length));
				else
					return Math.max(
							maxP(Arrays.copyOfRange(A, i + 1, A.length)),
							maxP(Arrays.copyOfRange(A, 0, j)));
			}
		}
	}

	public static void main(String[] args)
	{
		MaximumProductSubarray solution = new MaximumProductSubarray();
		System.out.println("" + solution.maxProduct(new int[] { -4, -3, -2 }));
	}
}