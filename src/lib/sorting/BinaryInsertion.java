package lib.sorting;

/**
 * Sorting an array using an optimized binary insertion sort with half exchanges.
 * 
 * @author If
 *
 */
public class BinaryInsertion {

  private BinaryInsertion() {}

  public static void sort(Comparable[] a) {
    int N = a.length;
    for (int i = 1; i < N; i++) {
      Comparable v = a[i];
      int lo = 0, hi = i;
      while (lo < hi) {
        int mid = lo + (hi - lo) / 2;
        if (less(v, a[mid])) {
          hi = mid;
        } else {
          lo = mid + 1;
        }
      }

      for (int j = i; j > lo; --j) {
        a[j] = a[j - 1];
      }
      a[lo] = v;
    }
  }

  private static boolean less(Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
  }

  public static void main(String[] args) {
    String[] a = {"how", "old", "are", "you"};
    BinaryInsertion.sort(a);
    for (String s : a) {
      System.out.println(s);
    }
  }
}
