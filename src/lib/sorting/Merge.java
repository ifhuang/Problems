package lib.sorting;

/**
 * Sorting an array using mergesort.
 * 
 * @author If
 *
 */
public class Merge {

  private Merge() {}

  private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
    for (int k = lo; k <= hi; k++) {
      aux[k] = a[k];
    }
    int i = lo, j = mid + 1;
    for (int k = lo; k <= hi; k++) {
      if (i > mid) {
        a[k] = aux[j++];
      } else if (j > hi) {
        a[k] = aux[i++];
      } else if (less(aux[j], aux[i])) {
        a[k] = aux[j++];
      } else {
        a[k] = aux[i++];
      }
    }
  }

  private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
    if (hi <= lo) {
      return;
    }
    int mid = lo + (hi - lo) / 2;
    sort(a, aux, lo, mid);
    sort(a, aux, mid + 1, hi);
    merge(a, aux, lo, mid, hi);
  }

  public static void sort(Comparable[] a) {
    Comparable[] aux = new Comparable[a.length];
    sort(a, aux, 0, a.length - 1);
  }

  private static boolean less(Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
  }

  private static void merge(Comparable[] a, int[] index, int[] aux, int lo, int mid, int hi) {
    for (int k = lo; k <= hi; k++) {
      aux[k] = index[k];
    }
    int i = lo, j = mid + 1;
    for (int k = lo; k <= hi; k++) {
      if (i > mid) {
        index[k] = aux[j++];
      } else if (j > hi) {
        index[k] = aux[i++];
      } else if (less(a[aux[j]], a[aux[i]])) {
        index[k] = aux[j++];
      } else {
        index[k] = aux[i++];
      }
    }
  }

  public static int[] indexSort(Comparable[] a) {
    int N = a.length;
    int[] index = new int[N];
    for (int i = 0; i < N; i++) {
      index[i] = i;
    }
    int[] aux = new int[N];
    sort(a, index, aux, 0, N - 1);
    return index;
  }

  private static void sort(Comparable[] a, int[] index, int[] aux, int lo, int hi) {
    if (hi <= lo) {
      return;
    }
    int mid = lo + (hi - lo) / 2;
    sort(a, index, aux, lo, mid);
    sort(a, index, aux, mid + 1, hi);
    merge(a, index, aux, lo, mid, hi);
  }

  public static void main(String[] args) {
    String[] a = {"how", "old", "are", "you"};
    Merge.sort(a);
    for (String s : a) {
      System.out.println(s);
    }
  }
}
