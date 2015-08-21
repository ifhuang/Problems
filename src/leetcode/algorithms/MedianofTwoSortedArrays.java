package leetcode.algorithms;

// https://oj.leetcode.com/problems/median-of-two-sorted-arrays/
public class MedianofTwoSortedArrays {
  // time O(n + m), space O(n + m)
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int n = nums1.length, m = nums2.length;
    int len = n + m;
    int[] nums = new int[len];
    int i = len - 1, i1 = n - 1, i2 = m - 1;
    while (i >= 0) {
      if (i1 < 0)
        nums[i] = nums2[i2--];
      else if (i2 < 0)
        nums[i] = nums1[i1--];
      else if (nums1[i1] > nums2[i2])
        nums[i] = nums1[i1--];
      else
        nums[i] = nums2[i2--];
      i--;
    }
    return nums.length % 2 == 1 ? nums[len / 2] : (nums[len / 2 - 1] + nums[len / 2]) / 2.;
  }

  // time O(log(m + n)), space O(1)
  public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
    int n1 = nums1.length;
    int n2 = nums2.length;
    int n = n1 + n2;
    if (n % 2 == 1) {
      return findK(nums1, 0, nums2, 0, n / 2 + 1);
    } else {
      return (findK(nums1, 0, nums2, 0, n / 2) + findK(nums1, 0, nums2, 0, n / 2 + 1)) / 2.;
    }
  }

  private int findK(int[] nums1, int i1, int[] nums2, int i2, int k) {
    int n1 = nums1.length - i1;
    int n2 = nums2.length - i2;
    if (n1 > n2) {
      return findK(nums2, i2, nums1, i1, k);
    }
    if (n1 == 0) {
      return nums2[i2 + k - 1];
    } else if (k == 1) {
      return Math.min(nums1[i1], nums2[i2]);
    } else {
      int t1 = Math.min(k / 2, n1);
      int t2 = Math.min(k / 2, n2);
      if (nums1[i1 + t1 - 1] < nums2[i2 + t2 - 1]) {
        return findK(nums1, i1 + t1, nums2, i2, k - t1);
      } else {
        return findK(nums1, i1, nums2, i2 + t2, k - t2);
      }
    }
  }
}
