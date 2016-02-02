package lib.sorting;

import java.util.Comparator;

/**
 * Sorting an array using selection sort.
 * 
 * @author If
 *
 */
public class Selection {

  private Selection() {}

  public static void sort(Comparable[] a) {
    int N = a.length;
    for (int i = 0; i < N; i++) {
      int min = i;
      for (int j = i + 1; j < N; j++) {
        if (less(a[j], a[min])) {
          min = j;
        }
      }
      exch(a, i, min);
    }
  }

  public static void sort(Object[] a, Comparator c) {
    int N = a.length;
    for (int i = 0; i < N; i++) {
      int min = i;
      for (int j = i + 1; j < N; j++) {
        if (less(c, a[j], a[min])) {
          min = j;
        }
      }
      exch(a, i, min);
    }
  }

  private static boolean less(Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
  }

  private static boolean less(Comparator c, Object v, Object w) {
    return c.compare(v, w) < 0;
  }

  private static void exch(Object[] a, int i, int j) {
    Object swap = a[i];
    a[i] = a[j];
    a[j] = swap;
  }

  public static void main(String[] args) {
    String[] a = {"how", "old", "are", "you"};
    Selection.sort(a);
    for (String s : a) {
      System.out.println(s);
    }
  }
}
