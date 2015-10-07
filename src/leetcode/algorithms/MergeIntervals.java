package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import leetcode.util.Interval;

// https://oj.leetcode.com/problems/merge-intervals/
public class MergeIntervals {
  // time O(nlogn), space O(n)
  public List<Interval> merge(List<Interval> intervals) {
    List<Interval> copy = new ArrayList<>(intervals);
    Collections.sort(copy, new Comparator<Interval>() {
      @Override
      public int compare(Interval i1, Interval i2) {
        return i1.start - i2.start;
      }
    });
    List<Interval> ans = new ArrayList<>();
    int i = 0;
    while (i < copy.size()) {
      Interval cur = copy.get(i);
      if (ans.isEmpty()) {
        ans.add(cur);
      } else {
        Interval pre = ans.get(ans.size() - 1);
        if (pre.end < cur.start) {
          ans.add(cur);
        } else {
          pre.end = Math.max(pre.end, cur.end);
        }
      }
      i++;
    }
    return ans;
  }
}
