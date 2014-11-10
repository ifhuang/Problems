package leetcode;

public class RemoveDuplicatesfromSortedArrayII
{
	public int removeDuplicates(int[] A)
	{
		if (A == null)
			return 0;
		if (A.length < 3)
			return A.length;
		int ans = 0;
		int l = A.length;
		int s = 0;
		int c = A[0];
		int i = 1;
		int count = 1;
		while (i < l)
		{
			if (A[i] == c)
			{
				count++;
				i++;
			}
			else
			{
				if (count <= 2)
				{
					ans += count;
					s = i;
					c = A[i];
					count = 1;
					i++;
				}
				else
				{
					ans += 2;
					for (int j = s + count; j < l; j++)
						A[j - count + 2] = A[j];
					l -= count - 2;
					s += 2;
					c = A[s];
					i = s + 1;
					count = 1;
				}
			}
		}
		if (count <= 2)
		{
			ans += count;
		}
		else
		{
			ans += 2;
		}
		return ans;
	}

	public static void main(String[] args)
	{
		RemoveDuplicatesfromSortedArrayII solution = new RemoveDuplicatesfromSortedArrayII();
		int[] A = new int[] { 1, 1, 1, 2, 2, 2, 3, 3 };
		int B = solution.removeDuplicates(A);
		System.out.println("" + B);
	}
}