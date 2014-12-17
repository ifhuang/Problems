package leetcode;

import java.util.List;

import leetcode.util.Interval;

// https://oj.leetcode.com/problems/insert-interval/
public class InsertInterval {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		int i = 0;
		int n = intervals.size();
		Interval low = null;
		for (; i < n; i++) {
			low = intervals.get(i);
			if (newInterval.start <= low.end)
				break;
		}
		if (i == n || newInterval.end < low.start)
			intervals.add(i, newInterval);
		else {
			low.start = Math.min(low.start, newInterval.start);
			low.end = Math.max(low.end, newInterval.end);
			for (i++; i < intervals.size();) {
				Interval next = intervals.get(i);
				if (next.start > low.end)
					break;
				else {
					low.start = Math.min(low.start, next.start);
					low.end = Math.max(low.end, next.end);
					intervals.remove(i);
				}
			}
		}
		return intervals;
	}
}
