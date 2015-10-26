package leetcode.algorithms;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

// https://leetcode.com/problems/find-median-from-data-stream/
public class FindMedianfromDataStream {
  // max queue is always larger or equal to min queue
  Queue<Integer> min = new PriorityQueue<>();
  Queue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

  // Adds a number into the data structure.
  public void addNum(int num) {
    max.offer(num);
    min.offer(max.poll());
    if (max.size() < min.size()) {
      max.offer(min.poll());
    }
  }

  // Returns the median of current data stream
  public double findMedian() {
    return max.size() == min.size() ? (max.peek() + min.peek()) / 2.0 : max.peek();
  }
}
