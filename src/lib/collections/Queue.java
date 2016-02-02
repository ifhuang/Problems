package lib.collections;

import java.util.Iterator;

/**
 * A first-in-first-out (FIFO) queue of generic items.
 * 
 * @author If
 *
 */
public class Queue<Item> implements Iterable<Item> {
  private Node<Item> first;
  private Node<Item> last;
  private int n;

  private static class Node<Item> {
    private Item item;
    private Node<Item> next;
  }

  public Queue() {
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
    Node<Item> oldlast = last;
    last = new Node<Item>();
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
    return new ListIterator<>(first);
  }

  private class ListIterator<Item> implements Iterator<Item> {
    private Node<Item> current;

    public ListIterator(Node<Item> first) {
      current = first;
    }

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
    Queue<String> q = new Queue<>();
    q.enqueue("a");
    q.enqueue("b");
    q.enqueue("c");
    System.out.println(q);
    q.dequeue();
    System.out.println(q);
  }
}
