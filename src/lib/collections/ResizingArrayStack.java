package lib.collections;

import java.util.Iterator;

/**
 * A last-in-first-out (LIFO) stack of generic items based on array.
 * 
 * @author If
 *
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {
  private Item[] items;
  private int n;

  public ResizingArrayStack() {
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

  public void push(Item item) {
    if (n == items.length) {
      resize(2 * items.length);
    }
    items[n++] = item;
  }

  public Item pop() {
    Item item = items[n - 1];
    items[n - 1] = null;
    n--;
    if (n > 0 && n == items.length / 4) {
      resize(items.length / 2);
    }
    return item;
  }

  public Item peek() {
    return items[n - 1];
  }

  public Iterator<Item> iterator() {
    return new ReverseArrayIterator();
  }

  private class ReverseArrayIterator implements Iterator<Item> {
    private int i;

    public ReverseArrayIterator() {
      i = n - 1;
    }

    public boolean hasNext() {
      return i >= 0;
    }

    public Item next() {
      return items[i--];
    }
  }

  public static void main(String[] args) {
    ResizingArrayStack<String> r = new ResizingArrayStack<>();
    r.push("a");
    r.push("b");
    r.push("c");
    for (String s : r) {
      System.out.println(s);
    }
    r.pop();
    for (String s : r) {
      System.out.println(s);
    }
  }

}
