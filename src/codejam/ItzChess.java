package codejam;

import java.util.Scanner;

public class ItzChess {
  static int num;
  static char[][] chess;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int T = scanner.nextInt();
    int k = 1;
    while (T-- > 0) {
      num = scanner.nextInt();
      chess = new char[8][8];
      for (int i = 0; i < 8; i++)
        for (int j = 0; j < 8; j++)
          chess[i][j] = '.';
      scanner.nextLine();
      for (int i = 0; i < num; i++) {
        String line = scanner.nextLine();
        chess[line.charAt(1) - '1'][line.charAt(0) - 'A'] = line.charAt(3);
      }
      int count = 0;
      int x;
      int y;
      for (int i = 0; i < 8; i++)
        for (int j = 0; j < 8; j++) {
          switch (chess[i][j]) {
            case 'K':
              if (i > 0)
                count = chess[i - 1][j] != '.' ? count + 1 : count;
              if (i > 0 && j > 0)
                count = chess[i - 1][j - 1] != '.' ? count + 1 : count;
              if (i > 0 && j < 7)
                count = chess[i - 1][j + 1] != '.' ? count + 1 : count;
              if (j > 0)
                count = chess[i][j - 1] != '.' ? count + 1 : count;
              if (j < 7)
                count = chess[i][j + 1] != '.' ? count + 1 : count;
              if (i < 7)
                count = chess[i + 1][j] != '.' ? count + 1 : count;
              if (i < 7 && j > 0)
                count = chess[i + 1][j - 1] != '.' ? count + 1 : count;
              if (i < 7 && j < 7)
                count = chess[i + 1][j + 1] != '.' ? count + 1 : count;
              break;
            case 'Q':
              x = i;
              y = j;
              while (x > 0) {
                x--;
                if (chess[x][y] != '.') {
                  count++;
                  break;
                }
              }
              x = i;
              y = j;
              while (x > 0 && y > 0) {
                x--;
                y--;
                if (chess[x][y] != '.') {
                  count++;
                  break;
                }
              }
              x = i;
              y = j;
              while (x > 0 && y < 7) {
                x--;
                y++;
                if (chess[x][y] != '.') {
                  count++;
                  break;
                }
              }
              x = i;
              y = j;
              while (y > 0) {
                y--;
                if (chess[x][y] != '.') {
                  count++;
                  break;
                }
              }
              x = i;
              y = j;
              while (y < 7) {
                y++;
                if (chess[x][y] != '.') {
                  count++;
                  break;
                }
              }
              x = i;
              y = j;
              while (x < 7) {
                x++;
                if (chess[x][y] != '.') {
                  count++;
                  break;
                }
              }
              x = i;
              y = j;
              while (x < 7 && y > 0) {
                x++;
                y--;
                if (chess[x][y] != '.') {
                  count++;
                  break;
                }
              }
              x = i;
              y = j;
              while (x < 7 && y < 7) {
                x++;
                y++;
                if (chess[x][y] != '.') {
                  count++;
                  break;
                }
              }
              break;
            case 'R':
              x = i;
              y = j;
              while (x > 0) {
                x--;
                if (chess[x][y] != '.') {
                  count++;
                  break;
                }
              }
              x = i;
              y = j;
              while (y > 0) {
                y--;
                if (chess[x][y] != '.') {
                  count++;
                  break;
                }
              }
              x = i;
              y = j;
              while (y < 7) {
                y++;
                if (chess[x][y] != '.') {
                  count++;
                  break;
                }
              }
              x = i;
              y = j;
              while (x < 7) {
                x++;
                if (chess[x][y] != '.') {
                  count++;
                  break;
                }
              }
              break;
            case 'B':
              x = i;
              y = j;
              while (x > 0 && y > 0) {
                x--;
                y--;
                if (chess[x][y] != '.') {
                  count++;
                  break;
                }
              }
              x = i;
              y = j;
              while (x > 0 && y < 7) {
                x--;
                y++;
                if (chess[x][y] != '.') {
                  count++;
                  break;
                }
              }
              x = i;
              y = j;
              while (x < 7 && y > 0) {
                x++;
                y--;
                if (chess[x][y] != '.') {
                  count++;
                  break;
                }
              }
              x = i;
              y = j;
              while (x < 7 && y < 7) {
                x++;
                y++;
                if (chess[x][y] != '.') {
                  count++;
                  break;
                }
              }
              break;
            case 'N':
              if (i > 0 && j > 1)
                count = chess[i - 1][j - 2] != '.' ? count + 1 : count;
              if (i > 0 && j < 6)
                count = chess[i - 1][j + 2] != '.' ? count + 1 : count;
              if (i < 7 && j > 1)
                count = chess[i + 1][j - 2] != '.' ? count + 1 : count;
              if (i < 7 && j < 6)
                count = chess[i + 1][j + 2] != '.' ? count + 1 : count;
              if (i > 1 && j < 7)
                count = chess[i - 2][j + 1] != '.' ? count + 1 : count;
              if (i > 1 && j > 0)
                count = chess[i - 2][j - 1] != '.' ? count + 1 : count;
              if (i < 6 && j < 7)
                count = chess[i + 2][j + 1] != '.' ? count + 1 : count;
              if (i < 6 && j > 0)
                count = chess[i + 2][j - 1] != '.' ? count + 1 : count;
              break;
            case 'P':
              if (j < 7) {
                if (i > 0)
                  count = chess[i - 1][j + 1] != '.' ? count + 1 : count;
                if (i < 7)
                  count = chess[i + 1][j + 1] != '.' ? count + 1 : count;
              }
              break;

            default:
              break;
          }
        }
      System.out.println(String.format("Case #%d: %d", k++, count));
    }
    scanner.close();
  }
}
