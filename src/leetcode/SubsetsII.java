package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsetsII
{
	public List<List<Integer>> subsetsWithDup(int[] num)
	{
		List<List<Integer>> result = new ArrayList<>();
		if (num == null || num.length == 0)
		{
			List<Integer> list = new ArrayList<>();
			result.add(list);
			return result;
		}
		else if (num.length == 1)
		{
			List<Integer> list = new ArrayList<>();
			result.add(list);
			list = new ArrayList<>();
			list.add(num[0]);
			result.add(list);
			return result;
		}
		else
		{
			Arrays.sort(num);
			List<List<Integer>> pre = subsetsWithDup(Arrays.copyOfRange(num, 0,
					num.length - 1));
			Set<List<Integer>> set = new HashSet<>();
			for (List<Integer> list : pre)
			{
				set.add(list);
				List<Integer> list2 = new ArrayList<>(list);
				list2.add(num[num.length - 1]);
				set.add(list2);
			}
			for (List<Integer> list : set)
			{
				result.add(list);
			}
			return result;
		}
	}
}