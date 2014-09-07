package leetcode;

public class FirstMissingPositive
{
	public int firstMissingPositive(int[] A)
	{
		if (A == null || A.length == 0)
			return 1;
		int i = 0;
		while (i < A.length)
		{
			if (A[i] > 0 && A[i] <= A.length && A[i] != i + 1
					&& A[A[i] - 1] != A[i])
			{
				int tmp = A[i];
				A[i] = A[A[i] - 1];
				A[tmp - 1] = tmp;
			}
			else
			{
				i++;
			}
		}
		for (int j = 0; j < A.length; j++)
		{
			if (A[j] != j + 1)
			{
				return j + 1;
			}
		}
		return A.length + 1;
	}
}
