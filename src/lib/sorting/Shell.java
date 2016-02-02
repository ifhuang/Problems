package lib.sorting;

/**
 * Sorting an array using Shellsort.
 * 
 * @author If
 *
 */
public class Shell {

  private Shell() {}

  public static void sort(Comparable[] a) {
    int N = a.length;

    int h = 1;
    while (h < N / 3) {
      h = 3 * h + 1;
    }

    while (h >= 1) {
      for (int i = h; i < N; i++) {
        for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
          exch(a, j, j - h);
        }
      }
      h /= 3;
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
    Shell.sort(a);
    for (String s : a) {
      System.out.println(s);
    }
  }

}
