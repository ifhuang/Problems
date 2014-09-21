package leetcode;

import java.util.Arrays;

public class SearchinRotatedSortedArrayII
{
	public boolean search(int[] A, int target)
	{
		if (A == null || A.length == 0)
			return false;
		if (A.length == 1)
			return A[0] == target ? true : false;
		int i = 0;
		for (; i < A.length - 1; i++)
			if (A[i] > A[i + 1])
				break;
		if (A[0] == target)
			return true;
		else if (A[0] < target)
			return Arrays.binarySearch(A, 0, i + 1, target) >= 0 ? true : false;
		else if (A[A.length - 1] == target)
			return true;
		else if (A[A.length - 1] > target)
			return Arrays.binarySearch(A, i + 1, A.length, target) >= 0 ? true
					: false;
		return false;
	}

	public static void main(String[] args)
	{
		SearchinRotatedSortedArrayII s = new SearchinRotatedSortedArrayII();
		System.out.println(s.search(new int[] { 5, 1, 3 }, 1));
	}
}
