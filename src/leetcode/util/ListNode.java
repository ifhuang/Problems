package leetcode.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class ListNode {
  public int val;
  public ListNode next;

  public ListNode(int x) {
    val = x;
    next = null;
  }

  public ListNode(int[] x) {
    if (x == null || x.length == 0) {

    } else if (x.length == 1) {
      val = x[0];
      next = null;
    } else {
      val = x[0];
      next = new ListNode(Arrays.copyOfRange(x, 1, x.length));
    }
  }

  public static ListNode createListFromFile(String path) throws Exception {
    BufferedReader br = new BufferedReader(new FileReader(path));
    String line;
    StringBuffer sb = new StringBuffer();
    while ((line = br.readLine()) != null) {
      sb.append(line);
    }
    br.close();
    String[] part = sb.toString().split(",");
    int[] data = new int[part.length];
    for (int i = 0; i < data.length; i++) {
      data[i] = Integer.parseInt(part[i]);
    }
    return new ListNode(data);
  }

  public static void print(ListNode head) {
    while (head.next != null) {
      System.out.print(head.val + ",");
      head = head.next;
    }
    System.out.println(head.val);
  }
}
