package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.Interval;

// https://oj.leetcode.com/problems/insert-interval/
public class InsertInterval {
  // time O(n), space O(n)
  public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    List<Interval> ans = new ArrayList<>();
    ans.add(newInterval);
    for (Interval cur : intervals) {
      Interval pre = ans.get(ans.size() - 1);
      if (pre.end < cur.start) {
        Interval p = new Interval(cur.start, cur.end);
        ans.add(p);
      } else if (pre.start > cur.end) {
        Interval p = new Interval(pre.start, pre.end);
        pre.start = cur.start;
        pre.end = cur.end;
        ans.add(p);
      } else {
        pre.start = Math.min(pre.start, cur.start);
        pre.end = Math.max(pre.end, cur.end);
      }
    }
    return ans;
  }
}
