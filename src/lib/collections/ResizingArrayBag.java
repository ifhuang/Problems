package lib.collections;

import java.util.Iterator;

/**
 * A bag (or multiset) of generic items based array.
 * 
 * @author If
 *
 */
public class ResizingArrayBag<Item> implements Iterable<Item> {
  private Item[] items;
  private int n;

  public ResizingArrayBag() {
    items = (Item[]) new Object[2];
    n = 0;
  }

  public boolean isEmpty() {
    return n == 0;
  }

  public int size() {
    return n;
  }

  private void resize(int capacity) {
    Item[] temp = (Item[]) new Object[capacity];
    for (int i = 0; i < n; i++) {
      temp[i] = items[i];
    }
    items = temp;
  }

  public void add(Item item) {
    if (n == items.length) {
      resize(2 * items.length);
    }
    items[n++] = item;
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
      return items[i++];
    }
  }

  public static void main(String[] args) {
    ResizingArrayBag<String> b = new ResizingArrayBag<>();
    b.add("Hello");
    b.add("World");
    b.add("how");
    b.add("are");
    b.add("you");
    for (String s : b) {
      System.out.println(s);
    }
  }

}
