package leetcode.algorithms;

import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-largest-element-in-an-array/
public class KthLargestElementinanArray {
  // time O(nlogk), space O(k)
  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(k);
    for (int num : nums) {
      if (pq.size() < k) {
        pq.offer(num);
      } else if (num > pq.peek()) {
        pq.poll();
        pq.offer(num);
      }
    }
    return pq.peek();
  }

  // time O(n), space O(1)
  public int findKthLargest2(int[] nums, int k) {
    return quickSelect(nums, 0, nums.length, k - 1);
  }

  private int quickSelect(int[] nums, int i, int j, int k) {
    int t1 = i;
    for (int t2 = i + 1; t2 < j; t2++) {
      if (nums[t2] < nums[i]) {
        t1++;
        swap(nums, t1, t2);
      }
    }
    swap(nums, i, t1);
    if (k == j - t1 - 1) {
      return nums[t1];
    } else if (k < j - t1 - 1) {
      return quickSelect(nums, t1 + 1, j, k);
    } else {
      return quickSelect(nums, i, t1, k - (j - t1));
    }
  }

  private void swap(int[] nums, int i, int j) {
    int t = nums[i];
    nums[i] = nums[j];
    nums[j] = t;
  }
}
