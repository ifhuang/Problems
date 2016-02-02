package lib.sorting;

import java.util.Comparator;

/**
 * Sorting an array using insertion sort.
 * 
 * @author If
 *
 */
public class Insertion {

  private Insertion() {}

  public static void sort(Comparable[] a) {
    int N = a.length;
    for (int i = 0; i < N; i++) {
      for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
        exch(a, j, j - 1);
      }
    }
  }

  public static void sort(Comparable[] a, int lo, int hi) {
    for (int i = lo; i <= hi; i++) {
      for (int j = i; j > lo && less(a[j], a[j - 1]); j--) {
        exch(a, j, j - 1);
      }
    }
  }

  public static void sort(Object[] a, Comparator comparator) {
    int N = a.length;
    for (int i = 0; i < N; i++) {
      for (int j = i; j > 0 && less(a[j], a[j - 1], comparator); j--) {
        exch(a, j, j - 1);
      }
    }
  }

  public static void sort(Object[] a, int lo, int hi, Comparator comparator) {
    for (int i = lo; i <= hi; i++) {
      for (int j = i; j > lo && less(a[j], a[j - 1], comparator); j--) {
        exch(a, j, j - 1);
      }
    }
  }

  public static int[] indexSort(Comparable[] a) {
    int N = a.length;
    int[] index = new int[N];
    for (int i = 0; i < N; i++) {
      index[i] = i;
    }

    for (int i = 0; i < N; i++) {
      for (int j = i; j > 0 && less(a[index[j]], a[index[j - 1]]); j--) {
        exch(index, j, j - 1);
      }
    }

    return index;
  }

  private static boolean less(Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
  }

  private static boolean less(Object v, Object w, Comparator comparator) {
    return comparator.compare(v, w) < 0;
  }

  private static void exch(Object[] a, int i, int j) {
    Object swap = a[i];
    a[i] = a[j];
    a[j] = swap;
  }

  private static void exch(int[] a, int i, int j) {
    int swap = a[i];
    a[i] = a[j];
    a[j] = swap;
  }

  public static void main(String[] args) {
    String[] a = {"how", "old", "are", "you"};
    Insertion.sort(a);
    for (String s : a) {
      System.out.println(s);
    }
  }
}
