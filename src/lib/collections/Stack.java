package lib.collections;

import java.util.Iterator;

/**
 * A last-in-first-out (LIFO) stack of generic items.
 * 
 * @author If
 *
 */
public class Stack<Item> implements Iterable<Item> {

  private Node<Item> first;
  private int n;

  private static class Node<Item> {
    private Item item;
    private Node<Item> next;
  }

  public Stack() {
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
    Node<Item> oldfirst = first;
    first = new Node<Item>();
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
    Stack<String> s = new Stack<>();
    s.push("a");
    s.push("b");
    s.push("c");
    System.out.println(s);
    s.pop();
    System.out.println(s);
  }

}
