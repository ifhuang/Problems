package hihocoder;

import java.io.PrintWriter;
import java.util.Scanner;

public class FarthestPoint {
  static Scanner in;
  static PrintWriter out;

  static void solve() {
    double x = in.nextDouble();
    double y = in.nextDouble();
    double r = in.nextDouble();
    int xS = (int) Math.ceil(x - r);
    int xB = (int) Math.floor(x + r);
    double max = 0;
    int ansX = 0;
    int ansY = 0;
    for (int i = xS; i <= xB; i++) {
      for (int k = -1; k <= 1; k += 2) {
        int j = 0;
        if (k == -1) {
          j = (int) Math.floor(y + Math.sqrt(r * r - (i - x) * (i - x)));
        } else {
          j = (int) Math.ceil(y - Math.sqrt(r * r - (i - x) * (i - x)));
        }
        double dis = getDis(x, y, i, j);
        if (Double.compare(dis, r) <= 0) {
          if (Double.compare(dis, max) > 0) {
            max = dis;
            ansX = i;
            ansY = j;
          } else if (Double.compare(dis, max) == 0) {
            if (i > ansX) {
              ansX = i;
              ansY = j;
            } else if (i == ansX) {
              if (j > ansY) {
                ansY = j;
              }
            }
          }
        }
      }
    }
    out.println(ansX + " " + ansY);
  }

  static double getDis(double x, double y, int i, int j) {
    return Math.sqrt((x - i) * (x - i) + (y - j) * (y - j));
  }

  public static void main(String[] args) {
    in = new Scanner(System.in);
    out = new PrintWriter(System.out);
    solve();
    out.close();
    in.close();
  }
}
