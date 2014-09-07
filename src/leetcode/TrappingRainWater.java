package leetcode;

public class TrappingRainWater
{
	public int trap(int[] A)
	{
		if (A == null || A.length < 3)
			return 0;
		int result = 0;

		int[] lmax = new int[A.length];
		lmax[0] = A[0];
		for (int i = 1; i < A.length; i++)
		{
			if (A[i] > lmax[i - 1])
				lmax[i] = A[i];
			else
				lmax[i] = lmax[i - 1];
		}

		int[] rmax = new int[A.length];
		rmax[A.length - 1] = A[A.length - 1];
		for (int i = A.length - 2; i >= 0; i--)
		{
			if (A[i] > rmax[i + 1])
				rmax[i] = A[i];
			else
				rmax[i] = rmax[i + 1];
		}

		for (int i = 1; i < A.length - 1; i++)
		{
			int min = Math.min(lmax[i], rmax[i]);
			if (min > A[i])
				result += min - A[i];
		}

		return result;
	}
}
