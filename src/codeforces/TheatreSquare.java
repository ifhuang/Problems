package codeforces;

import java.io.PrintStream;
import java.util.Scanner;

public class TheatreSquare {

  static long solve(int n, int m, int a) {
    long x = n % a == 0 ? n / a : n / a + 1;
    long y = m % a == 0 ? m / a : m / a + 1;
    return x * y;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    PrintStream ps = new PrintStream(System.out);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    int a = scanner.nextInt();
    ps.println(solve(n, m, a));
    ps.close();
    scanner.close();
  }

}
