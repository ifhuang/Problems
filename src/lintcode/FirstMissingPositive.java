package lintcode;

// http://www.lintcode.com/en/problem/first-missing-positive/
public class FirstMissingPositive {
  /**
   * @param A: an array of integers
   * @return: an integer
   */
  public int firstMissingPositive(int[] A) {
    // write your code here
    for (int i = 0; i < A.length;) {
      int j = A[i] - 1;
      if (j >= 0 && j < A.length && A[j] != A[i]) {
        swap(A, i, j);
      } else {
        i++;
      }
    }
    int i = 0;
    while (i < A.length) {
      if (i != A[i] - 1) {
        break;
      }
      i++;
    }
    return i + 1;
  }

  private void swap(int[] A, int i, int j) {
    int t = A[i];
    A[i] = A[j];
    A[j] = t;
  }
}
