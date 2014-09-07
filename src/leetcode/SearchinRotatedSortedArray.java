package leetcode;

import java.util.Arrays;

public class SearchinRotatedSortedArray
{
	public int search(int[] A, int target)
	{
		if (A == null || A.length == 0)
			return -1;
		if (A.length == 1)
		{
			if (A[0] == target)
				return 0;
			return -1;
		}
		if (A.length == 2)
		{
			if (A[0] == target)
				return 0;
			if (A[1] == target)
				return 1;
			return -1;
		}

		int left = 0;
		int right = A.length - 1;
		if (target == A[left])
			return left;
		if (target == A[right])
			return right;
		if (A[left] < A[right])
		{
			int index = Arrays.binarySearch(A, target);
			if (index >= 0)
				return index;
			else
				return -1;
		}

		int pivot;
		while (true)
		{
			int mid = left + (right - left) / 2;
			if (A[left] <= A[mid])
			{
				if (mid == A.length - 1)
				{
					pivot = mid;
					break;
				}
				if (A[mid] > A[mid + 1])
				{
					pivot = mid;
					break;
				}
				left = mid + 1;
			}
			else
			{
				if (mid == 0)
				{
					pivot = mid;
					break;
				}
				if (A[mid] < A[mid - 1])
				{
					pivot = mid - 1;
					break;
				}
				right = mid - 1;
			}
		}
		if (target > A[0])
		{
			int index = Arrays.binarySearch(A, 0, pivot + 1, target);
			if (index >= 0)
				return index;
			else
				return -1;
		}
		else
		{
			int index = Arrays.binarySearch(A, pivot + 1, A.length, target);
			if (index >= 0)
				return index;
			else
				return -1;
		}
	}
}
