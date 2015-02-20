package codeforces;

import java.io.*;
import java.util.*;

public class Lorry {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n, v;
    List<Boat> kayaks = new ArrayList<Boat>();
    List<Boat> catamarans = new ArrayList<Boat>();
    n = in.nextInt();
    v = in.nextInt();
    int numOfKayaks = 0, numOfCatamarans = 0;
    int sum1 = 0;
    for (int i = 1; i <= n; i++) {
      int type = in.nextInt(), capacity = in.nextInt();
      Boat boat = new Boat(i, capacity);
      if (type == 1) {
        kayaks.add(boat);
        sum1 += capacity;
        numOfKayaks++;
      } else {
        catamarans.add(boat);
        numOfCatamarans++;
      }
    }

    Collections.sort(kayaks);
    Collections.sort(catamarans);

    int selectedCatamarans = 0;
    int maxCapacity = 0, sum2 = 0, lastKayak = numOfKayaks;
    for (int i = 0; i <= numOfCatamarans; i++) {
      int j = Math.min(v - i * 2, numOfKayaks);
      if (j < 0)
        break;
      for (int k = lastKayak; k > j; k--)
        sum1 -= kayaks.get(numOfKayaks - k).capacity;
      if (i > 0)
        sum2 += catamarans.get(numOfCatamarans - i).capacity;
      if (sum1 + sum2 > maxCapacity) {
        maxCapacity = sum1 + sum2;
        selectedCatamarans = i;
      }
      lastKayak = j;
    }

    out.println(maxCapacity);
    for (int i = 0; i < selectedCatamarans; i++) {
      out.print(catamarans.get(numOfCatamarans - i - 1).index);
      out.print(' ');
    }
    for (int i = 0; i < Math.min(v - selectedCatamarans * 2, numOfKayaks); i++) {
      out.print(kayaks.get(numOfKayaks - i - 1).index);
      out.print(' ');
    }
    out.println();
    out.close();
    in.close();
  }
}


class Boat implements Comparable<Boat> {

  int index;
  int capacity;

  public Boat(int index, int capacity) {
    this.index = index;
    this.capacity = capacity;
  }

  @Override
  public int compareTo(Boat o) {
    return this.capacity - o.capacity;
  }

}
