package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class AandBandChess {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    int w = 0;
    int b = 0;
    for (int i = 0; i < 8; i++) {
      String line = in.readLine();
      for (int j = 0; j < 8; j++) {
        char c = line.charAt(j);
        switch (c) {
          case 'Q':
            w += 9;
            break;
          case 'q':
            b += 9;
            break;
          case 'R':
            w += 5;
            break;
          case 'r':
            b += 5;
            break;
          case 'B':
            w += 3;
            break;
          case 'b':
            b += 3;
            break;
          case 'N':
            w += 3;
            break;
          case 'n':
            b += 3;
            break;
          case 'P':
            w++;
            break;
          case 'p':
            b++;
            break;
          default:
            break;
        }
      }
    }
    if (w > b)
      out.println("White");
    else if (w == b)
      out.println("Draw");
    else
      out.println("Black");
    out.close();
    in.close();
  }
}
