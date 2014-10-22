package leetcode;

public class FindMinimuminRotatedSortedArrayII
{
	public int findMin(int[] num)
	{
		if (num == null)
			return 0;
		int min = num[0];
		for (int i = 1; i < num.length; i++)
			min = min > num[i] ? num[i] : min;
		return min;
	}
}