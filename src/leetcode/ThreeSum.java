package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class ThreeSum
{
	public ArrayList<ArrayList<Integer>> threeSum(int[] num)
	{
		if (num == null || num.length < 3)
			return new ArrayList<>();
		Arrays.sort(num);
		HashSet<ArrayList<Integer>> set = new HashSet<>();
		for (int i = 0; i < num.length - 2; i++)
			for (int j = i + 1; j < num.length - 1; j++)
			{
				int c = 0 - num[i] - num[j];
				if (Arrays.binarySearch(num, j + 1, num.length, c) > 0)
				{
					ArrayList<Integer> one = new ArrayList<>();
					one.add(num[i]);
					one.add(num[j]);
					one.add(c);
					set.add(one);
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
