package other;

public class QuickSort {
  public void quickSort(char[] c, int i, int j) {
    if (i + 1 >= j) {
      return;
    }
    int k = partition(c, i, j);
    quickSort(c, i, k);
    quickSort(c, k + 1, j);
  }

  private int partition(char[] c, int i, int j) {
    int i1 = i;
    for (int i2 = i + 1; i2 < j; i2++) {
      if (c[i2] < c[i]) {
        i1++;
        swap(c, i1, i2);
      }
    }
    swap(c, i, i1);
    return i1;
  }

  private void swap(char[] c, int i, int j) {
    char t = c[i];
    c[i] = c[j];
    c[j] = t;
  }
}
