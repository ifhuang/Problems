package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class FourSum
{
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target)
	{
		if (num == null || num.length < 4)
			return new ArrayList<>();
		Arrays.sort(num);
		HashSet<ArrayList<Integer>> set = new HashSet<>();
		for (int i = 0; i < num.length - 3; i++)
			for (int j = i + 1; j < num.length - 2; j++)
			{
				int low = j + 1;
				int high = num.length - 1;
				while (low < high)
				{
					int sum = num[i] + num[j] + num[low] + num[high];
					if (sum == target)
					{
						ArrayList<Integer> one = new ArrayList<>();
						one.add(num[i]);
						one.add(num[j]);
						one.add(num[low]);
						one.add(num[high]);
						set.add(one);
						low++;
					}
					else if (sum > target)
					{
						high--;
					}
					else
					{
						low++;
					}
				}
			}
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for (ArrayList<Integer> arrayList : set)
		{
			list.add(arrayList);
		}
		return list;
	}
}
