package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum
{
	public List<List<Integer>> threeSum(int[] num)
	{
		Set<List<Integer>> set = new HashSet<>();
		Arrays.sort(num);
		for (int i = 0; i < num.length - 2; i++)
			for (int j = i + 1, k = num.length - 1; j < k;)
			{
				int r = -num[i];
				if (num[j] + num[k] == r)
				{
					List<Integer> list = new ArrayList<>();
					list.add(num[i]);
					list.add(num[j]);
					list.add(num[k]);
					set.add(list);
					j++;
					k--;
				}
				else if (num[j] + num[k] > r)
					k--;
				else
					j++;
			}
		return new ArrayList<>(set);
	}
}
