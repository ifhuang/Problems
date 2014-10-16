package leetcode;

public class FindMinimuminRotatedSortedArray
{
	public int findMin(int[] num)
	{
		if (num == null || num.length < 1)
			return 0;
		if (num.length == 1)
			return num[0];
		if (num.length == 2)
			return Math.min(num[0], num[1]);
		int low = 0;
		int high = num.length - 1;
		if (num[low] < num[high])
			return num[low];
		while (low + 1 != high)
		{
			int mid = (low + high) >>> 1;
			if (num[mid] > num[low])
				low = mid;
			else if (num[mid] < num[high])
				high = mid;
		}
		return num[high];
	}
}