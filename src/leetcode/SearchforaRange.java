package leetcode;

import java.util.Arrays;

public class SearchforaRange
{
	public int[] searchRange(int[] A, int target)
	{
		if (A == null || A.length == 0)
			return new int[] { -1, -1 };
		int index = Arrays.binarySearch(A, target);
		if (index < 0)
		{
			return new int[] { -1, -1 };
		}
		else
		{
			int i = index + 1;
			for (; i < A.length; i++)
			{
				if (A[i] != target)
					break;
			}
			int j = index - 1;
			for (; j > -1; j--)
			{
				if (A[j] != target)
					break;
			}
			return new int[] { j + 1, i - 1 };
		}
	}
}
