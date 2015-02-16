package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import leetcode.util.Interval;

// https://oj.leetcode.com/problems/merge-intervals/
public class MergeIntervals {
  public List<Interval> merge(List<Interval> intervals) {
    List<Interval> ans = new ArrayList<>();
    if (intervals.isEmpty())
      return ans;
    Collections.sort(intervals, new Comparator<Interval>() {
      @Override
      public int compare(Interval i1, Interval i2) {
        return i1.start - i2.start;
      }
    });
    Interval preOld = intervals.get(0);
    Interval preNew = new Interval(preOld.start, preOld.end);
    ans.add(preNew);
    for (int i = 1; i < intervals.size(); i++) {
      Interval nowOld = intervals.get(i);
      if (preNew.end >= nowOld.start)
        preNew.end = Math.max(preNew.end, nowOld.end);
      else {
        preNew = new Interval(nowOld.start, nowOld.end);
        ans.add(preNew);
      }
    }
    return ans;
  }
}
