package other;

public class ReverseSecondHalf {
  public Node solve(Node head) {
    Node dummy = new Node(0, head);
    Node p = dummy;
    Node q = dummy;
    while (q.next != null && q.next.next != null) {
      p = p.next;
      q = q.next.next;
    }
    p.next = reverse(p.next);
    return dummy.next;
  }

  private Node reverse(Node head) {
    Node pre = null;
    Node cur = head;
    while (cur != null) {
      Node post = cur.next;
      cur.next = pre;
      pre = cur;
      cur = post;
    }
    return pre;
  }

  public static void main(String[] args) {
    ReverseSecondHalf rsh = new ReverseSecondHalf();
    Node head1 = null;
    rsh.solve(head1);
    Node head2 = new Node(0, null);
    rsh.solve(head2);
    Node head3 = new Node(0, new Node(1, null));
    rsh.solve(head3);
    Node head4 = new Node(0, new Node(1, new Node(2, null)));
    rsh.solve(head4);
  }
}


class Node {
  int val;
  Node next;

  public Node(int val, Node next) {
    this.val = val;
    this.next = next;
  }
}
