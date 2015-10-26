package leetcode.algorithms;

// https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree/
// Given an array of numbers, verify whether it is the correct preorder traversal sequence of a
// binary search tree.
// You may assume each number in the sequence is unique.
// Follow up:
// Could you do it using only constant space complexity?
public class VerifyPreorderSequenceinBinarySearchTree {
  public boolean verifyPreorder(int[] preorder) {
    return verify(preorder, 0, preorder.length);
  }

  private boolean verify(int[] a, int start, int end) {
    if (start >= end - 1) {
      return true;
    }
    int pivot = a[start];
    int bigger = -1;
    for (int i = start + 1; i < end; i++) {
      if (bigger == -1 && a[i] > pivot) {
        bigger = i;
      }
      if (bigger != -1 && a[i] < pivot) {
        return false;
      }
    }
    if (bigger == -1) {
      return verify(a, start + 1, end);
    } else {
      return verify(a, start + 1, bigger) && verify(a, bigger, end);
    }
  }
}
