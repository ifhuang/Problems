package codeforces;

import java.io.PrintStream;
import java.util.Scanner;

public class Shortestpathoftheking {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    PrintStream ps = new PrintStream(System.out);
    String s = scanner.nextLine();
    int sy = s.charAt(0) - 'a';
    int sx = 8 - Integer.parseInt(s.substring(1));
    String t = scanner.nextLine();
    int ty = t.charAt(0) - 'a';
    int tx = 8 - Integer.parseInt(t.substring(1));
    int count = 0;
    StringBuilder sb = new StringBuilder();
    while (sx != tx || sy != ty) {
      count++;
      if (sx == tx)
        if (sy < ty) {
          sy++;
          sb.append('R').append('\n');
        } else {
          sy--;
          sb.append('L').append('\n');
        }
      else if (sy == ty)
        if (sx < tx) {
          sx++;
          sb.append('D').append('\n');
        } else {
          sx--;
          sb.append('U').append('\n');
        }
      else if (sx < tx && sy < ty) {
        sx++;
        sy++;
        sb.append("RD").append('\n');
      } else if (sx < tx && sy > ty) {
        sx++;
        sy--;
        sb.append("LD").append('\n');
      } else if (sx > tx && sy < ty) {
        sx--;
        sy++;
        sb.append("RU").append('\n');
      } else {
        sx--;
        sy--;
        sb.append("LU").append('\n');
      }
    }
    ps.println(count);
    ps.print(sb.toString());
    ps.close();
    scanner.close();
  }

}
