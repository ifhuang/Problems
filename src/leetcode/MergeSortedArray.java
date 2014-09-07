package leetcode;

public class MergeSortedArray
{
	public void merge(int A[], int m, int B[], int n)
	{
		if (m == 0)
		{
			for (int i = 0; i < n; i++)
			{
				A[i] = B[i];
			}
		}
		if (n == 0)
		{
			return;
		}
		for (int i = 0, insert = 0; i < n;)
		{
			if (insert == m + i)
			{
				A[insert] = B[i];
				insert++;
				i++;
			}
			else if (A[insert] > B[i])
			{
				for (int j = m + i; j > insert; j--)
				{
					A[j] = A[j - 1];
				}
				A[insert] = B[i];
				i++;
			}
			else
			{
				insert++;
			}
		}
	}

}
