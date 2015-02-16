package leetcode;

// https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array/
public class RemoveDuplicatesfromSortedArray {
  public int removeDuplicates(int[] A) {
    if (A == null || A.length == 0)
      return 0;
    int count = 1;
    for (int i = 1; i < A.length; i++)
      if (A[i] != A[count - 1])
        A[count++] = A[i];
    return count;
  }
}
