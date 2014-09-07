package leetcode;

public class RemoveElement
{
	public int removeElement(int[] A, int elem)
	{
		if (A == null || A.length == 0)
			return 0;
		int count = 0;
		for (int i = 0; i < A.length; i++)
		{
			if (A[i] != elem)
			{
				A[count] = A[i];
				count++;
			}
		}
		return count;
	}
}
