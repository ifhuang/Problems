package lib.sorting;

/**
 * Sorting an array using an optimized version of insertion sort.
 * 
 * @author If
 *
 */
public class InsertionX {

  private InsertionX() {}

  public static void sort(Comparable[] a) {
    int N = a.length;

    int exchanges = 0;
    for (int i = N - 1; i > 0; i--) {
      if (less(a[i], a[i - 1])) {
        exch(a, i, i - 1);
        exchanges++;
      }
    }
    if (exchanges == 0)
      return;

    for (int i = 2; i < N; i++) {
      Comparable v = a[i];
      int j = i;
      while (less(v, a[j - 1])) {
        a[j] = a[j - 1];
        j--;
      }
      a[j] = v;
    }
  }

  private static boolean less(Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
  }

  private static void exch(Object[] a, int i, int j) {
    Object swap = a[i];
    a[i] = a[j];
    a[j] = swap;
  }

  public static void main(String[] args) {
    String[] a = {"how", "old", "are", "you"};
    InsertionX.sort(a);
    for (String s : a) {
      System.out.println(s);
    }
  }

}
