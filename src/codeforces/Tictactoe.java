package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

public class Tictactoe {

  static boolean checkWin(char[][] chess, char s) {
    for (int i = 0; i < 3; i++)
      if (s == chess[i][0] && s == chess[i][1] && s == chess[i][2])
        return true;
    for (int j = 0; j < 3; j++)
      if (s == chess[0][j] && s == chess[1][j] && s == chess[2][j])
        return true;
    if (s == chess[0][0] && s == chess[1][1] && s == chess[2][2])
      return true;
    if (s == chess[0][2] && s == chess[1][1] && s == chess[2][0])
      return true;
    return false;
  }

  static String solve(char[][] chess, int x, int o) {
    if (x < o || x > o + 1)
      return "illegal";
    boolean xw = checkWin(chess, 'X');
    boolean ow = checkWin(chess, '0');
    if (xw && ow || xw && x == o || ow && x > o)
      return "illegal";
    if (xw)
      return "the first player won";
    if (ow)
      return "the second player won";
    if (x + o == 9)
      return "draw";
    if (x == o)
      return "first";
    if (x > o)
      return "second";
    return "illegal";
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    char[][] chess = new char[3][3];
    int x = 0;
    int o = 0;
    for (int i = 0; i < 3; i++) {
      String line = in.nextLine();
      chess[i] = line.toCharArray();
      for (int j = 0; j < 3; j++)
        if (chess[i][j] == 'X')
          x++;
        else if (chess[i][j] == '0')
          o++;
    }
    out.println(solve(chess, x, o));
    out.close();
    in.close();
  }
}
