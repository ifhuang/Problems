package lib.sorting;

import java.util.Iterator;

/**
 * An indexed priority queue of generic keys.
 * 
 * @author If
 *
 * @param <Key>
 */
public class IndexMinPQ<Key extends Comparable<Key>> implements Iterable<Integer> {
  private int maxN;
  private int N;
  private int[] pq;
  private int[] qp;
  private Key[] keys;

  public IndexMinPQ(int maxN) {
    this.maxN = maxN;
    keys = (Key[]) new Comparable[maxN + 1];
    pq = new int[maxN + 1];
    qp = new int[maxN + 1];
    for (int i = 0; i <= maxN; i++) {
      qp[i] = -1;
    }
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public boolean contains(int i) {
    return qp[i] != -1;
  }

  public int size() {
    return N;
  }

  public void insert(int i, Key key) {
    N++;
    qp[i] = N;
    pq[N] = i;
    keys[i] = key;
    swim(N);
  }

  public int minIndex() {
    return pq[1];
  }

  public Key minKey() {
    return keys[pq[1]];
  }

  public int delMin() {
    int min = pq[1];
    exch(1, N--);
    sink(1);
    qp[min] = -1;
    keys[pq[N + 1]] = null;
    pq[N + 1] = -1;
    return min;
  }

  public Key keyOf(int i) {
    return keys[i];
  }

  public void changeKey(int i, Key key) {
    keys[i] = key;
    swim(qp[i]);
    sink(qp[i]);
  }

  public void decreaseKey(int i, Key key) {
    keys[i] = key;
    swim(qp[i]);
  }

  public void increaseKey(int i, Key key) {
    keys[i] = key;
    sink(qp[i]);
  }

  public void delete(int i) {
    int index = qp[i];
    exch(index, N--);
    swim(index);
    sink(index);
    keys[i] = null;
    qp[i] = -1;
  }

  private boolean greater(int i, int j) {
    return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
  }

  private void exch(int i, int j) {
    int swap = pq[i];
    pq[i] = pq[j];
    pq[j] = swap;
    qp[pq[i]] = i;
    qp[pq[j]] = j;
  }

  private void swim(int k) {
    while (k > 1 && greater(k / 2, k)) {
      exch(k, k / 2);
      k = k / 2;
    }
  }

  private void sink(int k) {
    while (2 * k <= N) {
      int j = 2 * k;
      if (j < N && greater(j, j + 1)) {
        j++;
      }
      if (!greater(k, j)) {
        break;
      }
      exch(k, j);
      k = j;
    }
  }

  public Iterator<Integer> iterator() {
    return new HeapIterator();
  }

  private class HeapIterator implements Iterator<Integer> {
    private IndexMinPQ<Key> copy;

    public HeapIterator() {
      copy = new IndexMinPQ<Key>(pq.length - 1);
      for (int i = 1; i <= N; i++)
        copy.insert(pq[i], keys[pq[i]]);
    }

    public boolean hasNext() {
      return !copy.isEmpty();
    }

    public void remove() {
      throw new UnsupportedOperationException();
    }

    public Integer next() {
      return copy.delMin();
    }
  }

}
