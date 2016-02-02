package lib.collections;

import java.util.Iterator;

/**
 * A bag (or multiset) of generic items.
 * 
 * @author If
 *
 */
public class Bag<Item> implements Iterable<Item> {
  private Node<Item> first;
  private int n;

  private static class Node<Item> {
    private Item item;
    private Node<Item> next;
  }

  public Bag() {
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
    Node<Item> oldfirst = first;
    first = new Node<Item>();
    first.item = item;
    first.next = oldfirst;
    n++;
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
    Bag<String> b = new Bag<>();
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
