package lib.collections;

import java.util.Iterator;

/**
 * A first-in-first-out (FIFO) queue of generic items based on array.
 * 
 * @author If
 *
 */
public class ResizingArrayQueue<Item> implements Iterable<Item> {
  private Item[] items;
  private int n;
  private int first;
  private int last;

  public ResizingArrayQueue() {
    items = (Item[]) new Object[2];
    n = 0;
    first = 0;
    last = 0;
  }

  public boolean isEmpty() {
    return n == 0;
  }

  public int size() {
    return n;
  }

  private void resize(int max) {
    Item[] temp = (Item[]) new Object[max];
    for (int i = 0; i < n; i++) {
      temp[i] = items[(first + i) % items.length];
    }
    items = temp;
    first = 0;
    last = n;
  }

  public void enqueue(Item item) {
    if (n == items.length) {
      resize(2 * items.length);
    }
    items[last++] = item;
    if (last == items.length) {
      last = 0;
    }
    n++;
  }

  public Item dequeue() {
    Item item = items[first];
    items[first] = null;
    n--;
    first++;
    if (first == items.length) {
      first = 0;
    }
    if (n > 0 && n == items.length / 4) {
      resize(items.length / 2);
    }
    return item;
  }

  public Item peek() {
    return items[first];
  }


  public Iterator<Item> iterator() {
    return new ArrayIterator();
  }

  private class ArrayIterator implements Iterator<Item> {
    private int i = 0;

    public boolean hasNext() {
      return i < n;
    }

    public Item next() {
      Item item = items[(i + first) % items.length];
      i++;
      return item;
    }
  }

  public static void main(String[] args) {
    ResizingArrayQueue<String> r = new ResizingArrayQueue<>();
    r.enqueue("a");
    r.enqueue("b");
    r.enqueue("c");
    for (String s : r) {
      System.out.println(s);
    }
    r.dequeue();
    for (String s : r) {
      System.out.println(s);
    }
  }
}
