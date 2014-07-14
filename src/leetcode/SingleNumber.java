package leetcode;

import java.util.HashSet;

public class SingleNumber
{
	public int singleNumber(int[] A)
	{
		if (A == null || A.length == 0)
			return 0;
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < A.length; i++)
		{
			if (set.contains(A[i]))
			{
				set.remove(A[i]);
			}
			else
			{
				set.add(A[i]);
			}
		}
		return (int) set.toArray()[0];
	}
}
