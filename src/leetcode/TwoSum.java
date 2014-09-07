package leetcode;

import java.util.HashMap;

public class TwoSum
{
	public int[] twoSum(int[] numbers, int target)
	{
		int[] result = new int[2];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++)
		{
			int remain = target - numbers[i];
			if (map.containsKey(remain))
			{
				result[0] = map.get(remain);
				result[1] = i + 1;
				break;
			}
			else
			{
				if (!map.containsKey(numbers[i]))
				{
					map.put(numbers[i], i + 1);
				}
			}
		}
		return result;
	}
}
