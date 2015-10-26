package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

// https://leetcode.com/problems/the-skyline-problem/
public class TheSkylineProblem {
  public List<int[]> getSkyline2(int[][] buildings) {
    List<int[]> result = new ArrayList<>();
    List<int[]> height = new ArrayList<>();
    for (int[] b : buildings) {
      height.add(new int[] {b[0], -b[2]});
      height.add(new int[] {b[1], b[2]});
    }
    Collections.sort(height, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
      }
    });
    Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2 - o1;
      }
    });
    pq.offer(0);
    int pre = 0;
    for (int[] h : height) {
      if (h[1] < 0) {
        pq.offer(-h[1]);
      } else {
        pq.remove(h[1]);
      }
      int cur = pq.peek();
      if (pre != cur) {
        result.add(new int[] {h[0], cur});
        pre = cur;
      }
    }
    return result;
  }
}
