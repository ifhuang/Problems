package lib.sorting;

/**
 * Sorting an array using quicksort with 3-way partitioning.
 * 
 * @author If
 *
 */
public class Quick3way {

  private Quick3way() {}

  public static void sort(Comparable[] a) {
    Knuth.shuffle(a);
    sort(a, 0, a.length - 1);
  }

  private static void sort(Comparable[] a, int lo, int hi) {
    if (hi <= lo) {
      return;
    }
    int lt = lo, gt = hi;
    Comparable v = a[lo];
    int i = lo;
    while (i <= gt) {
      int cmp = a[i].compareTo(v);
      if (cmp < 0) {
        exch(a, lt++, i++);
      } else if (cmp > 0) {
        exch(a, i, gt--);
      } else {
        i++;
      }
    }

    sort(a, lo, lt - 1);
    sort(a, gt + 1, hi);
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
    Quick3way.sort(a);
    for (String s : a) {
      System.out.println(s);
    }
  }

}
