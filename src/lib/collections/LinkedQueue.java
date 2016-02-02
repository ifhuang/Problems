package lib.collections;

import java.util.Iterator;

/**
 * A first-in-first-out (FIFO) queue of generic items based on linked list.
 * 
 * @author If
 *
 */
public class LinkedQueue<Item> implements Iterable<Item> {
  private Node first;
  private Node last;
  private int n;

  private class Node {
    private Item item;
    private Node next;
  }

  public LinkedQueue() {
    first = null;
    last = null;
    n = 0;
  }

  public boolean isEmpty() {
    return first == null;
  }

  public int size() {
    return n;
  }

  public Item peek() {
    return first.item;
  }

  public void enqueue(Item item) {
    Node oldlast = last;
    last = new Node();
    last.item = item;
    last.next = null;
    if (isEmpty()) {
      first = last;
    } else {
      oldlast.next = last;
    }
    n++;
  }

  public Item dequeue() {
    Item item = first.item;
    first = first.next;
    n--;
    if (isEmpty()) {
      last = null;
    }
    return item;
  }

  public String toString() {
    StringBuilder s = new StringBuilder();
    for (Item item : this) {
      s.append(item + " ");
    }
    return s.toString();
  }

  public Iterator<Item> iterator() {
    return new ListIterator();
  }

  private class ListIterator implements Iterator<Item> {
    private Node current = first;

    public boolean hasNext() {
      return current != null;
    }

    public Item next() {
      Item item = current.item;
      current = current.next;
      return item;
    }
  }

  public static void main(String[] args) {
    LinkedQueue<String> l = new LinkedQueue<>();
    l.enqueue("a");
    l.enqueue("b");
    l.enqueue("c");
    System.out.println(l);
    l.dequeue();
    System.out.println(l);
  }
}
