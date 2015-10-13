package leetcode.algorithms;

// https://oj.leetcode.com/problems/merge-sorted-array/
public class MergeSortedArray {
  // time O(m+n), space O(1)
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    for (int i1 = m - 1, i2 = n - 1, i3 = m + n - 1; i3 >= 0; i3--) {
      if (i1 < 0) {
        nums1[i3] = nums2[i2--];
      } else if (i2 < 0) {
        nums1[i3] = nums1[i1--];
      } else {
        if (nums1[i1] > nums2[i2]) {
          nums1[i3] = nums1[i1--];
        } else {
          nums1[i3] = nums2[i2--];
        }
      }
    }
  }
}
