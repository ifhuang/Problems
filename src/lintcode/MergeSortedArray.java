package lintcode;

// http://www.lintcode.com/en/problem/merge-sorted-array/
public class MergeSortedArray {
  /**
   * @param A: sorted integer array A which has m elements, but size of A is m+n
   * @param B: sorted integer array B which has n elements
   * @return: void
   */
  public void mergeSortedArray(int[] A, int m, int[] B, int n) {
    // write your code here
    int a = m - 1;
    int b = n - 1;
    int c = m + n - 1;
    while (c >= 0) {
      if (a == -1) {
        A[c--] = B[b--];
      } else if (b == -1) {
        A[c--] = A[a--];
      } else if (A[a] >= B[b]) {
        A[c--] = A[a--];
      } else {
        A[c--] = B[b--];
      }
    }
  }
}
