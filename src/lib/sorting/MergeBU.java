package lib.sorting;

/**
 * Sorting an array using bottom-up mergesort.
 * 
 * @author If
 *
 */
public class MergeBU {

  private MergeBU() {}

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

  public static void sort(Comparable[] a) {
    int N = a.length;
    Comparable[] aux = new Comparable[N];
    for (int n = 1; n < N; n = n + n) {
      for (int i = 0; i < N - n; i += n + n) {
        int lo = i;
        int m = i + n - 1;
        int hi = Math.min(i + n + n - 1, N - 1);
        merge(a, aux, lo, m, hi);
      }
    }
  }

  private static boolean less(Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
  }

  public static void main(String[] args) {
    String[] a = {"how", "old", "are", "you"};
    MergeBU.sort(a);
    for (String s : a) {
      System.out.println(s);
    }
  }
}
