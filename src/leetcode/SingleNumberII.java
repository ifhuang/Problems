package leetcode;

import java.util.HashMap;

public class SingleNumberII
{
	public int singleNumber(int[] A)
	{
		if (A == null || A.length == 0)
			return 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < A.length; i++)
		{
			if (map.containsKey(A[i]))
				map.put(A[i], map.get(A[i]) + 1);
			else
				map.put(A[i], 1);
		}
		for (int key : map.keySet())
		{
			if (map.get(key) != 3)
				return key;
		}
		return 0;
	}
}
