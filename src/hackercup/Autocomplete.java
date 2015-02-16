package hackercup;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Autocomplete {

  static Node root;

  static int solve(String s) {
    boolean flag = true;
    int h = 0;
    Node p = root;
    for (int i = 0; i < s.length(); i++) {
      if (flag)
        h++;
      int index = s.charAt(i) - 'a';
      if (p.children[index] == null) {
        p.children[index] = new Node();
        if (flag)
          flag = false;
      }
      p = p.children[index];
    }
    return h;
  }

  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(new FileInputStream("autocomplete.txt"));
    PrintStream ps = new PrintStream(new FileOutputStream("autocomplete-out.txt"));
    int T = scanner.nextInt();
    int k = 1;
    while (T-- > 0) {
      int N = scanner.nextInt();
      int count = 0;
      scanner.nextLine();
      root = new Node();
      while (N-- > 0)
        count += solve(scanner.nextLine());
      ps.println(String.format("Case #%d: %d", k++, count));
    }
    scanner.close();
    ps.close();
  }

}


class Node {
  public Node[] children;

  public Node() {
    children = new Node[26];
  }
}
