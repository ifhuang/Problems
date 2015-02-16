package leetcode;

// https://oj.leetcode.com/problems/first-missing-positive/
public class FirstMissingPositive {
  public int firstMissingPositive(int[] A) {
    int len = A.length;
    for (int i = 0; i < len;) {
      int index = A[i] - 1;
      if (index != i && index >= 0 && index < len && A[index] - 1 != index) {
        int t = A[index];
        A[index] = A[i];
        A[i] = t;
      } else
        i++;
    }
    for (int i = 0; i < len; i++)
      if (A[i] - 1 != i)
        return i + 1;
    return len + 1;
  }
}
