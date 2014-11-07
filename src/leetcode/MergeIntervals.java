package leetcode;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import leetcode.util.Interval;

public class MergeIntervals
{
	public List<Interval> merge(List<Interval> intervals)
	{
		if (intervals == null || intervals.size() < 2)
			return intervals;
		Collections.sort(intervals, new Comparator<Interval>()
		{
			public int compare(Interval arg0, Interval arg1)
			{
				return arg0.start - arg1.start;
			}
		});
		Interval first = intervals.get(0);
		for (int i = 1; i < intervals.size();)
		{
			Interval now = intervals.get(i);
			if (now.start > first.end)
			{
				first = now;
				i++;
			}
			else
			{
				first.end = Math.max(first.end, now.end);
				intervals.remove(i);
			}
		}
		return intervals;
	}
}