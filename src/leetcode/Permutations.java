package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations
{
	public List<List<Integer>> permute(int[] num)
	{
		List<List<Integer>> result = new ArrayList<>();
		if (num == null || num.length == 0)
			return result;
		if (num.length == 1)
		{
			List<Integer> list = new ArrayList<>();
			list.add(num[0]);
			result.add(list);
			return result;
		}
		else
		{
			List<List<Integer>> pre = permute(Arrays.copyOfRange(num, 0,
					num.length - 1));
			for (List<Integer> list : pre)
			{
				for (int i = 0; i <= list.size(); i++)
				{
					List<Integer> newList = new ArrayList<>(list);
					newList.add(i, num[num.length - 1]);
					result.add(newList);
				}
			}
			return result;
		}
	}
}
