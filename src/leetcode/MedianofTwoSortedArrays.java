package leetcode;

// https://oj.leetcode.com/problems/median-of-two-sorted-arrays/
public class MedianofTwoSortedArrays {
  public double findMedianSortedArrays(int[] A, int[] B) {
    int al = A.length;
    int bl = B.length;
    int mid = (al + bl) / 2;
    int r = (al + bl) % 2;
    if (r == 0)
      return (findKth(A, 0, B, 0, mid) + findKth(A, 0, B, 0, mid + 1)) / 2.0;
    else
      return findKth(A, 0, B, 0, mid + 1);
  }

  private double findKth(int A[], int as, int B[], int bs, int k) {
    int al = A.length - as;
    int bl = B.length - bs;
    if (al > bl)
      return findKth(B, bs, A, as, k);
    else if (al == 0)
      return B[bs + k - 1];
    else if (k == 1)
      return Math.min(A[as], B[bs]);
    int a = Math.min(al, k / 2);
    int b = Math.min(bl, k / 2);
    if (A[as + a - 1] < B[bs + b - 1])
      return findKth(A, as + a, B, bs, k - a);
    else
      return findKth(A, as, B, bs + b, k - b);
  }
}
