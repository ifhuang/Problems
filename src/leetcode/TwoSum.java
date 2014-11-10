package leetcode;

import java.util.HashMap;
import java.util.Map;

// https://oj.leetcode.com/problems/two-sum/
public class TwoSum
{
	public int[] twoSum(int[] numbers, int target)
	{
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < numbers.length; i++)
		{
			int r = target - numbers[i];
			if (map.containsKey(r))
				return new int[] { map.get(r) + 1, i + 1 };
			map.put(numbers[i], i);
		}
		throw new IllegalArgumentException("no solution");
	}
}
