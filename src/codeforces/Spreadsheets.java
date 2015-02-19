package codeforces;

import java.io.PrintStream;
import java.util.Scanner;

public class Spreadsheets {

  static String i2s(int i) {
    return i == 0 ? "" : i2s((i - 1) / 26) + (char) ('A' + (i - 1) % 26);
  }

  static int s2i(String s) {
    return s.length() == 0 ? 0 : s2i(s.substring(0, s.length() - 1)) * 26
        + s.charAt(s.length() - 1) - 'A' + 1;
  }

  static String solve(String s) {
    // one
    int c = s.indexOf("C");
    boolean flag = false;
    int i = 0;
    while (i < c)
      if (Character.isDigit(s.charAt(i))) {
        flag = true;
        break;
      } else
        i++;
    if (flag)
      return i2s(Integer.parseInt(s.substring(c + 1))) + s.substring(1, c);
    // two
    i = 0;
    while (true)
      if (Character.isDigit(s.charAt(i)))
        break;
      else
        i++;
    return "R" + s.substring(i) + "C" + s2i(s.substring(0, i));
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    PrintStream ps = new PrintStream(System.out);
    int n = scanner.nextInt();
    scanner.nextLine();
    while (n-- > 0)
      ps.println(solve(scanner.nextLine()));
    ps.close();
    scanner.close();
  }

}
