package leetcode;

public class SortColors
{
	public void sortColors(int[] A)
	{
		if (A == null || A.length < 2)
			return;
		int[] count = new int[3];
		for (int i = 0; i < A.length; i++)
		{
			count[A[i]]++;
		}
		for (int i = 0; i < A.length; i++)
		{
			if (i < count[0])
				A[i] = 0;
			else if (i < count[0] + count[1])
				A[i] = 1;
			else
				A[i] = 2;
		}
	}
}
