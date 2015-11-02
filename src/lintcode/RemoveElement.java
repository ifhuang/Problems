package lintcode;

// http://www.lintcode.com/en/problem/remove-element/
public class RemoveElement {
  /**
   * @param A: A list of integers
   * @param elem: An integer
   * @return: The new length after remove
   */
  public int removeElement(int[] A, int elem) {
    // write your code here
    int i = -1;
    int j = 0;
    while (j < A.length) {
      if (A[j] != elem) {
        i++;
        A[i] = A[j];
      }
      j++;
    }
    return i + 1;
  }
}
