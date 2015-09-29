package hihocoder;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class LuckySubstrings {
  static Scanner in;
  static PrintWriter out;

  static void solve() {
    Set<Integer> set = makeSet();
    Set<String> ans = new HashSet<String>();
    String s = in.next();
    for (int i = 0; i < s.length(); i++)
      for (int j = i + 1; j <= s.length(); j++)
        if (check(s.substring(i, j), set))
          ans.add(s.substring(i, j));
    List<String> list = new ArrayList<String>(ans);
    Collections.sort(list);
    for (String li : list)
      out.println(li);
  }

  static boolean check(String s, Set<Integer> set) {
    Set<Character> count = new HashSet<Character>();
    for (char c : s.toCharArray())
      count.add(c);
    return set.contains(count.size());
  }

  static Set<Integer> makeSet() {
    Set<Integer> set = new HashSet<Integer>();
    set.add(1);
    set.add(1);
    set.add(2);
    set.add(3);
    set.add(5);
    set.add(8);
    set.add(13);
    set.add(21);
    set.add(34);
    set.add(55);
    set.add(89);
    return set;
  }

  public static void main(String[] args) {
    in = new Scanner(System.in);
    out = new PrintWriter(System.out);
    solve();
    out.close();
    in.close();
  }
}
