package leetcode;

public class SortColors {
  public void sortColors(int[] A) {
    int len = A.length;
    int zero = -1;
    int one = -1;
    int two = -1;
    for (int i = 0; i < len; i++)
      if (A[i] == 0) {
        A[++two] = 2;
        A[++one] = 1;
        A[++zero] = 0;
      } else if (A[i] == 1) {
        A[++two] = 2;
        A[++one] = 1;
      } else
        A[++two] = 2;
  }
}
