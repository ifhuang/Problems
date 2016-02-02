package lib.sorting;

/**
 * Shuffling them using the Knuth (or Fisher-Yates) shuffling algorithm.
 * 
 * @author If
 *
 */
public class Knuth {

  private Knuth() {}

  public static void shuffle(Object[] a) {
    int N = a.length;
    for (int i = 0; i < N; i++) {
      int r = i + (int) (Math.random() * (N - i));
      Object swap = a[r];
      a[r] = a[i];
      a[i] = swap;
    }
  }

  public static void main(String[] args) {
    Integer[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    Knuth.shuffle(a);
    for (int i : a) {
      System.out.println(i);
    }
  }
}
