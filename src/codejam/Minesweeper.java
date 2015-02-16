package codejam;

import java.util.Scanner;

public class Minesweeper {
  static int N;
  static int[][] matrix;

  static int check(int i, int j) {
    int count = 0;
    if (i > 0 && j > 0)
      if (matrix[i - 1][j - 1] == -1)
        count++;
    if (i > 0)
      if (matrix[i - 1][j] == -1)
        count++;
    if (i > 0 && j < N - 1)
      if (matrix[i - 1][j + 1] == -1)
        count++;
    if (j > 0)
      if (matrix[i][j - 1] == -1)
        count++;
    if (j < N - 1)
      if (matrix[i][j + 1] == -1)
        count++;
    if (i < N - 1 && j > 0)
      if (matrix[i + 1][j - 1] == -1)
        count++;
    if (i < N - 1)
      if (matrix[i + 1][j] == -1)
        count++;
    if (i < N - 1 && j < N - 1)
      if (matrix[i + 1][j + 1] == -1)
        count++;
    return count;
  }

  static void init() {
    for (int i = 0; i < N; i++)
      for (int j = 0; j < N; j++)
        if (matrix[i][j] != -1)
          matrix[i][j] = check(i, j);
  }

  static void mark(int i, int j) {
    matrix[i][j] = 9;
    if (i > 0 && j > 0)
      if (matrix[i - 1][j - 1] == 0) {
        matrix[i - 1][j - 1] = 9;
        mark(i - 1, j - 1);
      } else {
        matrix[i - 1][j - 1] = 9;
      }
    if (i > 0)
      if (matrix[i - 1][j] == 0) {
        matrix[i - 1][j] = 9;
        mark(i - 1, j);
      } else {
        matrix[i - 1][j] = 9;
      }
    if (i > 0 && j < N - 1)
      if (matrix[i - 1][j + 1] == 0) {
        matrix[i - 1][j + 1] = 9;
        mark(i - 1, j + 1);
      } else {
        matrix[i - 1][j + 1] = 9;
      }
    if (j > 0)
      if (matrix[i][j - 1] == 0) {
        matrix[i][j - 1] = 9;
        mark(i, j - 1);
      } else {
        matrix[i][j - 1] = 9;
      }
    if (j < N - 1)
      if (matrix[i][j + 1] == 0) {
        matrix[i][j + 1] = 9;
        mark(i, j + 1);
      } else {
        matrix[i][j + 1] = 9;
      }
    if (i < N - 1 && j > 0)
      if (matrix[i + 1][j - 1] == 0) {
        matrix[i + 1][j - 1] = 9;
        mark(i + 1, j - 1);
      } else {
        matrix[i + 1][j - 1] = 9;
      }
    if (i < N - 1)
      if (matrix[i + 1][j] == 0) {
        matrix[i + 1][j] = 9;
        mark(i + 1, j);
      } else {
        matrix[i + 1][j] = 9;
      }
    if (i < N - 1 && j < N - 1)
      if (matrix[i + 1][j + 1] == 0) {
        matrix[i + 1][j + 1] = 9;
        mark(i + 1, j + 1);
      } else {
        matrix[i + 1][j + 1] = 9;
      }
  }

  static int solve() {
    int count = 0;
    for (int i = 0; i < N; i++)
      for (int j = 0; j < N; j++)
        if (matrix[i][j] == 0) {
          count++;
          mark(i, j);
        }
    for (int i = 0; i < N; i++)
      for (int j = 0; j < N; j++)
        if (matrix[i][j] != -1 && matrix[i][j] != 9)
          count++;
    return count;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int T = scanner.nextInt();
    int k = 1;
    while (T-- > 0) {
      N = scanner.nextInt();
      matrix = new int[N][N];
      for (int i = 0; i < N; i++) {
        String line = scanner.next();
        for (int j = 0; j < N; j++)
          if (line.charAt(j) == '*')
            matrix[i][j] = -1;
      }
      init();
      System.out.println(String.format("Case #%d: %d", k++, solve()));
    }
    scanner.close();
  }
}
