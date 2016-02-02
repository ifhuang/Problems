package lib.collections;

import java.util.Iterator;

/**
 * A last-in-first-out (LIFO) stack of generic items based on linked list;
 * 
 * @author If
 *
 */
public class LinkedStack<Item> implements Iterable<Item> {
  private Node first;
  private int n;

  private class Node {
    private Item item;
    private Node next;
  }

  public LinkedStack() {
    first = null;
    n = 0;
  }

  public boolean isEmpty() {
    return first == null;
  }

  public int size() {
    return n;
  }

  public void push(Item item) {
    Node oldfirst = first;
    first = new Node();
    first.item = item;
    first.next = oldfirst;
    n++;
  }

  public Item pop() {
    Item item = first.item;
    first = first.next;
    n--;
    return item;
  }

  public Item peek() {
    return first.item;
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
    LinkedStack<String> l = new LinkedStack<>();
    l.push("a");
    l.push("b");
    l.push("c");
    System.out.println(l);
    l.pop();
    System.out.println(l);
  }
}
