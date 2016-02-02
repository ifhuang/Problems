package lib.collections;

import java.util.Iterator;

/**
 * A bag (or multiset) of generic items based on linked list.
 * 
 * @author If
 *
 */
public class LinkedBag<Item> implements Iterable<Item> {
  private Node first;
  private int n;

  private class Node {
    private Item item;
    private Node next;
  }

  public LinkedBag() {
    first = null;
    n = 0;
  }

  public boolean isEmpty() {
    return first == null;
  }

  public int size() {
    return n;
  }

  public void add(Item item) {
    Node oldfirst = first;
    first = new Node();
    first.item = item;
    first.next = oldfirst;
    n++;
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
    LinkedBag<String> l = new LinkedBag<>();
    l.add("Hello");
    l.add("World");
    l.add("how");
    l.add("are");
    l.add("you");
    for (String s : l) {
      System.out.println(s);
    }
  }


}
