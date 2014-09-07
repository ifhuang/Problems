package leetcode;

import java.util.Arrays;

public class SearchInsertPosition
{
	public int searchInsert(int[] A, int target)
	{
		if (A == null || A.length == 0)
			return 0;
		int index = Arrays.binarySearch(A, target);
		if (index < 0)
		{
			return -index - 1;
		}
		else
		{
			return index;
		}
	}
}
