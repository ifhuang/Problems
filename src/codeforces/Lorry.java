package codeforces;

import java.io.*;
import java.util.*;

public class Lorry {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = in.nextInt(), v = in.nextInt();
    List<Boat> kList = new ArrayList<Boat>();
    List<Boat> cList = new ArrayList<Boat>();
    int kNum = 0, cNum = 0;
    int kSum = 0, cSum = 0;
    for (int i = 1; i <= n; i++) {
      int type = in.nextInt(), capacity = in.nextInt();
      Boat boat = new Boat(i, capacity);
      if (type == 1) {
        kList.add(boat);
        kSum += capacity;
        kNum++;
      } else {
        cList.add(boat);
        cNum++;
      }
    }

    Collections.sort(kList);
    Collections.sort(cList);

    int cCount = 0, kCount = kNum, ans = 0;
    for (int i = 0; i <= cNum; i++) {
      int j = Math.min(v - i * 2, kNum);
      if (j < 0)
        break;
      for (int k = j; k < kCount; k++)
        kSum -= kList.get(k).capacity;
      if (i > 0)
        cSum += cList.get(i - 1).capacity;
      if (kSum + cSum > ans) {
        ans = kSum + cSum;
        cCount = i;
      }
      kCount = j;
    }

    out.println(ans);
    for (int i = 0; i < cCount; i++) {
      out.print(cList.get(i).index);
      out.print(' ');
    }
    for (int i = 0; i < Math.min(v - cCount * 2, kNum); i++) {
      out.print(kList.get(i).index);
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
    return o.capacity - this.capacity;
  }

  @Override
  public String toString() {
    return "Boat [index=" + index + ", capacity=" + capacity + "]";
  }

}
