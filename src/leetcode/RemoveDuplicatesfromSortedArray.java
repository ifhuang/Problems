package leetcode;

public class RemoveDuplicatesfromSortedArray
{
	public int removeDuplicates(int[] A)
	{
		if (A == null || A.length == 0)
			return 0;
		int count = 1;
		int now = A[0];
		for (int i = 1; i < A.length; i++)
		{
			if (A[i] > now)
			{
				A[count] = A[i];
				now = A[count];
				count++;
			}
		}
		return count;
	}
}
