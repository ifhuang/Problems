package leetcode;

import java.util.LinkedList;
import java.util.List;

import leetcode.util.Interval;

public class InsertInterval
{
	public List<Interval> insert(List<Interval> intervals, Interval newInterval)
	{
		if (intervals == null)
		{
			List<Interval> list = new LinkedList<>();
			list.add(newInterval);
			return list;
		}
		else if (intervals.size() == 0)
		{
			intervals.add(newInterval);
			return intervals;
		}
		else
		{
			Interval first = intervals.get(0);
			Interval last = intervals.get(intervals.size() - 1);
			if (newInterval.end < first.start)
			{
				intervals.add(0, newInterval);
				return intervals;
			}
			else if (newInterval.end == first.start)
			{
				first.start = newInterval.start;
				return intervals;
			}
			else if (newInterval.start > last.end)
			{
				intervals.add(newInterval);
				return intervals;
			}
			else if (newInterval.start == last.end)
			{
				last.end = newInterval.end;
				return intervals;
			}
			else if (newInterval.start < first.start)
			{
				if (newInterval.end < first.end)
					newInterval.end = first.end;
				intervals.remove(0);
				return insert(intervals, newInterval);
			}
			else if (newInterval.start >= last.start)
			{
				newInterval.start = last.start;
				if (newInterval.end < last.end)
					newInterval.end = last.end;
				intervals.remove(intervals.size() - 1);
				return insert(intervals, newInterval);
			}
			else
			{
				for (int i = 1; i < intervals.size(); i++)
				{
					if (intervals.get(i).start > newInterval.start)
					{
						if (isOverlap(intervals.get(i - 1), newInterval))
						{
							Interval interval = intervals.remove(i - 1);
							newInterval.start = smaller(newInterval.start,
									interval.start);
							newInterval.end = bigger(newInterval.end,
									interval.end);
							return insert(intervals, newInterval);
						}
						else if (isOverlap(newInterval, intervals.get(i)))
						{
							Interval interval = intervals.remove(i);
							newInterval.start = smaller(newInterval.start,
									interval.start);
							newInterval.end = bigger(newInterval.end,
									interval.end);
							return insert(intervals, newInterval);
						}
						else
						{
							intervals.add(i, newInterval);
							return intervals;
						}
					}
				}
			}
			return null;
		}
	}

	private boolean isOverlap(Interval i1, Interval i2)
	{
		if (i1.end >= i2.start)
			return true;
		else
			return false;
	}

	private int bigger(int i1, int i2)
	{
		return i1 > i2 ? i1 : i2;
	}

	private int smaller(int i1, int i2)
	{
		return i1 < i2 ? i1 : i2;
	}
}
